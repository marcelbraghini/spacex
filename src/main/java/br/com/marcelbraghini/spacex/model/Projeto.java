package br.com.marcelbraghini.spacex.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(max=200)
    @NonNull
    private String nome;

    @Column(columnDefinition = "data_inicio")
    private LocalDate dataInicio;

    @Column(columnDefinition = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(columnDefinition = "data_fim")
    private LocalDate dataFim;

    @Size(max=5000)
    private String descricao;

    @Size(max=45)
    @Enumerated(EnumType.STRING)
    private Status status;

    private BigDecimal orcamento;

    @Size(max=45)
    @Enumerated(EnumType.STRING)
    private Risco risco;

    @NonNull
    private Integer idgerente;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membros",
            joinColumns = { @JoinColumn(name = "idprojeto") },
            inverseJoinColumns = { @JoinColumn(name = "idpessoa") })
    private Set<Pessoa> membros = new HashSet<>();

    public Boolean possivelExcluir(){
        if (status.equals(Status.INICIADO) ||
            status.equals(Status.EM_ANDAMENTO) ||
            status.equals(Status.ENCERRADO)) {
            return false;
        }
        return true;
    }

}

