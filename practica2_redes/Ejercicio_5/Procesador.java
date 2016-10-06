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
	private Socket socketServicio;
	private Random random;
	private int numeroPropio;

	public	ProcesadorTexto	(Socket	socketServicio) {
		this.socketServicio = socketServicio;
		this.random = new Random();		
		do{
			this.numeroPropio = random.nextInt(TOPE);
		} while (numeroPropio == 0);
	}

	public void run() { 
		procesa();	
	}

	void procesa() {

		String bufferRecepcion = null;
		String bufferEnvio = null;
		int numeroRecibido;
		int numeroCliente;
		int inferior = 0;
		int superior = TOPE
		boolean fin = false;

		InputStream inputStream = null;
		OutputStream outputStream = null;
		inReader = new BufferedReader(new InputStreamReader(inputStream));
		outPrinter = new PrintWriter(outputStream, true);

		try {
			inputStream = socketServicio.getInputStream();
			outputStream = socketServicio.getOutputStream();
			inReader = new BufferedReader(new ImputStreamReader(inputStream));
			outPrinter = new PrintWriter(outputStream, true);

			do { 
				
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

				do { 
					numeroCliente = random.nextInt(superior);
				} while (numeroCliente <= inferior);

				bufferEnvio = integer.toString(numeroCliente);
				
				System.out.println("Servidor envia: " + bufferEnvio);

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

					System.out.println("Respuesta de cliente: " + bufferRecepcion);
				} 

			} while (!fin);

		} catch (IOException e) {

			System.err.println("Error al obtener los flujos de E/S.");

		}

	}

}
