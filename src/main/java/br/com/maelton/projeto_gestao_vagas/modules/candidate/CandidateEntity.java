package br.com.maelton.projeto_gestao_vagas.modules.candidate;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//lombok dependency annotation which automatically generates getters and setters.
@Data
public class CandidateEntity {
    
    //Using spring-boot-starter-validation annotations to validate incoming data

    private String UUID;
    private String name;

    @NotBlank()
    //requisite validation for regexp => expressao regular
    @Pattern(regexp = "\\s+", message = "Digite um username válido.")
    private String username;
    
    //Email arg validation requisite
    @Email(message = "Digite um email válido.") 
    private String email;
    
    //Password arg validation requisite
    @Length(min = 8, max = 20, message = "Mínimo de 8 e máximo de 20 caracteres.")
    private String password;
    
    private String description;
    private String curriculum;

}
