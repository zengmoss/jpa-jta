package com.biostime.jpa.jta.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@DependsOn("transactionManager")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryOracle", transactionManagerRef = "transactionManager", basePackages = "com.biostime.jpa.jta.repository.oracle")
public class OracleConfig {
	@Resource
	private DataSource oracleDataSource;
	@Bean
	public JpaVendorAdapter oracleJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.ORACLE);
		return hibernateJpaVendorAdapter;
	}
	@DependsOn({"transactionManager","atomikosJtaPlatfom"})
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryOracle() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(oracleDataSource);
		entityManager.setJpaVendorAdapter(oracleJpaVendorAdapter());
		entityManager.setPackagesToScan("com.biostime.jpa.jta.domain.oracle");
		entityManager.setPersistenceUnitName("oraclePersistenceUnit");
		Properties properties = new Properties();       
        //jta设置
        properties.put("hibernate.current_session_context_class", "jta");
        properties.put("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");
        //这里指定我们自己创建的AtomikosJtaPlatfom
        properties.put("hibernate.transaction.jta.platform","com.biostime.jpa.jta.config.AtomikosJtaPlatfom");
        entityManager.setJpaProperties(properties);

		return entityManager;
    }
	
}
