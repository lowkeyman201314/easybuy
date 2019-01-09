package cn.bdqn.easybuy.dao.product;

import cn.bdqn.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 15:49
 * @Description:
 */
public interface ProductCategoryDao {
    //查询所有商品分类
    List<ProductCategory> queryAllProductCategorylist(String parentId);
}
