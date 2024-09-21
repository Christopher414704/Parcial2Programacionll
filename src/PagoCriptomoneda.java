public class PagoCriptomoneda implements MetodoPago {
    @Override
    public boolean procesar(double monto) {
        System.out.println("Procesando pago de $" + monto + " con CriptoMonedas");
        return true;
    }

    @Override
    public String obtenerNombre() {
        return "CriptoMoneda";
    }
}