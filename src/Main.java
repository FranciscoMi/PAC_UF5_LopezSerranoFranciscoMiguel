/**
 * @author franlopez
 * @version 2.0
 */

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
/**
 * Clase principal de la aplicaci�n de usuarios que seguir� los siguientes pasos:<br>
 * 1.- Creaci�n del usuario y sus datos<br>
 * 2.- Creaci�n de la cuenta.<br>
 * 3.- Visualizaci�n del men�.<br>
 * 4.- Realizaci�n de acciones<br>
 * 5.- Mensaje final al salir de la aplicaci�n
 */
	public static void main(String[] args) {
		
		//Creamos el objeto usuario de la clase Usuario para controlar sus cuentas, pero no lo instanciamos de momento porque queremos controlar sus excepciones
		Usuario usuario = null;
		
		//Controlamos que hasta que no se introduzca un usuario v�lido no se pueda continuar
		do {
			try {
				//Instanciamos el objeto usuario de la clase Usuario luego mostramos sus datos si no ha habido ninguna excepci�n
				usuario=new Usuario();
				
				@SuppressWarnings("resource") //Una vez utilizado Scanner se cerrar� para evitar errores
				Scanner introduceDatos=new Scanner(System.in);
				
				System.out.print("Por favor, Introduzca el nombre del usuario: ");
				usuario.setNombre(introduceDatos.nextLine());
				
				System.out.print("Introduzca la edad del usuario: ");
				//Si edad no es un n�mero entero dar� un error de usuario
				usuario.setEdad(introduceDatos.nextInt());
				boolean confirmar=false;
				//Comprobamos que el DNI introducido sea incorrecto hasta que "confirmar" sea true 
				while(!confirmar) {
					System.out.print("Introduzca el DNI del usuario (8 d�gitos + 1 caracter): ");
					//Al hacer una llamada al m�todo setDNI confirmamos que el DNI sea v�lido
					confirmar=usuario.setDNI(introduceDatos.next().toUpperCase(Locale.ROOT));
				}
				
				System.out.println(usuario);
			}catch(Exception e) {
				System.out.println("Usuario introducido incorrectamente.");
			}
		}while(usuario==null);//fin while
		//Cuando hayamos comprobado que el usuario es v�lido accedemos al men� de gastos e ingresos.
		/**
		 * int accion nos controlar� las opciones del men�
		 * Instanciamos cuentaUsuario que es un objeto de la clase Cuenta para trabajar con la cuenta del usuario
		 * De esta manera relaccionamos la clase Cuenta con la clase Usuario
		 */
		int accion = 0;
		Cuenta cuentaUsuario=new Cuenta(usuario);
		//generamos un constructor para cargar/guardar los datos
		fichUsuario archivoUser=new fichUsuario(cuentaUsuario);
		//Comprobamos que exista un archivo .dat con el mismo DNI. Si es as� cargamos el archivo, en caso contrario, generamos uno nuevo
		try {
			if(archivoUser.cargaUsuario(usuario.getDNI())==null) {
				try {
					System.out.println("\nSe generar� un nuevo archivo");
					//guardamos el usuario en un archivo
					archivoUser.guardaUsuario(usuario.getDNI());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else {
				cuentaUsuario=archivoUser.cargaUsuario(usuario.getDNI());
			}
			
		} catch (IOException error) {
			System.out.println("No existe el usuario "+usuario.getNombre());
			
		}
		
		
		@SuppressWarnings("resource")
		 //introducir es una variable para ingresar valores de Scanner
		Scanner introducir=new Scanner(System.in);				
		do { 
			//este par�metro try nos controlar� que los datos introducidos se correspondan con el tipo de datos correcto
			try {
				System.out.println("\nRealiza una nueva acci�n");
				System.out.println("1.- Introducir un nuevo Gasto");
				System.out.println("2.- Introducir un nuevo Ingreso");
				System.out.println("3.- Mostrar Gastos");
				System.out.println("4.- Mostrar Ingresos");
				System.out.println("5.- Mostrar Saldo");
				System.out.println("6.- Guardar datos");
				System.out.println("0.- Salir");
				
				//Introducimos un entero por teclado y lo guardamos en la variable accion
				accion=Integer.parseInt(introducir.nextLine());
				
				/**
				 * controlaString introduce valores de String temporales del usuario para el objeto cuentaUsuario
				 * controlaDouble introduce valores num�ricos temporalmente para el objeto cuentaUsuario
				 */
				String controlaString="";
				double controlaDouble=0;
				//Buscamos la opci�n elegida con un switch y la ejecutamos
				switch (accion){
					case 1: //Introducir un nuevo gasto
						System.out.println("Introduzca una descripci�n del Gasto: ");
						controlaString=introducir.nextLine();
						System.out.print("Introduzca la cantidad a gastar: ");
						controlaDouble=Double.parseDouble(introducir.nextLine());
						//A�adimos los datos introducidos al List Gasto del usuario y mostramos el saldo restante
						System.out.println("Saldo disponible:"+cuentaUsuario.addGastos(controlaString, controlaDouble)+"�.");
						break;
					case 2: //Introducir un nuevo ingreso
						System.out.println("Introduzca una descripci�n del nuevo Ingreso: ");
						controlaString=introducir.nextLine();
						System.out.print("Introduzca la cantidad a ingresar: ");
						controlaDouble=Double.parseDouble(introducir.nextLine());
						//A�adimos los datos introducidos al List Gasto del usuario y mostramos el saldo restante
						System.out.println("Saldo disponible:"+cuentaUsuario.addIngresos(controlaString, controlaDouble)+"�.");
						break;
					case 3: //Mostrar los gastos de la cuenta
						//recorremos el array List<Gasto>gastos con un foreach al m�todo getGastos de la clase Cuenta
						for(Gasto gasto:cuentaUsuario.getGastos())
							System.out.println(gasto);
						break;
					case 4: //Mostrar los ingresos de la cuenta
						//Recorremos el array List<Ingreso>ingresos con un foreach, haciendo una llamada al m�todo getIngresos de la clase Cuenta
						for(Ingreso ingreso:cuentaUsuario.getIngresos())
							System.out.println(ingreso);
						break;
					case 5:  //Mostrar el Saldo actual de la cuenta
						//Simplemente hacemos una llamada al m�todo getSaldo de la clase Cuenta
						//Eso s�, dejandolo un poco bonito :-D
						System.out.println("Saldo actual en su cuenta corriente: "+cuentaUsuario.getSaldo()+"�.\n");
						break;
					case 6:
						try{
							archivoUser.guardaUsuario(usuario.getDNI());
							System.out.println("Archivo guardado con el DNI "+usuario.getDNI());
						}catch(IOException e){
							e.printStackTrace();
						}
						break;
				}
			}catch(Exception e) {
				//Si los datos introducidos son incorrectos no guarda en el array, me muestra un mensaje y vuelve al men�
				System.out.println("Valor introducido incorrecto. La operaci�n no se ha podido realizar");
				continue;
			}
		}while (accion!=0);
		//Mensaje de fin de la aplicaci�n
		System.out.println("\nFin del programa.\nGracias por utilizar la aplicaci�n.");
	}

	

}
