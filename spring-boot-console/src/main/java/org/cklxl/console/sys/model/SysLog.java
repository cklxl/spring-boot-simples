package org.cklxl.console.sys.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`sys_log`")
public class SysLog {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 流水号
     */
    @Column(name = "`serial_no`")
    private String serialNo;

    /**
     * 操作类型
     */
    @Column(name = "`oper_type`")
    private String operType;

    /**
     * 操作业务
     */
    @Column(name = "`oper_biz`")
    private String operBiz;

    /**
     * 操作内容
     */
    @Column(name = "`oper_content`")
    private String operContent;

    /**
     * 操作用户id
     */
    @Column(name = "`oper_user_id`")
    private Long operUserId;

    /**
     * 操作用户姓名
     */
    @Column(name = "`oper_user_name`")
    private String operUserName;

    /**
     * 操作ip
     */
    @Column(name = "`oper_ip`")
    private String operIp;

    /**
     * 操作时间
     */
    @Column(name = "`oper_time`")
    private Date operTime;

    /**
     * 创建时间
     */
    @Column(name = "`create_time`")
    private Date createTime;

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
     * 获取流水号
     *
     * @return serial_no - 流水号
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * 设置流水号
     *
     * @param serialNo 流水号
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * 获取操作类型
     *
     * @return oper_type - 操作类型
     */
    public String getOperType() {
        return operType;
    }

    /**
     * 设置操作类型
     *
     * @param operType 操作类型
     */
    public void setOperType(String operType) {
        this.operType = operType;
    }

    /**
     * 获取操作业务
     *
     * @return oper_biz - 操作业务
     */
    public String getOperBiz() {
        return operBiz;
    }

    /**
     * 设置操作业务
     *
     * @param operBiz 操作业务
     */
    public void setOperBiz(String operBiz) {
        this.operBiz = operBiz;
    }

    /**
     * 获取操作内容
     *
     * @return oper_content - 操作内容
     */
    public String getOperContent() {
        return operContent;
    }

    /**
     * 设置操作内容
     *
     * @param operContent 操作内容
     */
    public void setOperContent(String operContent) {
        this.operContent = operContent;
    }

    /**
     * 获取操作用户id
     *
     * @return oper_user_id - 操作用户id
     */
    public Long getOperUserId() {
        return operUserId;
    }

    /**
     * 设置操作用户id
     *
     * @param operUserId 操作用户id
     */
    public void setOperUserId(Long operUserId) {
        this.operUserId = operUserId;
    }

    /**
     * 获取操作用户姓名
     *
     * @return oper_user_name - 操作用户姓名
     */
    public String getOperUserName() {
        return operUserName;
    }

    /**
     * 设置操作用户姓名
     *
     * @param operUserName 操作用户姓名
     */
    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    /**
     * 获取操作ip
     *
     * @return oper_ip - 操作ip
     */
    public String getOperIp() {
        return operIp;
    }

    /**
     * 设置操作ip
     *
     * @param operIp 操作ip
     */
    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    /**
     * 获取操作时间
     *
     * @return oper_time - 操作时间
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * 设置操作时间
     *
     * @param operTime 操作时间
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
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
}