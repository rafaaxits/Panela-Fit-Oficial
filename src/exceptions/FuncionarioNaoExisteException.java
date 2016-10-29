package exceptions;

public class FuncionarioNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	  public FuncionarioNaoExisteException() {
	    super("Nao existe funcionario com este codigo");
	    
	  }

}
