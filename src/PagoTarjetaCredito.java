import java.util.Scanner;

public class PagoTarjetaCredito implements MetodoPago {
    @Override
    public boolean procesar(double monto) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el número de tarjeta (16 dígitos): ");
        String numeroTarjeta = scanner.nextLine();

        System.out.print("Introduce el CVV (3 dígitos): ");
        String cvv = scanner.nextLine();

        System.out.print("Introduce la fecha de vencimiento (MM/AA): ");
        String fechaVencimiento = scanner.nextLine();


        if (numeroTarjeta.length() != 16 || cvv.length() != 3 || !fechaVencimiento.matches("\\d{2}/\\d{2}")) {
            System.out.println("Datos de tarjeta incorrectos. Pago fallido.");
            return false;
        }


        System.out.println("Procesando pago de $" + monto + " con Tarjeta de Crédito terminada en " + numeroTarjeta.substring(12));
        return true;
    }

    @Override
    public String obtenerNombre() {
        return "TarjetaCredito";
    }
}
