package exceptions;

public class ClienteNaoExisteException extends Exception {
	  private int codigo;

	  public ClienteNaoExisteException(int codigo) {
	    super("Não existe nenhum cliente com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
	}
