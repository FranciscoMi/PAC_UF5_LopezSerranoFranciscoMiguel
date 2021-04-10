/**
 * @author Francisco Miguel
 * @version 1.0
 * @implNote Clase abstracta encargada de controlar el dinero que entra y sale
 */
public abstract class Dinero {
	private double dinero;
	private String description;
	/**
	 * @return  dinero
	 */
	public double getDinero() {
		return dinero;
	}
	/**
	 * @param dinero que queremos establecer
	 */
	public void setDinero(double dinero) {
		this.dinero = dinero;
	}
	/**
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description a establecer
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
