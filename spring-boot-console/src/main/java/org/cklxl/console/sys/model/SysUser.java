package org.cklxl.console.sys.model;

import java.util.Date;
import javax.persistence.*;

import org.cklxl.console.log.annotation.LogFieldName;

@Table(name = "`sys_user`")
public class SysUser {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户编码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 用户名
     */
    @Column(name = "`name`")
    @LogFieldName(name = "用户名")
    private String name;

    /**
     * 密码
     */
    @Column(name = "`password`")
    @LogFieldName(name = "用户密码")
    private String password;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "`update_time`")
    private Date updateTime;

    /**
     * 版本号
     */
    @Column(name = "`version`")
    private Integer version;

    /**
     * 启用;1-是/0-否
     */
    @Column(name = "`enable`")
    private Boolean enable;

    /**
     * 删除;1-是/0-否
     */
    @Column(name = "`is_delete`")
    private Boolean isDelete;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户编码
     *
     * @return code - 用户编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置用户编码
     *
     * @param code 用户编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后修改时间
     *
     * @return update_time - 最后修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param updateTime 最后修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取启用;1-是/0-否
     *
     * @return enable - 启用;1-是/0-否
     */
    public Boolean getEnable() {
        return enable;
    }

    /**
     * 设置启用;1-是/0-否
     *
     * @param enable 启用;1-是/0-否
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * 获取删除;1-是/0-否
     *
     * @return is_delete - 删除;1-是/0-否
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置删除;1-是/0-否
     *
     * @param isDelete 删除;1-是/0-否
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}