import java.io.IOException;


/**
 * Clase GastoException es una clase para controlar los errores del usuario al trabajar con el saldo del usuario
 * @author Francisco Miguel L�pez
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GastoException extends IOException{
	/**
	 * @param sinSaldo almacena el c�digo de error
	 */
	private String sinSaldo;
	
	/**
	 * Constructor que generar� la excepci�n y agregar� el mensaje de error en caso de que no haya saldo suficiente
	 */
	GastoException(){
		this.sinSaldo="No dispone de saldo suficiente en su cuenta";
	}
	
	/**
	 * M�todo con par�metros para establecer el mensaje de la variable sinSaldo
	 * @param sinSaldo recoge el mensaje establecido con el constructor de la clase
	 */
	public GastoException(String sinSaldo) {
		this.sinSaldo=sinSaldo;
	}
	
	//Sobreescribimos el m�todo getMessage de de la clase gen�rica IOException para as� devolver el error producido
	@Override
	public String getMessage() {
		return sinSaldo;
	}
}
