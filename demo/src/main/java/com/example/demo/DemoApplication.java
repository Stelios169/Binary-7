/*
 * Copyright 2024-2025 Binary 7
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo;

import java.sql.Statement;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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

            String checkQuery = "SELECT COUNT(*) FROM Progr.Restaurant WHERE restaurant_id = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, 1);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                stmt.executeUpdate(sql);
            }

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
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    @Bean 
    public String spoonacularApiKey() {         
        return "your-dummy-api-key"; 
    }
}
