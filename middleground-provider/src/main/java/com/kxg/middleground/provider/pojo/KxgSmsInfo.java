package com.kxg.middleground.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_sms_info")
public class KxgSmsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String content;

    @Column(name = "max_verify_times")
    private Integer maxVerifyTimes;

    @Column(name = "verify_times")
    private Integer verifyTimes;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "biz_id")
    private String bizId;

    private Short status;

    @Column(name = "app_key")
    private String appKey;

    private String msg;

    @Column(name = "expired_time")
    private Date expiredTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return max_verify_times
     */
    public Integer getMaxVerifyTimes() {
        return maxVerifyTimes;
    }

    /**
     * @param maxVerifyTimes
     */
    public void setMaxVerifyTimes(Integer maxVerifyTimes) {
        this.maxVerifyTimes = maxVerifyTimes;
    }

    /**
     * @return verify_times
     */
    public Integer getVerifyTimes() {
        return verifyTimes;
    }

    /**
     * @param verifyTimes
     */
    public void setVerifyTimes(Integer verifyTimes) {
        this.verifyTimes = verifyTimes;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return template_id
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * @param templateId
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return request_id
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }

    /**
     * @return biz_id
     */
    public String getBizId() {
        return bizId;
    }

    /**
     * @param bizId
     */
    public void setBizId(String bizId) {
        this.bizId = bizId == null ? null : bizId.trim();
    }

    /**
     * @return status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return app_key
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * @param appKey
     */
    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    /**
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    /**
     * @return expired_time
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * @param expiredTime
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}