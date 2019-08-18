package com.training.config.security;

import com.training.security.JwtAuthenticationEntryPoint;
import com.training.security.JwtRequestFilter;
import com.training.security.JwtUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


@EnableWebSecurity
@Component
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
//configuracaos de autorizacao
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/auth").permitAll()
                .antMatchers(HttpMethod.GET, "/api/topico").permitAll()
                .antMatchers(HttpMethod.GET, "/api/topico/**").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                /**
                 * o spring já possui um filtro padrao, por isso quando temos de inserir um novo filtro
                 * temos que dizer a ordem dos filtros, como é um filtro para verificar se existe
                 * o token jwt logo ele tem que vir antes do filtro padrao do spring
                 */
                .and().addFilterBefore(this.jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    //configuraçoes de autenticacao
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(this.jwtUserDetailService).passwordEncoder(this.passwordEncoder());
    }

    @Override
//configuracaoes de arquivos estaticos CSS/JS caso o front fosse integrado por exemplo com
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception
    {
        return super.authenticationManager();
    }

    /**
     * esse bean foi criado pq na classe {@link JwtRequestFilter}, como ela
     * é criada fora do conteiner spring não tem como dar um @autowired em nenhuma propiedade
     * que for declarada lá, mas no momento que essa classe é declarada
     * como bean os @autowired passam a funcionar
     *
     */
    @Bean
    public JwtRequestFilter jwtRequestFilter() throws Exception
    {
        return new JwtRequestFilter();
    }
}
