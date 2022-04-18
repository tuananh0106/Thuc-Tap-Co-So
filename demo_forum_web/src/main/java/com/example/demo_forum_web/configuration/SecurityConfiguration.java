package com.example.demo_forum_web.configuration;

import com.example.demo_forum_web.reponsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final UserRepository userReponsitory;

    @Bean
    public UserDetailsService userDetailsService(){
        return super.userDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

    @Bean
    public DaoAuthenticationProvider authProvider(){//bước này là bảo mật
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Autowired
    public SecurityConfiguration(UserRepository userRepository) {
        this.userReponsitory = userRepository;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/login","/register")
                .permitAll()//những trang / /login /register thực hiện vào không cần đăng nhập
                .anyRequest()
                .authenticated()//những trang còn lại phải được thực hiện khi đã login
                .and()
                .formLogin()
                .loginPage("/login")//thay đổi trang login từ default của Security thành login thường
                .defaultSuccessUrl("/profile")//login thành công chuyền về profile
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.authenticationProvider(authProvider());
        authenticationManagerBuilder.userDetailsService(userReponsitory::getUserByUsername);
    }
}
