package com.sane.pkg.intercepts;

import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HandlerInterceptor extends HandlerInterceptorAdapter {
    private  String[] allowUrls;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestUrl=request.getRequestURI();
        //检查请求过来的是否是请求白名单中的一个
        for(String url:allowUrls){
            if(requestUrl.endsWith(url)||requestUrl.contains(url)){
                return  true;
            }
        }
        //如果请求中携带有x-requested-with 请求头则说明是ajax请求过来的
        if(request.getHeader("x-requested-with")!=null&&request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){

            try{
                String loginName= SessionUtil.getCurrentUserInfo(request);
                if(StringUtils.isEmpty(loginName)){
                    response.setHeader("sessionstatus", "timeout");
                    response.getWriter().print("timeout");
                    return false;
                }
                return  true;
            }
            catch (Exception ex){
                response.setHeader("sessionstatus", "timeout");
                response.getWriter().print("timeout");
                return  false;
            }
        }else{
            throw new SessionTimeOutException();
        }
    }

}
