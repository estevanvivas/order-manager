package org.example.ordersystem.provider;


/**
 * DTO que representa la respuesta cruda del proveedor externo de pagos.
 * Esta estructura está bajo control del proveedor y puede cambiar en cualquier momento.
 */
public record TransactionResponse(String sattus, String codeAutorization, long tp) {

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "resultCode='" + sattus + '\'' +
                ", authId='" + codeAutorization + '\'' +
                ", timestamp=" + tp +
                '}';
    }
}