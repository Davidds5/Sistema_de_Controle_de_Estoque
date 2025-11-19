package br.com.estoque.Service;

import br.com.estoque.Domain.Produto;
import br.com.estoque.Exceptions.ProdutoNaoEncotrado;
import br.com.estoque.Exceptions.QuantidadeInvalida;

import java.util.ArrayList;
import java.util.List;

public class EstoqueServico {
    private List<Produto> produtos = new ArrayList<>();

        // metodos tambem podem agir como construtor
        // de forma que o construtor e extansiado depois
        public void cadastra(String nome, String codigo, double preco, int quantidade){
            produtos.add(new Produto(nome, codigo, preco, quantidade));
            System.out.println("Produto cadrastado com sucesso!!");
        }
        public Produto buscaPorCodigo(String codigo) throws ProdutoNaoEncotrado {
            return produtos.stream().filter(p-> p.getCodigo().equalsIgnoreCase(codigo))
                    .findFirst()
                    .orElseThrow(() -> new ProdutoNaoEncotrado("Produto nao encotrado: "+ codigo));

        }
        public void entrada(String codigo, int quantidade) throws ProdutoNaoEncotrado, QuantidadeInvalida {
            if (quantidade <= 0)throw new QuantidadeInvalida("Quantidade Invalida para entrada");

            Produto p = buscaPorCodigo(codigo);
            p.adicionar(quantidade);
            System.out.println("Entrada registrada!");
        }
        public void saida(String codigo, int quantidade) throws ProdutoNaoEncotrado, QuantidadeInvalida{
            // Se a quantidade for menor que zero eu ultilizo a exceptions QuantidadeInvalidad
            if (quantidade <= 0)throw new QuantidadeInvalida("Quantidade invalida para saida");

            Produto produto = buscaPorCodigo(codigo);
            // se a quantidade removida for maior que a quantidade em estoque eu ultilzo a exceptions QuantidadeInvalida
            if (quantidade > produto.getQuantidade()){
                throw new QuantidadeInvalida("Estoque insuficiente para saida");
        }
            produto.remover(quantidade);
            System.out.println("Saida registrada!");
        }
        public void lista(){
            // mesma coisa de se usar um for each
            // para cada produto em produtos: imprima
            produtos.forEach(System.out::println);
        }
        public double valorTotalEstoque(){
            return produtos.stream()
                    .mapToDouble(Produto::valorTotal)
                    .sum();
            }
        }

