package br.com.systemsgs.servicos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome deve ser Informado!!!")
    private String nome;

    @NotBlank(message = "O CPF Deve ser Informado!!!")
    @CPF(message = "CPF Inválido!!!")
    private String cpf;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro = LocalDate.now();

}
