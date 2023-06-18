import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConfig {

    private static final String url = "jdbc:mysql://localhost:3306/imeltoko";
    private static final String username = "root";
    private static final String pass = "";

    private static Connection connect;
    private static Statement statement;

    public static void getConnection() {
        try {
            connect = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void getDatabase() {
        try {
            String query = "SELECT * FROM BARANG";
            PreparedStatement statement = connect.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String Nama = resultSet.getString("NAMA");
                int Harga = resultSet.getInt("HARGA");
                int Stok = resultSet.getInt("STOK");
                System.out.println("ID: " + id + ", NAMA: " + Nama + ", HARGA: " + Harga + ", STOK: " + Stok);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS BARANG (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "NAMA VARCHAR(255) NULL," +
                    "HARGA INT NULL," +
                    "STOK INT NULL" +
                    ")";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.executeUpdate();
            System.out.println("Table created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addData(String newNama, long newHarga, int newStok) {
        try {
            statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO `BARANG` (`ID`, `NAMA`, `HARGA`, `STOK`) VALUES (NULL, '"+newNama+"', '"+newHarga+"', '"+newStok+"') ");
            System.out.println("Data added successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editData(int ID, String NAMA, int HARGA, int STOK) {
        try {
            String query = "UPDATE BARANG SET NAMA=?, HARGA=?, STOK=? WHERE iD=?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setString(1, NAMA);
            statement.setDouble(2, HARGA);
            statement.setInt(3, STOK);
            statement.setInt(4, ID);
            statement.executeUpdate();
            System.out.println("Data updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(int id) {
        try {
            String query = "DELETE FROM BARANG WHERE ID=?";
            PreparedStatement statement = connect.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Data deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

