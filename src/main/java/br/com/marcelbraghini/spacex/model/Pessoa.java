package br.com.marcelbraghini.spacex.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(max=100)
    private String nome;

    private LocalDate datanascimento;

    @Size(max=14)
    private String cpf;

    private Boolean funcionario;

}

