package DadosMasmorras;

import java.util.Scanner;

public class Funcionario extends Pessoa {

	private String cargo;
	private int codigo;
	private int senha;

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void manipCargo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Cargo: ");
		setCargo(scan.nextLine());
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void manipCodigo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Codigo de Funcionario: ");
		setCodigo(scan.nextInt());

	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public void manipSenha() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a Senha: ");
		setSenha(scan.nextInt());
	}

	public void cadastrar() {

		System.out.println("---------------------");
		System.out.println("Vamos Iniciar o Cadastro de Funcionário");
		System.out.println("---------------------");

		manipNome();

		manipCpf();

		manipEndereco();

		manipEmail();

		manipTelefone();

		manipDtNacimento();

		manipCargo();

		manipCodigo();

		manipSenha();

		Scanner scan = new Scanner(System.in);
		int opt = 0;

		do {
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("Os seguintes dados foram cadastrados:\n" + toString());
			System.out.println("As informações estão corretas? (1. Para Sim/2. Para Não)");
			opt = scan.nextInt();
			if (opt == 2) {
				System.out.println("Qual campo deseja Editar? (Opção entre 1 e 9)");
				Editar(scan.nextInt());
			} else if (opt == 1) {
				opt = 386;
			}

		} while (opt != 386);

	}

	@Override
	public String toString() {
		return "Funcionario:\n(1)Nome: " + getNome() + "\n(2)CPF: " + getCpf() + "\n(3)Endereço: " + getEndereco()
				+ "\n(4)Email: " + getEmail() + "\n(5)Telefone: " + getTelefone() + "\n(6)Data de Nascimento: "
				+ getDtNacimento() + "\n(7)Cargo: " + getCargo() + "\n(8)Código Funcioáiro: " + getCodigo() + "\n(9)Senha: "
				+ getSenha();
	}

	public void Editar(int opt) {
		switch (opt) {
		case 1:
			manipNome();
			break;
		case 2:
			manipCpf();
			break;
		case 3:
			manipEndereco();
			break;
		case 4:
			manipEmail();
			break;
		case 5:
			manipTelefone();
			break;
		case 6:
			manipDtNacimento();
			break;
		case 7:
			manipCargo();
			break;
		case 8:
			manipCodigo();
			break;
		case 9:
			manipSenha();
			break;
		}

	}

}
