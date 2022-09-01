package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.PaisRegistro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRegistroRepository extends JpaRepository<PaisRegistro, Long> {

    PaisRegistro findCategoriaById(Long ID);
}
