package br.com.systemsgs.servicos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelServico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "A Descrição deve ser Informada!!!")
    private String descricao;

    @NotNull(message = "O Valor deve ser Informado!!!")
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ModelCliente cliente;

}
