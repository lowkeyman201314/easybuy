package cn.bdqn.easybuy.dao.product;

import cn.bdqn.easybuy.entity.ProductCategory;
import cn.bdqn.easybuy.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 15:50
 * @Description:
 */
public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {
    @Override
    public List<ProductCategory> queryAllProductCategorylist(String parentId) {
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        ProductCategory productCategory = null;
        StringBuffer sql = null;
        ResultSet rs=null;

        try {
            sql = new StringBuffer();
            sql.append("select id,name,iconClass,parentId,type from easybuy_product_category where 1=1");
            //按照商品分类的父级ID查询
            if (null != parentId && !"".equals(parentId)) {
                sql.append(" and parentId = ?");
            }
            rs=this.executeQuery(sql.toString(),parentId);
            while (rs.next()) {
                productCategory=new ProductCategory();
                productCategory.setId(rs.getInt("id"));
                productCategory.setName(rs.getString("name"));
                productCategory.setParentId(rs.getInt("parentId"));
                productCategory.setType(rs.getInt("type"));
                productCategory.setIconClass(rs.getString("iconClass"));
                productCategoryList.add(productCategory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productCategoryList;
    }
}
