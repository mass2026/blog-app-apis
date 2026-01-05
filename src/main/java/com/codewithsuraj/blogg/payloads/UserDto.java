package com.codewithsuraj.blogg.payloads;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
  
   private Integer id;
    
     @NotBlank(message = "Name  is required")
    private String name;

    @NotBlank(message = "Email  is required")
    @Email(message = "Invalid Format")
    private String email;

    @Size(min = 6,max=10, message = "Password must be at least 3 characters")
    @NotBlank(message = "Password  is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$",
             message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, one special character and no whitespace")
    private String password;
    private String about;
}