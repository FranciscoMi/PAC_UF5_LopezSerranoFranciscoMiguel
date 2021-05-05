
import java.io.Serializable;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class Usuario implements Serializable{
	private String nombre;
	private int edad;
	private String DNI;
/**
 * Esta clase nos permite gestionar un único usuario
 */
	
	Usuario(){
		@SuppressWarnings("resource") //Una vez utilizado Scanner se cerrará para evitar errores
		Scanner introduceDatos=new Scanner(System.in);
		
		System.out.print("Por favor, Introduzca el nombre del usuario: ");
		setNombre(introduceDatos.nextLine());
		
		System.out.print("Introduzca la edad del usuario: ");
		//Si edad no es un número entero dará un error de usuario
		setEdad(introduceDatos.nextInt());
		boolean confirmar=false;
		//Comprobamos que el DNI introducido sea incorrecto hasta que "confirmar" sea true 
		while(!confirmar) {
			System.out.print("Introduzca el DNI del usuario (8 dígitos + 1 caracter): ");
			confirmar=setDNI(introduceDatos.next().toUpperCase(Locale.ROOT));
			//Al hacer una llamada al método setDNI confirmamos que el DNI sea válido
			//confirmar=setDNI(DNI);
		}
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
	 * Esta clase nos permite comprobar que el DNI sea válido.
	 * Aún sabiendo que el DNI tiene unos parámetros concretos nos vale con comprobar que contenga 8 dígitos + un caracter entre A y Z
	 * @param DNI a establecer
	 */
	public boolean setDNI(String DNI) {
		//Creamos un patron para reconocer el DNI del usuario(8 dígitos mas una letra)
		Pattern patronDNI=Pattern.compile("[0-9]{8}[A-Z]|[0-9]{8}-[A-Z]");
		
		//Creamos el Matcher que será el que encaje patronDNI en el String pasado por parametro
		Matcher comprobarDNI=patronDNI.matcher(DNI);
		
		//Si el patrón del DNI no es correcto, devolverá false. Y true si es bueno
		if(comprobarDNI.matches()) {
			System.out.println("EL DNI introducido es válido :-D");
			this.DNI=DNI;
			return true;
		}else {
			System.out.println("EL DNI introducido es incorrecto :-(");
			return false;
		}
			
	}
	
	//Haremos una llamada a este método si los datos de la clase han sido buenos. 
	/**
	 * ToString() nos devuelve una cadena de caracteres personalizada.
	 */
	public String toString(){
		return "Usuario creado correctamente. \r\n Nombre: "+getNombre()+", Edad: "+getEdad()+" años, DNI: "+getDNI();
	}
		
}
