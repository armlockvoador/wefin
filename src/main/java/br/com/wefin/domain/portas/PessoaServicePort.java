package br.com.wefin.domain.portas;

import br.com.wefin.domain.dtos.PessoaDto;

public interface PessoaServicePort {
    boolean post(PessoaDto pessoa);
}