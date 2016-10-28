package exceptions;

public class FuncionarioJaExisteException extends Exception {
	  private int codigo;

	  public FuncionarioJaExisteException(int codigo) {
	    super("Ja existe um funcionario com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
	}