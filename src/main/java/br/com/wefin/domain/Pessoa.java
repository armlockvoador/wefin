package br.com.wefin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pessoa")
public class Pessoa {

    private UUID codigo;
    private String nome;
    private String identificador;
    private Integer tipoIdentificador;
}

