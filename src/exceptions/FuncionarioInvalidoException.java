package exceptions;

public class FuncionarioInvalidoException extends Exception {
	private static final long serialVersionUID = 1L;

	public FuncionarioInvalidoException(){
		super("Funcionario Invalido");
	}
}
