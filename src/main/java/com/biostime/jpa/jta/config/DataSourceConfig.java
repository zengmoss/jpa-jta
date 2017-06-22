package com.biostime.jpa.jta.config;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class DataSourceConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.oracle")
	public DataSource oracleDataSource() {
		AtomikosDataSourceBean oracleDataSource = new AtomikosDataSourceBean();
		oracleDataSource.setXaDataSource(new DruidXADataSource());
		oracleDataSource.setUniqueResourceName("cdco");
		return oracleDataSource;
	}

	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	public DataSource mysqlDataSource() {
		AtomikosDataSourceBean mysqlDataSource = new AtomikosDataSourceBean();
		mysqlDataSource.setXaDataSource(new DruidXADataSource());
		mysqlDataSource.setUniqueResourceName("cdcm");
		return mysqlDataSource;
	}

	@Bean
	public JdbcTemplate oracleJdbcTemplate() {
		return new JdbcTemplate(oracleDataSource());
	}

	@Bean
	public JdbcTemplate mysqlJdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}

	@Bean(name = "userTransaction")
	public UserTransaction userTransaction() throws Throwable {
		UserTransactionImp userTransactionImp = new UserTransactionImp();
		userTransactionImp.setTransactionTimeout(10000);
		return userTransactionImp;
	}

	@Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
	public TransactionManager atomikosTransactionManager() throws Throwable {
		UserTransactionManager userTransactionManager = new UserTransactionManager();
		userTransactionManager.setForceShutdown(false);
		return userTransactionManager;
	}

	@Bean(name = "transactionManager")
	@DependsOn({ "userTransaction", "atomikosTransactionManager" })
	public PlatformTransactionManager transactionManager() throws Throwable {
		UserTransaction userTransaction = userTransaction();
		TransactionManager atomikosTransactionManager = atomikosTransactionManager();
		return new JtaTransactionManager(userTransaction, atomikosTransactionManager);
	}
	//上面三个都认识，下面说一下这个bean
    @Bean(name = "atomikosJtaPlatfom")
    public AtomikosJtaPlatfom atomikosJtaPlatfom(){
        AtomikosJtaPlatfom atomikosJtaPlatfom = new AtomikosJtaPlatfom();
        try {
            atomikosJtaPlatfom.setTm(atomikosTransactionManager());
            atomikosJtaPlatfom.setUt(userTransaction());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return atomikosJtaPlatfom;

    }
}
