package vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import servicio.*;
import utilidades.Utilidad;
import modelo.*;

public class Menu {
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	ClienteServicio clienteServicio = new ClienteServicio(listaClientes);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	String fileName = "Clientes";
	String fileName1 = "DBClientes.csv";
	Scanner sc = new Scanner(System.in);

	public void iniciarMenu() {
		boolean salir = false;
		int opcion;

		while (!salir) {

			System.out.println("1. Listar cliente");
			System.out.println("2. Agregar cliente");
			System.out.println("3. Editar cliente");
			System.out.println("4. Importar datos");
			System.out.println("5. Exportar datos");
			System.out.println("6. Terminar programa \n");

			System.out.println("Escribe una de las opciones \n");
			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				listarCliente();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente();
				break;
			case 4:
				importarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				System.out.println("Abandonando el sistema de clientes \n");
				System.out.println("Acaba de salir del sistema \n");
				salir = true;
				break;
			default:
				System.out.println("Opcion no valida \n");
			}
		}

	}

	private void listarCliente() {
		clienteServicio.listarClientes();
		Utilidad.sigue();

	}

	private void agregarCliente() {

		System.out.println("-------------- Crear cliente --------------");
		System.out.println("Ingresa RUN del cliente");
		String run = sc.next();

		System.out.println("Ingresa nombre del cliente");
		String nombre = sc.next();

		System.out.println("Ingresa apellido del cliente ");
		String apellido = sc.next();

		System.out.println("Ingresa años como cliente");
		String anios = sc.next();

		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;

		Cliente cliente = new Cliente(run, nombre, apellido, anios, nombreCategoria);
		cliente.setRunCliente(run);
		cliente.setNombreCliente(nombre);
		cliente.setApellidoCliente(apellido);
		cliente.setAniosCliente(anios);

		clienteServicio.agregarCliente(run, nombre, apellido, anios, nombreCategoria);
		Utilidad.sigue();
	}

	private void editarCliente() {

		int opcion;

		System.out.println("Seleccione que desea hacer");
		System.out.println("1. Cambiar el estado del cliente");
		System.out.println("2. Editar los datos ingresados del cliente");
		System.out.println("Ingrese opción");
		opcion = sc.nextInt();

		if (opcion == 1) {
			clienteServicio.editaEstadoCliente();

		} else {
			System.out.println("ingrese el run del cliente a editar");
			String op = sc.next();

			List<Cliente> listaClientes = clienteServicio.getListaClientes();
			for (Cliente cliente : listaClientes) {
				if (cliente.getRunCliente().equals(op)) {
					clienteServicio.editarCliente(cliente.getRunCliente(), cliente.getNombreCliente(),
							cliente.getApellidoCliente(), cliente.getAniosCliente(), cliente.getNombreCategoria());
				}
			}
		}
		Utilidad.sigue();
	}

	private void importarDatos() {

		System.out.print("Importar Datos \n");
		System.out.print("Ingrese la ruta del archivo PDBClientes.csv” \n");

		List<Cliente> listaClientes = archivoServicio.cargarDatos(fileName1);
		if (listaClientes != null && !listaClientes.isEmpty()) {
			clienteServicio.setListaClientes(listaClientes);
			System.out.print("Datos cargados correctamente en la lista \n");
			Utilidad.sigue();
		} else {
			System.out.print("No se pudo cargar los datos del archivo" + fileName + "\n");
		}

	}

	private void exportarDatos() {

		int opcion;

		ExportadorCsv exportadorCsv = new ExportadorCsv();
		ExportadorTxt exportadortxt = new ExportadorTxt();
		List<Cliente> listaClientes = clienteServicio.getListaClientes();

		System.out.print("--------------Exportar Datos-------------------- \n");
		System.out.println("Seleccione el formato a exportar");

		System.out.println("1. Formato csv");
		System.out.println("2. Formato txt");

		System.out.println("Ingrese una opcion para exportar");
		System.out.print("---------------------------------------------------------- \n");

		opcion = sc.nextInt();

		if (opcion == 1) {

			exportadorCsv.exportar(fileName + ".csv", listaClientes);

		} else {
			exportadortxt.exportar(fileName + ".txt", listaClientes);

		}

		Utilidad.sigue();
	}

}
