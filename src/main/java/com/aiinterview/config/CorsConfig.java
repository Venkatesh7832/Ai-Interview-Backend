//
package com.aiinterview.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of(
            "http://localhost:5173",
            "https://ai-interview-frontend-ga9f.onrender.com"
        ));

        config.setAllowedMethods(List.of("GET","POST","PUT","DELETE","OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}




//package com.aiinterview.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.web.cors.*;
//import org.springframework.web.filter.CorsFilter;
//
//import java.util.Arrays;
//
//@Configuration
//public class CorsConfig {
//
//    @Value("${cors.allowed-origins}")
//    private String allowedOrigins;
//
//    @Bean
//    public CorsFilter corsFilter() {
//
//        CorsConfiguration config = new CorsConfiguration();
//
//        // ✅ Allow frontend URL (Render + local)
//        config.setAllowedOrigins(Arrays.asList(allowedOrigins.split(",")));
//
//        config.setAllowedMethods(Arrays.asList(
//                "GET", "POST", "PUT", "DELETE", "OPTIONS"
//        ));
//
//        config.setAllowedHeaders(Arrays.asList("*"));
//
//        config.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source =
//                new UrlBasedCorsConfigurationSource();
//
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsFilter(source);
//    }
//}
//
