package Bridge.Code.remotes;

import Bridge.Code.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device dispositivo) {
        super.dispositivo = dispositivo;
    }

    public void silenciar() {
        System.out.println("Control remoto: silenciar (mute)");
        dispositivo.setVolumen(0);
    }
}
