import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class Test {
    private static final String URL = "jdbc:postgresql://localhost:5432/TestPostgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String QRY = "SELECT * FROM Comune";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                preparedStatement = connection.prepareStatement(QRY);
                resultSet = preparedStatement.executeQuery();

                while(resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String regione = resultSet.getString("regione");
                    System.out.println("Comune: " + nome + " - Regione: " + regione);
                }
            } catch (SQLException sqlE) {
                System.out.println("Impossibile connettersi al DB: " + sqlE.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Impossibile trovare il driver JDBC: " + e.getMessage());
        } finally {
            try {
                if(resultSet != null)
                    resultSet.close();
                if(preparedStatement != null)
                    preparedStatement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException sqlE) {
                System.out.println("Impossibile chiudere il DB: " + sqlE.getMessage());
            }
        }

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        Utente utente = new Utente();
        utente.setPassword("Password");
        utente.setUsername("Username");
        manager.persist(utente);

        manager.getTransaction().commit();
    }
}
