public class Main {

    public static void main(String[] args) {

        Boton boton = new Boton();

        ObservadorBoton guardar = new GuardarObservador();
        ObservadorBoton sonido = new SonidoObservador();
        ObservadorBoton registro = new RegistroObservador();

        boton.agregarObservador(guardar);
        boton.agregarObservador(sonido);
        boton.agregarObservador(registro);

        boton.click();
    }
}