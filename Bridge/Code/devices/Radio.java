package Bridge.Code.devices;

public class Radio implements Device {
    private boolean encendido = false;
    private int volumen = 30;
    private int canal = 1;

    @Override
    public boolean estaHabilitado() {
        return encendido;
    }

    @Override
    public void habilitar() {
        encendido = true;
    }

    @Override
    public void deshabilitar() {
        encendido = false;
    }

    @Override
    public int getVolumen() {
        return volumen;
    }

    @Override
    public void setVolumen(int volumen) {
        if (volumen > 100) {
            this.volumen = 100;
        } else if (volumen < 0) {
            this.volumen = 0;
        } else {
            this.volumen = volumen;
        }
    }

    @Override
    public int getCanal() {
        return canal;
    }

    @Override
    public void setCanal(int canal) {
        this.canal = canal;
    }

    @Override
    public void imprimirEstado() {
        System.out.println("------------------------------------");
        System.out.println("| Soy una radio.");
        System.out.println("| Estado: " + (encendido ? "encendida/habilitada" : "apagada/deshabilitada"));
        System.out.println("| Volumen actual: " + volumen + "%");
        System.out.println("| Canal actual: " + canal);
        System.out.println("------------------------------------\n");
    }

}
