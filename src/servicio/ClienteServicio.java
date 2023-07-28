package servicio;
import modelo.Cliente;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class ClienteServicio {
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	

	public ClienteServicio() {
		
	}
	
	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void listarCliente() {
		if (listaClientes.isEmpty()) {
			System.out.println("La lista se encuentra vacía");
			return;
		}
		for (Cliente cliente: listaClientes) {
			System.out.println(cliente.toString());
		}
	}
	
	public void agregarCliente(Cliente cliente) {
		if (cliente == null) {
			System.out.println("Cliente no puede ser nulo");
		}
		else {
			listaClientes.add(cliente);	
		}
		
		
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	

	public Cliente obtenerClientePorRUN(String runCliente) {
	    for (Cliente cliente : listaClientes) {
	        if (cliente.getRunCliente().equals(runCliente)) {
	            return cliente;
	        }
	    }
	    return null;
	}
	
	
	
	public void cambiarEstadoCliente(String runCliente) {
	}
	
	public void editarCliente(Cliente cliente) {
	
		}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void addListaClientes(List<Cliente> listaClientes) {
		this.listaClientes.addAll(listaClientes);
	}
	
}
