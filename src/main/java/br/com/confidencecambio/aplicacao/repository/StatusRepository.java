package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    Status findCategoriaById(Long ID);

}
