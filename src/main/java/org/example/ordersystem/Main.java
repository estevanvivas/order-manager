package org.example.ordersystem;

import org.example.ordersystem.order.Order;
import org.example.ordersystem.order.OrderSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        OrderSystem orderSystem = new OrderSystem();

        // Caso 1: pago exitoso
        log.info("--- Caso 1: monto válido ---");
        Order order1 = orderSystem.createOrder(UUID.randomUUID(), 150000.0);
        log.info("Resultado: {}", order1);

        // Caso 2: monto inválido
        log.info("--- Caso 2: monto inválido ---");
        Order order2 = orderSystem.createOrder(UUID.randomUUID(), -500.0);
        log.info("Resultado: {}", order2);

        log.info("=== Fin del Paso 1 ===");
    }
}
