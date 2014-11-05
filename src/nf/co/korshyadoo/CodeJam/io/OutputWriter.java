package nf.co.korshyadoo.CodeJam.io;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OutputWriter {

	public static boolean write(String outputLocation, String data) {
		Path output = Paths.get(outputLocation);
		try {
			Files.deleteIfExists(output);
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] bytes = data.getBytes();
		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(output, CREATE, APPEND))) {
			out.write(bytes, 0, bytes.length);
		} catch (IOException x) {
			System.err.println(x);
			return false;
		}
		return true;
	}
}
