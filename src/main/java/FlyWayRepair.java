import org.flywaydb.core.Flyway;

public class FlyWayRepair {
    public static void main(String[] args) {
        // Configura la instancia de Flyway con la configuración de tu base de datos, usuario y contraseña
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/vollmed_api", "root", "pass")
                .load();

        // Ejecuta la reparación de Flyway
        flyway.repair();
    }
}
