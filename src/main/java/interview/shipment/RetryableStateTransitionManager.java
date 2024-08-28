package interview.shipment;

import java.util.Map;

public class RetryableStateTransitionManager extends StateTransitionManager{

    //State1 on Event1 | Max allowed count

    Map<State, Map<Event, Integer>> retryConfiguration;
}
