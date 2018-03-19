package com.mds.filter;


import com.mds.common.WebConstants;
import com.mds.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-5-15
 * Time: 下午10:13
 * To change this template use File | Settings | File Templates.
 */
public class LoginFilter implements Filter {

    protected FilterConfig filterConfig;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String disableTestFilter = filterConfig.getInitParameter("disableTestFilter");
        if("N".equals(disableTestFilter)){ //不启用过来器
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        // 判断是否是http请求
        if (!(servletRequest instanceof HttpServletRequest)|| !(servletResponse instanceof HttpServletResponse)) {
            throw new ServletException(
                    "OncePerRequestFilter just supports HTTP requests");
        }
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpRequest.getSession(true);
        System.out.println("sessionId:"+session.getId());
        String url = httpRequest.getRequestURI(); //访问的链接

        //登录相关的请求不进行过滤
        String noFilterUrl = filterConfig.getInitParameter("noFilterUrl"); //重定向url
        System.out.println(url);
        if(noFilterUrl.indexOf(url) > -1){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        String redirectUrl = filterConfig.getInitParameter("redirectUrl"); //重定向url
        //验证用户登录
        User user = (User)session.getAttribute(WebConstants.CURRENT_USER);
        if(user == null){  //用户未登录
            ((HttpServletResponse) servletResponse).sendRedirect(redirectUrl);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
