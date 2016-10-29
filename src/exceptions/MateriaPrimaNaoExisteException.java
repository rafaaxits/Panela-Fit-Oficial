package exceptions;

public class MateriaPrimaNaoExisteException extends Exception {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	  public MateriaPrimaNaoExisteException() {
	    super("Nao existe nenhuma materia prima com o codigo");
	 
	  }
}