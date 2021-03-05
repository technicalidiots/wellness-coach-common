//package com.dev.wellness.jwt;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.ExpiredJwtException;
//
//@Component
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//	@Autowired
//	JwtTokenUtil jwtTokenUtil;
//
//	@Autowired
//	JwtDetailsService jwtDetailsService;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		final String requestTokenizer = request.getHeader("Authorization");
//
//		String username = null;
//		String token = null;
//
//		if (null != requestTokenizer && requestTokenizer.startsWith("Bearer")) {
//			token = requestTokenizer.substring(7);
//
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(token);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			System.out.println("JWT token does not begin with Bearer String");
//		}
//
//		if (null != username && null == SecurityContextHolder.getContext().getAuthentication()) {
//			UserDetails userDetails = jwtDetailsService.loadUserByUsername(username);
//
//			if (jwtTokenUtil.validateToken(token, userDetails)) {
//				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//						userDetails, null, userDetails.getAuthorities());
//
//				authenticationToken.setDetails(new WebAuthenticationDetails(request));
//
//				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//
//			}
//
//		}
//		filterChain.doFilter(request, response);
//	}
//}
