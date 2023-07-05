package br.com.wefin.domain.adapters.service;

import br.com.wefin.config.exception.BadRequestException;
import br.com.wefin.domain.adapters.service.mappers.MapperPessoa;
import br.com.wefin.domain.dtos.PessoaDto;
import br.com.wefin.domain.portas.PessoaServicePort;
import br.com.wefin.domain.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaServicePort {

    private final PessoaRepository pessoaRepository;
    private final MapperPessoa mapperPessoa;
    private final PessoaService pessoaService;
    @Override
    public boolean post(PessoaDto pessoaDto) {
        try {
            pessoaDto = pessoaService.validateIdentificador(pessoaDto);
            var pessoa = mapperPessoa.toPessoa(pessoaDto);
            pessoaRepository.save(pessoa);
            return true;
        } catch (Exception exception) {
            throw new BadRequestException();
        }
    }
}