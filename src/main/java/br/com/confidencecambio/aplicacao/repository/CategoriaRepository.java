package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Autowired
    Categoria findCategoriaById(Long ID);
}
