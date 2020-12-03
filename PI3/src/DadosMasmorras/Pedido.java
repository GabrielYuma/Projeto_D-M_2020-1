package DadosMasmorras;

import java.util.Scanner;

public class Pedido {

	Scanner scan = new Scanner(System.in);
	boolean confirma;
	int cod, i, j, opc, tam, funcionario, qnt = 0, unidade, confcom;
	long cliente;
	double total;
	int produtos[] = new int[500];
	int quantidade[] = new int[500];
	Loja loja = new Loja();
	
	public void finalizarCompra() {
		
		loja.persAdminCont();
		loja.persAdminCarr();
		loja.persFuncioCont();
		loja.persFuncioCarr();
		loja.persClienteCont();
		loja.persClienteCarr();
		loja.persProdutoCont();
		loja.persProdutoCarr();

		total = 0;
			
		do {
			opc= Menu();
			switch (opc) {
			
			case 4:
				for (i = 0; i < tam; i++) {
					produtos[i] = 0;
					quantidade[i] = 0;
				}
				tam = 0;
				qnt = 0;
			

			case 1:
				produtos[tam] = loja.buscarProdutoC();
				tam++;
							
				System.out.println("Digite a quantidade: ");
				quantidade[qnt] = scan.nextInt();
				qnt++;
			
				System.out.println("\n Lista atual de produtos: ");
				for (j = 0; j < tam; j++) {
					System.out.println("\nJogo " + loja.buscarProdutoN(produtos[j]) + "  |   Código do produto: "
							+ produtos[j] + " \n Preço unitário: " + loja.buscarProdutoP(produtos[j])
							+ " | Quantidade: " + quantidade[j]);
				}
				break;

			case 2:
				System.out.println("\n Digite o código do produto para remover");
				cod = scan.nextInt();
				confirma = false;
				for (i = 0; i < tam; i++) {
                    if (produtos[i] == cod) {
                        System.out.println("\nDigite a quantidade que quer remover: ");
                        int corona = scan.nextInt();
                        if(quantidade[i] == corona) {
                            while (i < tam) {
                                produtos[i] = produtos[i + 1];
                                quantidade[i] = quantidade[i + 1];
                                i++;
                            }

                            confirma = true;
                            tam--;
                            qnt--;
                            break;
                        } else {
                            quantidade[i] = quantidade[i] - corona;
                            confirma = true;
                        }
                    }
                }
				if (!confirma) {
					System.out.println("\nCódigo incorreto");
				}
				
				System.out.println("\n Lista atual de produtos: ");
				for (j = 0; j < tam; j++) {
					System.out.println("\nJogo " + loja.buscarProdutoN(produtos[j]) + "  |   Código do produto: "
							+ produtos[j] + " \n Preço unitário: " + loja.buscarProdutoP(produtos[j])
							+ " | Quantidade: " + quantidade[j]);
				}
				
				break;

			case 3:
				for (i = 0; i < tam; i++) {
					total = total + (loja.buscarProdutoP(produtos[i]) * quantidade[i]);
				}

				for (i = 0; i < tam; i++) {
					System.out.println("\nJogo " + loja.buscarProdutoN(produtos[i]) + "  |   Código do produto: "
							+ produtos[i] + " \n Preço unitário: " + loja.buscarProdutoP(produtos[i])
							+ " | Quantidade: " + quantidade[i]);
					System.out.println("\n Total do carrinho  R$" + total);
				}
				pagamentoCompra();
				break;

			
			case 0:
				System.out.println("\n Você saiu!");
				break;

			default:
				System.out.println("\nCódigo inserido incorreto! ");

			}
		}while (opc != 0);

		
	}
	
	
	public void pagamentoCompra() {
		System.out.println("\nDigite a opção:\n 1 - Cartão de Crédito \n 2 - Dinheiro");
		opc = scan.nextInt();

		if (opc == 1) {

			int nCartao, nValidadeano, nValidademes, codSeguranca, cpf;
			String nome;

			cliente = loja.buscarClienteC(); 
			funcionario = loja.buscarFuncioC(); 

			System.out.println("\n Digite o numero do cartão: ");
			nCartao = scan.nextInt();

			System.out.println("\n Digite o codigo de segurança do cartão: ");
			codSeguranca = scan.nextInt();

			System.out.println("\n Digite o CPF do usuário do cartão: ");
			cpf = scan.nextInt();

			System.out.println("\n Digite a validade do cartão; mês e ano respectivamente: ");
			nValidademes = scan.nextInt();
			nValidadeano = scan.nextInt();

			System.out.println("\n Digite o nome do dono do cartão: ");
			nome = scan.next();

			System.out.println("\n Compra de  " + nome + "\n° CPF: " + cpf + " \n Valor da compra: R$" + total);

			System.out.println("\n Deseja parcelar a compra? 1 - Sim \n 2 - Não");
			opc = scan.nextInt();

			if (opc == 1) {
				System.out.println("\n Digite o numero de parcelas (de até 6x): ");
				int parcelas = scan.nextInt();

				System.out.println("\n\n Compra realizada pelo cliente " + nome + "\n CPF:" + cliente
						+ " \n Pedido dividido em " + parcelas + " parcelas de R$" + (total / parcelas));
				System.out.println("\n Código do vendedor: " + funcionario + "\n");
				System.out.println("");

			} else {
				System.out.println("\n\n Compra realizada pelo cliente " + nome + "\n CPF:" + cliente);
				System.out.println("\n\n Código do vendedor: " + funcionario + "\n");
				System.out.println("");
			}

		} else if (opc == 2) {
			System.out.println("\n Digite o valor pago pelo cliente: ");
			double valor = scan.nextDouble();

			System.out.println("\n O troco do cliente é de R$" + (valor - total));

		} else {
			System.out.println("\n Opção inválida!");

		}

		{
			System.out.println("\n Confirmar compra?\n 1 - Sim\n 2 - Não");
			confcom = scan.nextInt();

			if (confcom == 1) {
				System.out.println("\n Compra realizada! ");

			} else if (confcom == 2) {
				for (i = 0; i < tam; i++) {
					produtos[i] = 0;
					quantidade[i] = 0;
				}
				tam = 0;
				qnt = 0;
				System.out.println("\n Pedido cancelado!");
			}
		}
		while (confcom != 1 && confcom !=2);
	}

	
	public int Menu() {
		System.out.println(
				"\n Escolha a opção:\n (1) - Inserir produto\n (2) - Remover produto\n (3) - Finalizar compra\n (4) - Nova compra\n (0) - Sair");
		return opc = scan.nextInt();
	}
}
