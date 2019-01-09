package cn.bdqn.easybuy.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 19:08
 * @Description:
 */
public class PrintUtils {
    private static void print(String msg,HttpServletResponse response){
        PrintWriter writer=null;
        if(null!=response){
            try {
                writer=response.getWriter();
                writer.print(msg);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        }
    }

    public static void write(Object object, HttpServletResponse response){
        //响应的数据类型
        response.setContentType("text/html;charset=utf-8");
        //把数据封装为JSON格式
        String json= JSONObject.toJSONString(object);
        print(json,response);
    }
}
