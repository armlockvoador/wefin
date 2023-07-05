package br.com.wefin.config;

import br.com.wefin.WefinApplication;
import br.com.wefin.domain.adapters.service.PessoaService;
import br.com.wefin.domain.adapters.service.PessoaServiceImpl;
import br.com.wefin.domain.adapters.service.mappers.MapperPessoa;
import br.com.wefin.domain.repository.PessoaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = WefinApplication.class)
public class BeanConfiguration {

    @Bean
    PessoaServiceImpl productServiceImpl(PessoaService pessoaService, PessoaRepository repository, MapperPessoa mapper) {
        return new PessoaServiceImpl(repository, mapper, pessoaService);
    }
}
