package com.smart.web;

import com.smart.cons.CommonConstant;
import com.smart.domain.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ForumFilter implements Filter {
    private static final String FILTERED_REQUEST = "@@session_context_filtered_request";

    private static final String [] INHERENT_ESCAPE_URLS = {"/index.jsp","index.html", "/login.jsp",
            "/login/doLogin.html","/register.html","/register.jsp","/board/listBoardTopics-","board/listTopicPosts-"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest!=null && servletRequest.getAttribute(FILTERED_REQUEST)!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletRequest.setAttribute(FILTERED_REQUEST,Boolean.TRUE);
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            User userContext = getSessionUser(request);

            if(userContext!=null && isURILogin(request.getRequestURI(),request)){
                String toUrl = request.getRequestURI().toString();
                if(!StringUtils.isEmpty(request.getQueryString())){
                    toUrl += "?" + request.getQueryString();
                }
                request.getSession().setAttribute(CommonConstant.LOGIN_TO_URL,toUrl);
                servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
                return ;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
    }

    private boolean isURILogin(String requestURI, HttpServletRequest request) {
        if (request.getContextPath().equalsIgnoreCase(requestURI)
                || (request.getContextPath() + "/").equalsIgnoreCase(requestURI))
            return true;
        for (String uri : INHERENT_ESCAPE_URLS) {
            if (requestURI != null && requestURI.indexOf(uri) >= 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
