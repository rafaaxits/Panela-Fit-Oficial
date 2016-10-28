package exceptions;

public class FuncionarioNaoExisteException extends Exception {
	  private int codigo;

	  public FuncionarioNaoExisteException(int codigo) {
	    super("Nao existe nenhum funcionario com o codigo '" + codigo + "'.");
	    this.codigo = codigo;
	  }

	  public int getCodigo() {
	    return this.codigo;
	  }
}
