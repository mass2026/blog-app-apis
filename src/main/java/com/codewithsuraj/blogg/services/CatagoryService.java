package com.codewithsuraj.blogg.services;

import java.util.List;

import com.codewithsuraj.blogg.payloads.CatogeryDto;

public interface CatagoryService {
   
    //create catogery
    CatogeryDto  createCatogery( CatogeryDto catogeryDto);

   //update catogery
    CatogeryDto updateCatogery( CatogeryDto catogeryDto, Integer catogeryId);

    //delete catogery
    void deleteCatogery(Integer catogeryId);
    //get catogery by id
    CatogeryDto getCatogeryById(Integer catogeryId);
    //get all catogery
    List<CatogeryDto> getAllCatogery();
}
