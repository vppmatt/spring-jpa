package com.multicode.payments.unitTests;

import com.multicode.payments.control.*;
import com.multicode.payments.service.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit.jupiter.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class ControllerTests {

    @Autowired
    private SupportUtilitiesController controller;

    @MockBean
    private CCUtilsService service;

    @Test
    public void testGetAllCountries() {
        Mockito.when(service.getAllCountries()).thenReturn(List.of("USA","FRA","GBR"));
        Map<String, String[]> result = controller.getAllCountries();
        assertTrue(result.size() == 1);
        String[] countries = result.get("country");

        assertTrue(countries.length == 3);
        String[] expectedArray = new String[]{"USA","FRA","GBR"};
        System.out.println(expectedArray);
        assertArrayEquals(expectedArray, countries);

    }

}
