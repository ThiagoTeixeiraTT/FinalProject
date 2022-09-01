package br.letscode.models;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "descricao")
    private String descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco.setScale(2).toString();
    }

    public void setPreco(String preco) {
        this.preco = new BigDecimal(preco);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto(long id, String nome, String preco, String descricao){
        this.id = id;
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.descricao = descricao;
    }

    public Produto(String nome, String preco, String descricao){
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.descricao = descricao;
    }

    public Produto() {}

}
