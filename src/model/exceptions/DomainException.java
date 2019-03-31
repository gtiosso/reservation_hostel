package model.exceptions;

// A SuperClasse Exception obriga a todas as exceções serem tratadas de alguma forma
public class DomainException extends Exception {

	// A SuperClasse Exception é uma classe Serializable e precisa ter um numero de versão delcarado	
	private static final long serialVersionUID = 1L;

	// Alterando o construtor padrão para receber uma mensagem do tipo string como argumento e repassar para o construtor SuperClasse
	public DomainException(String msg) {
		super(msg);
	}
	
}
