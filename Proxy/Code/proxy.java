interface Imagen {
    void mostrar();
}

class ImagenReal implements Imagen {
    private final String archivo;

    ImagenReal(String archivo) {
        this.archivo = archivo;
        System.out.println("Cargando " + archivo);
    }

    @Override
    public void mostrar() {
        System.out.println("Mostrando " + archivo);
    }
}

// Proxy virtual: crea la imagen real solo cuando se necesita.
class ImagenProxy implements Imagen {
    private final String archivo;
    private ImagenReal imagenReal;

    ImagenProxy(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void mostrar() {
        if (imagenReal == null) {
            imagenReal = new ImagenReal(archivo);
        }
        imagenReal.mostrar();
    }
}

public class proxy {
    public static void main(String[] args) {
        Imagen imagen = new ImagenProxy("foto.png");
        System.out.println("Proxy creado: la imagen todavia no se cargo.");
        imagen.mostrar();
        imagen.mostrar();
    }
}
