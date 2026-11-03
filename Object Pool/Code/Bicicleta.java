public class Bicicleta {
    private final int numero;
    private String socio;
    private int resistencia = 1;                   // nivel de 1 a 10

    public Bicicleta(int numero) { this.numero = numero; }

    public void asignar(String socio) {
        this.socio = socio;
        System.out.println("Bicicleta #" + numero + " asignada a " + socio
                + " (resistencia " + resistencia + ")");
    }

    public void setResistencia(int nivel) {
        this.resistencia = nivel;
        System.out.println("  " + socio + " sube la resistencia a " + nivel);
    }

    public void limpiar() {                        // se reinicia antes de reutilizarse
        this.socio = null;
        this.resistencia = 1;
    }

    public int getNumero() { return numero; }
}