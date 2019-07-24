package br.com.chamae.gameEvent.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LoginServerClientConfig {

    private static final String CHAMAE_CLIENT_ID = "chamae-client";
    private static final String CHAMAE_CLIENT_SECRET = "chamaenoixpraumgame";

    @Bean(name = "login-client-rest-template")
    public RestTemplate buildRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.getMessageConverters().add(new FormHttpMessageConverter());
        BasicAuthorizationInterceptor interceptor = new BasicAuthorizationInterceptor(
        		CHAMAE_CLIENT_ID, CHAMAE_CLIENT_SECRET);
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add(interceptor);
        template.setInterceptors(interceptors);
        return template;
    }

}
