package com.kxg.middleground.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_assembly_serect")
public class KxgAssemblySerect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 组件id
     */
    @Column(name = "assembly_id")
    private Long assemblyId;

    /**
     * 项目id
     */
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 应用授权的密钥
     */
    @Column(name = "access_key")
    private String accessKey;

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
     * 获取组件id
     *
     * @return assembly_id - 组件id
     */
    public Long getAssemblyId() {
        return assemblyId;
    }

    /**
     * 设置组件id
     *
     * @param assemblyId 组件id
     */
    public void setAssemblyId(Long assemblyId) {
        this.assemblyId = assemblyId;
    }

    /**
     * 获取项目id
     *
     * @return product_id - 项目id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置项目id
     *
     * @param productId 项目id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
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
     * 获取应用授权的密钥
     *
     * @return access_key - 应用授权的密钥
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 设置应用授权的密钥
     *
     * @param accessKey 应用授权的密钥
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey == null ? null : accessKey.trim();
    }
}