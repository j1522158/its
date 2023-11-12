package com.example.its.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true) // @PreAuthorizeを有効にする(認可処理)
public class MethodSecurityConfig {
}
