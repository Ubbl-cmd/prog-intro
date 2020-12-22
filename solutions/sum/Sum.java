public class Sum {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			args[i] = args[i].replaceAll("[\\p{Blank}\\p{Cntrl}\\p{Space}\\p{javaWhitespace}]", " ").replaceAll("\\s+", " ");
			String[] tempStringArray = args[i].trim().split("\\s");
			for (int j = 0; j < tempStringArray.length; j++) {	
				if (tempStringArray[j].isEmpty() == false) {
					sum += Integer.parseInteger(tempStringArray[j]);
				}
			}
		}
		System.out.println(sum);
	}
}
