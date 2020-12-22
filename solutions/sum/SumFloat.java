public class SumFloat {
  public static void main(String[] args) {
    float sum = 0;
    for (int i = 0; i < args.length; i++) {
      int lastSpace = 0;
      for (int j = 1; j < args[i].length(); j++) {
        if (!(Character.isWhitespace(args[i].charAt(j))) && (Character.isWhitespace(args[i].charAt(j - 1)))) {
          lastSpace = j;
        }
        if ((Character.isWhitespace(args[i].charAt(j))) && !(Character.isWhitespace(args[i].charAt(j - 1)))) {
          sum += Float.parseFloat(args[i].substring(lastSpace, j));
        }
      }
      if (!Character.isWhitespace(args[i].charAt(args[i].length() - 1))) {
        sum += Float.parseFloat(args[i].substring(lastSpace,args[i].length()));
      }
    }
    System.out.println(sum);
  }
}


// public class SumFloat {
// 	public static void main(String[] args) {
// 		float sum = 0;
// 		for (int i = 0; i < args.length; i++) {
// 			// args[i] = "0 " + args[i] + " 0";
// 			args[i] = args[i].replaceAll("[\\p{javaWhitespace}]", " ").trim().replaceAll("\\s+", " ");
// 			String[] tempStringArray = args[i].trim().split("\\s");
// 			for (int j = 0; j < tempStringArray.length; j++) {
// 				if (tempStringArray[j].matches("[^.{0}]")) {
// 					sum += 0;
// 				} else {
// 					Float.parseFloat(tempStringArray[j]);
// 				}
// 			}
// 		}
// 		System.out.println(sum);
// 	}
// }