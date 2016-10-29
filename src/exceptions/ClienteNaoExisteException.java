package exceptions;

public class ClienteNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	  public ClienteNaoExisteException() {
	    super("Nao existe nenhum cliente com este codigo");
	    
	  }
}
