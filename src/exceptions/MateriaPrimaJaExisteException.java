package exceptions;

public class MateriaPrimaJaExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	  public MateriaPrimaJaExisteException(int codigo) {
	    super("Ja existe uma materia prima com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }

}
