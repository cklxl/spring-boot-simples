package org.cklxl.console.log.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.cklxl.console.log.annotation.LogRule;
import org.cklxl.console.log.constant.OperType;
import org.cklxl.console.log.parser.ContentParser;
import org.cklxl.console.log.service.LogService;
import org.cklxl.console.sys.model.SysLog;
import org.cklxl.console.util.ReflectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

/**
 * 拦截@LogRule注解的方法<br>
 * 将具体修改存储到数据库中
 * 
 * @author Kun.Chen
 * @date 2019-06-04 11:53:36
 */
@Aspect
@Slf4j
public class OperLogInterceptor {

    private SysLog operateLog;

    /**
     * 变更前
     */
    private Object oldObject;

    /**
     * 变更后
     */
    private Object newObject;

    private Map<String, Object> feildValues;

    @Inject
    private LogService operatelogService;

    @PostConstruct
    public void init() {
        log.info("load... OperLogInterceptor");
    }
    @Before("@annotation(logRule)")
    public void doBefore(JoinPoint joinPoint, LogRule logRule) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object[] args = joinPoint.getArgs();
        Object info = Objects.nonNull(args) && args.length > 0 ? args[0] : null;
        String[] feilds = logRule.feildName();
        operateLog = new SysLog();
        operateLog.setSerialNo(UUID.randomUUID().toString().replaceAll("-", ""));
        operateLog.setOperUserId(1L);
        operateLog.setOperUserName("");
        operateLog.setOperIp("");
        operateLog.setOperTime(new Date());
        String bizName = logRule.bizName();
        if (StringUtils.isNotBlank(bizName)) {
            operateLog.setOperBiz(bizName);
        } else {
            operateLog.setOperBiz(request.getRequestURL().toString());
        }
        operateLog.setOperType(logRule.name());
        operateLog.setOperContent("");
        if (OperType.UPDATE.equals(logRule.name())) {
            for (String feild : feilds) {
                feildValues = new HashMap<>();
                if (Objects.isNull(info)) {
                    // TODO
                }
                log.info("info {} =: {}", feild, info);
                Object result = ReflectionUtils.getFieldValue(info, feild);
                feildValues.put(feild, result);
            }
            try {
                ContentParser contentParser = (ContentParser) logRule.parseclass().newInstance();
                oldObject = contentParser.getResult(feildValues, logRule);
            } catch (Exception e) {
                log.error("service加载失败:", e);
            }
        } else {
            if (OperType.UPDATE.equals(logRule.name())) {
                log.error("id查询失败，无法记录日志");
            }
        }
    }

    @AfterReturning(pointcut = "@annotation(logRule)", returning = "object")
    public void doAfterReturing(Object object, LogRule logRule) {
        if (OperType.UPDATE.equals(logRule.name())) {
            ContentParser contentParser = null;
            try {
                contentParser = (ContentParser) logRule.parseclass().newInstance();
                newObject = contentParser.getResult(feildValues, logRule);
            } catch (Exception e) {
                log.error("service加载失败:", e);
            }
            try {
                List<Map<String, Object>> changelist = ReflectionUtils.compareTwoClass(oldObject, newObject);
                StringBuilder str = new StringBuilder();
                for (Map<String, Object> map : changelist) {
                    str.append("【" + map.get("name") + "】从【" + map.get("old") + "】改为了【" + map.get("new") + "】;\n");
                }
                operateLog.setOperContent(str.toString());

            } catch (Exception e) {
                log.error("比较异常", e);
            }
        }
        operatelogService.save(operateLog);
    }

}
