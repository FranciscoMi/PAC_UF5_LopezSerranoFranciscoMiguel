import java.io.Serializable;

/**
 * @author Francisco Miguel López 
 * Gasto hereda de Dinero. Los valores se inicializan en el constructor
 */
@SuppressWarnings("serial")
public class Gasto extends Dinero implements Serializable{


	/**
	 * Constructor de clase con parámetros
	 * @param gasto es el valor en euros de tipo double que se ha gastado
	 * @param description es una breve descripción del gasto
	 */
	Gasto(double gasto, String description) {
		super.setDinero(gasto);
		super.setDescription(description);
	}
	/**
	 * Nos devuelve una cadena con un mensaje personalizado
	 */
	public String toString() {
		return "Gasto: "+super.getDescription()+", cantidad: "+super.getDinero()+"€.";
	}
}
