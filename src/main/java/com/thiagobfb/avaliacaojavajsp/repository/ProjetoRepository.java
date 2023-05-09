package com.thiagobfb.avaliacaojavajsp.repository;

import com.thiagobfb.avaliacaojavajsp.domain.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
}
