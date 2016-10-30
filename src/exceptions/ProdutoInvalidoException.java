package exceptions;

public class ProdutoInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ProdutoInvalidoException(){
		super("Produto Invalido");
	}
}
