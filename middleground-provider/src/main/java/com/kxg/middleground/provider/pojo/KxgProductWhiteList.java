package com.kxg.middleground.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_product_white_list")
public class KxgProductWhiteList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_key")
    private String appKey;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "product_ip_list")
    private String productIpList;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "update_time")
    private Date updateTime;

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
     * @return product_ip_list
     */
    public String getProductIpList() {
        return productIpList;
    }

    /**
     * @param productIpList
     */
    public void setProductIpList(String productIpList) {
        this.productIpList = productIpList == null ? null : productIpList.trim();
    }

    /**
     * @return product_type
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
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
}