package com.psybooks.psybooksexportingservice.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class TokenAuthFilter {//extends OncePerRequestFilter {
    private final String expectedAuthToken;

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var authHeader = request.getHeader(AUTHORIZATION);
//        if (isBlank(authHeader) || !authHeader.startsWith("Bearer ")) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Missing Bearer authorization");
//            return;
//        }
//
//        var expected = "Bearer " + expectedAuthToken;
//        if (!Objects.equals(expected, authHeader)) {
//            response.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid token");
//            return;
//        }
//
//        var authentication = new UsernamePasswordAuthenticationToken("Bussiness-logic-service", null, new ArrayList<>());
//        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        try {
//            filterChain.doFilter(request, response);
//        } catch (Exception e) {
//            log.warn("Failed API request [" + request.getRequestURI() + "]", e);
//            response.sendError(500, e.getMessage());
//        }
//    }
}
