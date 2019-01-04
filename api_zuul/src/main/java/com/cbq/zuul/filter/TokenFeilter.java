package com.cbq.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 过滤器（请求之前） Pre Post Get 权限拦截   FilterConstants校验常亮的类
 */
@Component
public class TokenFeilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取当前上下文
        RequestContext requestCntext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestCntext.getRequest();

        //从url 的参数获取，也可以从cookie,header获取  在Zuul网关访问服务格式如下 A="不能为空"http://localhost:9000/clienteureka/gets?A=1
        String token = httpServletRequest.getParameter("A");
        if(StringUtils.isEmpty(token)){
            //返回没有权限
            requestCntext.setSendZuulResponse(false);
            //设置 code 值
            requestCntext.setResponseStatusCode(500);
        }
        return null;
    }
}
