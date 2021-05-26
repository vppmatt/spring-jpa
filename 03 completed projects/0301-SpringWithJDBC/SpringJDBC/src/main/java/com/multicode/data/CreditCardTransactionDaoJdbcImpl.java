package com.multicode.data;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.support.*;

import com.multicode.domain.*;
import org.springframework.stereotype.*;

import javax.annotation.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

@Component
public class CreditCardTransactionDaoJdbcImpl extends JdbcDaoSupport implements CreditCardTransactionDao {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<CreditCardTransaction> findAll() {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        List<CreditCardTransaction> transactions = jdbcTemplate.query("SELECT * FROM ccTransactions", new CreditCardTransactionRowMapper());
        return transactions;
    }

    @Override
    public List<CreditCardTransaction> findAllByOrderId(String orderId) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "SELECT * FROM ccTransactions where order_id = ?";
        Object[] parameters = new Object[]{orderId};
        int[] parameterTypes = new int[]{java.sql.Types.VARCHAR};
        List<CreditCardTransaction> transactions = jdbcTemplate.query(sql, parameters, parameterTypes, new CreditCardTransactionRowMapper());
        return transactions;
    }

    @Override
    public List<CreditCardTransaction> findAllByTaxCode(Integer taxCode) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        String sql = "SELECT * FROM ccTransactions where tax_code = ?";
        Object[] parameters = new Object[]{taxCode};
        int[] parameterTypes = new int[]{java.sql.Types.INTEGER};
        List<CreditCardTransaction> transactions = jdbcTemplate.query(sql, parameters, parameterTypes, new CreditCardTransactionRowMapper());
        return transactions;
    }

    @Override
    public boolean setTaxRate(Integer transactionId, Double newRate) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();
        String sql = "UPDATE ccTransactions set tax_rate = ? where id = ?";
        Object[] parameters = new Object[]{newRate, transactionId};
        int[] parameterTypes = new int[]{java.sql.Types.DOUBLE, java.sql.Types.INTEGER};
        int result = jdbcTemplate.update(sql, parameters, parameterTypes);
        return result == 1;
    }


    class CreditCardTransactionRowMapper implements RowMapper<CreditCardTransaction> {

        @Override
        public CreditCardTransaction mapRow(ResultSet resultSet, int i) throws SQLException {
            CreditCardTransaction ccTransaction = new CreditCardTransaction();
            ccTransaction.setId(resultSet.getInt("id"));
            ccTransaction.setAmount(resultSet.getDouble("amount"));
            ccTransaction.setCurrency(resultSet.getString("currency"));
            ccTransaction.setCountry(resultSet.getString("country"));
            ccTransaction.setDate(resultSet.getDate("date"));
            ccTransaction.setOrderId(resultSet.getString("order_id"));
            ccTransaction.setTaxCode(resultSet.getInt("tax_code"));
            ccTransaction.setTaxRate(resultSet.getDouble("tax_rate"));
            ccTransaction.setType(resultSet.getString("type"));
            return ccTransaction;
        }
    }
}
