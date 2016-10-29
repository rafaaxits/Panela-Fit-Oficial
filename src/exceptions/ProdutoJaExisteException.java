package exceptions;

public class ProdutoJaExisteException extends Exception {


	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdutoJaExisteException(int codigo) {
	    super("Ja existe um produto com o codigo '" + codigo + "'.");

	  }

}
