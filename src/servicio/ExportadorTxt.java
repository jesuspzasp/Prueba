package servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;

public class ExportadorTxt extends Exportador{
	
	Scanner sc = new Scanner(System.in);
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		if (listaClientes == null) {
			System.out.print("No hay datos");
		} else {
			System.out.print("Ingresa la ruta donde desea exportar el archivo Clientes .txt: ");
			String txtSeparatorValue = ",";
			String filePath = sc.nextLine();
			String file = filePath + "/" + fileName;
			File fl = new File(file);
			if (fl.exists()) {
				
				fl.delete();
			}

			try {

				PrintWriter pWritter = new PrintWriter(new FileWriter(file));
				listaClientes.forEach(cliente -> {

					pWritter.append(cliente.getRunCliente()).append(txtSeparatorValue)
					.append(cliente.getNombreCliente()).append(txtSeparatorValue)
					.append(cliente.getApellidoCliente()).append(txtSeparatorValue)
					.append(cliente.getAniosCliente()).append(txtSeparatorValue)
					.append(String.valueOf(cliente.getNombreCategoria())).append(System.lineSeparator());
				});
				
				pWritter.close();
				System.out.print("---------------------------------------------------------- \n");
				System.out.print("Datos de clientes exportados correctamente en formato txt. \n");
			} catch (Exception error) {
				System.out.print("El archivo no pudo ser creado en \n");
			}
		}
		
	}
	
}
