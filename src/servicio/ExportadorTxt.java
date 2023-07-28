package servicio;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		File archivo = new File(fileName + ".txt");
		try {
			archivo.createNewFile();
		}
		catch (Exception e) {
			System.out.println ("Error al crear archivo por;" + e);
		}
		try {
			FileWriter writer = new FileWriter (archivo);
			for (Cliente cliente: listaClientes) {
				writer.write(cliente.toString()+ "\n");
			}
			System.out.println("El producto ha sido exportado con éxito");
			writer.close();
		}
		catch (Exception e) {
			System.out.println ("Error al escribir el archivo");
		}
	}

}
