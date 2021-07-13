package br.com.systemsgs.servicos.controller;

import br.com.systemsgs.servicos.model.ModelCliente;
import br.com.systemsgs.servicos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping(value = "/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelCliente salvaCliente(@RequestBody @Valid ModelCliente modelCliente){
        return clienteRepository.save(modelCliente);
    }

}
