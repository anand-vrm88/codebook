package interview.otherinterview.shipment;

public class ShipmentDemo {

    public static void main(String[] args) {
        StateTransitionManager stateTransitionManager = buildStateTransitionManager();

        ShipmentManager shipmentManager = new ShipmentManager(stateTransitionManager);

        OrderItem orderItem1 = new OrderItem(12);
        OrderItem orderItem2 = new OrderItem(13);

        shipmentManager.placeOrder(orderItem1);
        shipmentManager.placeOrder(orderItem2);

        shipmentManager.packOrder(orderItem1);
        shipmentManager.pickOrder(orderItem1);
        shipmentManager.shipOrder(orderItem1);
        shipmentManager.deliveredOrder(orderItem1);

        shipmentManager.packOrder(orderItem2);
        shipmentManager.pickOrder(orderItem2);
        shipmentManager.shipOrder(orderItem2);

        //shipmentManager.inTransitOrder(orderItem1);
        //shipmentManager.outForDeliveryOrder(orderItem1);

        shipmentManager.inTransitOrder(orderItem2);
        shipmentManager.outForDeliveryOrder(orderItem2);
        shipmentManager.deliveredOrder(orderItem2);
    }

    private static StateTransitionManager buildStateTransitionManager() {
        StateTransitionManager stateTransitionManager = new StateTransitionManager();
        stateTransitionManager.configureStateTransition(State.ORDER_PLACED, Event.PACKED, State.ORDER_PACKED);
        stateTransitionManager.configureStateTransition(State.ORDER_PACKED, Event.PICKED_UP, State.ORDER_PICKED_UP);
        stateTransitionManager.configureStateTransition(State.ORDER_PICKED_UP, Event.SHIPPED, State.ORDER_SHIPPED);
        stateTransitionManager.configureStateTransition(State.ORDER_SHIPPED, Event.IN_TRANSIT, State.ORDER_IN_TRANSIT);
        stateTransitionManager.configureStateTransition(State.ORDER_SHIPPED, Event.DELIVERED, State.ORDER_DELIVERED);
        stateTransitionManager.configureStateTransition(State.ORDER_IN_TRANSIT, Event.OUT_FOR_DELIVERY, State.ORDER_OUT_FOR_DELIVERY);
        stateTransitionManager.configureStateTransition(State.ORDER_OUT_FOR_DELIVERY, Event.DELIVERED, State.ORDER_DELIVERED);
        return stateTransitionManager;
    }
}
