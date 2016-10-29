package exceptions;

public class FornecedorNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	  public FornecedorNaoExisteException() {
	    super("Nao existe nenhum fornecedor com este codigo");
	    
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
