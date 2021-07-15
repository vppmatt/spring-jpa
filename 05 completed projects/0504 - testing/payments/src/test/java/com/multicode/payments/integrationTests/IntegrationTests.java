package com.multicode.payments.integrationTests;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.multicode.payments.data.*;
import com.multicode.payments.domain.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit.jupiter.*;
import org.springframework.test.web.servlet.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CreditCardTransactionRepository repository;

    @Test
    public void testThatPostingANewTransactionGetsAddedToTheDatabase() throws Exception {

        CreditCardTransaction transaction = new CreditCardTransaction();
        transaction.setOrderId("223344");
        transaction.setCountry("USA");
        transaction.setAmount(17.33);

        ObjectMapper om = new ObjectMapper();
        String json = om.writeValueAsString(transaction);

        mockMvc.perform(post("/api/cctransaction")
                .contentType("application/json")
                .content(json))
                .andExpect(status().isOk());
        
        ArgumentCaptor<CreditCardTransaction> capturedTransaction = ArgumentCaptor.forClass(CreditCardTransaction.class);

        Mockito.verify(repository).save(capturedTransaction.capture());
        assertEquals("223344", capturedTransaction.getValue().getOrderId());

    }

}
