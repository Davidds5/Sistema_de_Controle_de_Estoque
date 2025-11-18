package br.com.estoque.Exceptions;

public class ProdutoNaoEncotrado extends Exception{
    // essa String msg e extansiada da class Exceptions
    public ProdutoNaoEncotrado(String msg){
        super(msg);
    }

}
