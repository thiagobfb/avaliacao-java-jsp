package com.thiagobfb.avaliacaojavajsp.services;

import com.thiagobfb.avaliacaojavajsp.domain.Projeto;
import com.thiagobfb.avaliacaojavajsp.repository.ProjetoRepository;
import com.thiagobfb.avaliacaojavajsp.services.exception.ObjectNotFoundException;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public List<Projeto> getProjetos() {
        return Streamable.of(repository.findAll()).toList();
    }

    public Projeto addProjeto(Projeto projeto) {
        return repository.save(projeto);
    }

    public void deleteProjeto(Long id) {
        repository.deleteById(id);
    }

    public Projeto getProjetoPorId(Long id) {
        Optional<Projeto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrato ! Id: " + id + ", Tipo: " + Projeto.class.getName()));
    }

    public void update(Projeto projeto) {
        Projeto prj = this.getProjetoPorId(projeto.getId());
        prj.setDataInicio(projeto.getDataInicio());
        prj.setDataFim(projeto.getDataFim());
        prj.setDescricao(projeto.getDescricao());
        prj.setGerente(projeto.getGerente());
        prj.setMembros(projeto.getMembros());
        prj.setNome(projeto.getNome());
        prj.setOrcamento(projeto.getOrcamento());
        prj.setRisco(projeto.getRisco());
        prj.setStatus(projeto.getStatus());
        repository.save(prj);
    }
}
