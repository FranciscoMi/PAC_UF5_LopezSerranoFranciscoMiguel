import java.io.IOException;


/**
 * Clase GastoException es una clase para controlar los errores del usuario al trabajar con el saldo del usuario
 * @author Francisco Miguel L�pez
 * @version 2.0
 */
@SuppressWarnings("serial")
public class GastoException extends Exception{
	
	/**
	 * Constructor que generar� la excepci�n y agregar� el mensaje de error en caso de que no haya saldo suficiente
	 */
	GastoException(){
		//super hace una llamada al constructor de la clase Exception y a�ade el mensaje de error al m�todo getMessage
		super("No dispone de saldo suficiente en su cuenta");
		
	}
	
}
