package br.com.estoque.Domain;

public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;

    public Produto(String nome, String codigo, double preco, int quantidade){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;

    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void adicionar(int qtd){
        this.quantidade += qtd;
    }
    public void remover(int qtd){
        this.quantidade += qtd;
    }
    public double valorTotal(){
        return quantidade * preco;
    }
    @Override
    public String toString(){
        return "Nome: "+nome+" |Codigo: "+codigo+" |Preco: R$"+preco+" |Quantidade: "+ quantidade;

    }
}
