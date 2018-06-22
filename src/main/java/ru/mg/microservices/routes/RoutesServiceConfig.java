package ru.mg.microservices.routes;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * Конфиг сервиса марштрутов, с компонент сканом и тд
 */
@Configuration
@ComponentScan({"ru.mg.microservices.repository", "ru.mg.microservices.entity"})
@EntityScan("ru.mg.microservices.entity")
@EnableJpaRepositories("ru.mg.microservices.entity")
@PropertySource("classpath:db-router-server-config.properties")
public class RoutesServiceConfig {
        private Logger logger;

        public RoutesServiceConfig() {
            logger = Logger.getLogger(getClass().getName());
        }

    /**
     * Конфигурим датасорс
     * @return датасорс
     */
    @Bean
        public DataSource dataSource() {
            logger.info("dataSource() invoked");

            DataSource dataSource = (new EmbeddedDatabaseBuilder()).build();

            logger.info("dataSource = " + dataSource);

            return dataSource;
        }

}
