import com.multicode.domain.*;

import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //JDBC example  code
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: Could not find the MySQL driver - check you have the jar file and it's on the build path");
        }

        String connectionString = "jdbc:mysql://localhost:3306/payments?user=root&password=password";

        try(Connection connection = DriverManager.getConnection(connectionString);
            Statement statement = connection.createStatement();
            ResultSet transactionsRS = statement.executeQuery("SELECT * FROM ccTransactions where order_id = '21212355'")
        ) {

            List<CreditCardTransaction> ccTransactionList = new ArrayList<>();
            while(transactionsRS.next()) {
                CreditCardTransaction ccTransaction = new CreditCardTransaction();
                ccTransaction.setId(transactionsRS.getInt("id"));
                ccTransaction.setAmount(transactionsRS.getDouble("amount"));
                ccTransaction.setCurrency(transactionsRS.getString("currency"));
                ccTransaction.setDate(transactionsRS.getDate("date"));
                ccTransaction.setOrderId(transactionsRS.getString("order_id"));
                ccTransaction.setTaxCode(transactionsRS.getInt("tax_code"));
                ccTransaction.setTaxRate(transactionsRS.getDouble("tax_rate"));
                ccTransaction.setType(transactionsRS.getString("type"));
                ccTransactionList.add(ccTransaction);
            }

            for (CreditCardTransaction ccTransaction : ccTransactionList) {
                System.out.println(ccTransaction);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
