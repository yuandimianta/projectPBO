
import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class Conn {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_simulator";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static long cardNumber;
    private static int pin;
    private static String name;
    private static String address;
    private static Date birth;
    private static long phoneNumber;
    private static String gender;
    private static long balance;
    private static Statement statement;
    
    public static long getBalance() {
        return balance;
    }
    public static void setBalance(long balance) {
        Conn.balance = balance;
    }

    public static long getCardNumber() {
        return Conn.cardNumber;
    }
    public static void setCardNumber(long cardNumber) {
        Conn.cardNumber = cardNumber;
    }

    public static void setPin(int pin) {
        Conn.pin = pin;
    }
    public static int getPin(){
        return Conn.pin;
    } 

    public static void setName(String name){
        Conn.name = name;
    }
    public static String getName(){
        return Conn.name;
    }

    

    private static Connection connect() throws Exception {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static boolean isValidUser(long cardNumb, int pin) {
        boolean found = false;
        try (Connection conn = connect()) {
            String query = "select * from user where cardnumber = ? and Pin = ?";
            try(PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setLong(1, cardNumb);
                statement.setInt(2, pin);
                try(ResultSet set = statement.executeQuery()){
                    if (set.next()) {
                        JOptionPane.showMessageDialog(null, "Login berhasil");
                        found = true;
                        getAllData();
                    }
                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

     public static boolean cekCardNumber(long cardNumb) {
        boolean found = false;
        try (Connection conn = connect()) {
            String query = "select * from user where cardNumber = ?";
            try(PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setLong(1, cardNumb);
                try(ResultSet set = statement.executeQuery()){
                    if (set.next()) {
                        found = true;
                    }
                }

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

    public static boolean isBalanceZero() {
        boolean isZero = false;

        try (Connection conn = connect()) {
            String query = "SELECT * FROM user WHERE Balance = 0";

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            isZero = resultSet.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isZero;
    }

    public static void insertUser(int pin, String name, String alamat, String birth, String phone, String gender, String email) {
        cardNumber = generateCardNumber();
        int balance = 0;
        try(Connection conn = connect()){
            String query = "insert into user values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setLong(1, cardNumber);
            statement.setInt(2, pin);
            statement.setString(3, name);
            statement.setString(4, alamat);
            statement.setString(5, birth);
            statement.setString(6, phone);
            statement.setString(7, gender);
            statement.setLong(8, balance);
            statement.setString(9, email);

            int rowsAffected = statement.executeUpdate();
             if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Register Berhasil\nNomor Kartu : " + Conn.cardNumber + "\nPIN : " + RegisterPage.getPin());
            } else {
                JOptionPane.showMessageDialog(null, "Register Gagal");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void setorTunai(long balance) {
        try (Connection conn = connect()) {
            String query = "UPDATE user SET Balance = Balance + ? WHERE cardNumber = ?";
            PreparedStatement statement = conn.prepareStatement(query);

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
    
    public static void tarikTunai(long amount) {
        try (Connection conn = connect()) {
            String query = "UPDATE user SET Balance = Balance - ? WHERE cardNumber = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setLong(1, amount);
            statement.setLong(2, cardNumber);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Rows : " + rowsAffected);
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil Tarik Tunai");
            } else {
                JOptionPane.showMessageDialog(null, "Tarik Tunai Gagal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static void getAllData() {
        try (Connection conn = connect()) {
            String query = "select * from user where cardNumber = ?";
            try(PreparedStatement statement = conn.prepareStatement(query)){
                statement.setLong(1, LoginPage.getCardNum());
                try(ResultSet set = statement.executeQuery()){
                    while (set.next()) {
                        cardNumber = set.getLong("cardNumber");
                        pin = set.getInt("pin");
                        name = set.getString("Name");
                        address = set.getString("Alamat");
                        phoneNumber = set.getLong("Phone");
                        gender = set.getString("Gender");
                        balance = set.getLong("Balance");
                    }
                }
            }
        } catch (Exception e) {
            {
                e.printStackTrace();
            }
        }
    }

    public static void changePin(int pin){
        try (Connection conn = connect()) {
            String query = "UPDATE user SET PIN = ? WHERE cardNumber = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            statement.setInt(1, pin);
            statement.setLong(2, cardNumber);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil Ganti PIN");
            } else {
                JOptionPane.showMessageDialog(null, "Ganti PIN Gagal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void transfer(long cardNumTo, long amount){
        try(Connection conn = connect()){
            // Kurangi saldo dari rekening pengirim
            String querySender = "UPDATE user SET Balance = Balance - ? WHERE cardNumber = ?";
            PreparedStatement senderStatement = conn.prepareStatement(querySender);
            senderStatement.setLong(1, amount);
            senderStatement.setLong(2, cardNumber);
            int rowsAffectedSender = senderStatement.executeUpdate();
    
            // Tambahkan saldo ke rekening penerima
            String queryReceiver = "UPDATE user SET Balance = Balance + ? WHERE cardNumber = ?";
            PreparedStatement receiverStatement = conn.prepareStatement(queryReceiver);
            receiverStatement.setLong(1, amount);
            receiverStatement.setLong(2, cardNumTo);
            int rowsAffectedReceiver = receiverStatement.executeUpdate();
    
            if (rowsAffectedSender > 0 && rowsAffectedReceiver > 0) {
                JOptionPane.showMessageDialog(null, "Berhasil Transfer");
            } else {
                JOptionPane.showMessageDialog(null, "Transfer Gagal");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
}