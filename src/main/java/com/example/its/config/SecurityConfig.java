package com.example.its.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor //lombok
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // @RequiredArgsConstructorでfinalかつ初期化されていない値がコンストラクタとして生成される
    // CustomUserDetailsServiceクラスが代入される
    private final UserDetailsService userDetailsService;
    // PasswordEncoderConfigクラスで指定したPasswordEncoderを取得
    private final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // h2-console利用時に許可する設定
//        http
//                .authorizeRequests().antMatchers("/h2-console/**").permitAll()
//                .and()
//                .csrf().ignoringAntMatchers("/h2-console/**")
//                .and()
//                .headers().frameOptions().disable();
//
//        http
//                .authorizeRequests()
//                .mvcMatchers("/users/**").hasAuthority("ADMIN") // 「users以下はADMIN権限のみ」をSpringへ伝える
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                //.usernameParameter("aaa") デフォルトパラメータから変更したい場合はここに記載
//                //.passwordParameter("bbb")
//                .loginPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
}