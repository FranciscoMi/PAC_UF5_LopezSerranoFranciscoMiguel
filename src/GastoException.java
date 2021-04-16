import java.io.IOException;


/**
 * Clase GastoException es una clase para controlar los errores del usuario al trabajar con el saldo del usuario
 * @author Francisco Miguel López
 * @version 2.0
 */
@SuppressWarnings("serial")
public class GastoException extends Exception{
	
	/**
	 * Constructor que generará la excepción y agregará el mensaje de error en caso de que no haya saldo suficiente
	 */
	GastoException(){
		//super hace una llamada al constructor de la clase Exception y añade el mensaje de error al método getMessage
		super("No dispone de saldo suficiente en su cuenta");
		
	}
	
}
