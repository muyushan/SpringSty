package com.sane.pkg.intercepts;

import com.sane.pkg.exceptions.SessionTimeOutException;
import com.sane.pkg.utils.SessionUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter {
   private org.slf4j.Logger logger= LoggerFactory.getLogger(SessionCheckInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("=============session check=========");
        String requestUrl=request.getRequestURI();

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
            try{
                String loginName= SessionUtil.getCurrentUserInfo(request);
                if(StringUtils.isEmpty(loginName)){

                    throw  new SessionTimeOutException("Session 过期请重新登录");
                }
                return  true;
            }
            catch (Exception ex){
               throw  new SessionTimeOutException(ex.getMessage());
            }

        }
    }

}
