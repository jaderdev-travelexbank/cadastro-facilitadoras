package br.com.confidencecambio.aplicacao.repository;

import br.com.confidencecambio.aplicacao.model.Merchant;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>{

    @Query(value = "select m.status from merchant m order by m.status DESC limit 1", nativeQuery = true)
    Merchant findByMaxStatus();

    @Query(value = "select * from facilitadoras.dbo.merchant", nativeQuery = true)
    <S extends Merchant> @NotNull List<S> find();

    Optional<Merchant> findById(Long id);
}
