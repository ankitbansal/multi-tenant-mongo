package com.demo.multitenant.mongodb.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class TenantContextFilter extends OncePerRequestFilter {

	public static final String TENANT_NAME = "X-TENANT-NAME";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tenantName = request.getHeader(TENANT_NAME);
		RequestContextHolder.getRequestAttributes().setAttribute("tenantName", tenantName,
				RequestAttributes.SCOPE_REQUEST);
		filterChain.doFilter(request, response);
	}

}
