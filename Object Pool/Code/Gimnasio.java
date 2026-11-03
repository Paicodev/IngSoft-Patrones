public class Gimnasio {
    public static void main(String[] args) {
        PoolBicicletas pool = new PoolBicicletas(2);

        Bicicleta bAna = pool.obtener();
        bAna.asignar("Ana");
        bAna.setResistencia(8);
        Bicicleta bBeto = pool.obtener();
        bBeto.asignar("Beto");

        try {
            pool.obtener();                        // ya no quedan
        } catch (IllegalStateException e) {
            System.out.println("Carla espera: " + e.getMessage());
        }

        pool.devolver(bAna);                       // Ana termina su clase
        Bicicleta bCarla = pool.obtener();         // se reutiliza la misma bicicleta
        bCarla.asignar("Carla");                   // llega con la resistencia reiniciada
        System.out.println("Disponibles: " + pool.cantidadDisponibles());   // 0
    }
}
