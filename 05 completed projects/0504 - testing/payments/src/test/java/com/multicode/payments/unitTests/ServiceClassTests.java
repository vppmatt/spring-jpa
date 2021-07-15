package com.multicode.payments.unitTests;
import com.multicode.payments.data.*;
import com.multicode.payments.domain.*;
import com.multicode.payments.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit.jupiter.*;

import javax.activation.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ServiceClassTests {

    @Autowired
    private CCUtilsService service;

    @MockBean
    private CreditCardTransactionRepository repository;

    @BeforeEach
    public void setUp() {
        CreditCardTransaction transaction1 = new CreditCardTransaction();
        transaction1.setId(1);
        transaction1.setAmount(32.0);
        transaction1.setCountry("USA");
        transaction1.setOrderId("3322");

        CreditCardTransaction transaction2 = new CreditCardTransaction();
        transaction2.setId(2);
        transaction2.setAmount(16.0);
        transaction2.setCountry("FRA");
        transaction2.setOrderId("3317");

        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(transaction1));
        Mockito.when(repository.findById(2)).thenReturn(java.util.Optional.of(transaction1));
        Mockito.when(repository.findAllByCountry("FRA")).thenReturn(List.of(transaction2));
    }

    @Test
    public void testGetById() {
        CreditCardTransaction result = service.getById(1);
        assertEquals(1, result.getId());
    }

    @Test
    public void testGetByCountry() {
        List<CreditCardTransaction> result = service.getAllForACountry("FRA");
        assertEquals(1, result.size());
    }

}
