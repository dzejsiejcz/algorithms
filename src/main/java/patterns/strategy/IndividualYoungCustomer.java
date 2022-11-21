package patterns.strategy;

import patterns.strategy.predicators.AggressivePredictor;

public class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        this.buyPredictor = new AggressivePredictor();
    }
    
}
