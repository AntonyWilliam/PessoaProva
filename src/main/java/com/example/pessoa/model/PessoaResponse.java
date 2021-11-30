package com.example.pessoa.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaResponse {
    private Long id;
    private String nome;
    private String matricula;
    private String endereco;
    private String curso;
}
