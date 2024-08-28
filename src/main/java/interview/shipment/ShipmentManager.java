package interview.shipment;

import java.util.HashMap;
import java.util.Map;

public class ShipmentManager {
    private final StateTransitionManager stateTransitionManager;

    private final Map<OrderItem, State> orderStatus;

    public ShipmentManager(StateTransitionManager stateTransitionManager) {
        this.stateTransitionManager = stateTransitionManager;
        this.orderStatus = new HashMap<>();
    }

    public void placeOrder(OrderItem orderItem) {
        orderStatus.put(orderItem, State.ORDER_PLACED);
        System.out.printf("%s is placed\n", orderItem);
    }

    public void packOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.PACKED);
    }

    public void pickOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.PICKED_UP);
    }

    public void shipOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.SHIPPED);
    }

    public void inTransitOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.IN_TRANSIT);
    }

    public void outForDeliveryOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.OUT_FOR_DELIVERY);
    }

    public void deliveredOrder(OrderItem orderItem){
        updateOrder(orderItem, Event.DELIVERED);
    }

    private void updateOrder(OrderItem orderItem, Event event) {
        State currrentState = orderStatus.get(orderItem);
        State nextState = stateTransitionManager.nextStateOnTransition(currrentState, event);
        //orderItem.getRetryCount();
        //State nextState = retryStateTransitionManager.nextStateOnTransition(currentState, event, currentRetryCount);
        //orderItem.incrementRetryCount();
        orderStatus.put(orderItem, nextState);
        System.out.printf("%s in %s moved to %s \n", orderItem, currrentState, nextState);
    }
}
