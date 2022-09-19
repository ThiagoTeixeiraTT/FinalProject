package br.letscode.dto;

import java.math.BigDecimal;


public class ProdutoDto {

    private long idProduto;
    private String nome;
    private BigDecimal preco;
    private String descricao;

    public long getId() {
        return idProduto;
    }

    public void setId(long id) {
        this.idProduto = id;
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

    public ProdutoDto(long idProdudo, String nome, String preco, String descricao){
        this.idProduto = idProdudo;
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.descricao = descricao;
    }

    public ProdutoDto(String nome, String preco, String descricao){
        this.nome = nome;
        this.preco = new BigDecimal(preco);
        this.descricao = descricao;
    }

    public ProdutoDto() {}

}
