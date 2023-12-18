package br.com.maelton.projeto_gestao_vagas.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

//Cria getters e setters para os atributos de classe
@Data
//Cria um construtor com todos os atributos de classe
@AllArgsConstructor
public class ErrorMessageDTO {
    private String message;
    private String errorField;
}
