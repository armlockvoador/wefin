package br.com.wefin.domain.adapters.service;

import br.com.wefin.domain.dtos.PessoaDto;
import br.com.wefin.domain.dtos.enums.TipoIdentificadorEnum;
import br.com.wefin.domain.utils.CNPJValidator;
import br.com.wefin.domain.utils.CPFValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private CNPJValidator cnpjValidator;

    @Autowired
    private CPFValidator cpfValidator;

    public PessoaDto validateIdentificador(PessoaDto pessoaDto) {

        if (cnpjValidator.isValid(pessoaDto.getIdentificador())
                && pessoaDto.getTipoIdentificador().name().equals(TipoIdentificadorEnum.JURIDICA.name())) {
            return pessoaDto;
        }
        else if (cpfValidator.isValid(pessoaDto.getIdentificador())
                && pessoaDto.getTipoIdentificador().name().equals(TipoIdentificadorEnum.FISICA.name())) {
            return pessoaDto;
        } else {
            return new PessoaDto();
        }
    }
}
