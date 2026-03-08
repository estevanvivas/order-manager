package org.example.ordersystem.order;

import org.example.ordersystem.provider.PaymentProvider;
import org.example.ordersystem.provider.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class OrderSystem {

    private static final Logger log = LoggerFactory.getLogger(OrderSystem.class);

    // ACOPLAMIENTO DIRECTO: instancia concreta del proveedor externo
    //private final PaymentProvider paymentProvider;

    //Acomplamiento al contrato estable
    private final PaymentService paymentService;



    public OrderSystem(PaymentService paymentService) {
        // ACOPLAMIENTO DIRECTO: creación directa del proveedor externo
        // this.paymentProvider = new PaymentProvider();
        // log.debug("Sistema de órdenes iniciado");

        //Creacion directa al servicio de pago
        this.paymentService=paymentService;
     log.debug("Sistema de órdenes iniciado");
    }

    /**
     * Crea una orden y procesa el pago directamente con el proveedor externo.
     *
     * @param clientId identificador del cliente
     * @param amount   monto a cobrar
     * @return la orden con su estado final
     */
    public Order createOrder(UUID clientId, double amount) {
        Order order = new Order(clientId, amount);
        log.info("Creando orden — orderId={}, clientId={}, monto={}", order.getId(), clientId, amount);

        // ACOPLAMIENTO DIRECTO: el sistema principal conoce y usa la firma exacta
        // del proveedor externo: executeTransaction(user, amount, currency)
        log.debug("Invocando proveedor externo — usuario={}, monto={}, moneda=COP", clientId, amount);

       // TransactionResponse response = paymentProvider.executeTransaction(clientId, amount, "COP");

       //LLamada al servicio de pago
       PaymentResult paymentResult = paymentService.processPayment(clientId.toString(), amount);
       



        if (paymentResult.success()) {
            order.setStatus(OrderStatus.APPROVED);
            log.info("Pago aprobado — orderId={}, codigoAutorizacion={}", order.getId(), paymentResult.codeAuthorization());
        } else {
            order.setStatus(OrderStatus.REJECTED);
            log.warn("Pago rechazado — orderId={}, codigoResultado={}", order.getId(), paymentResult.codeAuthorization());
        }

        return order;
    }
}
