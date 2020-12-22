import java.util.Scanner;

public class Reverse {
	public static void main(String[] args){
		int[] num = new int[1000000];
		int[] numlen = new int[1000000];
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
			numlen[l] = i - a;
			l++;
			a = i;
		}
		int[] numt = new int[l];
		int[] nums = new int[i];
		for (int j = l - 1; j >= 0; j--){
			// for (int k = 0; k < numlen[j]; k++) {
			// 	System.out.print(num[i - 1 - k] + " ");
			// }
			for (int c = 0; c < numlen[j]; c++) {
				if (nums[j] < num[i - 1 - c]) {
					nums[j] = num[i - 1 - c];
				}
				if (numt[c] < num[i - 1 - c]) {
					numt[c] = num[i - 1 - c];
				}
			}
			// System.out.print("\n");
			i = i - numlen[j];
		}
		for (int j = l - 1; j >= 0; j--){
			for (int c = 0; c < numlen[j]; c++) {
				if (numt[c] > nums[j]) {
					System.out.print(numt[c] + " ");
				} else {
					System.out.print(nums[j] + " ");
				}
			}
			System.out.print("\n");
		}
	}
}
/*


3
1 2
3 2 1

*/