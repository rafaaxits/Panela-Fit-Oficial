package exceptions;

public class ClienteJaExisteException extends Exception{
	private int codigo;

	  public ClienteJaExisteException(int codigo) {
	    super("Já existe um cliente cadastrado com o cpf '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}

