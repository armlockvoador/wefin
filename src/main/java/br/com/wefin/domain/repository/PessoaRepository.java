package br.com.wefin.domain.repository;

import br.com.wefin.domain.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

}
