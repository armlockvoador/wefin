package br.com.wefin.domain.adapters.service.mappers;

import br.com.wefin.domain.Pessoa;
import br.com.wefin.domain.dtos.PessoaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperPessoa {

    public Pessoa toPessoa(PessoaDto pessoaDto) {
        return Pessoa.builder().nome(pessoaDto.getNome())
                .identificador(pessoaDto.getIdentificador())
                .tipoIdentificador(pessoaDto.getTipoIdentificador().identificador).build();
    }

}
