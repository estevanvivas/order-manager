package org.example.ordersystem.order;

import java.util.UUID;

/**
 * Representa una orden del sistema principal.
 */
public class Order {

    private final UUID id;
    private final UUID clientId;
    private final double amount;
    private OrderStatus status;

    public Order(UUID clientId, double amount) {
        this.id = UUID.randomUUID();
        this.clientId = clientId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public double getAmount() {
        return amount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}