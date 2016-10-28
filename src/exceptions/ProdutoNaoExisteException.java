package exceptions;

public class ProdutoNaoExisteException extends Exception {
	  private int codigo;

	  public ProdutoNaoExisteException(int codigo) {
	    super("Nao existe nenhum produto com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }

}
