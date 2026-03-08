package org.example.ordersystem.order;


//Intefaz de la cual va a depender todo el sistema

public interface PaymentService {

    /**
     * Procesa la orden de pago
     * @param clientId identificador del cliente 
     * @param amount monto a cobrar
     * @return resultado del pago
     */

    PaymentResult processPayment(String clientId, double amount);
    
}
