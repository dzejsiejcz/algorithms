package patterns.strategy.predicators;

import patterns.strategy.BuyPredictor;

public class ConservativePredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "[Conservative predictor] Buy debentures of XYZ";
    }
    
}
