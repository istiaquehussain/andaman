package com.coe.andaman.as.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Profile("dev")
@Configuration
@EnableWebSecurity
public class JWTWebConfig extends BaseWebConfig {
	
	@Value("${app.oauth2.jwt.signing-key}")
	private String SIGNING_KEY;//"as466gf"
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY);
        return converter;
	}
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}
