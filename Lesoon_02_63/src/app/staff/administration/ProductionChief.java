package app.staff.administration;

import app.staff.specialists.productions.MachineOperator;
import app.staff.specialists.productions.StoreKeeper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2025
 */

public class ProductionChief {

    @Autowired
    private MachineOperator machineOperator;
    @Autowired
    private StoreKeeper storeKeeper;

    public void giveOrders() {
        machineOperator.work();
        storeKeeper.work();
    }

    public MachineOperator getMachineOperator() {
        return machineOperator;
    }

    public void setMachineOperator(MachineOperator machineOperator) {
        this.machineOperator = machineOperator;
    }

    public StoreKeeper getStoreKeeper() {
        return storeKeeper;
    }

    public void setStoreKeeper(StoreKeeper storeKeeper) {
        this.storeKeeper = storeKeeper;
    }
}
