package exceptions;

public class ClienteNaoExisteException extends Exception {
	  private int codigo;

	  public ClienteNaoExisteException() {
	    super("N�o existe nenhum cliente com o codigo");
	    
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
	}
