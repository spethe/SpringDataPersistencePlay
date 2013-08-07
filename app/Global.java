import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.context.annotation.Configuration;
import play.*;

import org.springframework.context.*;
import org.springframework.context.support.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Global extends GlobalSettings {

    static final String DEFAULT_PERSISTENCE_UNIT = "defaultPersistenceUnit";
    //private ApplicationContext ctx;
    final private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    @Override
    public void onStart(Application app) {
        //ctx = new ClassPathXmlApplicationContext("components.xml");
        super.onStart(app);
        ctx.register(SpringDataJpaConfiguration.class);
        ctx.scan("controllers", "models", "actions", "repo");
        ctx.refresh();

        ctx.start();
    }

    @Override
    public void onStop(final Application app) {
        // This will call any destruction lifecycle methods and then release the beans e.g. @PreDestroy
        ctx.stop();

        super.onStop(app);
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) {
        return ctx.getBean(clazz);
    }
    @Configuration
    @EnableJpaRepositories("repo")
    public static class SpringDataJpaConfiguration {



        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory(DEFAULT_PERSISTENCE_UNIT);
        }

        @Bean
        public HibernateExceptionTranslator hibernateExceptionTranslator() {
            return new HibernateExceptionTranslator();
        }

        @Bean
        public JpaTransactionManager transactionManager() {
            return new JpaTransactionManager();
        }
    }
}
