package exceptions;

public class FuncionarioNaoExisteException extends Exception {


	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioNaoExisteException(int codigo) {
	    super("Nao existe nenhum funcionario com o codigo '" + codigo + "'.");

	  }
}
