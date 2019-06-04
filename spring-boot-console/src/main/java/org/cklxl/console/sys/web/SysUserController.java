package org.cklxl.console.sys.web;

import java.util.Date;

import javax.inject.Inject;

import org.cklxl.console.log.annotation.LogRule;
import org.cklxl.console.log.constant.OperType;
import org.cklxl.console.sys.model.SysUser;
import org.cklxl.console.sys.service.SysUserService;
import org.cklxl.console.sys.web.request.UserRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysUserController {

    @Inject
    private SysUserService sysUserService;

    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    @LogRule(name = OperType.SAVE, serviceclass = SysUserService.class)
    public boolean save() {
        SysUser user = new SysUser();
        user.setCode("P0000001");
        user.setName("张三");
        user.setPassword("123123");
        sysUserService.save(user);
        return true;
    }

    @RequestMapping(value = "/user/edit", method = {RequestMethod.GET,RequestMethod.POST})
    @LogRule(name = OperType.UPDATE, serviceclass = SysUserService.class)
    public boolean edit(@RequestParam Long id, @RequestParam String password) {
        SysUser user = new SysUser();
        user.setId(id);
        user.setCode("P0000001");
        user.setName("张三");
        user.setPassword(password);
        user.setUpdateTime(new Date());
        sysUserService.update(user);
        return true;
    }
    
    @RequestMapping(value = "/user/edit1", method = {RequestMethod.GET,RequestMethod.POST})
    @LogRule(name = OperType.UPDATE, serviceclass = SysUserService.class)
    public boolean edit1(UserRequest request) {
        SysUser user = new SysUser();
        user.setId(request.getId());
        user.setCode("P0000001");
        user.setName("张三");
        user.setPassword(request.getPassword());
        user.setUpdateTime(new Date());
        sysUserService.update(user);
        return true;
    }

}
