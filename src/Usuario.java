
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	private String nombre;
	private int edad;
	private String DNI;
/**
 * Esta clase nos permite gestionar un ?nico usuario
 */
	
	Usuario(){
		
	}

	/**
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre del usuario a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad a establecer
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return dNI
	 */
	public String getDNI() {
		return DNI;
	}

	/**
	 * Esta clase nos permite comprobar que el DNI sea v?lido.
	 * A?n sabiendo que el DNI tiene unos par?metros concretos nos vale con comprobar que contenga 8 d?gitos + un caracter entre A y Z
	 * @param DNI a establecer
	 */
	public boolean setDNI(String DNI) {
		//Creamos un patron para reconocer el DNI del usuario(8 d?gitos mas una letra)
		Pattern patronDNI=Pattern.compile("[0-9]{8}[A-Z]|[0-9]{8}-[A-Z]");
		
		//Creamos el Matcher que ser? el que encaje patronDNI en el String pasado por parametro
		Matcher comprobarDNI=patronDNI.matcher(DNI);
		
		//Si el patr?n del DNI no es correcto, devolver? false. Y true si es bueno
		if(comprobarDNI.matches()) {
			System.out.println("EL DNI introducido es v?lido :-D");
			this.DNI=DNI;
			return true;
		}else {
			System.out.println("EL DNI introducido es incorrecto :-(");
			return false;
		}
			
	}
	
	//Haremos una llamada a este m?todo si los datos de la clase han sido buenos. 
	/**
	 * ToString() nos devuelve una cadena de caracteres personalizada.
	 */
	public String toString(){
		return "Usuario creado correctamente. \r\n Nombre: "+getNombre()+", Edad: "+getEdad()+" a?os, DNI: "+getDNI();
	}
		
}
