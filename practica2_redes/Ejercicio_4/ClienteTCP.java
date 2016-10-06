import	java.io.BufferedReader;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.InputStreamReader;
import	java.io.OutputStream;
import	java.io.PrintWriter;
import	java.net.Socket;
import	java.net.UnknownHostException;

public class ClienteTCP {

	public static void main(String[] args) {

		String bufferEnvio;
		String bufferRecepcion;

		String host = "localhost";
		int port = 8989;
		
		Socket socketServicio = null;

		try {
			socketServicio = new Socket(host, port);
			
			InputStream inputStream = socketServicio.getInputStream();
			OutputStream outputStream = socketServicio.getOutputStream();

			bufferEnvio = "Tomate el zumo antes de que se le vayan las vitaminas";

			PrintWriter outPrinter = new PrintWriter(outputStream, true);
			outPrinter.println(bufferEnvio);

			outPrinter.flush();

			BufferedReader inReader = new BufferedReader(new InputStream(inputStream));
			bufferRecepcion = inReader.readLine();

			System.out.print("\nRecibido: " + bufferRecepcion + "\n");

			socketServicio.close();

		} catch (UnknownHostException e) {

			System.err.println("Error: Nombre de host no encontrado. ");

		} catch (IOException e) {

			System.err.println("Error de E/S al abrir el socket.");

		}

	}

}
