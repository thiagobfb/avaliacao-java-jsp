package com.thiagobfb.avaliacaojavajsp.repository;

import com.thiagobfb.avaliacaojavajsp.domain.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
