
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

public class RunProces {
	public static void main(String[] args) {
		if (args.length <=0) {
			System.err.println("Falta el nombre del ejectuable");
			System.exit(-1);
			
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		String pid;
		pid = ManagementFactory.getRuntimeMXBean().getName();
		
		System.out.println("El pid del padre es "+pid);
		
		try {
			Process proceso = pb.start();
			int retorno = proceso.waitFor();
			System.out.println("La ejecución de "+ Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException | InterruptedException e) {
			System.err.println("Excepcion de E/S o proceso interrumpido");
			// TODO: handle exception
		}
	}
}
