package com.codewithsuraj.blogg.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsuraj.blogg.payloads.CatogeryDto;
import com.codewithsuraj.blogg.services.CatagoryService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/categories")
public class CatagoryController {
     @Autowired
    private CatagoryService catagoryService;

    //CREATE CATAGORY
    @PostMapping("/")
     public ResponseEntity <CatogeryDto> createCategory( @Valid @RequestBody CatogeryDto categoryDto){
      
        CatogeryDto createdCatogery = catagoryService.createCatogery(categoryDto);
        return  new ResponseEntity<CatogeryDto>(createdCatogery , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatogeryDto> putMethodName( @Valid @PathVariable Integer id, @RequestBody CatogeryDto catogeryDto) {
         
        CatogeryDto catogeryDto1 = this.catagoryService.updateCatogery(catogeryDto, id);
        return ResponseEntity.ok(catogeryDto1);
    }

    
    //TODO: delete catogery
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory( @Valid @PathVariable Integer id){
        
        this.catagoryService.deleteCatogery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Get catogery by id
    @GetMapping("{id}")
    public ResponseEntity<CatogeryDto> getCategoryById(@Valid @PathVariable Integer id) {
        CatogeryDto catogeryDto = this.catagoryService.getCatogeryById(id);
        return ResponseEntity.ok(catogeryDto);
    }
    
    //Get all catogery
    @GetMapping("/")
    public ResponseEntity<List<CatogeryDto>> getAllCategories(){
       List<CatogeryDto> catogeryDtos = this.catagoryService.getAllCatogery();
        return ResponseEntity.ok(catogeryDtos);
    }
}
