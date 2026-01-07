package com.codewithsuraj.blogg.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsuraj.blogg.entities.Category;
import com.codewithsuraj.blogg.payloads.CatogeryDto;
import com.codewithsuraj.blogg.repositories.CatagoryRepo;

@Service
public class CatagoryServiceImpl implements CatagoryService {
    
    @Autowired
    private CatagoryRepo catagoryRepo;

    

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
        Category cat = this.catagoryRepo.findById(catogeryId).orElseThrow(()-> new RuntimeException("Catogery not found"));
        this.catagoryRepo.delete(cat);
    }

    @Override
    public CatogeryDto getCatogeryById(Integer catogeryId) {
        Category cat = this.catagoryRepo.findById(catogeryId).orElseThrow(()-> new RuntimeException("Catogery not found"));
        return this.modelMapper.map(cat, CatogeryDto.class);
    }

    @Override
    public List<CatogeryDto> getAllCatogery() {
        List<Category> cats = this.catagoryRepo.findAll();
        List<CatogeryDto> catogeryDtos = cats.stream().map(cat -> this.modelMapper.map(cat, CatogeryDto.class)).toList();
        return catogeryDtos;
    }

}
