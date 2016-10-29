package exceptions;

public class FornecedorNaoExisteException extends Exception {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FornecedorNaoExisteException(int codigo) {
	    super("Nao existe nenhum fornecedor com o codigo.");
	    
	  }

}
