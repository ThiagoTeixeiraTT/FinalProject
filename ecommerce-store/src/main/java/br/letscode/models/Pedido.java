package br.letscode.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    @Column(name = "ValorTotal")
    private String valorTotal;

    @Column(name = "data")
    private LocalDateTime dataPedido;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EnumStatusPedido status;

    public void setValorTotal(BigDecimal valBd) {
        this.valorTotal = valBd.setScale(2, RoundingMode.HALF_UP).toString();

    }

    public Pedido(Cliente cliente, Produto produto, long quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.status = EnumStatusPedido.CONFIRMADO;
        this.dataPedido = LocalDateTime.now();
    }

}
