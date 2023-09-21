import java.io.*;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WithBuffer {
	public static void main(String[] args) throws IOException {
		String add = JOptionPane.showInputDialog(null, "Introduce URL: ");
		URL url = new URL(add);
		BufferedInputStream in = null;
		FileOutputStream out = null;

		JFileChooser save = new JFileChooser();
		in = new BufferedInputStream(url.openStream());

		save.showSaveDialog(null);

		do {
			System.out.println("Introduce nome arquivo destino: ");
		} while (save.showSaveDialog(null) != JFileChooser.APPROVE_OPTION);

		File fileOut = save.getSelectedFile();
		out = new FileOutputStream(fileOut);

		int c;
		while ((c = in.read()) != -1)
			out.write(c);

		JOptionPane.showMessageDialog(null, "ERROR");
		System.exit(1);

		if (in != null)
			in.close();
		if (out != null)
			out.close();

	}
}
