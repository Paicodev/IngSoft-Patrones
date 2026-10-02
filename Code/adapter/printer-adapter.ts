export {};

// Target: contrato que espera usar el cliente.
interface Printer {
  print(message: string): void;
}

// Adaptee: servicio existente con una operación distinta.
class LegacyPrinter {
  printDocument(document: string): void {
    console.log(`Impresora antigua: ${document}`);
  }
}

// Adapter: adapta el contrato antiguo al contrato esperado por el cliente.
class PrinterAdapter implements Printer {
  constructor(private readonly legacyPrinter: LegacyPrinter) {}

  print(message: string): void {
    this.legacyPrinter.printDocument(message);
  }
}

// Client: depende del contrato Printer y no necesita conocer LegacyPrinter.
class Client {
  printMessage(printer: Printer, message: string): void {
    printer.print(message);
  }
}

// Demo: el cliente usa la impresora antigua a través del adaptador.
const legacyPrinter = new LegacyPrinter();
const printer: Printer = new PrinterAdapter(legacyPrinter);

const client = new Client();
client.printMessage(printer, "Adaptado con el patron Adapter");
