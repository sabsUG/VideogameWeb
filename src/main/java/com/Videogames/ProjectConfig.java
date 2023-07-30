package com.Videogames;


import java.util.Locale;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;


@Configuration
public class ProjectConfig implements WebMvcConfigurer {
    /* Los siguientes métodos son para incorporar el tema de internacionalización en el proyecto */

    /* localeResolver se utiliza para crear una sesión de cambio de idioma*/
    @Bean
    public org.springframework.web.servlet.LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

 

    /* localeChangeInterceptor se utiliza para crear un interceptor de cambio de idioma*/
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

 

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

 

    //Bean para poder acceder a los Messages.properties en código...
    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/registro/nuevo").setViewName("/registro/nuevo");
 }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/","/index","/errores/**",
                        "/carrito/**","/pruebas/**","/reportes/**",
                        "/register/**","/js/**","/webjars/**", "/styles/**", "/login")
                        .permitAll()
                        
                .requestMatchers(
                        "/product/Videogames2D", "/product/Videogames3D", "/product/AllVideogames", "/product/VideogamesVR", 
                        "/product/LearnDesign2D", "/product/LearnDesign3D", "/product/LearnCsharp", "/product/LearnGamedev", "/product/Shop",
                        "/product/saveVideogame", "/product/save2dCourse",  "/product/save3dCourse",  "/product/savecCourse",  "/product/saveGameCourse", "/product/saveShop",
                        "/product/editVideogame/**", "/product/edit2dCourse/**", "/product/edit3dCourse/**", "/product/editcCourse/**", "/product/editgameCourse/**", "/product/editShop/**",
                        "/product/deleteVideogame/**", "/product/deleteCourse2D/**", "/product/deleteCourse3D/**", "/product/deleteCourseC/**", "/product/deleteCourseGame/**", "/product/deleteShop/**",
                        "/job/listed","/job/new","/job/Designers", "/job/Unity", "/job/FrontEnd", "/job/Ios", "/job/Android",
                        "/job/edit/**","/job/delete/**",
                        "/usuario/nuevo","/usuario/guardar",
                        "/usuario/modificar/**","/usuario/eliminar/**",
                        "/reportes/**",
                        "/update/News"
                ).hasRole("ADMIN")
                        
                .requestMatchers(
                        "/product/Videogames2D", "/product/Videogames3D", "/product/AllVideogames", "/product/VideogamesVR", 
                        "/product/LearnDesign2D", "/product/LearnDesign3D", "/product/LearnCsharp", "/product/LearnGamedev", "/product/Shop",
                        "/job/listed",
                        "/usuario/listado",
                        "/update/News"
                ).hasAnyRole("ADMIN", "VENDEDOR")
                .requestMatchers(
                       
                         "/product/Videogames2D", "/product/Videogames3D", "/product/AllVideogames", "/product/VideogamesVR", 
                        "/product/LearnDesign2D", "/product/LearnDesign3D", "/product/LearnCsharp", "/product/LearnGamedev", "/product/Shop",
                        "/job/listed",
                        "/usuario/listado", 
                        "/update/News"
                )
                .hasRole("USER")
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

/* El siguiente método se utiliza para completar la clase no es 
    realmente funcional, la próxima semana se reemplaza con usuarios de BD */    
    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
                .username("juan")
                .password("{noop}123")
                .roles("USER", "VENDEDOR", "ADMIN")
                .build();
        UserDetails sales = User.builder()
                .username("rebeca")
                .password("{noop}456")
                .roles("USER", "VENDEDOR")
                .build();
        UserDetails user = User.builder()
                .username("pedro")
                .password("{noop}789")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user, sales, admin);
    }
}