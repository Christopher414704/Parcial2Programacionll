import java.util.HashMap;
import java.util.Map;

public class ProcesadorPago {
    private Map<String, MetodoPago> metodosPago;

    public ProcesadorPago() {
        this.metodosPago = new HashMap<>();
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        metodosPago.put(metodoPago.obtenerNombre(), metodoPago);
    }

    public boolean realizarPago(String nombreMetodo, double monto) {
        MetodoPago metodoPago = metodosPago.get(nombreMetodo);
        if (metodoPago == null) {
            throw new IllegalArgumentException("Método de pago no soportado: " + nombreMetodo);
        }
        return metodoPago.procesar(monto);
    }

    public boolean existeMetodoPago(String nombreMetodo) {
        return metodosPago.containsKey(nombreMetodo);
    }
}
