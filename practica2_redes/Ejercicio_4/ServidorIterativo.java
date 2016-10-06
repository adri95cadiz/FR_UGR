import	java.io.IOException;
import	java.net.DatagramSocket;
import	java.net.DatagramPacket;
import	java.net.InetAddress;
import 	java.util.Random;

public class ServidorIterativo {

	public static void main(String[] args) {

		int port = 8989;

		DatagramSocket socketServidor = null;
		byte[] bufferRecepcion = new byte[256];
		byte[] bufferEnvio = new byte[256];
		DatagramPacket paquete = null;
		DatagramPacket paqueteModificado = null;
		InetAddress direccion;
		int puerto;

		String mensaje;

		try {
			socketServidor = new DatagramSocket(port);

		} catch (IOException e) {

			System.err.println("Error de E/S al abrir el socket");

		}

		do { 
			paquete = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);

			try { 
				socketServidor.receive(paquete);

			} catch (IOException e) {

			System.err.println("Error de E/S al abrir el socket");

			}

			mensaje = new String(paquete.getData());
			direccion = paquete.getAddress();
			puerto = paquete.getPort();

			String[] s = mensaje.split(" ");
			String resultado = "";

			Random random = new Random();

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
	
			bufferEnvio = resultado.getBytes();

			paqueteModificado = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccion, puerto);
			
			try { 
				socketServidor.send(paqueteModificado);			
			} catch (IOException e) {

			System.err.println("Error de E/S al abrir el socket");

			}

		} while (true);
	
	}

}
