package br.com.wefin.domain.dtos;

import br.com.wefin.domain.dtos.enums.TipoIdentificadorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    @NotBlank(message = "Necessário o preenchimento do nome")
    private String nome;

    @Min(value = 11)
    @Max(value = 14)
    private String identificador;

    @NotBlank(message = "Necessário o tipo de identificador")
    private TipoIdentificadorEnum tipoIdentificador;


}