package exceptions;

public class ProdutoNaoExisteException extends Exception {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public ProdutoNaoExisteException() {
		super("Nao existe nenhum produto com este codigo.");
	}
}
