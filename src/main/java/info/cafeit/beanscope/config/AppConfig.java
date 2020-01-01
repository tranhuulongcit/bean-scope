package info.cafeit.beanscope.config;

import info.cafeit.beanscope.bean.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
@PropertySource("classpath:/application.properties")
public class AppConfig {

    @Value("${cafeit.datasource}")
    private String datasource;



    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DataSource dataSourceSingleton() {
        return new DataSource(datasource);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public DataSource dataSourcePrototype() {
        return new DataSource(datasource);
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@RequestScope
    public DataSource dataSourceRequest() {
        return new DataSource(datasource);
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@SessionScope
    public DataSource dataSourceSession() {
        return new DataSource(datasource);
    }

    @Bean
    @Scope(value = "application", proxyMode = ScopedProxyMode.TARGET_CLASS)
    //@ApplicationScope
    public DataSource dataSourceApplication() {
        return new DataSource(datasource);
    }

}
