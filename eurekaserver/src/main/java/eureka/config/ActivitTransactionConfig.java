package eureka.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ActivitTransactionConfig extends AbstractProcessEngineAutoConfiguration {

	@Autowired
	DataSource activitiDataSource;
	
	@Autowired
	PlatformTransactionManager platformTransactionManager;
	
	@Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
        SpringAsyncExecutor springAsyncExecutor) throws IOException {
		
		
		SpringProcessEngineConfiguration config= this.baseSpringProcessEngineConfiguration(activitiDataSource, platformTransactionManager, springAsyncExecutor);
		config.setProcessDefinitionCacheLimit(1);
		return config;
    }
	
	public static void main(String[] args) {
		switch (11) {
		case 11:
			break;

		default:
			break;
		}
	}
}
