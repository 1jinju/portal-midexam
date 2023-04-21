package kr.ac.jejunu.portalmidexam.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@Configuration
public class DaoFactory {
    private String className = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost/jeju";
    private String username = "jeju";
    private String password = "jejupw";
    @Bean
    public UserDao userDao() throws ClassNotFoundException {
        UserDao userDao = new UserDao(jdbcContext());
        return userDao;
    }

    @Bean
    public JdbcContext jdbcContext() throws ClassNotFoundException {
        JdbcContext jdbcContext = new JdbcContext(dataSource());
        return jdbcContext;
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
