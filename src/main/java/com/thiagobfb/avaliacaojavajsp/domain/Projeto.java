package com.thiagobfb.avaliacaojavajsp.domain;

import com.thiagobfb.avaliacaojavajsp.domain.enums.RiscoProjeto;
import com.thiagobfb.avaliacaojavajsp.domain.enums.StatusProjeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "PROJETO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projeto {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data-inicio")
    private LocalDate dataInicio;

    @Column(name = "data-previsao-fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data-fim")
    private LocalDate dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @Column(name = "orcamento", nullable = false)
    private Double orcamento;

    @Column(name = "risco", nullable = false)
    @Enumerated(EnumType.STRING)
    private RiscoProjeto risco;

    @ManyToOne
    @JoinColumn(name = "idgerente")
    private Pessoa gerente;

    @ManyToMany
    @JoinTable(
            name = "membros",
            joinColumns = @JoinColumn(name = "idprojeto"),
            inverseJoinColumns = @JoinColumn(name = "idpessoa"))
    private Set<Pessoa> membros;

}
