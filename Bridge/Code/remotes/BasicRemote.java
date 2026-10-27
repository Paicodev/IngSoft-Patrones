package Bridge.Code.remotes;

import Bridge.Code.devices.Device;

public class BasicRemote implements Remote {
    protected Device dispositivo;

    public BasicRemote() {}

    public BasicRemote(Device dispositivo) {
        // Este campo es el PUENTE hacia la jerarquía de dispositivos:
        this.dispositivo = dispositivo;
    }

    @Override
    public void alternarEncendido() {
        System.out.println("Control remoto: botón de encendido presionado");
        // La abstracción traduce una intención de alto nivel 
        // a llamadas primitivas del dispositivo:
        if (dispositivo.estaHabilitado()) {
            dispositivo.deshabilitar();
        } else {
            dispositivo.habilitar();
        }
    }

    @Override
    public void bajarVolumen() {
        System.out.println("Control remoto: bajar volumen");
        dispositivo.setVolumen(dispositivo.getVolumen() - 10);
    }

    @Override
    public void subirVolumen() {
        System.out.println("Control remoto: subir volumen");
        dispositivo.setVolumen(dispositivo.getVolumen() + 10);
    }

    @Override
    public void bajarCanal() {
        System.out.println("Control remoto: bajar canal");
        dispositivo.setCanal(dispositivo.getCanal() - 1);
    }

    @Override
    public void subirCanal() {
        System.out.println("Control remoto: subir canal");
        dispositivo.setCanal(dispositivo.getCanal() + 1);
    }
}
