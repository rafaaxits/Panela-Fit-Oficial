package exceptions;

public class FuncionarioNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	  public FuncionarioNaoExisteException() {
	    super("Nao existe funcionario com este codigo");
	    
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
