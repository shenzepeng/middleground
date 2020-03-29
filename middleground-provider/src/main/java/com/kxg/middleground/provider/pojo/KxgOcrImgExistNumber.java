package com.kxg.middleground.provider.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_ocr_img_exist_number")
public class KxgOcrImgExistNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "ocr_exist_number")
    private Long ocrExistNumber;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return ocr_exist_number
     */
    public Long getOcrExistNumber() {
        return ocrExistNumber;
    }

    /**
     * @param ocrExistNumber
     */
    public void setOcrExistNumber(Long ocrExistNumber) {
        this.ocrExistNumber = ocrExistNumber;
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
}