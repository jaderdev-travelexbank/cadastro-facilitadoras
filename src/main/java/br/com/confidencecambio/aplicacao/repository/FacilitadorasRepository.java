package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Facilitadoras;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilitadorasRepository extends JpaRepository<Facilitadoras, Long> {

    List<Facilitadoras> findByNomeFantasiaContains(String descricao);

    List<Facilitadoras> findByNomeRegistroContains(String toString);
}