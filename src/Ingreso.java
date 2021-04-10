

/**
 * @author Francisco Miguel
 * @version 1.0
 * Esta clase hereda de Dinero y establece los ingresos que se introducen en la cuenta del usuario
 *
 */
public class Ingreso extends Dinero{
	/**
	 * Constructor de clase con parámetros
	 * @param ingreso es el valor en euros que se ingresa
	 * @param description es una breve descripción del ingreso
	 */
	Ingreso(double ingreso, String description) {
		//super nos permite hacer una llamada a la clase padre (Dinero) para utilizar sus métodos y establecer los ingresos
		super.setDinero(ingreso);
		super.setDescription(description);
	}
	/**
	 * Nos devuelve una cadena con un mensaje personalizado
	 */
	public String toString() {
		return "Ingreso: "+super.getDescription()+", cantidad: "+super.getDinero()+"€.";
	}

}
