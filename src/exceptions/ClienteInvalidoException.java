package exceptions;

public class ClienteInvalidoException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ClienteInvalidoException(){
		super("Cliente Invalido");
	}
}
