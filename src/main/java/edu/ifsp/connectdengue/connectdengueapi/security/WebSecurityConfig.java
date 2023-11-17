package edu.ifsp.connectdengue.connectdengueapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    // Dentro de WebSecurityConfig
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .requiresChannel(channel -> channel.anyRequest().requiresSecure())
            .csrf().disable() // Necessário para permitir acesso ao POST
            .httpBasic(Customizer.withDefaults())
            .authorizeHttpRequests(
                authorize -> authorize.requestMatchers(HttpMethod.DELETE, "/dengue/relatos/remove/{id}").permitAll() //Relato
                                      .requestMatchers(HttpMethod.GET, "/dengue/relatos").permitAll()
                                      .requestMatchers(HttpMethod.GET, "/dengue/relatos/{id}").permitAll()

                                      .requestMatchers(HttpMethod.GET, "/dengueshow/ver").permitAll() //Dengue Show
                                      .requestMatchers(HttpMethod.GET, "/dengue/dengueShow/{id}").permitAll()
                                      .requestMatchers(HttpMethod.DELETE, "/dengueshow/quiz/remove/{id}").permitAll()

                                      .requestMatchers(HttpMethod.GET, "/dengue/sintomas").permitAll() //Sintomas
                                      .requestMatchers(HttpMethod.GET, "/dengue/sintomas/{id}").permitAll()
                                      .requestMatchers(HttpMethod.DELETE, "/dengue/sintomas/remove/{id}").permitAll()

                                      .requestMatchers(HttpMethod.GET, "/dengue/denuncias").permitAll() //Denuncia
                                      .requestMatchers(HttpMethod.GET, "/dengue/denuncias/{id}").permitAll()
                                      .requestMatchers(HttpMethod.DELETE, "/dengue/denuncias/remove/{id}").permitAll()
                                      ) 
            .authorizeHttpRequests(
                authorize -> authorize.requestMatchers(HttpMethod.POST, "/dengue/relatos/inserir").authenticated()
                                    .requestMatchers(HttpMethod.POST, "/dengueshow/inserir").authenticated()
                                    .requestMatchers(HttpMethod.POST, "/dengue/sintomas/inserir").authenticated()
                                    .requestMatchers(HttpMethod.POST, "/dengue/denuncias/inserir").authenticated()
                                    );

        return http.build();
    }

    // Dentro de WebSecurityConfig
    @Bean
    public UserDetailsService userDetailsService() {
         UserDetails user = User.withDefaultPasswordEncoder()
             .username("connectdengue")
             .password("connectdengue")
             .build();

         return new InMemoryUserDetailsManager(user);
     }
}
