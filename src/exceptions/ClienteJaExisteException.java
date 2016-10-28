package exceptions;

public class ClienteJaExisteException extends Exception{
	private int codigo;

	  public ClienteJaExisteException(int codigo) {
	    super("J� existe um cliente cadastrado com o cpf '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}

