package exceptions;

public class FornecedorInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FornecedorInvalidoException(){
		super("Fornecedor Invalido");
	}
}
