package org.cklxl.console.log.parser;

import java.util.Map;

import org.cklxl.console.base.api.BaseService;
import org.cklxl.console.log.annotation.LogRule;
import org.cklxl.console.util.SpringUtil;
import org.springframework.util.Assert;

/**
 * 基础解析类 单表编辑时可以直接使用id来查询 如果为多表复杂逻辑，请自行编写具体实现类
 * 
 * @author Kun.Chen
 * @param <ID>
 * @date 2019-06-04 13:51:23
 */
public class DefaultContentParse implements ContentParser {
    @Override
    public Object getResult(Map<String, Object> feildValues, LogRule logRule) {
        Assert.isTrue(feildValues.containsKey("id"), "主键Key不存在");
        Object key = feildValues.get("id");
        Class<?> cls = logRule.serviceclass();
        BaseService service = (BaseService) SpringUtil.getBean(cls);
        return service.selectById(key);
    }

}
