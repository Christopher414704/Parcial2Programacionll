import java.util.Scanner;

public class PagoTransferenciaBancaria implements MetodoPago {
    @Override
    public boolean procesar(double monto) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduce el número de cuenta bancaria (20 dígitos): ");
        String numeroCuenta = scanner.nextLine();


        if (numeroCuenta.length() != 20) {
            System.out.println("Número de cuenta incorrecto. Pago fallido.");
            return false;
        }

        System.out.println("Iniciando transferencia bancaria de $" + monto + " a la cuenta " + numeroCuenta);
        System.out.println("Esperando confirmación manual...");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.print("¿La transferencia fue completada correctamente? (escribe 'si' para confirmar): ");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("si")) {
            System.out.println("Transferencia bancaria a la cuenta " + numeroCuenta + " confirmada");
            return true;
        } else {
            System.out.println("Transferencia bancaria fallida o cancelada");
            return false;
        }
    }

    @Override
    public String obtenerNombre() {
        return "TransferenciaBancaria";
    }
}
