package Bridge.Code;

import Bridge.Code.devices.Device;
import Bridge.Code.devices.Radio;
import Bridge.Code.devices.Tv;
import Bridge.Code.remotes.AdvancedRemote;
import Bridge.Code.remotes.BasicRemote;

public class Demo {
    public static void main(String[] args) {
        probarDispositivo(new Tv());
        probarDispositivo(new Radio());
    }

    public static void probarDispositivo(Device dispositivo) {
        System.out.println("Pruebas con el control remoto básico.");
        BasicRemote controlBasico = new BasicRemote(dispositivo);
        controlBasico.alternarEncendido();
        dispositivo.imprimirEstado();

        System.out.println("Pruebas con el control remoto avanzado.");
        AdvancedRemote controlAvanzado = new AdvancedRemote(dispositivo);
        controlAvanzado.alternarEncendido();
        controlAvanzado.silenciar();
        dispositivo.imprimirEstado();
    }
}
