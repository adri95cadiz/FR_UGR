import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;
import	java.net.Socket;
import	java.util.Random;
import	java.io.BufferedReader;
import	java.io.PrintWriter;
import	java.io.InputStreamReader;

public class ProcesadorYodafy {

	private Socket socketServicio;
	private	InputStream imputStream;
	private OutputStream outputStream;
	private Random random;

	public	ProcesadorTexto	(Socket	socketServicio) {
		this.socketServicio = socketServicio;
		this.random = new Random();
	}

	void procesa() {

		int bytesRecibidos = 0;
		String datosEnviar = null;

		try {
			inputStream = socketServicio.getInputStream();
			outputStream = socketServicio.getOutputStream();

			bufferedReader inReader = new BufferedReader(new InputStreamReader(inputStream));
			datosRecibidos = inReader.readLine();

			String respuesta = yodaDo(peticion);

			PrintWriter outPrinter = new PrintWriter(outputStream, true);
			outPrinter.println(respuesta);

		} catch (IOException e) {

			System.err.println("Error al obtener los flujos de E/S.");

		}

	}

	private string yodaDo(String peticion) {

		String[] s = peticion.split(" ");
		String resultado = "";

		for(int i = 0; i < s.length; i++) {
			int j = random.nextInt(s.length);
			int k = random.nextInt(s.length);
			String aux = s[j];

			s[j] = s[k];
			s[k] = aux;
		}

		resultado = s[0];

		for(int i = 1; i < s.length; i++) {
			resultado += " " + s[i];
		}

		return resultado;
	}

}
