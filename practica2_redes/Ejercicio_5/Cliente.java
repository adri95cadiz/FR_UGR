import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;
import	java.net.Socket;
import	java.util.Random;
import	java.io.BufferedReader;
import	java.io.PrintWriter;
import	java.io.InputStreamReader;

public class Procesador extends Thread {
	
	private static final int TOPE = 20;

	public static void main(String[] args) {

	
		String bufferRecepcion = null;
		String bufferEnvio = null;

		String host = "localhost";
		int port = 8989;
		int numeroPropio;
		int numeroServidor;
		int numeroRecibido
		int inferior = 0;

		Random random = new Random();
			
		socket socketServicio = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		inReader = new BufferedReader(new InputStreamReader(inputStream));
		outPrinter = new PrintWriter(outputStream, true);

		try {
			socketServicio = new Socket(host, port);
			inputStream = socketServicio.getInputStream();
			outputStream = socketServicio.getOutputStream();
			inReader = new BufferedReader(new ImputStreamReader(inputStream));
			outPrinter = new PrintWriter(outputStream, true);

		} catch (IOException e) {

			System.err.println("Error al obtener los flujos de E/S.");	
	
		}

		do { 	
			numeroPropio = random.nextInt(TOPE);
		} while (numeroPropio == 0);
				
		do {
			try{

				do {
					numeroServidor = random.nextInt(superior);
				} while (numeroServidor <= inferior);

				bufferEnvio = integer.toString(numeroServidor);
				
				System.out.println("Cliente envia: " + bufferEnvio);

				outPrinter.println(bufferEnvio);
				outPrinter.flush();

				bufferRecepcion = inReader.readLine();

				if (bufferRecepcion.equals("=")) {
					fin = true;
					socketServicio.close();
					System.out.println("Respuesta de cliente: Correcta.");
				} else {
					if(bufferRecepcion.equals("<") {
						superior = numeroCliente;
					} else {
						inferior = numeroCliente;					
					}

					System.out.println("\tRespuesta de servidor: " + bufferRecepcion);
				}
				
				bufferRecepcion = inReader.readLine();

				numeroRecibido = Integer.parseInt(bufferRecepcion);

				if (numeroRecibido == numeroPropio) {
					outPrinter.println("=");
					fin = true;
				} else {
					
					if(numeroRecibido > numeroPropio) {
						outPrinter.println("<");
					} else {
						outPrinter.println(">");					
					}

				} while (!fin);

			} catch (IOException e) {

				System.err.println("Error al abrir el socket.");

			}

		} while (!fin);

	}

}
