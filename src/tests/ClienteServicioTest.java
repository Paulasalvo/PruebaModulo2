package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import servicio.ClienteServicio;
import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicioTest {
	 @Test
	    public void agregarClienteTest() {
	       ClienteServicio servicio = new ClienteServicio();
	       Cliente clienteTest = new Cliente("18459394-3", "Javier", "Arroyo", " 1 año");
	       servicio.agregarCliente(clienteTest);
	       assertEquals(1, servicio.getListaClientes().size());
	       assertEquals("18459394-3", servicio.getListaClientes().get(0).getRunCliente());
	       
	    }
	
	 @Test
	 public void agrearClienteNullTest() {
		 ClienteServicio servicio = new ClienteServicio();
		 Cliente clienteTest = null;
		 servicio.agregarCliente(clienteTest);
		 assertEquals(0, servicio.getListaClientes().size());
	 }
	 
	 
}
