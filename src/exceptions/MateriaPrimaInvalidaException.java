package exceptions;

public class MateriaPrimaInvalidaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MateriaPrimaInvalidaException(){
		super("Materia Prima Invalida");
	}
}
