package servicio;

import java.util.List;
import java.util.ArrayList;

import modelo.CategoriaEnum;
import modelo.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;


public class ArchivoServicio extends Exportador {

	public List<Cliente> cargarDatos (String filePath) {
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		try{
			FileReader fileReader = new FileReader(filePath+"/"+"DBClientes.csv");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String clienteCsv;
			while ((clienteCsv = bufferedReader.readLine())!= null) {
				 String[] clienteArray = clienteCsv.split(",");
				 CategoriaEnum categoria;
				 if(clienteArray[4].equalsIgnoreCase("activo")) {
					 categoria = CategoriaEnum.ACTIVO;
				 }
				 else {
					 categoria = CategoriaEnum.INACTIVO;
				 }
				 
				 Cliente newCliente = new Cliente(clienteArray[0],clienteArray[1], clienteArray[2],clienteArray[3], categoria);
				 listaCliente.add(newCliente);
			}
			bufferedReader.close();
		}
		catch(Exception e){
			System.out.println("Error al cargar la lista");
		}
	
		return listaCliente;	
	}
	
	
	
	
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}

}
