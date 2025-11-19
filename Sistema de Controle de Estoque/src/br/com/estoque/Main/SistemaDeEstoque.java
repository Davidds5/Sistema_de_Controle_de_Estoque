package br.com.estoque.Main;

import br.com.estoque.Exceptions.ProdutoNaoEncotrado;
import br.com.estoque.Exceptions.QuantidadeInvalida;
import br.com.estoque.Service.EstoqueServico;
import br.com.estoque.Util.LoggerUtil;

import java.util.Scanner;

public class SistemaDeEstoque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstoqueServico estoqueServico = new EstoqueServico();

        while (true) {
            System.out.println("\n======= SISTEMA DE ESTOQUE ========");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Entrada de estoque");
            System.out.println("3 - Saída de estoque");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Valor total do estoque");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");

            int op;

            try {
                op = sc.nextInt();
                sc.nextLine(); // Consumindo ENTER
            } catch (Exception e) {
                System.out.println("⚠ Entrada inválida! Digite apenas números.");
                sc.nextLine(); // limpar buffer
                continue; // volta para o menu
            }

            try {
                switch (op) {
                    case 1: // CADASTRO DE PRODUTO
                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();

                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();
                        sc.nextLine();

                        estoqueServico.cadastra(nome, codigo, preco, quantidade);
                        System.out.println("✔ Produto cadastrado com sucesso!");
                        break;

                    case 2:
                        System.out.print("Código: ");
                        String codigoEntrada = sc.nextLine();

                        System.out.print("Quantidade: ");
                        int qtdEntrada = sc.nextInt();
                        sc.nextLine();

                        estoqueServico.entrada(codigoEntrada, qtdEntrada);
                        System.out.println("✔ Entrada registrada com sucesso!");
                        break;

                    case 3:
                        System.out.print("Código: ");
                        String codigoSaida = sc.nextLine();

                        System.out.print("Quantidade: ");
                        int qtdSaida = sc.nextInt();
                        sc.nextLine();

                        estoqueServico.saida(codigoSaida, qtdSaida);
                        System.out.println("✔ Saída registrada com sucesso!");
                        break;

                    case 4:
                        estoqueServico.lista();
                        break;

                    case 5:
                        double total = estoqueServico.valorTotalEstoque();
                        System.out.println("💰 Valor total do estoque: R$ " + total);
                        break;

                    case 6:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("⚠ Opção inválida!");
                }

            } catch (QuantidadeInvalida | ProdutoNaoEncotrado e) {
                System.out.println("Erro: " + e.getMessage());
                LoggerUtil.registraErro(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                LoggerUtil.registraErro("ERRO GERAL: " + e.getMessage());
            }
        }
    }
}
