package com.psybooks.psybooksexportingservice.config;

import org.springframework.beans.factory.annotation.Value;

//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
public class SecurityConfig {
    @Value("${expectedAuthToken.business-logic-service}")
    private String expectedAuthToken;


//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//
//        http.exceptionHandling(eh -> eh.authenticationEntryPoint(
//            (request, response, ex) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage())));
//
//
//        http.authorizeHttpRequests(ar -> ar
//            .requestMatchers("/items/rest/**").permitAll());
//
//        http.addFilterBefore(new TokenAuthFilter(expectedAuthToken), SecurityContextHolderFilter.class);
//
//        http.anonymous(AbstractHttpConfigurer::disable);
//
//        return http.build();
//    }
}
