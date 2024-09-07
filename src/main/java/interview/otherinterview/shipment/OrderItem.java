package interview.otherinterview.shipment;

import java.util.Objects;

public class OrderItem {

    private final int itemId;

    public OrderItem(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return itemId == orderItem.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemId);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                '}';
    }
}
