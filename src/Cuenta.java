import java.util.ArrayList;
import java.util.List;

/**
 * Clase que controla los ingresos, gastos y saldo del usuario al que anexionemos
 * @author Francisco Miguel López
 * @version 1.0
 *
 */

public class Cuenta {
	/**
	 * @param saldo valor que nos almacena el saldo actual de la cuenta y que se incrementará o decrementará a medida que introduzcamos ingresos y gastos
	 */
	private double saldo;
	/** 
	 * @param usuario objeto perteneciente a la clase Usuario con el que relaccionaremos los datos de la cuenta
	 */
	private Usuario usuario;
	 /**
	 *@param gastos ArrayList de la clase Gasto para almacenar los gastos de la cuenta
	 */
	private List<Gasto>gastos;
	/**
	 * @param ingresos ArrayList de la clase Ingreso para almacenar los ingresos a la cuenta
	 */
	private List<Ingreso> ingresos;
	
	/**
	 * Constructor de clase que nos relaccionará el usuario con las cuentas
	 * @param usuario es el objeto de la clase Usuario con el que trabajar
	 */
	Cuenta(Usuario usuario){
		//Agregamos el objeto usuario para controlar sus cuentas
		this.usuario=usuario;
		//Inicializamos los arrays
		this.ingresos=new ArrayList<Ingreso>();
		this.gastos=new ArrayList<Gasto>();
	}

	/**
	 * @return saldo establecido
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo a establecer
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * @return usuario devuelve el objeto de la clase Usuario con todos sus parámetros
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario a establecer
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * Método para añadir un ingreso a la cuenta del usuario
	 * @param description es una descripcion breve del ingreso
	 * @param cantidad es la cantidad establecida en euros
	 * @return saldo actualizado agregado
	 */
	public double addIngresos(String description, double cantidad) {
		//Establecemos el objeto ingresar para añadir ingresos (cantidad y descripción) al ArrayList ingresos
		Ingreso ingresar=new Ingreso(cantidad, description);
		if (ingresos.isEmpty()) {
			ingresos.add(0, ingresar);
		}else {
			ingresos.add((ingresos.size()), ingresar);
		}
		//Actualizamos el saldo y lo devolvemos para su posterior utilización
		setSaldo(getSaldo()+cantidad);
		return saldo;
	}
	
	/**
	 * Método para añadir un gasto al usuario.
	 * @param description es una breve descripción del gasto
	 * @param cantidad es la cantidad pagada en euros
	 * @return saldo actualizado ya restado
	 */
	public double addGastos(String description, double cantidad)  {
		 //Establecemos el objeto gastar como Gasto para que sirva como intermediario del ArrayList gastos
		Gasto gastar=new Gasto(cantidad, description);
		
		//Si disponemos de saldo haremos el gasto. En caso contrario no se podrá producir la transacción. 
		//el método try nos controlará las excepciones en caso de que no haya saldo suficiente
		try {
			if(getSaldo()<cantidad) {
				//Si no tenemos saldo suficiente lanzamos la excepción que hemos creado (GastoException), y el gasto no se realizará
				throw new GastoException();
			}else {
				//Una vez confirmado el saldo, comprobaremos que el array no esté vacio.
				if (gastos.isEmpty()) {
					//En caso de que el array gastos esté vacio agregaremos los valores al primer índice
					gastos.add(0, gastar);
					}else {
					//Si el array ya tiene valores agregamos el contenido del nuevo gasto al final
						gastos.add((gastos.size()), gastar);
					}
				//Si el saldo es suficiente, descontaremos la cantidad del pago
				setSaldo(getSaldo()-cantidad);
			}//fin if
		}catch(GastoException mensajeError) {
			//Mostramos el mensaje que ya hemos generado en caso de que no haya saldo suficiente
			System.out.println(mensajeError.getMessage());
		}
		//Pase lo que pase devolvemos el saldo actualizado
		return saldo;
	}//fin addGastos
		
		
	/**
	 * Método que nos devuelve el array de Gastos
	 * @return gastos
	 */
	public List<Gasto> getGastos() {
		return gastos;
	}

	
	/**
	 * Método que nos devuelve el array de Ingresos
	 * @return ingresos
	 */
	public List<Ingreso> getIngresos() {
		return ingresos;
	}
	
	/**
	 * Método sobreescrito de la clase padre Object que nos devuelve una cadena con el saldo actual del usuario
	 */
	public String toString() {
		return "Usuario: "+usuario.getNombre()+". Saldo restante: "+getSaldo();
	}

	
}
