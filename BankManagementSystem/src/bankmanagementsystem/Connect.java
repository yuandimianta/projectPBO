import java.sql.*;
import javax.swing.JOptionPane;

public class Connect {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost:3306/atmsimulator";
    private final String USER = "root";
    private final String PASS = "";

    private Statement statement;
    private Connection connect;
    
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Gagal");
        }
    }

}
