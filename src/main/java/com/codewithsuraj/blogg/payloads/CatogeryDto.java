package com.codewithsuraj.blogg.payloads;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CatogeryDto {
    
    private Integer categoryId;

    
    @NotBlank(message = "Category Title is required")
    private String categoryTitle;


    @NotBlank(message = "Category Description is required")
    @Max(value = 500)
    private String categoryDescription;
    

}