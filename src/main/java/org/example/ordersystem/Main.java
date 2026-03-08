package org.example.ordersystem;

import org.example.ordersystem.order.Order;
import org.example.ordersystem.order.OrderSystem;
import org.example.ordersystem.order.PaymentResult;
import org.example.ordersystem.order.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

    /*********************************************** */

        //Metodo temporal que sirve para demostrar el paso 3 no necesario a partir del punto 4
        PaymentService paymentService = new PaymentService() {
           

            @Override
            public PaymentResult processPayment(String clientId, double amount) {
              boolean success=amount>0;
                String codeRandom;
                if(success){
                    codeRandom="TEST-AUTH";
                }else{
                    codeRandom=null;
                }
                return new PaymentResult(success,codeRandom);
            }
        };
        OrderSystem orderSystem = new OrderSystem(paymentService);
//************************************************************* */


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
