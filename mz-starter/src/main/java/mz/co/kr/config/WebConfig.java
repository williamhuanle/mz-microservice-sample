package mz.co.kr.config;

import mz.co.kr.adapters.EmployeeJpaAdapterImpl;
import mz.co.kr.domain.services.EmployeeServiceImpl;
import mz.co.kr.ports.api.EmployeeServicePort;
import mz.co.kr.ports.spi.EmployeePersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public EmployeePersistencePort employeePersistence(){
        return new EmployeeJpaAdapterImpl();
    }

    @Bean
    public EmployeeServicePort employeeService(){
        return new EmployeeServiceImpl(employeePersistence());
    }

}
