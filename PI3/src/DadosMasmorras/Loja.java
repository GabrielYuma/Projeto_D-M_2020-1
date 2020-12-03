package DadosMasmorras;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Loja {
	private int quantAdmin;
	private Admin vetAdmin[] = new Admin[quantAdmin];
	private int quantFuncio;
	private Funcionario vetFuncio[] = new Funcionario[quantFuncio];
	private int quantCliente;
	private Cliente vetCliente[] = new Cliente[quantCliente];
	private int quantProduto;
	private Produto vetProduto[] = new Produto[quantProduto];

	// Grupo AMD
	public void cadAdmin() {
		quantAdmin++;
		persAdminCarr();
		int x = quantAdmin - 1;
		if (x <= 0) {
			x = 1;
		}
		Admin adm = new Admin();
		vetAdmin[x] = adm;
		adm.cadastrar();
		persAdminCriar();
	}

	public void persAdminCriar() {
		PrintWriter arquivo = null;
		try {
			FileWriter out = new FileWriter("Admin.txt");
			arquivo = new PrintWriter(out);
			arquivo.print("Administrador Sistema");
			arquivo.print(";;");
			arquivo.print("1111111111");
			arquivo.print(";;");
			arquivo.print("Local da Loja");
			arquivo.print(";;");
			arquivo.print("XXXX@XXXXXX.com");
			arquivo.print(";;");
			arquivo.print(111111111);
			arquivo.print(";;");
			arquivo.print(11111);
			arquivo.print(";;");
			arquivo.print(1);
			arquivo.print(";;");
			arquivo.println(1);
			for (int i = 1; i < vetAdmin.length; i++) {
				if (vetAdmin[i] != null) {
					arquivo.print(vetAdmin[i].getNome());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getCpf());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getEndereco());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getEmail());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getTelefone());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getDtNacimento());
					arquivo.print(";;");
					arquivo.print(vetAdmin[i].getCodigo());
					arquivo.print(";;");
					arquivo.println(vetAdmin[i].getSenha());
				}

			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			arquivo.close();
		}

	}

	public void persAdminCont() {
		quantAdmin = 0;
		try {
			FileReader arq = new FileReader("Admin.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			do {
				linha = lerArq.readLine();
				quantAdmin++;
			} while (linha != null);
			if (quantAdmin <= 1) {
				quantAdmin = 2;
			}
			quantAdmin--;
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			quantAdmin = 1;

		}

	}

	public void persAdminCarr() {
		try {
			FileReader arq = new FileReader("Admin.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			int i = 0;
			this.vetAdmin = new Admin[quantAdmin];
			do {
				linha = lerArq.readLine();
				if (linha != null) {
					Admin adm = new Admin();
					vetAdmin[i] = adm;
					String[] atributos = linha.split(";;");
					vetAdmin[i].setNome(atributos[0]);
					vetAdmin[i].setCpf(Long.parseLong(atributos[1]));
					vetAdmin[i].setEndereco(atributos[2]);
					vetAdmin[i].setEmail(atributos[3]);
					vetAdmin[i].setTelefone(Long.parseLong(atributos[4]));
					vetAdmin[i].setDtNacimento(Integer.parseInt(atributos[5]));
					vetAdmin[i].setCodigo(Integer.parseInt(atributos[6]));
					vetAdmin[i].setSenha(Integer.parseInt(atributos[7]));
					i++;
				}
			} while (linha != null);
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			vetAdmin = new Admin[quantAdmin];

		}

	}

	public void listarAdmin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Lista de Administradores Cadastrados");
		for (int i = 0; i < quantAdmin; i++) {
			System.out.println("-------------------------");
			System.out.println("((" + (i + 1) + "))" + vetAdmin[i].toString());
		}
		System.out.println(
				"Deseja editar algum Administrador? (Digite o nº entre ((N)) para identificar qual ou 0 para sair");
		int opt = scan.nextInt();
		opt--;
		if (opt > 1 && opt < quantAdmin) {
			System.out.println(vetAdmin[opt].toString());
			System.out.println("Qual campo deseja Editar? (Opção entre 1 e 8)");
			vetAdmin[opt].Editar(scan.nextInt());
		}
	}

	public void buscarAdmin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Vamos Iniciar a Busca");
		System.out.println("-------------------------");
		System.out.println("Digite o CPF do Administrador que deseja encontrar: ");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		long x = 0;
		for (int i = 0; i < quantAdmin; i++) {
			x = vetAdmin[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}
		}
		if (!achou) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado como Administrador");
			System.out.println("-------------------------");

		} else {
			int opt = 0;
			do {
				System.out.println(vetAdmin[local].toString());
				System.out.println("Qual campo deseja Editar? (Opção entre 1 e 9 ou 0 para sair)");
				opt = scan.nextInt();
				vetAdmin[local].Editar(opt);
			} while (opt != 0);
		}

	}

	public void excluirAdmin() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF do Administrador que deseja excluir");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		for (int i = 0; i < quantAdmin; i++) {
			long x = vetAdmin[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF do Administrador Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado como Administrador");
			System.out.println("-------------------------");

		} else {
			System.out.println(vetAdmin[local].toString());
			System.out.println("Tem Certeza que deseja excluir? ( 1 - Para Sim e 2 - Para Não)");
			int opt = scan.nextInt();
			if (opt == 1) {
				vetAdmin[local] = null;
				persAdminCriar();
				persAdminCont();
				persAdminCarr();
			}

		}

	}

	public void desativarAdmin() {

	}

	public String[] loginAdmin(int login, int senha) {

		String aprovado[] = new String[3];
		aprovado[0] = "0";
		aprovado[1] = "0";
		aprovado[2] = "0";

		for (int i = 0; i < quantAdmin; i++) {
			int x = vetAdmin[i].getCodigo();
			if (x == login) {
				int y = vetAdmin[i].getSenha();
				if (y == senha) {
					aprovado[0] = "1";
					aprovado[1] = vetAdmin[i].getNome();
					aprovado[2] = String.valueOf(vetAdmin[i].getSenha());
					break;
				}
			}

		}
		return aprovado;

	}

	// Grupo Funcionario
	public void cadFuncionario() {
		quantFuncio++;
		persFuncioCarr();
		int x = quantFuncio - 1;
		if (x < 0) {
			x = 0;
		}
		Funcionario funcio = new Funcionario();
		vetFuncio[x] = funcio;
		funcio.cadastrar();
		persFuncioCriar();

	}

	public void persFuncioCriar() {
		PrintWriter arquivo = null;
		try {
			FileWriter out = new FileWriter("Funcionario.txt");
			arquivo = new PrintWriter(out);
			for (int i = 0; i < vetFuncio.length; i++) {
				if (vetFuncio[i] != null) {
					arquivo.print(vetFuncio[i].getNome());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getCpf());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getEndereco());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getEmail());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getTelefone());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getDtNacimento());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getCargo());
					arquivo.print(";;");
					arquivo.print(vetFuncio[i].getCodigo());
					arquivo.print(";;");
					arquivo.println(vetFuncio[i].getSenha());
				}

			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			arquivo.close();
		}

	}

	public void persFuncioCont() {
		quantFuncio = 0;
		try {
			FileReader arq = new FileReader("Funcionario.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			do {
				linha = lerArq.readLine();
				quantFuncio++;
			} while (linha != null);
			quantFuncio--;
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			quantFuncio = 1;
		}

	}

	public void persFuncioCarr() {
		try {
			FileReader arq = new FileReader("Funcionario.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			int i = 0;
			this.vetFuncio = new Funcionario[quantFuncio];
			do {
				linha = lerArq.readLine();
				if (linha != null) {
					Funcionario funcio = new Funcionario();
					vetFuncio[i] = funcio;
					String[] atributos = linha.split(";;");
					vetFuncio[i].setNome(atributos[0]);
					vetFuncio[i].setCpf(Long.parseLong(atributos[1]));
					vetFuncio[i].setEndereco(atributos[2]);
					vetFuncio[i].setEmail(atributos[3]);
					vetFuncio[i].setTelefone(Long.parseLong(atributos[4]));
					vetFuncio[i].setDtNacimento(Integer.parseInt(atributos[5]));
					vetFuncio[i].setCargo(atributos[6]);
					vetFuncio[i].setCodigo(Integer.parseInt(atributos[7]));
					vetFuncio[i].setSenha(Integer.parseInt(atributos[8]));
					i++;
				}

			} while (linha != null);
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			vetFuncio = new Funcionario[quantFuncio];

		}

	}

	public void listarFuncio() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Lista de Funcionarios Cadastrados");

		for (int i = 0; i < quantFuncio; i++) {
			System.out.println("-------------------------");
			System.out.println("(" + (i + 1) + ") " + vetFuncio[i].toString());
		}
		System.out.println(
				"Deseja editar algum funcionario? (Digite o nº entre ((N)) para identificar qual ou 0 para sair");
		int opt = scan.nextInt();
		opt--;
		if (opt > 0 && opt < quantFuncio) {
			System.out.println(vetFuncio[opt].toString());
			System.out.println("Qual campo deseja Editar? (Opção entre 1 e 9)");
			vetFuncio[opt].Editar(scan.nextInt());
		}

	}

	public int buscarFuncio() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Vamos Iniciar a Busca");
		System.out.println("-------------------------");
		System.out.println("Digite o CPF do Funcionario que deseja encontrar");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		int retorno = 0;
		for (int i = 0; i < quantFuncio; i++) {
			long x = vetFuncio[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado");
			System.out.println("-------------------------");

		} else {
			int opt = 0;
			System.out.println(vetFuncio[local].toString());
			System.out.println("Qual campo deseja Editar? (Opção entre 1 e 9)");
			vetFuncio[local].Editar(scan.nextInt());
			retorno = vetFuncio[local].getCodigo();
		}
		return retorno;
	}

	public void excluirFuncio() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF do Funcionario que deseja excluir");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		for (int i = 0; i < quantFuncio; i++) {
			long x = vetFuncio[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado");
			System.out.println("-------------------------");

		} else {
			System.out.println(vetFuncio[local].toString());
			System.out.println("Tem Certeza que deseja excluir? ( 1 - Para Sim e 2 - Para Não)");
			int opt = scan.nextInt();
			if (opt == 1) {
				vetFuncio[local] = null;
				persFuncioCriar();
				persFuncioCont();
				persFuncioCarr();
			}

		}

	}

	public String[] loginFuncio(int login, int senha) {

		String aprovado[] = new String[3];
		aprovado[0] = "0";
		aprovado[1] = "0";
		aprovado[2] = "0";

		for (int i = 0; i < quantFuncio; i++) {
			int x = vetFuncio[i].getCodigo();
			if (x == login) {
				int y = vetFuncio[i].getSenha();
				if (y == senha) {
					aprovado[0] = "1";
					aprovado[1] = vetFuncio[i].getNome();
					aprovado[2] = String.valueOf(vetFuncio[i].getSenha());
					break;
				}
			}

		}
		return aprovado;

	}

	// Grupo CLiente
	public void cadCliente() {
		quantCliente++;
		if (quantCliente <= 1) {
			quantCliente = 2;
		}
		persClienteCarr();
		int x = quantCliente - 1;
		if (x < 0) {
			x = 0;
		}
		Cliente cliente = new Cliente();
		vetCliente[x] = cliente;
		cliente.cadastrar();
		persClienteCriar();

	}

	public void persClienteCriar() {
		PrintWriter arquivo = null;
		try {
			FileWriter out = new FileWriter("Cliente.txt");
			arquivo = new PrintWriter(out);
			for (int i = 0; i < vetCliente.length; i++) {
				if (vetCliente[i] != null) {
					arquivo.print(vetCliente[i].getNome());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getCpf());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getEndereco());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getEmail());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getTelefone());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getDtNacimento());
					arquivo.print(";;");
					arquivo.print(vetCliente[i].getCodCliente());
				}

			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			arquivo.close();
		}

	}

	public void persClienteCont() {
		quantCliente = 0;
		try {
			FileReader arq = new FileReader("Cliente.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			do {
				linha = lerArq.readLine();
				quantCliente++;
			} while (linha != null);
			quantCliente--;
			arq.close();
		} catch (Exception e) {
			System.out.println(e);
			quantCliente = 1;
		}

	}

	public void persClienteCarr() {
		try {
			FileReader arq = new FileReader("Cliente.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			int i = 0;
			vetCliente = new Cliente[quantCliente];
			do {
				linha = lerArq.readLine();
				if (linha != null) {
					Cliente cliente = new Cliente();
					vetCliente[i] = cliente;
					String[] atributos = linha.split(";;");
					vetCliente[i].setNome(atributos[0]);
					vetCliente[i].setCpf(Long.parseLong(atributos[1]));
					vetCliente[i].setEndereco(atributos[2]);
					vetCliente[i].setEmail(atributos[3]);
					vetCliente[i].setTelefone(Long.parseLong(atributos[4]));
					vetCliente[i].setDtNacimento(Integer.parseInt(atributos[5]));
					vetCliente[i].setCodCliente(Integer.parseInt(atributos[6]));
					i++;
				}

			} while (linha != null);
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			vetCliente = new Cliente[quantCliente];

		}

	}

	public void listarCliente() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Lista de Clientes Cadastrados");

		for (int i = 0; i < quantCliente; i++) {
			System.out.println("-------------------------");
			System.out.println("(" + (i + 1) + ") " + vetCliente[i].toString());
		}
		System.out
				.println("Deseja editar algum cliente? (Digite o nº entre ((N)) para identificar qual ou 0 para sair");
		int opt = scan.nextInt();
		opt--;
		if (opt > 0 && opt < quantCliente) {
			System.out.println(vetCliente[opt].toString());
			System.out.println("Qual campo deseja Editar? (Opção entre 1 e 9)");
			vetCliente[opt].Editar(scan.nextInt());
		}

	}

	public long buscarCliente() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Vamos Iniciar a Busca");
		System.out.println("-------------------------");
		System.out.println("Digite o CPF do Cliente que deseja encontrar");
		long CPF = scan.nextLong();
		int local = 0;
		boolean achou = false;
		long retorno = 0;

		for (int i = 0; i < quantCliente; i++) {
			long x = vetCliente[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (!achou) {
			int opt = 0;
			do {
				System.out.println("-------------------------");
				System.out.println("CPF não Cadastrado");
				System.out.println("-------------------------");
				System.out.println("Deseja Cadastrar o Cliente? (1- Sim/2- Não");
				opt = scan.nextInt();
			} while (opt != 1 && opt != 2);
			if (opt == 1) {
				cadCliente();
				achou = true;
			}

		}
		if (achou) {
			int opt = 0;
			System.out.println(vetCliente[local].toString());
			do {
				System.out.println("Deseja Editar? (1 - Sim / 2- Não)");
				opt = scan.nextInt();
			} while (opt != 1 && opt != 2);
			if (opt == 1) {
				vetCliente[local].Editar(scan.nextInt());
			} else {
				retorno = vetCliente[local].getCpf();
			}
		}
		return retorno;

	}

	public void excluirCliente() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF do Cliente que deseja excluir");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		for (int i = 0; i < quantCliente; i++) {
			long x = vetCliente[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado");
			System.out.println("-------------------------");

		} else {
			System.out.println(vetCliente[local].toString());
			System.out.println("Tem Certeza que deseja excluir? ( 1 - Para Sim e 2 - Para Não)");
			int opt = scan.nextInt();
			if (opt == 1) {
				vetCliente[local] = null;
				persClienteCriar();
				persClienteCont();
				persClienteCarr();
			}

		}

	}

	// Grupo Produto
	public void cadProduto() {
		quantProduto++;
		persProdutoCarr();
		int x = quantProduto - 1;
		if (x < 0) {
			x = 0;
		}
		Produto produto = new Produto();
		vetProduto[x] = produto;
		produto.cadastrar();
		persProdutoCriar();
	}

	public void persProdutoCriar() {
		PrintWriter arquivo = null;
		try {
			FileWriter out = new FileWriter("Produto.txt");
			arquivo = new PrintWriter(out);
			for (int i = 0; i < vetProduto.length; i++) {
				if (vetProduto[i] != null) {
					arquivo.print(vetProduto[i].getCod());
					arquivo.print(";;");
					arquivo.print(vetProduto[i].getNome());
					arquivo.print(";;");
					arquivo.print(vetProduto[i].getDesc());
					arquivo.print(";;");
					arquivo.print(vetProduto[i].getGenero());
					arquivo.print(";;");
					arquivo.print(vetProduto[i].getCategoria());
					arquivo.print(";;");
					arquivo.print(vetProduto[i].getQnt());
					arquivo.print(";;");
					arquivo.println(vetProduto[i].getPrice());
				}

			}

		} catch (Exception e) {
			System.out.println(e);

		} finally {
			arquivo.close();
		}

	}

	public void persProdutoCont() {
		quantProduto = 0;
		try {
			FileReader arq = new FileReader("Produto.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			do {
				linha = lerArq.readLine();
				quantProduto++;
			} while (linha != null);
			quantProduto--;
			arq.close();
		} catch (Exception e) {
			System.out.println(e);
			quantProduto = 1;
		}

	}

	public void persProdutoCarr() {
		try {
			FileReader arq = new FileReader("Produto.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha;
			int i = 0;
			this.vetProduto = new Produto[quantProduto];
			do {
				linha = lerArq.readLine();
				if (linha != null) {
					Produto produto = new Produto();
					vetProduto[i] = produto;
					String[] atributos = linha.split(";;");
					vetProduto[i].setCod(Integer.parseInt(atributos[0]));
					vetProduto[i].setNome(atributos[1]);
					vetProduto[i].setDesc(atributos[2]);
					vetProduto[i].setGenero(atributos[3]);
					vetProduto[i].setCategoria(atributos[4]);
					vetProduto[i].setQnt(Integer.parseInt(atributos[5]));
					vetProduto[i].setPrice(Double.parseDouble(atributos[6]));
					i++;
				}

			} while (linha != null);
			arq.close();

		} catch (Exception e) {
			System.out.println(e);
			vetProduto = new Produto[quantProduto];
		}

	}

	public void listarProduto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Lista de Produtos Cadastrados");

		for (int i = 0; i < quantProduto; i++) {
			System.out.println("-------------------------");
			System.out.println("(" + (i + 1) + ") " + vetProduto[i].toString());
		}
		System.out
				.println("Deseja editar algum Produto? (Digite o nº entre ((N)) para identificar qual ou 0 para sair");
		int opt = scan.nextInt();
		opt--;
		if (opt > 0 && opt < quantProduto) {
			System.out.println(vetProduto[opt].toString());
			System.out.println("Qual campo deseja Editar? (Opção entre 1 e 7)");
			vetProduto[opt].Editar(scan.nextInt());
		}

	}

	public void buscarProduto(int tipo) {

		String[] retorno = { "0", "0", "0", "0", "0", "0", "0" };
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Vamos Iniciar a Busca");
		System.out.println("-------------------------");
		int local = 0;
		boolean achou = false;
		int x = 0;
		int cod = 0;
		String listar;
		achou = false;
		switch (tipo) {
		case 1:
			x = 0;
			System.out.println("Digite o Código do Produto");
			cod = scan.nextInt();
			for (int i = 0; i < quantProduto; i++) {
				x = vetProduto[i].getCod();
				if (x == cod) {
					System.out.println("-------------------------");
					System.out.println("Produto Encontrado");
					System.out.println("-------------------------");
					local = i;
					achou = true;
					break;
				}
			}
			if (!achou) {
				System.out.println("-------------------------");
				System.out.println("Produto não Cadastrado");
				System.out.println("-------------------------");

			}
			break;
		case 2:
			System.out.println("Escolha o Genero:");
			System.out.println("(1) Educativo");
			System.out.println("(2) Competitivo");
			System.out.println("(3) Cooperativo");
			cod = scan.nextInt();
			switch (cod) {
			case 1:
				listar = "Educativo";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getGenero())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;
			case 2:
				listar = "Competitivo";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getGenero())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;
			case 3:
				listar = "Cooperativo";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getGenero())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;

			}
			break;

		case 3:
			System.out.println("Escolha a Categoria:");
			System.out.println("(1) Kids");
			System.out.println("(2) Experts");
			System.out.println("(3) Familia");
			System.out.println("(4) Galera");
			cod = scan.nextInt();

			switch (cod) {
			case 1:
				listar = "Kids";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getCategoria())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;
			case 2:
				listar = "Experts";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getCategoria())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;
			case 3:
				listar = "Familia";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getCategoria())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;
			case 4:
				listar = "Galera";
				for (int i = 0; i < quantProduto; i++) {
					if (listar.equalsIgnoreCase(vetProduto[i].getCategoria())) {
						System.out.println("-------------------------");
						System.out.println(vetProduto[i].toString());
						achou = true;
					}
				}
				break;

			}

			if (!achou) {
				System.out.println("-------------------------");
				System.out.println("Produto não Cadastrado");
				System.out.println("-------------------------");

			}
		}

	}

	public int buscarProdutoC() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Digite o Código do Produto");
		int cod = scan.nextInt();
		int retorno;
		int local = 0;
		for (int i = 0; i < quantProduto; i++) {
			long x = vetProduto[i].getCod();
			if (x == cod) {
				local = i;
				break;
			}

		}
		retorno = vetProduto[local].getCod();
		return retorno;
	}

	public double buscarProdutoP(int cod) {
		double retorno;
		int i;
		for (i = 0; i < quantProduto; i++) {
			long x = vetProduto[i].getCod();
			if (x == cod) {
				break;
			}

		}
		retorno = vetProduto[i].getPrice();
		return retorno;
	}

	public String buscarProdutoN(int cod) {
		String retorno;
		int i;
		for (i = 0; i < quantProduto; i++) {
			long x = vetProduto[i].getCod();
			if (x == cod) {
				break;
			}

		}
		retorno = vetProduto[i].getNome();
		return retorno;
	}

	public void excluirProduto() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Cod do Produto que deseja excluir");
		long cod = scan.nextInt();
		int local = 0;
		boolean achou = false;
		for (int i = 0; i < quantProduto; i++) {
			long x = vetCliente[i].getCpf();
			if (x == cod) {
				System.out.println("-------------------------");
				System.out.println("Produto Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("Produto não Cadastrado");
			System.out.println("-------------------------");

		} else {
			System.out.println(vetProduto[local].toString());
			System.out.println("Tem Certeza que deseja excluir? ( 1 - Para Sim e 2 - Para Não)");
			int opt = scan.nextInt();
			if (opt == 1) {
				vetCliente[local] = null;
				persClienteCriar();
				persClienteCont();
				persClienteCarr();
			}

		}

	}

	// Grupo Vendas

	public long buscarClienteC() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Digite o CPF do Cliente que deseja encontrar");
		System.out.println("-------------------------");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		long retorno = 0;

		for (int i = 0; i < quantCliente; i++) {
			long x = vetCliente[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (!achou) {
			int opt = 0;
			do {
				System.out.println("-------------------------");
				System.out.println("CPF não Cadastrado");
				System.out.println("-------------------------");
				System.out.println("Deseja Cadastrar o Cliente? (1- Sim/2- Não");
				opt = scan.nextInt();
			} while (opt != 1 && opt != 2);
			if (opt == 1) {
				cadCliente();
				achou = true;
			}

		}
		if (achou) {
			int opt = 0;
			System.out.println(vetCliente[local].toString());
			retorno = vetCliente[local].getCpf();
		}
		return retorno;

	}

	public int buscarFuncioC() {
		Scanner scan = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("Vamos Iniciar a Busca");
		System.out.println("-------------------------");
		System.out.println("Digite o CPF do Funcionario que deseja encontrar");
		long CPF = scan.nextInt();
		int local = 0;
		boolean achou = false;
		int retorno = 0;
		for (int i = 0; i < quantFuncio; i++) {
			long x = vetFuncio[i].getCpf();
			if (x == CPF) {
				System.out.println("-------------------------");
				System.out.println("CPF Encontrado");
				System.out.println("-------------------------");
				local = i;
				achou = true;
				break;
			}

		}
		if (achou == false) {
			System.out.println("-------------------------");
			System.out.println("CPF não Cadastrado");
			System.out.println("-------------------------");

		} else {
			int opt = 0;
			System.out.println(vetFuncio[local].toString());
			retorno = vetFuncio[local].getCodigo();
		}
		return retorno;
	}

}
