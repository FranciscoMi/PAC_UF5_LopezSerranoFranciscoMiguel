import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class fichUsuario implements Serializable{
	
	
	protected Cuenta usuario;
	private static final long serialVersionUID = 4692605396190162504L;
	
	
	fichUsuario(Cuenta usuario){
		this.usuario=usuario;	
	}

	/**
	 * Guarda el usuario introducido en un fichero Usuario.txt
	 * @throws IOException 
	 */
	public void guardaUsuario(String dni) throws IOException {
		
		//Definimos la variable a serializar para recoger el objeto fichUsuario
		ObjectOutputStream serialUsuario=null;
		try {
			//Definimos el fichero donde introducir los datos del usuario creando un constructor de la clase ObjectOutput Stream
			serialUsuario=new ObjectOutputStream(new FileOutputStream(new File(dni+".dat")));
			//Añadimos los datos del objeto fichUsuario
			serialUsuario.writeObject(usuario);
			
			
			
			
		}catch (IOException e) {
			System.out.println("Error en el archivo Usuario.txt. \nError: ");
			e.printStackTrace();
		}finally {
			if (serialUsuario!=null) {
				//Cerramos el flujo de escritura del objeto
				serialUsuario.close();	
				}
			
			}
		}
	
	
	public Cuenta cargaUsuario(String dni) throws IOException {
		ObjectInputStream serialUsuario=null;
		try {
			serialUsuario=new ObjectInputStream(new FileInputStream(dni+".dat"));
			usuario=(Cuenta)serialUsuario.readObject();
			
			
		}catch(Exception e) {
			System.out.println("No se ha encontrado el fichero "+e);
			return null;
		}
		finally {
			if (serialUsuario!=null){
				//Cerramos el flujo de lectura del objeto
				serialUsuario.close();
				
			}
				
		}
		return usuario;
		
	}

	

	/**
	 * @param ingresos el ingresos a establecer
	 * @throws IOException 
	 */
	public void setIngresos(String dni) throws IOException {
		ObjectOutputStream setIngreso=null;
		try {
			setIngreso=new ObjectOutputStream(new FileOutputStream(dni+".dat"));
			for (Ingreso metoIngreso:usuario.getIngresos()) {
				setIngreso.writeObject(metoIngreso);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}finally {
			if(setIngreso!=null) {
				setIngreso.close();
			}
		}
		
	}

	/**
	 * @return el usuario
	 */
	public Cuenta getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario el usuario a establecer
	 */
	public void setUsuario(Cuenta usuario) {
		this.usuario = usuario;
	}

}
