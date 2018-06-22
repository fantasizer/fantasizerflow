package org.fantasizer.flow.config;

import com.zaxxer.hikari.HikariDataSource;
import org.fantasizer.flow.core.datasource.HikariProperties;
import org.fantasizer.flow.core.flowable.GunsDefaultProcessDiagramGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.fantasizer.flow.config.properties.GunsFlowableProperties;

/**
 * 工作流配置
 *
 * @author fengshuonan
 * @date 2017-12-02 22:28
 */
@Configuration
public class FlowableConfig implements EngineConfigurationConfigurer<SpringProcessEngineConfiguration> {
    @Autowired
    HikariProperties hikariProperties;

    @Autowired
    GunsFlowableProperties gunsFlowableProperties;

    /**
     * flowable单独的数据源
     */
    private HikariDataSource flowableDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        hikariProperties.config(dataSource);
        gunsFlowableProperties.config(dataSource);
        return dataSource;
    }

    @Override
    public void configure(SpringProcessEngineConfiguration configuration) {
        configuration.setDataSource(this.flowableDataSource());
        configuration.setActivityFontName("宋体");
        configuration.setLabelFontName("宋体");
        configuration.setProcessDiagramGenerator(new GunsDefaultProcessDiagramGenerator());
    }
}
