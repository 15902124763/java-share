package com.niki.account.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Description :日志拦截
 * @Author : yarm.yang
 * @Date : 2020/5/9 15:28
*/
public class LogTraceIdInterceptor extends HandlerInterceptorAdapter {
    /**
     * traceId
     */
    private final static String TRACE_ID = "traceId";


    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String traceId = request.getHeader("traceId");
        if(StringUtils.isBlank(traceId)){
            traceId = UUID.randomUUID().toString().replaceAll("-","");
        }
        MDC.put(TRACE_ID, traceId);
        response.setHeader("traceId", traceId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
        // 删除
        MDC.remove(TRACE_ID);
    }
}
