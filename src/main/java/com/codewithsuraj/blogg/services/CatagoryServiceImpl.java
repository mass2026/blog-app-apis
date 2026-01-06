package com.codewithsuraj.blogg.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.codewithsuraj.blogg.entities.Category;
import com.codewithsuraj.blogg.payloads.CatogeryDto;
import com.codewithsuraj.blogg.repositories.CatagoryRepo;

public class CatagoryServiceImpl implements CatagoryService {
    
    @Autowired
    private CatagoryRepo catagoryRepo;

    @Autowired
    private CatogeryDto catagoryDto;

    @Autowired
    private ModelMapper modelMapper;

  

    @Override
    public CatogeryDto createCatogery(CatogeryDto catogeryDto) {
        
        Category cat =this.modelMapper.map(catogeryDto, Category.class);
        Category addedCat =this.catagoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CatogeryDto.class);
    }

    @Override
    public CatogeryDto updateCatogery(CatogeryDto catogeryDto, Integer catogeryId) {
        Category cat = this.catagoryRepo.findById(catogeryId).orElseThrow(()-> new RuntimeException("Catogery not found"));
        cat.setCategoryTitle(catogeryDto.getCategoryTitle());
        cat.setCategoryDescription(catogeryDto.getCategoryDescription());
        Category updatedCat = this.catagoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CatogeryDto.class);
        
    }

    @Override
    public void deleteCatogery(Integer catogeryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCatogery'");
    }

    @Override
    public CatogeryDto getCatogeryById(Integer catogeryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCatogeryById'");
    }

    @Override
    public List<CatogeryDto> getAllCatogery() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCatogery'");
    }

}
