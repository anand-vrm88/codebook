package interview.shipment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StateTransitionManager {

    private final Map<State, Map<Event, State>> stateTransitionConfiguration;

    public StateTransitionManager() {
        this.stateTransitionConfiguration = new HashMap<>();
    }

    public void configureStateTransition(State startState, Event event, State nextState) {
        Map<Event, State> transitionMap = this.stateTransitionConfiguration.getOrDefault(startState, new HashMap<>());
        transitionMap.put(event, nextState);
        this.stateTransitionConfiguration.put(startState, transitionMap);
    }

    public State nextStateOnTransition(State startState, Event event) {
        Map<Event, State> eventStateMap = this.stateTransitionConfiguration.get(startState);
        if (Objects.isNull(eventStateMap) || eventStateMap.isEmpty() || Objects.isNull(eventStateMap.get(event))) {
            throw new IllegalArgumentException(String.format("Can't transit state from %s based on event %s", startState, event));
        }
        return eventStateMap.get(event);
    }
}






