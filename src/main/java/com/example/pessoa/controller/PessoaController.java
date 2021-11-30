package com.example.pessoa.controller;
import com.example.pessoa.model.Pessoa;
import com.example.pessoa.model.PessoaRequest;
import com.example.pessoa.model.PessoaResponse;
import com.example.pessoa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {
    //Onde e como serão feitas as requisições da aplicação

    @Autowired
    private PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar (@RequestBody PessoaRequest pessoa) {
        return new ResponseEntity<Pessoa>(this.service.salvar(pessoa), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<PessoaResponse>> lista(){
        return ResponseEntity.ok(this.service.lista());
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void deletePessoa(@RequestParam("id") Long id) {
        this.service.deletePessoa(id);
    }


    /*
    //Buscar Cadastros
    @GetMapping("/buscarCadastro")
    public List<Pessoa> getAlunos() {
        return this.service.pesquisaPessoa();
    }

    //teste
    //Buscar Cadasros parametro = nome
    @GetMapping("/getAlunoNome")
    public Pessoa getAlunoNome(@RequestParam("nome") String nome) {
        return this.service.getByNome(nome);
    }

    //Buscar Cadastro parametro = nome
    @GetMapping("/curso")
    public Pessoa getCurso(@RequestParam("curso") String curso) {
        return this.service.getByCurso(curso);
    }

    //Criar cadastro
    @PostMapping("/cadastrarAluno")
    public void cadastroAluno(@RequestBody Pessoa pessoa) {
        this.service.cadastroAluno(pessoa);
    }

    //Alterar dados de cadastro
    @PutMapping("/alterarAluno")
    public Pessoa alterarCadasro(@RequestBody Pessoa pessoa) {
        return this.service.alterarCadastro(pessoa);
    }

    //Remover cadastro
    @DeleteMapping("/{matricula}")
    public void removerCadastro(@PathVariable("matricula") Integer id) {
        this.service.excluirCadastro(id);
    }
    */
}
