import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tienda tienda = new Tienda();
        Scanner scanner = new Scanner(System.in);

        // Aqui es donde pueden agregarse los metodos de pago (Agregar nuevos)
        tienda.agregarMetodoPago(new PagoPayPal());
        tienda.agregarMetodoPago(new PagoCriptomoneda());
        tienda.agregarMetodoPago(new PagoTarjetaCredito());
        tienda.agregarMetodoPago(new PagoTransferenciaBancaria());


        System.out.println("Métodos de pago disponibles: " + tienda.obtenerMetodosDisponibles());

        // Aqui crea un Bucle Repetitio donde pregunta al cliente el nombre del Metodo de Pago
        // Posteriormente Despues de elegir el Metodo de pago y monto, finalizaras la compra
        // Posteriormente repetira si desea pagar con otro metodo de pago.

        while (true) {

            System.out.print("Elige un método de pago (o escribe 'salir' para terminar): ");
            String nombreMetodo = scanner.nextLine();


            if (nombreMetodo.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del sistema...");
                break;
            }


            System.out.print("Introduce el monto a pagar: ");
            double monto;
            try {
                monto = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Monto inválido, intenta nuevamente.");
                continue;
            }


            boolean resultado = tienda.procesarCompra(nombreMetodo, monto);
            if (resultado) {
                System.out.println("Pago procesado con éxito.\n");
            } else {
                System.out.println("Fallo en el procesamiento del pago.\n");
            }
        }

        scanner.close();
    }
}
