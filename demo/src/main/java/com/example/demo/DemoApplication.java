package com.example.demo;

import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableConfigurationProperties
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        String jdbcURL = "jdbc:h2:file:./data/testdb";
        String dbUser = "sa";
        String dbPassword = "";

        String sqlFilePath = "..\\Binary-7\\demo\\src\\main\\resources\\DatabaseInserter.sql";

        try (Connection conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {

            String sql = new String(Files.readAllBytes(Paths.get(sqlFilePath)));

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (IOException e) {
            System.err.println("Error reading the SQL file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error executing SQL: " + e.getMessage());
        }
    }

    public CommandLineRunner loadData(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection()) {
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("schema.sql"));
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("data.sql"));
            }
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    /*@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

}
