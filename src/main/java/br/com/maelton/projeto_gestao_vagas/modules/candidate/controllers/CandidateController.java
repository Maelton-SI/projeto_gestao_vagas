package br.com.maelton.projeto_gestao_vagas.modules.candidate.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maelton.projeto_gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    
    @PostMapping("/create")
    //@Valid is used to validate incoming data
    public void create(@Valid @RequestBody CandidateEntity candidate) {
        System.out.println("Candidate: ("+ 
                           candidate.getName() + 
                           ", " + candidate.getEmail() +
                           ") has been created.");
    }
}
