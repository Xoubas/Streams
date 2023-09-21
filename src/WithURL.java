import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WithURL {
	public static void main(String[] args) throws IOException {
		String url = JOptionPane.showInputDialog(null, "Introduce URL: ");
		URL urlIn = new URL(url);
		InputStream in = null;
		FileOutputStream out = null;

		try {
			JFileChooser save = new JFileChooser();
			in = urlIn.openStream();

			save.showSaveDialog(null);

			do {
				System.out.println("Introduce nome arquivo destino: ");
			} while (save.showSaveDialog(null) != JFileChooser.APPROVE_OPTION);

			File fileOut = save.getSelectedFile();
			out = new FileOutputStream(fileOut);

			int c;
			while ((c = in.read()) != -1)
				out.write(c);

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "ERROR");
			System.exit(1);
		} finally {
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}
