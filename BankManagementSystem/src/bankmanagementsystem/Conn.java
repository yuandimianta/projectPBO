
import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class Conn {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_simulator";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static long cardNumber;
    public static int pin;
    public static String name;
    public static String address;
    public static Date birth;
    public static long phoneNumber;
    public static String gender;
    public static long balance;
    public static Statement statement;

    private static Connection connect() throws Exception {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static boolean isValidUser(long cardNumb, int pin) {
        boolean found = false;
        try (Connection conn = connect()) {
            String query = "select * from user where cardNumber = '" + cardNumb + "' and PIN = '" + pin + "'";
            statement = conn.createStatement();
            ResultSet set = statement.executeQuery(query);
            if (set.next()) {
                JOptionPane.showMessageDialog(null, "Login berhasil");
                found = true;
                cardNumber = cardNumb;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    public static boolean isValidRegis(String username) {
        try (Connection conn = connect()) {
            String query = "SELECT * FROM user WHERE Name = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()) {
                    return !resultSet.next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static long generateCardNumber() {
        Random random = new Random();

        long combinedNumber = 0;
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            combinedNumber = combinedNumber * 10 + digit;
        }
        return combinedNumber;
    }

    public static int generatePIN() {
        Random random = new Random();

        int combinedNumber = 0;
        for (int i = 0; i < 6; i++) {
            int digit = random.nextInt(10);
            combinedNumber = combinedNumber * 10 + digit;
        }
        return combinedNumber;
    }

    public static boolean isBalanceZero() {
        boolean isZero = false;

        try (Connection conn = connect()) {
            String sql = "SELECT * FROM user WHERE Balance = 0";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            isZero = resultSet.next(); // Set isZero menjadi true jika ada baris dengan Balance = 0

            resultSet.close();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isZero;
    }

    public static void insertUser(String name, String alamat, String birth, String phone, String gender) {
        cardNumber = generateCardNumber();
        pin = generatePIN();
        int balance = 0;
        try (Connection conn = connect()) {
            String query = "insert into user values('" + cardNumber + "','" + pin + "','" + name + "','" + alamat
                    + "','" + birth + "','" + phone + "','" + gender + "','" + balance + "')";
            statement = conn.createStatement();
            int rowsAffected = statement.executeUpdate(query);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Nomor Kartu : " + Conn.cardNumber + "\nPIN : " + Conn.pin);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setorTunai(long balance) {
        try (Connection conn = connect()) {
            String query = "UPDATE user SET Balance = Balance + ? WHERE cardNumber = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            // Mengatur nilai parameter untuk placeholder
            statement.setLong(1, balance);
            statement.setLong(2, cardNumber);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil Setor Tunai");
            } else {
                JOptionPane.showMessageDialog(null, "Setor Tunai Gagal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getAllData() {
        try (Connection conn = connect()) {
            String query = "select * from user where cardNumber = '" + LoginPage.cardNum + "'";
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
    }
}