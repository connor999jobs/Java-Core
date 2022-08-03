package com.my.collections.sortedMap.example1;

public class OrderLineId implements Comparable<OrderLineId>{
    private int orderId;
    private int line;

    public OrderLineId(int orderId, int line) {
        this.orderId = orderId;
        this.line = line;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public int compareTo(OrderLineId o) {
        if (o == null)
            return 1;

        if (this.orderId != o.orderId)
            return this.orderId - o.orderId;

        return this.line - o.line;
    }
}
