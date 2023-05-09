package com.thiagobfb.avaliacaojavajsp.services;

import com.thiagobfb.avaliacaojavajsp.domain.Pessoa;
import com.thiagobfb.avaliacaojavajsp.domain.Projeto;
import com.thiagobfb.avaliacaojavajsp.repository.PessoaRepository;
import com.thiagobfb.avaliacaojavajsp.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> findAll() {
        return Streamable.of(repository.findAll()).toList();
    }

    public Pessoa insert(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Pessoa find(Long id) {
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato ! Id: " + id + ", Tipo: " + Pessoa.class.getName()));
    }

    public Pessoa update(Pessoa pessoa) {
        Pessoa obj = this.find(pessoa.getId());
        obj.setNome(pessoa.getNome());
        obj.setFuncionario(pessoa.getFuncionario());
        return repository.save(obj);
    }
}
