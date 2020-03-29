package com.kxg.middleground.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_assembly")
public class KxgAssembly {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assembly_name")
    private String assemblyName;

    @Column(name = "app_key")
    private String appKey;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private Short status;

    @Column(name = "short_introduce")
    private String shortIntroduce;

    @Column(name = "assembly_doc")
    private String assemblyDoc;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "controller_api")
    private String controllerApi;

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
     * @return assembly_name
     */
    public String getAssemblyName() {
        return assemblyName;
    }

    /**
     * @param assemblyName
     */
    public void setAssemblyName(String assemblyName) {
        this.assemblyName = assemblyName == null ? null : assemblyName.trim();
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
     * @return short_introduce
     */
    public String getShortIntroduce() {
        return shortIntroduce;
    }

    /**
     * @param shortIntroduce
     */
    public void setShortIntroduce(String shortIntroduce) {
        this.shortIntroduce = shortIntroduce == null ? null : shortIntroduce.trim();
    }

    /**
     * @return assembly_doc
     */
    public String getAssemblyDoc() {
        return assemblyDoc;
    }

    /**
     * @param assemblyDoc
     */
    public void setAssemblyDoc(String assemblyDoc) {
        this.assemblyDoc = assemblyDoc == null ? null : assemblyDoc.trim();
    }

    /**
     * @return create_user
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * @return update_user
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * @param updateUser
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * @return controller_api
     */
    public String getControllerApi() {
        return controllerApi;
    }

    /**
     * @param controllerApi
     */
    public void setControllerApi(String controllerApi) {
        this.controllerApi = controllerApi == null ? null : controllerApi.trim();
    }
}