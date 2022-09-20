package br.letscode.models;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPedido;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @Column(name = "quantidade")
    private long quantidade;

    @Column(name = "data")
    private LocalDateTime DataPedido;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatusPedido status;

    public void setStatus (EnumStatusPedido status) {
        this.status = status;
    }

    public Pedido(Cliente cliente, Produto produto, long quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.status = EnumStatusPedido.CONFIRMADO;
        this.DataPedido = LocalDateTime.now();
    }

}
