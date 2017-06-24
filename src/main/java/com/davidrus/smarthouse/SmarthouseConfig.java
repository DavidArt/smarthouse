package com.davidrus.smarthouse;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

/**
 * Created by david on 22-Jun-17.
 */
@Configuration
@ComponentScan(basePackageClasses = {SmarthouseScannable.class})
public class SmarthouseConfig {
    @Bean
    public Mapper mapper() {
        return new DozerBeanMapper();
    }

    @ConfigurationProperties(prefix = "datasource.mysql")
    @Bean
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("root")
                .password("david")
                .url("jdbc:mysql://localhost:3306/smarthousedb")
                .driverClassName("com.mysql.jdbc.Driver")
                .build();
    }
}
