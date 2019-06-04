package org.cklxl.console.sys.service;

import javax.inject.Inject;

import org.cklxl.console.base.api.BaseService;
import org.cklxl.console.sys.mapper.SysUserMapper;
import org.cklxl.console.sys.model.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统用户
 * 
 * @author Kun.Chen
 * @date 2019-06-04 11:03:47
 */
@Service
public class SysUserService implements BaseService<SysUser, Long> {

    @Inject
    private SysUserMapper sysUserMapper;

//    @Transactional
    public void save(SysUser user) {
        sysUserMapper.insertSelective(user);
    }

//    @Transactional
    public void update(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public SysUser selectById(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

}
