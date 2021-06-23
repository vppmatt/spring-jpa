package com.allstate.service;

import com.allstate.domain.Shoes;

import java.util.List;

public interface ShoesService {

    List<Shoes> getShoesBySize(Integer size);

    List<Shoes> getShoesByPrice (Double price);

}
