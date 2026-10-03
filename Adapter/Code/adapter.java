// Target: contrato que espera usar el cliente.
interface Printer {
    void print(String message);
}

// Adaptee: servicio existente con una operación distinta.
class LegacyPrinter {
    void printDocument(String document) {
        System.out.println("Impresora antigua: " + document);
    }
}

// Adapter: adapta el contrato antiguo al contrato esperado por el cliente.
class PrinterAdapter implements Printer {
    private final LegacyPrinter legacyPrinter;

    PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print(String message) {
        legacyPrinter.printDocument(message);
    }
}

// Client: depende del contrato Printer, no de LegacyPrinter.
class Client {
    void printMessage(Printer printer, String message) {
        printer.print(message);
    }
}

// Main de demostración.
public class adapter {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer printer = new PrinterAdapter(legacyPrinter);

        Client client = new Client();
        client.printMessage(printer, "Adaptado con el patron Adapter");
    }
}
