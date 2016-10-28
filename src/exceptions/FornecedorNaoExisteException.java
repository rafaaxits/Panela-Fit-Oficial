package exceptions;

public class FornecedorNaoExisteException extends Exception {
	  private int codigo;

	  public FornecedorNaoExisteException(int codigo) {
	    super("Nao existe nenhum fornecedor com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }

}
