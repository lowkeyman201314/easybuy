package cn.bdqn.easybuy.web;

import cn.bdqn.easybuy.util.EmptyUtils;
import cn.bdqn.easybuy.util.PrintUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 18:43
 * @Description:
 */
@WebServlet(name = "AbstractServlet")
public abstract class AbstractServlet extends HttpServlet {
    //
    public abstract Class getServletClass();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询字符串的名字
        String action = request.getParameter("action");
        //参数值为处理某个请求的方法名称
        Method method = null;
        //返回结果
        Object result = null;
        if (EmptyUtils.isEmpty(action)) {
            //如果参数为空，返回首页
            result = execute();
        } else {
            try {
                method = getServletClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
                //调用方法，返回结果:this(继承了抽象类的子类的实例对象)
                result = method.invoke(this, request, response);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void init() throws ServletException {

    }

    /**
     * 返回首页的方法
     *
     * @return
     */
    public Object execute() {
        return "/pre/index";
    }

    /**
     * 返回结果的方法
     * @param request
     * @param response
     * @param result
     * @throws Exception
     */
    protected void toView(HttpServletRequest request,
                          HttpServletResponse response,
                          Object result) throws Exception {
        if (!EmptyUtils.isEmpty(result)) {
            //如果返回结果是String
            if (result instanceof String) {
                //拼接成一个jsp文件的名称
                String viewName=result.toString()+".jsp";
                request.getRequestDispatcher(viewName).forward(request,response);
            }else{
                PrintUtils.write(result,response);
            }
        }
    }
}
