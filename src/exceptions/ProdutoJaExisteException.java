package exceptions;

public class ProdutoJaExisteException extends Exception {
	  private int codigo;

	  public ProdutoJaExisteException(int codigo) {
	    super("Ja existe um produto com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
