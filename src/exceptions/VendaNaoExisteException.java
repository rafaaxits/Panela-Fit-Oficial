package exceptions;

public class VendaNaoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VendaNaoExisteException() {
		super("Nao existe nenhuma venda com este codigo");
	}

}
