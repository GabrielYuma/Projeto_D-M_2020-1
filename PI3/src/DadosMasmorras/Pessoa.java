package DadosMasmorras;

import java.util.Scanner;

public abstract class Pessoa {
	private String nome;
	private long cpf;
	private String endereco;
	private String email;
	private long telefone;
	private int dtNacimento;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
		}

	public int getDtNacimento() {
		return dtNacimento;
	}

	public void setDtNacimento(int dtNacimento) {
		this.dtNacimento = dtNacimento;
		
	}

	public void manipNome() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Nome: ");
		setNome(scan.nextLine());

	}

	public void manipCpf() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF: ");
		setCpf(scan.nextLong());
	}

	public void manipEndereco() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Endereço: ");
		setEndereco(scan.nextLine());
	}

	public void manipEmail() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Email: ");
		setEmail(scan.nextLine());
	}

	public void manipTelefone() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o Telefone: ");
		setTelefone(scan.nextLong());
	}
	
	public void manipDtNacimento() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Data de Nascimento: ");
		setDtNacimento(scan.nextInt());
	}

	
	
	
}
