package com.allstate.data;

import com.allstate.domain.Shoes;

import java.util.List;

public interface ShoesDao {

    List<Shoes> getShoesBySizeDao(Integer Size);

    List<Shoes> getShoesByPriceDao(Double Price);

}
