package com.allstate.service;

import com.allstate.data.ShoesDao;
import com.allstate.domain.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional(Transactional.TxType.REQUIRED)
public class ShoesServiceImpl implements ShoesService {

    @Autowired
    private ShoesDao dao;

    @Override
    public List<Shoes> getShoesBySize(Integer size) {
        return dao.getShoesBySizeDao(size);
        //return from the dao
    }

    @Override
    public List<Shoes> getShoesByPrice(Double price) {
      return dao.getShoesByPriceDao(price);

   //return frpom the data daowill
    }
}
