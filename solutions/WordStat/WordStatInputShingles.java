import java.io.*;
import java.util.*;

public class WordStatInputShingles {
	public static void main(String[] args) {
		try {
			Reader reader = new InputStreamReader (new FileInputStream(args[0]), "utf-8");
			char[] buffer = new char[200000];
			StringBuilder word = new StringBuilder();
			LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
			try {
				while (true) {
					int num = reader.read(buffer) ;
					if (num == -1) {
						reader.close();
						break;
					}
					String str = new String(new String(buffer, 0, num) + " ");
					for (int i = 0; i <= num; i++) {
						if (Character.isLetter(str.charAt(i)) || Character.getType(str.charAt(i)) == 20
						 || str.charAt(i) == '\'') {
							word.append(str.charAt(i));
						} else {
							if (word.length() >= 3) {
								for (int k = 0; k < word.length() - 2; k++) {
									String string = word.toString().substring(k, k + 3);
									map.put(string.toLowerCase(), map.getOrDefault(string.toLowerCase(), 0) + 1);
								}
							}
							word.setLength(0);
						}
					}
				}
			} finally {
				reader.close();
			}
			Writer writer = new OutputStreamWriter (new FileOutputStream(args[1]), "utf-8");
			try {
				for (Map.Entry item: map.entrySet()) {
					writer.write(item.getKey() + " " + item.getValue() + "\n");
				}
			} finally {	
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("IOException  " + e.getMessage());
		} 
	}
}
