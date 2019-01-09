package cn.bdqn.easybuy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @Author: 老鱼
 * @Date: 2019/1/9 14:59
 * @Description:
 */
@WebFilter(filterName = "EncodeFilter",
        urlPatterns = "/*",
        initParams = {@WebInitParam(name = "encode", value = "utf-8")})
public class EncodeFilter implements Filter {
    private String encode = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encode = filterConfig.getInitParameter("encode");
        if (this.encode == null) {
            this.encode = encode;
        }
    }

    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws ServletException, IOException {
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encode);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        encode = null;
    }

}
