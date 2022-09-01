package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}