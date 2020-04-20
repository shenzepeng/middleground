package com.kxg.middleground.provider.dao;

import com.kxg.middleground.provider.mapper.KxgProductMapper;
import com.kxg.middleground.provider.pojo.KxgProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Auther: szp
 * @Date: 2020/3/31 15:52
 * @Description: 沈泽鹏写点注释吧
 */
@Repository
public class KxgProductDao {
    @Autowired
    private KxgProductMapper kxgProductMapper;

    /**
     * 新增项目
     * @param kxgProduct
     * @return
     */
    public Integer addProduct(KxgProduct kxgProduct){
      return kxgProductMapper.insert(kxgProduct);
    }

    /**
     * 通过项目创阿金
     * @param appKey
     * @return
     */
    public KxgProduct findProductByAppKey(String appKey){
        Example example=new Example(KxgProduct.class);
        example.createCriteria().andEqualTo("appKey",appKey);
        return kxgProductMapper.selectOneByExample(example);
    }

    /**
     * 通过userid找到项目
     * @param userId
     * @return
     */
    public List<KxgProduct> findProductByUserId(Long userId){
        Example example=new Example(KxgProduct.class);
        example.createCriteria().andEqualTo("userId",userId);
        example.orderBy("id").desc();
        return kxgProductMapper.selectByExample(example);
    }

    /**
     * 通过openid
     * @param openId
     * @return
     */
    public List<KxgProduct> findProductByOpenId(String openId){
        Example example=new Example(KxgProduct.class);
        example.createCriteria().andEqualTo("openid",openId);
        example.orderBy("id").desc();
        return kxgProductMapper.selectByExample(example);
    }

    /**
     * 通过userid和项目名称找到项目信息
     * @param userId
     * @return
     */
    public List<KxgProduct> findProductByUserIdAndProductName(Long userId,String productName){
        Example example=new Example(KxgProduct.class);
        example.createCriteria().andEqualTo("userId",userId).andLike("productName","%"+productName+"%");
        example.orderBy("id").desc();
        return kxgProductMapper.selectByExample(example);
    }

    public List<KxgProduct> findProductByOpenidAndProductName(String openId,String productName){
        Example example=new Example(KxgProduct.class);
        example.createCriteria().andEqualTo("openid",openId).andLike("productName","%"+productName+"%");
        example.orderBy("id").desc();
        return kxgProductMapper.selectByExample(example);
    }

    /**
     * 通过项目id找到项目
     * @param id
     * @return
     */
    public KxgProduct findProductById(Long id){
        return kxgProductMapper.selectByPrimaryKey(id);
    }


}
