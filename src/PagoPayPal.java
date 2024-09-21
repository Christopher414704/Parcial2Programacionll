public class PagoPayPal implements MetodoPago {
    @Override
    public boolean procesar(double monto) {
        System.out.println("Procesando pago de $" + monto + " con PayPal");
        return true;
    }

    @Override
    public String obtenerNombre() {
        return "PayPal";
    }
}