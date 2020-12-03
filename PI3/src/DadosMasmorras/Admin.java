package DadosMasmorras;

import java.util.Scanner;

public class Admin extends Pessoa {
	private int codigo;
	private int senha;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void manipCodigo() {
		Scanner scan = new Scanner(System.in);
		System.out.println("C�digo: ");
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
		System.out.println("Senha: ");
		setSenha(scan.nextInt());
	}

	public void cadastrar() {

		System.out.println("---------------------");
		System.out.println("Cadastro de Administrador");
		System.out.println("---------------------");

		manipNome();

		manipCpf();

		manipEndereco();

		manipEmail();

		manipTelefone();

		manipDtNacimento();

		manipCodigo();

		manipSenha();

		Scanner scan = new Scanner(System.in);
		int opt = 0;

		do {
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("Os seguintes dados foram cadastrados:\n" + toString());
			System.out.println("As informa��es est�o corretas? (1. Para Sim/2. Para N�o)");
			opt = scan.nextInt();
			if (opt == 2) {
				System.out.println("Qual campo deseja Editar? (Op��o entre 1 e 9)");
				Editar(scan.nextInt());
			} else if (opt == 1) {
				opt = 386;
			}

		} while (opt != 386);

	}

	@Override
	public String toString() {
		return "Administradores:\n(1)Nome: " + getNome() + "\n(2)CPF: " + getCpf() + "\n(3)Endere�o: " + getEndereco()
				+ "\n(4)Email: " + getEmail() + "\n(5)Telefone: " + getTelefone() + "\n(6)Data de Nascimento: "
				+ getDtNacimento() + "\n(8)C�digo: " + getCodigo() + "\n(9)Senha: " + getSenha();
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
		case 8:
			manipCodigo();
			break;
		case 9:
			manipSenha();
			break;
		case 0:
			System.out.println("Saiu");
			break;
		default:
			System.out.println("Op��o Invalida");
		}

	}

}
