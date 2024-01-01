package com.example.its.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * SpringSecurityの設定クラス
 */
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // for h2-console 本番では消してよし
        http
                .authorizeRequests().antMatchers("/h2-console/**").permitAll() // 開発用 localhost8080でh2-consoleにアクセスする用
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**") //
                .and()
                .headers().frameOptions().disable(); // ヘッダーのフレームオプションを無効化

        http
                .authorizeRequests()
                .mvcMatchers("/login/**").permitAll()
                .mvcMatchers("/users/**").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()// フォーム認証
                //.usernameParameter("") キー名を変更する場合
                //.passwordParameter("") キー名を変更する場合
                .loginPage("/login"); // /loginは認証不要
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}