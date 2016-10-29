package exceptions;

public class ClienteNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	  public ClienteNaoExisteException() {
	    super("Nao existe nenhum cliente com este codigo");
	    
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
	}
