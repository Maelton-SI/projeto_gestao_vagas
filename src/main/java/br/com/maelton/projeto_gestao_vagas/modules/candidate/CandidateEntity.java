package br.com.maelton.projeto_gestao_vagas.modules.candidate;

import lombok.Data;

//lombok dependency annotation which automatically generates getters and setters.
@Data
public class CandidateEntity {
    
    private String UUID;
    private String name;
    private String username;
    private String email;
    private String password;
    private String description;
    private String curriculum;

}
