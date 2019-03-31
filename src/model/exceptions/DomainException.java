package model.exceptions;

// A SuperClasse RuntimeException NÃO obriga a todas as exceções serem tratadas
public class DomainException extends RuntimeException {

	// A SuperClasse RuntimeException é uma classe Serializable e precisa ter um numero de versão delcarado	
	private static final long serialVersionUID = 1L;

	// Alterando o construtor padrão para receber uma mensagem do tipo string como argumento e repassar para o construtor SuperClasse
	public DomainException(String msg) {
		super(msg);
	}
	
}
