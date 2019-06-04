package org.cklxl.console.log.service;

import javax.inject.Inject;

import org.cklxl.console.sys.mapper.SysLogMapper;
import org.cklxl.console.sys.model.SysLog;

public class LogService {
    @Inject
    private SysLogMapper sysLogMapper;

    public void save(SysLog sysLog) {
        sysLogMapper.insertSelective(sysLog);
    }
}
