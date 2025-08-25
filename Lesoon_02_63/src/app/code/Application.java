package app.code;

import app.staff.administration.Director;
import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;
import app.staff.specialists.Secretary;
import app.staff.specialists.productions.MachineOperator;
import app.staff.specialists.productions.StoreKeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

public class Application {

    public static void main(String[] args) {

        MachineOperator machineOperator = new MachineOperator();
        StoreKeeper storeKeeper = new StoreKeeper();

        Merchandiser merchandiser = new Merchandiser();
        SalesManager salesManager = new SalesManager();
        Secretary secretary = new Secretary();

        ProductionChief productionChief = new ProductionChief();
        productionChief.setMachineOperator(machineOperator);
        productionChief.setStoreKeeper(storeKeeper);

        SalesChief salesChief = new SalesChief();
        salesChief.setMerchandiser(merchandiser);
        salesChief.setSalesManager(salesManager);

        Director director = new Director();
        director.setSecretary(secretary);
        director.setProductionChief(productionChief);
        director.setSalesChief(salesChief);

        director.manageCompany();



    }
}
