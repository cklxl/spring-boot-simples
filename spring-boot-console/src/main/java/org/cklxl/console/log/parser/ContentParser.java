package org.cklxl.console.log.parser;

import java.util.Map;

import org.cklxl.console.log.annotation.LogRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 解析接口
 *
 *
 * @author Kun.Chen
 * @date 2019-06-04 11:39:00
 */
public interface ContentParser {

    final static Logger logger = LoggerFactory.getLogger(ContentParser.class);

    /**
     * 获取信息返回查询出的对象
     * 
     * @param feildValues 查询条件的参数值
     * @param logRule     注解
     * @return
     */
    public Object getResult(Map<String, Object> feildValues, LogRule logRule);
}
