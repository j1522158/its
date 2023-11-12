package com.example.its.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration // コンポーネントスキャンの対象とする
public class PasswordEncoderConfig {

    @Bean // メソッドの戻り値のインスタンスがBean登録されるようになる
    public PasswordEncoder passwordEncoder(){
        // パスワードの保存に適した計算の遅いハッシュ関数
        // ソルト付与, ストレッチングも自動で処理
        return new Pbkdf2PasswordEncoder();
    }
}
