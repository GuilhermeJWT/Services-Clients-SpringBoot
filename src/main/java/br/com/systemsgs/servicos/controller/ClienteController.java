package br.com.systemsgs.servicos.controller;

import br.com.systemsgs.servicos.exception.RecursoNaoEncontradoException;
import br.com.systemsgs.servicos.model.ModelCliente;
import br.com.systemsgs.servicos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping(value = "/listaTodos")
    public List<ModelCliente> listaTodos(){
        return clienteRepository.findAll();
    }

    @GetMapping(value = "/pesquisa/{id}")
    public ModelCliente buscaPorId(@PathVariable("id") Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException());
    }

    @PutMapping(value = "/atualiza/{id}")
    public String atualizaCliente(@PathVariable("id") Long id, @RequestBody ModelCliente modelCliente){
        clienteRepository.findById(id).map(cliente -> {modelCliente.setId(cliente.getId()); return clienteRepository.save(modelCliente);}).orElseThrow(() -> new RecursoNaoEncontradoException());

        return "Cliente Atualizado com Sucesso!!!";
    }

    @DeleteMapping(value = "/deletar/{id}")
    public String deletaCliente(@PathVariable("id") Long id){
        clienteRepository.findById(id).map(cliente -> {clienteRepository.delete(cliente); return Void.TYPE;}).orElseThrow(() -> new RecursoNaoEncontradoException());

        return "Cliente Deletado com Sucesso!!!";
    }

}
