package org.fantasizer.flow.config.properties;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * flowable工作流的的配置
 *
 * @author fengshuonan
 * @date 2017-12-02 23:18
 */
@Configuration
@ConfigurationProperties(prefix = GunsFlowableProperties.GUNS_FLOWABLE_DATASOURCE)
public class GunsFlowableProperties {

    public static final String GUNS_FLOWABLE_DATASOURCE = "guns.flowable.datasource";

    /**
     * 默认多数据源的链接
     */
    private String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/guns_flowable?autoReconnect=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false";

    /**
     * 默认多数据源的数据库账号
     */
    private String username = "root";

    /**
     * 默认多数据源的数据库密码
     */
    private String password = "password";

    public void config(HikariDataSource dataSource) {
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}