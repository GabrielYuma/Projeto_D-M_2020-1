package DadosMasmorras;

import java.util.Scanner;

public class Produto {
	private int cod, qnt;
	private String nome, desc, genero, categoria;
	private double price;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void manipCod() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Código: ");
		setCod(scan.nextInt());
	}

	// sep
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void manipNome() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Nome: ");
		setNome(scan.nextLine());
	}

	// sep
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void manipDesc() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Descrição: ");
		setDesc(scan.nextLine());
	}

	// sep
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void manipGenero() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha o Genero:");
		System.out.println("(1) Educativo");
		System.out.println("(2) Competitivo");
		System.out.println("(3) Cooperativo");
		int cod = scan.nextInt();
		switch (cod) {
		case 1:
			setGenero("Educativo");
			break;
		case 2:
			setGenero("Competitivo");
			break;
		case 3:
			setGenero("Cooperativo");
			break;
		}

	}

	// sep
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void manipCategoria() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Escolha a Categoria:");
		System.out.println("(1) Kids");
		System.out.println("(2) Experts");
		System.out.println("(3) Familia");
		System.out.println("(4) Galera");
		int cod = scan.nextInt();
		switch (cod) {
		case 1:
			setCategoria("Kids");
			break;
		case 2:
			setGenero("Experts");
			break;
		case 3:
			setGenero("Familia");
			break;
		case 4:
			setGenero("Galera");
			break;
		}
	}

	// sep
	public int getQnt() {
		return qnt;
	}

	public void setQnt(int qnt) {
		this.qnt = qnt;
	}

	public void manipQnt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a Quantidade: ");
		setQnt(scan.nextInt());
	}

	// sep
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void manipPrice() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Preço: ");
		setPrice(scan.nextDouble());
	}

	@Override
	public String toString() {
		return "Produto [cod=" + cod + ", qnt=" + qnt + ", nome=" + nome + ", desc=" + desc + ", genero=" + genero
				+ ", categoria=" + categoria + ", price=" + price + "]";
	}

	public void cadastrar() {

		System.out.println("---------------------");
		System.out.println("Vamos Iniciar o Cadastro dos Produtos");
		System.out.println("---------------------");

		manipCod();

		manipNome();

		manipDesc();

		manipGenero();

		manipCategoria();

		manipQnt();

		manipPrice();

		Scanner scan = new Scanner(System.in);
		int opt = 0;

		do {
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("Os seguintes dados foram cadastrados:\n" + toString());
			System.out.println("As informações estão corretas? (1. Para Sim/2. Para Não)");
			opt = scan.nextInt();
			if (opt == 2) {
				System.out.println("Qual campo deseja Editar? (Opção entre 1 e 7)");
				Editar(scan.nextInt());
			} else if (opt == 1) {
				opt = 386;
			}

		} while (opt != 386);

	}

	public void Editar(int opt) {
		switch (opt) {
		case 1:
			manipCod();
			break;
		case 2:
			manipNome();
			break;
		case 3:
			manipDesc();
			break;
		case 4:
			manipGenero();
			break;
		case 5:
			manipCategoria();
			break;
		case 6:
			manipQnt();
			break;
		case 7:
			manipPrice();
			break;
		}

	}

}
