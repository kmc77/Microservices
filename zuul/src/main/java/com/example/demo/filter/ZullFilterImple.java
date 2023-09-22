package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZullFilterImple extends ZuulFilter {
	
	private static final Logger logger = LoggerFactory.getLogger(ZullFilterImple.class);
	//필터로 사용하겠다고 설정
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public Object run() throws ZuulException {
		logger.info("======== Object run()1 ========");
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		logger.info(request.getRequestURI());
		logger.info("======== Object run()2 ========");
		
		return null;
	}


	@Override
	//필터의 타입을 정의하는 메서드입니다.
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; //사전 라우팅 필터링을 위한 "pre"
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1; //작은 값이 우선권을 가집니다.
	}

}
