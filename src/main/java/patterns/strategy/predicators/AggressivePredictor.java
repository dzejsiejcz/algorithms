package patterns.strategy.predicators;

import patterns.strategy.BuyPredictor;

public class AggressivePredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "[Aggressive predictor] Buy stock of XYZ";
    }
    
}
