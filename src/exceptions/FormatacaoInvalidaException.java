package exceptions;

public class FormatacaoInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;

	public FormatacaoInvalidaException() {
		super("Formatação Invalida");
	}
}
