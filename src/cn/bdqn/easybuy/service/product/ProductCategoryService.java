package cn.bdqn.easybuy.service.product;

import cn.bdqn.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 16:06
 * @Description:
 */
public interface ProductCategoryService {
    //查询所有商品分类
    List<ProductCategory> queryAllProductCategorylist(String parentId);
}
