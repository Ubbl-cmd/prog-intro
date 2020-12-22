import java.io.*;

public class WordStat {
	public static void main(String[] args) {
		try {
			// Ввод
			FileReader reader = new FileReader(args[0]);
			char[] a = new char[20000];
			int num = reader.read(a);
			//reader.close();
			String text = new String(new String(a, 0, num) + " ");
			// Обработка
			String[] key = new String[1000000];
			for (int i=0; i < 1000000; i++) {
				key[i] = "";
			}
			int[] freq = new int[1000000];
			int lastSpace = 0;
			int differentWords = 0;
			for (int i = 1; i < text.length(); i++) {
				if ((Character.isWhitespace(text.charAt(i-1))) && (Character.isWhitespace(text.charAt(i)) == false)) {
					lastSpace = i;
				} 
				if ((Character.isWhitespace(text.charAt(i))) && (Character.isWhitespace(text.charAt(i-1)) == false)) {
					boolean found = false;
					for (int j = 0; j < differentWords; j++) {
						if (key[j].equals(text.substring(lastSpace, i))) {
							freq[j]++;
							found = true;
						}
					}
					if (found == false) {
						key[differentWords] = text.substring(lastSpace, i);
						freq[differentWords] = 1;
						differentWords++;
					}
				}

			}

			// Вывод
			FileWriter writer = new FileWriter("output.txt");
			for (int i = 0; i < differentWords; i++) {
				writer.write(key[i] + " " + freq[i] + "\n");
			}
			writer.flush();


		} catch(IOException ex) {
			System.out.println("FileNotFound " + args[0] + " " + ex);
		} //finally {
			// reader.close();
		// }
	}
}