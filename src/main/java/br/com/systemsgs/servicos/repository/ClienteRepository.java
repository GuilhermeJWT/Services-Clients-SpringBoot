package br.com.systemsgs.servicos.repository;

import br.com.systemsgs.servicos.model.ModelCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ModelCliente, Long> {

}
