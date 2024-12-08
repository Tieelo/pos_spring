package de.tieelo.pos_spring.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.*;

public class ApiKeyFilter extends OncePerRequestFilter {

	private static final String API_KEY_HEADER = "X-API-KEY";
	private static final String VALID_API_KEY = "1234"; // Ersetzen Sie dies durch den tatsächlichen API-Key

	@Override
	protected void doFilterInternal(HttpServletRequest request,
	                                HttpServletResponse response,
	                                FilterChain filterChain) throws ServletException, IOException {


		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
			filterChain.doFilter(request, response);
			return;
		}

		String apiKey = request.getHeader(API_KEY_HEADER);

		if (VALID_API_KEY.equals(apiKey)) {
			// Erstellen Sie ein Authentication-Objekt
			Authentication auth = new UsernamePasswordAuthenticationToken("apiKeyUser", null,
					java.util.Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
			SecurityContextHolder.getContext().setAuthentication(auth);
		} else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		filterChain.doFilter(request, response);
	}
}