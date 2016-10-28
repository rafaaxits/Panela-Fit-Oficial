package exceptions;

public class FornecedorJaExisteException extends Exception {
	  private int codigo;

	  public FornecedorJaExisteException(int codigo) {
	    super("Ja existe um fornecedor com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
