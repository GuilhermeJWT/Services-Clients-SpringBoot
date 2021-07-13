package br.com.systemsgs.servicos.exception;

import java.util.Arrays;
import java.util.List;

public class RestApiErrorsException {

    private List<String> erros;

    public RestApiErrorsException(String msgErro){
        this.erros = Arrays.asList(msgErro);
    }

    public RestApiErrorsException(List<String> erros){
        this.erros = erros;
    }

    public List<String> getErros() {
        return erros;
    }

}
