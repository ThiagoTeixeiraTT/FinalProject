package br.letscode.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;
    
    @JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
    @OneToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "quantidade")
    private Long quantidade;
    @Column(name = "data")
    private LocalDateTime DataPedido;
    @Column(name = "status")
    private EnumStatusPedido status;

    public void setStatus (EnumStatusPedido status) {
        this.status = status;
    }

    public Pedido(Cliente cliente, Produto produto, Long quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }


}
