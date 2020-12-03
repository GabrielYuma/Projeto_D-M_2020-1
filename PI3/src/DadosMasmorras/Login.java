package DadosMasmorras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Login {
	static int codigo, senha = 0;
	static String dadosLogin[] = new String[3];
	static Loja loja = new Loja();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opt1, opt2 = 0;
		dadosLogin[0] = "0";
		dadosLogin[1] = "0";
		dadosLogin[2] = "0";
		try {
			FileReader arq = new FileReader("Primeira.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			do {
				linha = lerArq.readLine();
			} while (linha != null);
			arq.close();
		} catch (Exception e) {
			System.out.println("Primeira Execução, fazendo ajustes necessários");
			loja.persAdminCriar();
			PrintWriter arquivo = null;
			try {
				FileWriter out = new FileWriter("Primeira.txt");
				arquivo = new PrintWriter(out);
				arquivo.print("Funciona");
			} catch (Exception e1) {
				System.out.println(e1);
			} finally {
				arquivo.close();
			}
		}
		loja.persAdminCont();
		loja.persAdminCarr();
		loja.persFuncioCont();
		loja.persFuncioCarr();
		loja.persClienteCont();
		loja.persClienteCarr();
		loja.persProdutoCont();
		loja.persProdutoCarr();
		
		do {
			System.out.println("-------------------------");
			System.out.println("Sistema Dados e Masmorras");
			System.out.println("-------------------------");
			System.out.println("(1) Para efetuar Busca de Produtos");
			System.out.println("(2) Para efetuar Login");
			System.out.println("(0) Para sair");
			opt1 = scan.nextInt();

			switch (opt1) {
			case 1:
				System.out.println("-------------------------");
				System.out.println("Buscar Produto");
				System.out.println("-------------------------");
				System.out.print("1- Listar por Categoria: ");
				System.out.print("2- Listar por Genero: ");
				int tipo = scan.nextInt();
				switch (tipo) {
				case 1:
					loja.buscarProduto(3);
					break;
				case 2:
					loja.buscarProduto(2);
					break;
				}
				break;

			case 2:
				System.out.println("-------------------------");
				System.out.println("Sistema Dados e Masmorras");
				System.out.println("-------------------------");
				System.out.print("Digite o Codigo de Login: ");
				codigo = scan.nextInt();
				System.out.print("Digite a Senha: ");
				senha = scan.nextInt();
				
				dadosLogin = loja.loginAdmin(codigo, senha);
				
				if (dadosLogin[0] == "0") {
					dadosLogin = loja.loginFuncio(codigo, senha);
				}
				if (dadosLogin[0] == "1") {
					do {
						opt2 = 200;
						System.out.println("-------------------------");
						System.out.println("Bem Vindo Administrador " + dadosLogin[1]);
						System.out.println("-------------------------");
						System.out.println("(1) Opções de Administrador");
						System.out.println("(2) Opções de Funcionários");
						System.out.println("(3) Opções de Cliente");
						System.out.println("(4) Opções de Produto");
						System.out.println("(5) Opções de Venda");
						System.out.println("(0) Para Sair");
						opt2 = scan.nextInt();
						switch (opt2) {
						case 1:
							menuAdministrador();
							break;
						case 2:
							menuFuncionario();
							break;
						case 3:
							menuCliente();
							break;
						case 4:
							menuProduto();
							break;
						case 5:
							Pedido ped = new Pedido();
							ped.finalizarCompra();
							break;
						}

					} while (opt2 != 0);

				} else if (dadosLogin[0] == "2") {
					do {
						opt2 = 200;
						System.out.println("-------------------------");
						System.out.println("Bem Vindo" + dadosLogin[1]);
						System.out.println("-------------------------");
						System.out.println("(1) Opções de Cliente");
						System.out.println("(2) Opções de Produto");
						System.out.println("(3) Opções de Venda");
						System.out.println("(0) Para Sair");
						opt2 = scan.nextInt();
						switch (opt2) {
						case 1:
							menuCliente();
							break;
						case 2:
							menuProduto();
							break;
						case 3:
							Pedido ped = new Pedido();
							ped.finalizarCompra();
							break;
						}
					} while (opt2 != 0);
				} else {
					System.out.println("-------------------------");
					System.out.println("Login ou Senha inseridos Incorretamente");
					System.out.println("-------------------------");
					break;
				}

			}

		} while (opt1 != 0);

	}

	public static void menuAdministrador() {
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("-------------------------");
			System.out.println("CONTROLE DE Administradores");
			System.out.println("-------------------------");
			System.out.println("(1) Cadastrar Administrador");
			System.out.println("(2) Exibir todos os Administradores Cadastrados");
			System.out.println("(3) Buscar um Aministrador pelo CPF");
			System.out.println("(4) Desativar um Administrador");
			System.out.println("(5) Excluir um Administrador");
			System.out.println("(0) Sair");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				loja.cadAdmin();
				break;
			case 2:
				loja.listarAdmin();
				break;
			case 3:
				loja.buscarAdmin();
				break;
			case 4:
				System.out.println("Em Construção");
				break;
			case 5:
				loja.excluirAdmin();
				break;
			}

		} while (opt != 0);
	}

	public static void menuFuncionario() {
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("-------------------------");
			System.out.println("CONTROLE DE Funcionario");
			System.out.println("-------------------------");
			System.out.println("(1) Cadastrar Funcionario");
			System.out.println("(2) Exibir todos os Funcionarios Cadastrados");
			System.out.println("(3) Buscar um Funcionario pelo CPF");
			System.out.println("(4) Desativar um Funcionario");
			System.out.println("(5) Exlcuir um Funcionario");
			System.out.println("(0) Para Sair");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				loja.cadFuncionario();
				break;
			case 2:
				loja.listarFuncio();
				break;
			case 3:
				loja.buscarFuncio();
				break;
			case 4:
				System.out.println("Em Construção");
				break;
			case 5:
				loja.excluirFuncio();
				break;
			}

		} while (opt != 0);
	}

	public static void menuCliente() {
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("-------------------------");
			System.out.println("CONTROLE DE CLIENTES");
			System.out.println("-------------------------");
			System.out.println("(1) Para Cadastrar Cliente");
			System.out.println("(2) Para Exibir todos os Clientes Cadastrados");
			System.out.println("(3) Para Buscar um Cliente pelo CPF");

			if (dadosLogin[0] == "1") {
				System.out.println("(4) Para Desativar um Funcionario");
				System.out.println("(5) Para Exlcuir um Cliente");
			}

			System.out.println("(0) Para Sair");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				loja.cadCliente();
				break;
			case 2:
				loja.listarCliente();
				break;
			case 3:
				loja.buscarCliente();
				break;
			case 4:
				if (dadosLogin[0] == "1") {
				}
				break;
			case 5:
				if (dadosLogin[0] == "1") {
					loja.excluirCliente();
				}
				break;
			}

		} while (opt != 0);
	}

	public static void menuProduto() {
		Scanner scan = new Scanner(System.in);
		int opt = 0;
		do {
			System.out.println("-------------------------");
			System.out.println("CONTROLE DE Produtos");
			System.out.println("-------------------------");
			System.out.println("(1) Para Cadastrar Produto");
			System.out.println("(2) Para Exibir todos os Produtos Cadastrados");
			System.out.println("(3) Para Buscar um Produto");

			if (dadosLogin[0] == "1") {
				System.out.println("(4) Para Desativar um Produto");
				System.out.println("(5) Para Exlcuir um Produto");
			}
			System.out.println("(0) Para Sair");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				
				loja.cadProduto();
				break;
			case 2:
				
				loja.listarProduto();
				break;
			case 3:
				
				loja.buscarProduto(1);
				break;
				
			case 4:
				if (dadosLogin[0] == "1") {
					System.out.println("em construção");
				}
				break;

			case 5:
				if (dadosLogin[0] == "1") {
					loja.excluirProduto();
				}
				break;
			}

		} while (opt != 0);
	}
}
