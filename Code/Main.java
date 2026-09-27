public class Main {

    public static void main(String[] args){

        DatabaseConnection db1 = DatabaseConnection.getInstance();

        db1.executeQuery("SELECT * FROM usuarios");

        DatabaseConnection db2 = DatabaseConnection.getInstance();

        db1.executeQuery("SELECT * FROM productos");


        System.out.println("Ambas variables hacen referencia a la misma instancia?" + (db1 == db2));
    }
}