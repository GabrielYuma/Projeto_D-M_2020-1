package DadosMasmorras;

import java.util.Scanner;

public class Cliente extends Pessoa {
	private int codCliente;

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public void cadastrar() {

		System.out.println("---------------------");
		System.out.println("Vamos Iniciar o Cadastro de Cliente");
		System.out.println("---------------------");

		manipNome();

		manipCpf();

		manipEndereco();

		manipEmail();

		manipTelefone();

		manipDtNacimento();

		Scanner scan = new Scanner(System.in);
		int opt = 0;

		do {
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("Os seguintes dados foram cadastrados:\n" + toString());
			System.out.println("As informações estão corretas? (1. Para Sim/2. Para Não)");
			opt = scan.nextInt();
			if (opt == 2) {
				System.out.println("Qual campo deseja Editar? (Opção entre 1 e 6)");
				Editar(scan.nextInt());
			} else if (opt == 1) {
				opt = 386;
			}

		} while (opt != 386);

	}

	@Override
	public String toString() {
		return "Clientes:\n(1)Nome: " + getNome() + "\n(2)CPF: " + getCpf() + "\n(3)Endereço: " + getEndereco()
				+ "\n(4)Email: " + getEmail() + "\n(5)Telefone: " + getTelefone() + "\n(6)Data de Nascimento: "
				+ getDtNacimento() + "\n(7)Código Funcioáiro: " + getCodCliente();
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

		}

	}

}
