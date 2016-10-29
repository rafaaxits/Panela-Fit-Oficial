package exceptions;

public class FornecedorNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  public FornecedorNaoExisteException() {
	    super("Nao existe nenhum fornecedor com este codigo");
	    
	  }

}
