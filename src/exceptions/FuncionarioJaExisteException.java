package exceptions;

public class FuncionarioJaExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	  public FuncionarioJaExisteException(int codigo) {
	    super("Ja existe um funcionario com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
	}