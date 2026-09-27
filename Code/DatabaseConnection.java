public class DatabaseConnection {
    
    private static DatabaseConnection instance;

    private DatabaseConnection(){
        System.out.println("Conexion creada");
    }

    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public void executeQuery(String query){
        System.out.println("Ejecutando consulta:" + query);
    }
}
