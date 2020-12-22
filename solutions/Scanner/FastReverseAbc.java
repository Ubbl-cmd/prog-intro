public class FastReverseAbc {
	public static void main(String[] args){
		String[] num = new String[10000000];
		int[] numlen = new int[10000000];
		int i = 0;
		int l = 0;
		int a = 0;
		Scanner scanner = new Scanner (System.in);
		while (scanner.hasNextLine()){
			Scanner sc = new Scanner (scanner.nextLine());
			while(sc.hasNextInt()) {
				num[i] = sc.nextInt();
				i++;
			}
			numlen[l] = i-a;
			l++;
			a = i;
		}
		for (int j = l-2; j >= 0; j--){
			for (int k = 0; k < numlen[j]; k++) {
				System.out.print(num[i-1-k] + " ");
			}
			System.out.print("\n");
			i = i-numlen[j];
		}
	}
}