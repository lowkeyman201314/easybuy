package cn.bdqn.easybuy.service.product;

import cn.bdqn.easybuy.dao.product.ProductCategoryDao;
import cn.bdqn.easybuy.dao.product.ProductCategoryDaoImpl;
import cn.bdqn.easybuy.entity.ProductCategory;

import java.util.List;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 16:07
 * @Description:
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private ProductCategoryDao dao=new ProductCategoryDaoImpl();
    @Override
    public List<ProductCategory> queryAllProductCategorylist(String parentId) {
        return dao.queryAllProductCategorylist(parentId);
    }
}
