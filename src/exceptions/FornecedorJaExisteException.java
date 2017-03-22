package exceptions;

public class FornecedorJaExisteException extends Exception {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int codigo;

	public FornecedorJaExisteException(int codigo) {
		super("Ja existe um fornecedor com o codigo '" + codigo + "'.");
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}
}
