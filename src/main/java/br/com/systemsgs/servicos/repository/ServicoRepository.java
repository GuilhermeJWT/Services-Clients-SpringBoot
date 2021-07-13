package br.com.systemsgs.servicos.repository;

import br.com.systemsgs.servicos.model.ModelServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<ModelServico, Long> {

}
