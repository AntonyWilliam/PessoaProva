package com.example.pessoa.service;

import com.example.pessoa.model.Pessoa;
import com.example.pessoa.model.PessoaRequest;
import com.example.pessoa.model.PessoaResponse;
import com.example.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    //REGRAS DE NEGOCIO
    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public Pessoa salvar(PessoaRequest dto) {
        return this.repository.save(convertePessoaRequestParaPessoa(dto));
    }

    public List<PessoaResponse> lista(){
        return this.repository.findAll()
                .stream()
                .map(p-> convertePessoaResponse(p))
                .collect(Collectors.toList());
    }

    private Pessoa convertePessoaRequestParaPessoa(PessoaRequest dto) {
        return Pessoa.builder()
                .nome(dto.getNome())
                .matricula(dto.getMatricula())
                .endereco(dto.getEndereco())
                .curso(dto.getCurso())
                .build();
    }

    private PessoaResponse convertePessoaResponse(Pessoa pessoa) {
        return PessoaResponse.builder()
                .id(pessoa.getId())
                .nome(pessoa.getNome())
                .matricula(pessoa.getMatricula())
                .curso(pessoa.getCurso())
                .build();

    }
    public void deletePessoa(Long id) {
        this.repository.deleteById(id);
    }

    /*
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> pesquisaPessoa() {
        return this.repository.findAll();
    }

    public Pessoa getByNome(String nome) {
        return this.repository.findByNome(nome);
    }

    public Pessoa getByCurso(String curso) {
        return this.repository.findByCurso(curso);
    }

    public void cadastroAluno(Pessoa pessoa) {
        this.repository.save(pessoa);
    }

    public Pessoa alterarCadastro(Pessoa pessoa) {
        return this.repository.save(pessoa);
    }

    public void excluirCadastro(Integer matricula) {
        this.repository.deleteById(matricula);
    }
     */
}
