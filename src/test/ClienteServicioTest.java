package test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;

public class ClienteServicioTest {
	
	private static Logger logger = 
			Logger.getLogger("test.PruebasUnitarias");
	
	@Test
	public void agrearClienteTest(){
		logger.info("Test agregar cliente");
		
		Cliente cliente = new Cliente("17.098.475-3", "Pepe", "Ramirez", "3", CategoriaEnum.ACTIVO);
		List<Cliente> listaClientes = new ArrayList<Cliente>();
			listaClientes.add(cliente);
	}

	@Test
	public void agrearClienteNullTest(){
		logger.info("Test agregar cliente null");
		
		Cliente cliente = new Cliente(null, null, null, null, null);
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		listaClientes.add(cliente);
		
	}
}
