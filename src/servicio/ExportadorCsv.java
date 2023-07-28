package servicio;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		 try {
	            PrintWriter writer = new PrintWriter(new FileWriter(fileName + ".csv"));
	    
	            writer.println("RUN, Nombre, Apellido, Años de antigüedad, Estado");
	    
	            for (Cliente cliente : listaClientes) {
	                writer.println(cliente.getRunCliente() + ", " +
			                		cliente.getNombreCliente() + ", " +
			                		cliente.getApellidoCliente() + ", " +
	                               cliente.getAniosCliente() + ", " +
	                               cliente.getNombreCategoria());
	            }
	    
	            writer.close();
	    
	            System.out.println("Se ha exportado el archivo CSV correctamente.");
	        } catch (IOException e) {
	            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
	        }
	    }
	}
	


