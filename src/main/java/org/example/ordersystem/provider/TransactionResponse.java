package org.example.ordersystem.provider;


/**
 * DTO que representa la respuesta cruda del proveedor externo de pagos.
 * Esta estructura está bajo control del proveedor y puede cambiar en cualquier momento.
 */
public record TransactionResponse(String resultCode, String authId, long timestamp) {

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "resultCode='" + resultCode + '\'' +
                ", authId='" + authId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}