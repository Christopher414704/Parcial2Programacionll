import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private ProcesadorPago procesadorPago;
    private List<String> metodosDisponibles;

    public Tienda() {
        this.procesadorPago = new ProcesadorPago();
        this.metodosDisponibles = new ArrayList<>();
    }

    public void agregarMetodoPago(MetodoPago metodoPago) {
        procesadorPago.agregarMetodoPago(metodoPago);
        metodosDisponibles.add(metodoPago.obtenerNombre());
    }

    public List<String> obtenerMetodosDisponibles() {
        return new ArrayList<>(metodosDisponibles);
    }

    public boolean procesarCompra(String nombreMetodo, double monto) {
        if (!procesadorPago.existeMetodoPago(nombreMetodo)) {
            System.out.println("Método de pago no disponible: " + nombreMetodo);
            return false;
        }
        System.out.println("Procesando compra de $" + monto + " con " + nombreMetodo);
        return procesadorPago.realizarPago(nombreMetodo, monto);
    }
}