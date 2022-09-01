package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Notoriedade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotoriedadeRepository extends JpaRepository<Notoriedade, Long> {

    Notoriedade findCategoriaById(Long ID);
}
