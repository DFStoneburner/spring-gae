package stone.spring.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "stone.spring.repositories")
public class PersistenceConfig {

	@Bean
	public PlatformTransactionManager transactionManager() {
		EntityManagerFactory factory = entityManagerFactory();
		return new JpaTransactionManager(factory);
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setPackagesToScan("stone.spring.models");
		factory.setPersistenceUnitName("jpa");
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

		return factory.getObject();
	}
}
