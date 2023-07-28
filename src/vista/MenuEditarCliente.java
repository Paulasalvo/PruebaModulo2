package vista;

import java.util.Scanner;

import modelo.Cliente;
import modelo.CategoriaEnum;
import servicio.ClienteServicio;

public class MenuEditarCliente {
	Scanner scanner = new Scanner(System.in);
	ClienteServicio clienteServicio; 
	
	
	
	public MenuEditarCliente(Scanner scanner, ClienteServicio clienteServicio) {
		super();
		this.scanner = scanner;
		this.clienteServicio = clienteServicio;
	}

	public void menuEditarCliente() {
		int opcion;
	    do {
	    	System.out.println("----- -Editar Cliente -----");
	        System.out.println("Seleccione qué desea hacer:");
	        System.out.println("1.-Cambiar el estado del Cliente");
	        System.out.println("2.-Editar los datos ingresados del Cliente");
	        System.out.println("3.-Volver al menú principal");
	        System.out.println("Ingrese opcion:");
	        opcion = scanner.nextInt();
            scanner.nextLine(); 
	        switch (opcion) {
	            case 1:
	            	menuEditarEstado();
	                break;
	            case 2: 
	            	menuEditarDatos();
	            	break;
	            case 3: 
	            	break;
	        }    	
	    }while (opcion != 3);
	      
	}
	
	public void menuEditarEstado() {
		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCliente= scanner.nextLine();
		Cliente cliente = clienteServicio.obtenerClientePorRUN(runCliente);
		if(cliente == null) {
			System.out.println("Rut no existe, ingrese nuevamente");
			return;
		}
		CategoriaEnum currentCategoria = cliente.getNombreCategoria();
		CategoriaEnum contraCategoria = CategoriaEnum.ACTIVO;
		if (currentCategoria == CategoriaEnum.ACTIVO) {
			contraCategoria = CategoriaEnum.INACTIVO;
		}
		
		int opcion;
	    do {
	    	System.out.println("-----Actualizando estado del Cliente----");
	        
	    	System.out.println("El estado actual es:"+ cliente.getNombreCategoria());
	        System.out.println("1.-Si desea cambiar el estado del Cliente a " + contraCategoria);
	        System.out.println("2.-Si desea mantener el estado del cliente "+ currentCategoria);
	        System.out.println("Ingrese opcion:");
	        opcion = scanner.nextInt();
            scanner.nextLine(); 
	        switch (opcion) {
	            case 1:
	            	cliente.setNombreCategoria(contraCategoria);
	            	System.out.println("Estado modificado con éxito");
	                break;
	            case 2: 
	            	System.out.println("Estado sin modificar");
	            	break;
	        
	        }    	
	    }while (opcion != 2);
	}
	
	
	public void menuEditarDatos() {
		System.out.println("Ingrese RUN del Cliente a editar:");
		String runCliente= scanner.nextLine();
		Cliente cliente = clienteServicio.obtenerClientePorRUN(runCliente);
		if(cliente == null) {
			System.out.println("Rut no existe, ingrese nuevamente");
			return;
		}
		int opcion;
	    do {
	    	System.out.println("-----Actualizando Datos del Cliente----");
	        
	    	System.out.println("1.-El RUN del Cliente es: "+ cliente.getRunCliente());
	    	System.out.println("2.-El nombre del Cliente es: "+ cliente.getNombreCliente());
	    	System.out.println("3.-El apellido del Cliente es: "+ cliente.getApellidoCliente());
	        System.out.println("4.-Los años como cliente son: " + cliente.getAniosCliente());
	        System.out.println("5.-Volver al menú principal");
	        System.out.println("Ingrese opcion a editar de los datos del cliente: ");
	        System.out.println("--------------------------------------------------");
	        opcion = scanner.nextInt();
            scanner.nextLine(); 
	        switch (opcion) {
	            case 1:
	            	System.out.println("1.-Ingrese nuevo RUN del Cliente: ");
	            	String nuevoRunCliente= scanner.nextLine();
	            	cliente.setRunCliente(nuevoRunCliente);
	            	System.out.println("Datos cambiados con éxito");
	            	break;
	            case 2: 
	            	System.out.println("1.-Ingrese nuevo nombre del Cliente: ");
	            	String nombreCliente= scanner.nextLine();
	            	cliente.setNombreCliente(nombreCliente);
	            	System.out.println("Datos cambiados con éxito");
	            	break;
	            case 3: 
	            	System.out.println("1.-Ingrese nuevo apellido del Cliente: ");
	            	String apellidoCliente= scanner.nextLine();
	            	cliente.setApellidoCliente(apellidoCliente);
	            	System.out.println("Datos cambiados con éxito");
	            	break;
	            case 4: 
	            	System.out.println("1.-Ingrese nueva antigüedad del Cliente en años: ");
	            	String aniosCliente= scanner.nextLine();
	            	cliente.setAniosCliente(aniosCliente);
	            	System.out.println("Datos cambiados con éxito");
	            	break;
	            case 5: 
	            	break;
	        
	        }    	
	    }while (opcion != 5);
	}
}
