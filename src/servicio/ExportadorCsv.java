package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import modelo.*;

public class ExportadorCsv extends Exportador {

	Scanner scanner = new Scanner(System.in);

	public void exportar(String fileName, List<Cliente> listaClientes) {
		if (listaClientes == null) {
			System.out.print("No hay datos");
		} else {
			System.out.print("Ingresa la ruta donde desea exportar el archivo Clientes.Csv: ");
			String cvsSeparatorValue = ",";
			String filePath = scanner.nextLine();
			String file = filePath + "/" + fileName;
			File fl = new File(file);
			if (fl.exists()) {

				fl.delete();
			}

			try {

				PrintWriter pWritter = new PrintWriter(new FileWriter(file));
				listaClientes.forEach(cliente -> {

					pWritter.append(cliente.getRunCliente()).append(cvsSeparatorValue)
							.append(cliente.getNombreCliente()).append(cvsSeparatorValue)
							.append(cliente.getApellidoCliente()).append(cvsSeparatorValue)
							.append(cliente.getAniosCliente()).append(cvsSeparatorValue)
							.append(String.valueOf(cliente.getNombreCategoria())).append(System.lineSeparator());
				});
				pWritter.close();
				System.out.print("---------------------------------------------------------- \n");
				System.out.print("Datos de clientes exportados correctamente en formato csv. \n");
			} catch (Exception error) {
				System.out.print("El archivo no pudo ser creado \n");
			}
		}

	}

}
