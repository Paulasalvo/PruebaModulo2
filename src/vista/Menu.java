package vista;


import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import modelo.CategoriaEnum;
import servicio.ClienteServicio;
import servicio.ExportadorTxt;
import servicio.ExportadorCsv;
import servicio.ArchivoServicio;
import utilidades.Utilidad;



public class Menu {
    private ClienteServicio clienteServicio;
    private String fileName = "Clientes";
    private String fileName1 = "DBClientes.csv";
    private Scanner scanner; 
    ExportadorCsv exportadorCsv = new ExportadorCsv();
    ExportadorTxt exportadorTxt = new ExportadorTxt();
    ArchivoServicio cargarDatos = new ArchivoServicio();
    Utilidad utilidad = new Utilidad();
    

    
    public Menu() {
    	clienteServicio = new ClienteServicio();
    	scanner = new Scanner(System.in);
  
       
    }

    public void iniciarMenu() {
       int opcion;
       
        do {
        	 mostrarMenuPrincipal();
        	 opcion = scanner.nextInt();
             scanner.nextLine(); 
	        switch (opcion) {
	            case 1:
	               	clienteServicio.listarCliente();
	                break;
	            case 2:
	            	utilidad.imprimirSeccion("Crear Cliente");
	            	System.out.println("Ingresa RUN del Cliente:");
	            	String runCliente = scanner.nextLine();
	            	System.out.println("Ingresa Nombre del Cliente:");
	            	String nombreCliente = scanner.nextLine();
	            	System.out.println("Ingresa Apellido del Cliente:");
	            	String apellidoCliente = scanner.nextLine();
	            	System.out.println("Ingresa años como Cliente:");
	            	String aniosCliente = scanner.nextLine();
	            	Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente);
	            	clienteServicio.agregarCliente(cliente);
	            	System.out.println("---El cliente se ha guardado con éxito---");
	            	
	                break;
	            case 3:
	                MenuEditarCliente submenu = new MenuEditarCliente(scanner, clienteServicio);
	                submenu.menuEditarCliente();
	                
	                break;
	            case 4:
	                    
	            		String rutaimport = rutaImportarCsv();
	                    List<Cliente> listaCargada = cargarDatos.cargarDatos(rutaimport);
	            		if (!listaCargada.isEmpty()){
	            			System.out.println("La lista ha sido cargado con existo");
	            		}
	                    clienteServicio.addListaClientes(listaCargada);
	            		
	                
	                break;
	            case 5:
	                do {
	                	menuExportador();
	                	opcion = scanner.nextInt();
	                    scanner.nextLine(); 
	        	        switch (opcion) {
	        	            case 1:
	        	            	String ruta = mensajeRutaCsv();
	        	            	String fileName = "Cliente";
	        	            	exportadorCsv.exportar(ruta + "/" + fileName, clienteServicio.getListaClientes());
	        	            	break;
	        	            case 2:
	        	            	exportadorTxt.exportar("archivo", clienteServicio.getListaClientes());
	        	            	break;
	        	            case 3:
	        	            	break;
	        	            default:
	        	                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
	        	                break;
	        	        }        
	                }while (opcion !=3); 
	                break;
	            case 6:
	            	utilidad.limpiezaPantalla();
	            	break;
	            case 7:
	            	break;
	            default:
	                System.out.println("Opción inválida. Por favor, seleccione una opción válida del menú.");
	                break;
	        }
        }while (opcion != 7);
        System.out.println("Ha salido del menú");
    }    

    public void mostrarMenuPrincipal() {
    	utilidad.imprimirSeccion("MENÚ PRINCIPAL");
        System.out.println("1. Listar Cliente");
        System.out.println("2. Agregar Cliente");
        System.out.println("3. Editar Cliente");
        System.out.println("4. Importar Datos");
        System.out.println("5. Exportar Datos");
        System.out.println("6. Limpiar pantalla");
        System.out.println("7. Terminar Programa");
        System.out.println("Seleccione una opción: ");
    }
    
    public void menuExportador() {
        utilidad.imprimirSeccion("Exportar Datos");
        System.out.println("Seleccione el formato a exportar");
        System.out.println("1. Formato csv");
        System.out.println("2. Formato txt");
        System.out.println("3. Salir");
        System.out.println("Ingrese una opción para exportar:");
        System.out.println("----------------------------------");
    }     
        public String mensajeRutaCsv() {
        	String ruta = ""; 
        	String sistemaOperativo = System.getProperty("os.name").toLowerCase();
             
             if (sistemaOperativo.contains("win")) {
                 utilidad.imprimirSeccion("Exportar Datos en Windows");
                 System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
                 ruta = scanner.nextLine();
             } 
             else {
            	 utilidad.imprimirSeccion("Exportar Datos en Mac o Linux");
                 System.out.println("Ingresa la ruta en donde desea exportar el archivo clientes.csv:");
                 ruta = scanner.nextLine();
             }
        
             return ruta;
       
    }
        
        public String rutaImportarCsv() {
        	String ruta = ""; 
        	String sistemaOperativo = System.getProperty("os.name").toLowerCase();
             
             if (sistemaOperativo.contains("win")) {
                 utilidad.imprimirSeccion("Cargar Datos en Windows");
                 System.out.println("Ingresa la ruta en donde se encuentra el archivo  DBClientes.csv:");
                 ruta = scanner.nextLine();
             } 
             else {
            	 utilidad.imprimirSeccion("Cargar Datos en Mac o Linux");
                 System.out.println("Ingresa la ruta en donde se encuentra el archivo  DBClientes.csv:");
                 ruta = scanner.nextLine();
             }
        
             return ruta;
       
    }

      
}

