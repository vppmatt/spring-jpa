import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String connectionString = "jdbc:mysql://localhost:3306/invoice_manager?user=root&password=c0nygre";

        try (
                Connection connection = DriverManager.getConnection(connectionString);
                Statement statement = connection.createStatement();
                ResultSet allCustomersRS = statement.executeQuery("SELECT * FROM customer")
        ) {
            updateCustomerName(81, "Smaller Bikes Ltd", connection);

            List<Customer> customers = new ArrayList<>();

            while (allCustomersRS.next()) {
//                System.out.println(allCustomersRS.getString("name"));
//                System.out.println(allCustomersRS.getString("address1"));
//                System.out.println(allCustomersRS.getString("address2"));
//                System.out.println(allCustomersRS.getString("address3"));
//                System.out.println(allCustomersRS.getString("address4"));
//                System.out.println(allCustomersRS.getString("country"));
//                System.out.println(allCustomersRS.getString("email"));
//                System.out.println(allCustomersRS.getString("phone"));
                Customer customer = new Customer();
                customer.setId(allCustomersRS.getLong("id"));
                customer.setName(allCustomersRS.getString("name"));
                customer.setAddress1(allCustomersRS.getString("address1"));
                customer.setAddress2(allCustomersRS.getString("address2"));
                customer.setAddress3(allCustomersRS.getString("address3"));
                customer.setAddress4(allCustomersRS.getString("address4"));
                customer.setCountry(allCustomersRS.getString("country"));
                customer.setEmail(allCustomersRS.getString("email"));
                customer.setPhone(allCustomersRS.getString("phone"));
                customers.add(customer);
            }

            for (Customer customer : customers) {
                System.out.println(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateCustomerName(int customerId, String newName, Connection connection)
            throws SQLException {
        String sql = "UPDATE customer SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,newName);
        statement.setInt(2, customerId);
        statement.executeUpdate();
        statement.close();
    }
}
