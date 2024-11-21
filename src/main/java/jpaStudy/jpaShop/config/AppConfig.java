package jpaStudy.jpaShop.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"jpaStudy.jpaShop.service", "jpaStudy.jpaShop.repository"})
@EnableJpaRepositories(basePackages = "jpaStudy.jpaShop.repository")
@EnableTransactionManagement
public class AppConfig {/** 스프링 프레임워크 설정 */
    @Bean
    public DataSource dataSource(){//db connection 기능을 관장, db 연결 정보가 담겨있다
        System.out.println("sex");
        DataSource ds = new DataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:jpa-shop");
        ds.setUsername("sa");
        ds.setPassword("");
//        ds.setInitialSize(2); //미리 만들어 놓을 커넥션 개수
//        ds.setMaxActive(10); //활성화 가능한(이용가능한) 커넥션 개수
//        ds.setMaxIdle(10);
//        ds.setTestWhileIdle(true); //유휴 커넥션 검사
//        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); //최소 유휴 시간 3분
//        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); //10초 주기
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource datasource){
        System.out.println("seex");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("jpaStudy.jpaShop.domain");//@Entity가 붙은 클래스를 자동으로 검색하기 위한 시작점 지정
        factory.setDataSource(datasource);
        factory.setJpaProperties(jpaProperties());

        return factory;
    }

    private Properties jpaProperties(){
        Properties properties = new Properties();

        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);
        properties.put("hibernate.use_sql_comments", true);
        properties.put("hibernate.id.new_generator_mappings", true);
        properties.put("hibernate.hbm2ddl.auto", "create");

        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager tm = new JpaTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public static PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


}
