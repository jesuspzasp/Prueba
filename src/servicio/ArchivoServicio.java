package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.*;

public class ArchivoServicio extends Exportador {

	Scanner sc = new Scanner(System.in);

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

	}

	public List<Cliente> cargarDatos(String fileName) {

		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String filepath = sc.nextLine();
		String file = filepath + File.separator + fileName;

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				CategoriaEnum categoria = CategoriaEnum.ACTIVO;
				Cliente cliente = new Cliente(values[0], values[1], values[2], values[3], categoria.parse(values[4]));
				listaClientes.add(cliente);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al crear directorio" + e.toString());
		} finally {
			try {

			} catch (Exception error) {
				System.out.print("no se pudo crear el archivo \n");
			}
		}

		return listaClientes;

	}

}
