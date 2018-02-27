package com.iordneto.userCrud.filters;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

import com.iordneto.userCrud.services.AuthenticationService;

@Provider
public class SecurityFilter implements ContainerRequestFilter {

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "secure";
	private final static Logger log = Logger.getLogger(SecurityFilter.class.getName());
	private AuthenticationService authenticationService = new AuthenticationService();

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		log.info("Executando REST request filter");

		if (requestContext.getRequest().getMethod().equals("OPTIONS")) {
			log.info("HTTP Method (OPTIONS) - Detectado!");
			requestContext.abortWith(Response.status(Response.Status.OK).build());
		}

		if (requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
			if (authHeader != null && authHeader.size() > 0) {
				String authToken = authHeader.get(0);
				authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
				String decodedString = Base64.decodeAsString(authToken);
				StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
				String email = tokenizer.nextToken();
				String senha = tokenizer.nextToken();

				if (authenticationService.authenticate(email, senha))
					return;

			}
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource.").type(MediaType.TEXT_PLAIN).build();

			requestContext.abortWith(unauthorizedStatus);

		}

	}

}
