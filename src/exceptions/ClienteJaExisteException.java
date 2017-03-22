package exceptions;

public class ClienteJaExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;

	public ClienteJaExisteException(int codigo) {
		super("Já existe um cliente cadastrado com o codigo '" + codigo + "'.");
		this.codigo = codigo;
	}

	public int getCodigo() {
		return this.codigo;
	}
}
