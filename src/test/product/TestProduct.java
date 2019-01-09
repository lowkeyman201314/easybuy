package test.product;

import cn.bdqn.easybuy.dao.product.ProductCategoryDao;
import cn.bdqn.easybuy.dao.product.ProductCategoryDaoImpl;
import org.junit.Test;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 16:01
 * @Description:
 */
public class TestProduct {
    @Test
    public void test(){
        ProductCategoryDao dao=new ProductCategoryDaoImpl();
        System.out.println(dao.queryAllProductCategorylist("0").size());
    }
}
