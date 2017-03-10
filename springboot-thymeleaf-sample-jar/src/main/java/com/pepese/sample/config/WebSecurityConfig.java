package com.pepese.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.pepese.sample.service.security.UserDetailsServiceImpl;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// セキュリティ設定を無視するリクエスト設定
		// 静的リソースに対するアクセスはセキュリティ設定を無視する
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認可の設定
		http.authorizeRequests().antMatchers("/login").permitAll() // /loginは全ユーザーアクセス許可
				.anyRequest().authenticated(); // それ他は全て認証無しの場合アクセス不許可、/loginへリダイレクトされる

		// ログイン設定
		http.formLogin().loginProcessingUrl("/login") // 認証処理のパス
				.loginPage("/login") // ログインフォームのパス
				//.failureHandler(new DelegatingAccessDeniedHandler()) // 認証失敗時に呼ばれるハンドラクラス
				.defaultSuccessUrl("/") // 認証成功時の遷移先
				.usernameParameter("username").passwordParameter("password") // ユーザー名、パスワードのパラメータ名
				.and();

		// ログアウト設定
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウト処理のパス
				.logoutSuccessUrl("/login") // ログアウト完了時のパス
				.deleteCookies("JSESSIONID"); // ログアウト完了後Cookieを破棄する
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// ユーザ認証ロジックのサービスを設定する
		auth.userDetailsService(userDetailsService);
				// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
				//.passwordEncoder(new BCryptPasswordEncoder());
	}
}