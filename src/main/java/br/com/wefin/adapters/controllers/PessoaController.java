package br.com.wefin.adapters.controllers;

import br.com.wefin.domain.dtos.PessoaDto;
import br.com.wefin.domain.portas.PessoaServicePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/pessoa")
public class PessoaController {

    private final PessoaServicePort pessoaServicePort;

    public PessoaController(PessoaServicePort pessoaServicePort) {
        this.pessoaServicePort = pessoaServicePort;
    }

    @PostMapping
    public void postPessoa(@Valid @RequestBody PessoaDto pessoaDto) {
        pessoaServicePort.post(pessoaDto);
    }
}