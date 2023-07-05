package br.com.wefin.domain.adapters.service;

import br.com.wefin.domain.Pessoa;
import br.com.wefin.domain.adapters.service.mappers.MapperPessoa;
import br.com.wefin.domain.dtos.PessoaDto;
import br.com.wefin.domain.dtos.enums.TipoIdentificadorEnum;
import br.com.wefin.domain.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PessoaServiceImplTest {

    @Mock
    private PessoaService pessoaService;
    @Mock
    private MapperPessoa mapperPessoa;
    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaServiceImpl pessoaServiceImpl;

    @Test
    void returnTrueWhenCpfIsValidAndIdentifyIsFisica() {
        var pessoaDto = PessoaDto.builder()
                .identificador("47419609004")
                .nome("Lucas")
                .tipoIdentificador(TipoIdentificadorEnum.FISICA)
                .build();

        var pessoa = Pessoa.builder()
                .identificador("47419609004")
                .nome("Lucas")
                .tipoIdentificador(TipoIdentificadorEnum.FISICA.identificador)
                .build();


        when(pessoaService.validateIdentificador(pessoaDto)).thenReturn(pessoaDto);
        when(mapperPessoa.toPessoa(pessoaDto)).thenReturn(pessoa);
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        var actual = pessoaServiceImpl.post(pessoaDto);
        assertTrue(actual);
    }

    @Test
    void returnTrueWhenCnpjIsValidAndIdentifyIsJuridica() {
        var pessoaDto = PessoaDto.builder()
                .identificador("69776951000153")
                .nome("Lucas")
                .tipoIdentificador(TipoIdentificadorEnum.JURIDICA)
                .build();

        var pessoa = Pessoa.builder()
                .identificador("75581259000172")
                .nome("Lucas")
                .tipoIdentificador(TipoIdentificadorEnum.JURIDICA.identificador)
                .build();


        when(pessoaService.validateIdentificador(pessoaDto)).thenReturn(pessoaDto);
        when(mapperPessoa.toPessoa(pessoaDto)).thenReturn(pessoa);
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);

        var actual = pessoaServiceImpl.post(pessoaDto);
        assertTrue(actual);
    }

    @Test
    void whenIdentifyIsNotValidGetBadRequest() {

        var pessoaDto = PessoaDto.builder()
                .identificador("6977695")
                .nome("Lucas")
                .tipoIdentificador(TipoIdentificadorEnum.JURIDICA)
                .build();

        when(pessoaService.validateIdentificador(pessoaDto)).thenReturn(new PessoaDto());
        when(mapperPessoa.toPessoa(new PessoaDto())).thenReturn(new Pessoa());
        when(pessoaRepository.save(new Pessoa()));

        try {
            pessoaServiceImpl.post(pessoaDto);
            fail("Solicitação Http mal formada");
        } catch (RuntimeException e) {
            assertEquals("Solicitação Http mal formada", e.getMessage());
        }
    }
}