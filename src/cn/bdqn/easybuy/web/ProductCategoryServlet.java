package cn.bdqn.easybuy.web;

import cn.bdqn.easybuy.entity.ProductCategory;
import cn.bdqn.easybuy.service.product.ProductCategoryService;
import cn.bdqn.easybuy.service.product.ProductCategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 16:08
 * @Description:
 */
@WebServlet(name = "home",urlPatterns = "/home")
public class ProductCategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        //
        ProductCategoryService service=new ProductCategoryServiceImpl();
        List<ProductCategory> categories=service.queryAllProductCategorylist("0");
        //
        request.setAttribute("categories",categories);
        //
        request.getRequestDispatcher("/pre/index.jsp").forward(request,response);

    }
}
