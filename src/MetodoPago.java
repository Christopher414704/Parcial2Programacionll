public interface MetodoPago {
    boolean procesar(double monto);
    String obtenerNombre();
}
