package com.example.second.filter;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @author zhangyu<zhangyu @ cecdat.com>
 * @version v0.1 2020/3/23
 * @class <code>TraceFilter</code>
 * @see
 * @since JDK1.8
 */
@Slf4j
@WebFilter(filterName="traceFilter",urlPatterns= "/*")
public class TraceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 从请求头中获取traceId
        String traceId = request.getHeader("traceId");
        String parentApp = request.getHeader("parentApp");
        // 不存在就生成一个
        if (traceId == null || "".equals(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
        // 放入MDC中
        MDC.put("traceId", traceId);
        if(parentApp != null && !("".equals(parentApp))){
            MDC.put("parentApp",parentApp);
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
