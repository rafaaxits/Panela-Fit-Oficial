package exceptions;

public class VendaJaExisteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	
	public VendaJaExisteException(int codigo){
		super("J� existe um venda cadastrado com o codigo '" + codigo + "'.");
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return this.codigo;
	}
}
