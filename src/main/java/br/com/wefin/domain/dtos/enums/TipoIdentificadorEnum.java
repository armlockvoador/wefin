package br.com.wefin.domain.dtos.enums;

public enum TipoIdentificadorEnum {

    FISICA(1),JURIDICA(2);

    public final int identificador;
    TipoIdentificadorEnum(int valor) {
        identificador = valor;
    }
}
