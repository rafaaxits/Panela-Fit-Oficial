package exceptions;

public class ProdutoNaoExisteException extends Exception {


	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoNaoExisteException(int codigo) {
	    super("Nao existe nenhum produto com o codigo '" + codigo + "'.");

	  }
}
