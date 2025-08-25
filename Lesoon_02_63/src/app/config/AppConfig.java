package app.config;

import app.staff.administration.Director;
import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;
import app.staff.specialists.Secretary;
import app.staff.specialists.productions.MachineOperator;
import app.staff.specialists.productions.StoreKeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

@Configuration
public class AppConfig {

    @Bean
    public Director getDirector() {
        return new Director();
    }

    @Bean
    public ProductionChief  getProductionChief() {
        return new ProductionChief();
    }

    @Bean
    public SalesChief  getSalesChief() {
        return new SalesChief();
    }

    @Bean
    public MachineOperator getMachineOperator() {
        return new MachineOperator();
    }

    @Bean
    public StoreKeeper getStoreKeeper() {
        return new StoreKeeper();
    }

    @Bean
    public Merchandiser getMerchandiser() {
        return new Merchandiser();
    }

    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }

    @Bean
    public Secretary secretary() {
        return new Secretary();
    }




}
