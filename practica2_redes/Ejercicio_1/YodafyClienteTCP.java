import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;
import	java.net.Socket;
import	java.net.UnknownHostException;

public class ClienteTCP {

	public static void main(String[] args) {

		byte[] bufferEnvio;
		byte[] bufferRecepcion = new byte[256];
		int bytesLeidos = 0;

		String host = "localhost";
		int port = 8989;
		
		Socket socketServicio = null;

		try {
			socketServicio = new Socket(host, port);
			
			InputStream inputStream = socketServicio.getInputStream();
			OutputStream outputStream = socketServicio.getOutputStream();

			bufferEnvio = "Tomate el zumo antes de que se le vayan las vitaminas".getBytes();

			outputStream.write(bufferEnvio, 0, bufferEnvio.length);

			outputStream.flush();

			bytesLeidos = imputStream.read(bufferRecepcion);

			System.out.print("\nRecibido: ");
			for (int i = 0; i < bytesLeidos; i++) {
				System.out.print((char) bufferRecepcion[i]);
			}
			System.out.println("\n");

			socketServicio.close();

		} catch (UnknownHostException e) {

			System.err.println("Error: Nombre de host no encontrado. ");

		} catch (IOException e) {

			System.err.println("Error de E/S al abrir el socket.");

		}

	}

}
