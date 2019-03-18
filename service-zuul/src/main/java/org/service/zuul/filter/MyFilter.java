package org.service.zuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * Zuul的过滤,做安全验证等
 * 
 * 
 */
@Component
public class MyFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);

	/**
	 * shouldFilter()这里可以写逻辑判断，是否要过滤，这里返回true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 过滤器的具体逻辑。可用很复杂，包括查sql,nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() throws ZuulException {

		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		String accessToken = request.getParameter("token");
		if (accessToken == null) {
			logger.warn("token 为空!");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token 为空!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		logger.info("通过!");
		return null;
	}

	/**
	 * filterType()返回一个字符串代表过滤器的类型 在zuul中定义了四种不同生命周期的过滤器类型: pre: 路由之前 routing: 路由之时
	 * post: 路由之后 error: 发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filterOrder()过滤的顺序
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}
