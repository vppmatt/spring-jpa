package com.allstate;

import com.allstate.config.Config;
import com.allstate.domain.Shoes;
import com.allstate.service.ShoesService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        ShoesService service = applicationContext.getBean(ShoesService.class);

        //List<CreditCardTransaction> ccTransactionList = service.getTransactionsByOrderId("21212355");
        List<Shoes> shoesSizeList = service.getShoesBySize(7);

        for (Shoes shoesSize : shoesSizeList) {
            System.out.println(shoesSize);

        }

        List<Shoes> shoesPriceList = service.getShoesByPrice(10.00);

        for (Shoes shoesPrice : shoesPriceList) {
            System.out.println(shoesPrice);
        }
        System.out.println("End");
    }
}
