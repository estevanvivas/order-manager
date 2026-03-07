package org.example.ordersystem.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.UUID;

public class PaymentProvider {

    private static final Logger log = LoggerFactory.getLogger(PaymentProvider.class);

    /**
     * Procesa una transacción usando la interfaz propia del proveedor.
     *
     * @param user     identificador del usuario en el sistema del proveedor
     * @param amount   monto de la transacción
     * @param currency moneda de la transacción (ISO 4217)
     * @return respuesta del proveedor con estructura propia
     */
    public TransactionResponse executeTransaction(UUID user, double amount, String currency) {
        log.debug("Proveedor externo: iniciando transacción — usuario={}, monto={}, moneda={}",
                user, amount, currency);

        // Simula validación básica del proveedor
        if (amount <= 0) {
            log.warn("Proveedor externo: monto inválido recibido — monto={}", amount);
            return new TransactionResponse("FAILED", null, Instant.now().toEpochMilli());
        }

        String authId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        long timestamp = Instant.now().toEpochMilli();

        log.info("Proveedor externo: transacción aprobada — authId={}, timestamp={}", authId, timestamp);
        return new TransactionResponse("00", authId, timestamp);
    }
}