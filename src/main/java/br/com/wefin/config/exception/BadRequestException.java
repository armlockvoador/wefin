package br.com.wefin.config.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Solicitação Http mal formada");
    }

}