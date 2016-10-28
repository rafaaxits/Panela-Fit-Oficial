package exceptions;

public class MateriaPrimaNaoExisteException extends Exception {
	  private int codigo;

	  public MateriaPrimaNaoExisteException(int codigo) {
	    super("Nao existe nenhuma materia prima com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
