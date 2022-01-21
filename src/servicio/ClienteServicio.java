package servicio;

import java.util.List;
import java.util.Scanner;

import modelo.*;
import utilidades.Utilidad;

public class ClienteServicio {
	List<Cliente> listaClientes;
	Scanner sc = new Scanner(System.in);

	public ClienteServicio(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void listarClientes() {

		if (listaClientes != null) {
			for (Cliente cliente : listaClientes) {
				System.out.println("-------------- Datos del cliente --------------");
				System.out.println("1. run : " + cliente.getRunCliente());
				System.out.println("2. nombre: " + cliente.getNombreCliente());
				System.out.println("3. Apellido: " + cliente.getApellidoCliente());
				System.out.println("4. Años que lleva como cliente: " + cliente.getAniosCliente());
				System.out.println("5. Categoria: " + cliente.getNombreCategoria());
				System.out.println("----------------------------------------------- \n");
			}
		} else {
			System.out.print("No hay datos en el sistema \n");
		}
	}

	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {

		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);

		if (listaClientes != null) {
			listaClientes.add(cliente);
			System.out.println("Cliente agregado correctamente");
			System.out.println("----------------------------------------------- \n");
		} else {
			System.out.println("No se agrego el cliente");
			System.out.println("----------------------------------------------- \n");
		}
	}

	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {

		boolean salir = false;
		int opcion;
		for (Cliente cliente : listaClientes) {
			if ((cliente.getRunCliente()).equals(runCliente)) {
				while (!salir) {

					System.out.println("Seleccione que desea hacer");
					System.out.println("1. El RUN del Cliente es: " + runCliente);
					System.out.println("2. El nombre del cliente es: " + nombreCliente);
					System.out.println("3. El apellido del cliente es: " + apellidoCliente);
					System.out.println("4. Los años como cliente son: " + aniosCliente);
					System.out.println("Ingrese opción");
					opcion = sc.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("Ingrese el nuevo RUN del cliente");
						runCliente = sc.next();
						cliente.setRunCliente(runCliente);
						System.out.println("Datos Cambiados con éxito");
						salir = true;
						break;
					case 2:
						System.out.println("Ingrese el nuevo nombre del cliente");
						nombreCliente = sc.next();
						cliente.setNombreCliente(nombreCliente);
						System.out.println("Datos Cambiados con éxito");
						salir = true;
						break;
					case 3:
						System.out.println("Ingrese el nuevo apellido del cliente");
						apellidoCliente = sc.next();
						cliente.setApellidoCliente(apellidoCliente);
						System.out.println("Datos Cambiados con éxito");
						salir = true;
						break;
					case 4:
						System.out.println("Ingresa a cuanto quieres modificar los años que lleva como cliente");
						aniosCliente = sc.next();
						cliente.setAniosCliente(aniosCliente);
						System.out.println("Datos Cambiados con éxito");
						salir = true;
						break;
					}
				}
			}
		}

		Utilidad.sigue();
	}

	public void editaEstadoCliente() {

		CategoriaEnum nombreEnum = CategoriaEnum.ACTIVO;

		System.out.println("ingrese el run del cliente a editar");
		String rut = sc.next();
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(rut)) {
				System.out.println("----------Actualizando estado del cliente-----------");

				System.out.println("El estado actual del cliente es: " + cliente.getNombreCategoria());
				System.out.println("1. Si desea cambiar el estado a INACTIVO");
				System.out.println("2. Si desea mantener el estado a ACTIVO");
				System.out.println("Ingrese opción \n");
				int opcion = sc.nextInt();

				if (opcion == 1) {
					nombreEnum = CategoriaEnum.INACTIVO;
					cliente.setNombreCategoria(nombreEnum);
					System.out.println("El estado actual es: " + nombreEnum);
				} else {
					nombreEnum = CategoriaEnum.ACTIVO;
					cliente.setNombreCategoria(nombreEnum);

				}
			}
			Utilidad.sigue();
		}
	}

}
