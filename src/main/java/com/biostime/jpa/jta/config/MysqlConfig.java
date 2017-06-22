package com.biostime.jpa.jta.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@DependsOn("transactionManager")
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryMysql", transactionManagerRef = "transactionManager", basePackages = "com.biostime.jpa.jta.repository.mysql")
public class MysqlConfig {
	@Resource
	private DataSource mysqlDataSource;
	@Primary
	@Bean
	public JpaVendorAdapter mysqlJpaVendorAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
		return hibernateJpaVendorAdapter;
	}
	@DependsOn({"transactionManager","atomikosJtaPlatfom"})
	@Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryMysql() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setJtaDataSource(mysqlDataSource);
		entityManager.setJpaVendorAdapter(mysqlJpaVendorAdapter());
		entityManager.setPackagesToScan("com.biostime.jpa.jta.domain.mysql");
		entityManager.setPersistenceUnitName("mysqlPersistenceUnit");
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
