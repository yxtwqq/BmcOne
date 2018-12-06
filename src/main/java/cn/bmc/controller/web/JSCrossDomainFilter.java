package cn.bmc.controller.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决js跨域问题
 * @author
 *
 */
@WebFilter(filterName = "JSCrossDomainFilter",urlPatterns = "/*")
public class JSCrossDomainFilter implements Filter {

    private String accessControlAllowOrigin;

    private String accessControlAllowHeaders;

    private String accessControlAllowMethods;

    private String accessControlMaxAge;

    @Override
    public void init(FilterConfig config) throws ServletException {
        //使用"*"表示允许所有域名的脚本访问该资源
        accessControlAllowOrigin="*";
        //表示实际请求中允许携带的首部字段
        accessControlAllowHeaders="Authentication,Origin, X-Requested-With, Content-Type, Accept, No-Cache,Pragma,Last-Modified, Cache-Control, Expires, X-E4M-With,token";
        //设置允许的请求方式
        accessControlAllowMethods="GET, POST, HEAD, PUT, DELETE";
        //用来指定本次预检请求的有效期
        accessControlMaxAge="0";
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin",accessControlAllowOrigin);
        response.setHeader("Access-Control-Allow-Headers",accessControlAllowHeaders );
        response.setHeader("Access-Control-Allow-Methods", accessControlAllowMethods);
        response.setHeader("Access-Control-Max-Age", accessControlMaxAge);
        //针对ie8跨域请求处理
        response.setHeader("XDomainRequestAllowed", "1");
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}
