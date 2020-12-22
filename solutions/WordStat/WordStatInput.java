import java.io.*;
import java.util.*;

public class WordStatInput{
	public static void main(String[] args){
		try {
			Reader reader = new InputStreamReader (new FileInputStream (args[0]), "utf-8");
			Writer writer = new OutputStreamWriter (new FileOutputStream (args[1]), "utf-8");
			try {
				char[] buffer = new char[200000];
				StringBuilder word = new StringBuilder();
				LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
				while (true){
					int num = reader.read(buffer) ;
					if (num == -1){
						break;
					}
					String str = new String(new String(buffer, 0, num) + " ");
					System.out.println(str);
					for (int i = 0; i <= num; i++) {
						if (Character.isLetter(str.charAt(i)) || Character.getType((int)str.charAt(i)) == 20 || String.valueOf(str.charAt(i)).equals("'")) {
							word.append(str.charAt(i));
						} else {
							if (word.length() >=3) {
								String string = word.toString().substring(word.length()-3,word.length());
							}
							if (map.get(word.toString().toLowerCase()) != null) {
								map.put(word.toString().toLowerCase(), map.get(word.toString().toLowerCase()) + 1);
							} else if (word.length() != 0) {
								map.put(word.toString().toLowerCase(), 1);
							}
							word.setLength(0);
						}
					}
				}
				for(Map.Entry item: map.entrySet()){
				writer.write(item.getKey() + " " + item.getValue() + "\n");
				}
			} finally {
				reader.close();
				writer.close();
			}
		} catch (IOException e) {
			System.out.println("IOException  " + e.getMessage());
		}
	}
}