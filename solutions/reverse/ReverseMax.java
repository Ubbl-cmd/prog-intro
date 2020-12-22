import java.util.Scanner;

public class ReverseMax {
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
				a++;
			}
			numlen[l] = a;
			l++;
			a = 0;
		}
		int[] numt = new int[1000000];
		int[] nums = new int[1000000];
		for (int p = 0; p < l; p++) {
			numt[p] =Integer.MIN_VALUE;
		}
		for (int p = 0; p < i; p++) {
			nums[p] =Integer.MIN_VALUE;
		}
		int d = 0;
		for (int j = 0; j < l; j++){
			for (int c = 0; c < numlen[j]; c++) {
				if (nums[j] < num[d]) {
					nums[j] = num[d];
				}
				if (numt[c] < num[d]) {
					numt[c] = num[d];
				}
				d++;
			}
		}

		for (int j = 0; j < l; j++) {
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
