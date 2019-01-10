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
 * @Date: 2019/1/9 19:24
 * @Description:
 */
@WebServlet(name = "home", urlPatterns = "/home")
public class HomeServlet extends AbstractServlet {

    private ProductCategoryService service;

    @Override
    public Class getServletClass() {
        return HomeServlet.class;
    }

    @Override
    public void init() throws ServletException {
        service = new ProductCategoryServiceImpl();
    }

    public String index(HttpServletRequest request,
                        HttpServletResponse response) throws Exception {
        List<ProductCategory> categories = service.queryAllProductCategorylist("0");
        request.setAttribute("categories", categories);

        return "/pre/index";
    }
}
