import java.util.Random;

public class IfSwitch {

	static int MAX = 100000000;

	public static void main(String[] args) {
		IfSwitch ex = new IfSwitch();
		Random random = new Random();
		/*int[] arr = new int[MAX];
		for (int i = 0; i < MAX; i++) {
			arr[i] = random.nextInt(10);
		}*/
		long millis = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++)
			ex.ifEx(i);
		System.out.println("if : " + (System.currentTimeMillis() - millis));
		millis = System.currentTimeMillis();
		for (int i = 0; i < MAX; i++)
			ex.switchEx(i);
		System.out.println("switch : " + (System.currentTimeMillis() - millis));
	}

	public void ifEx(int value) {
		int cnt = 0;
		int ans;
		//Random random = new Random();
		//while (cnt < MAX) {
			if (value== 0) {
				ans = 0;
			} else if (value== 1) {
				ans = 1;
			} else if (value == 2) {
				ans = 2;
			} else if (value == 3) {
				ans = 3;
			} else if (value == 4) {
				ans = 4;
			} else if (value == 5) {
				ans = 5;
			} else if (value == 6) {
				ans = 6;
			} else if (value == 7) {
				ans = 7;
			} else if (value == 8) {
				ans = 8;
			} else {
				ans = 9;
			}
			//cnt++;
		//}
	}

	public void switchEx(int value) {
		int cnt = 0;
		int ans;

		//Random random = new Random();
		//while (cnt < MAX) {
			switch (value) {
				case 0:
					ans = 0;
					break;
				case 1:
					ans = 1;
					break;
				case 2:
					ans = 2;
					break;
				case 3:
					ans = 3;
					break;
				case 4:
					ans = 4;
					break;
				case 5:
					ans = 5;
					break;
				case 6:
					ans = 6;
					break;
				case 7:
					ans = 7;
					break;
				case 8:
					ans = 8;
					break;
				default:
					ans = 9;
					break;
			}
			//cnt++;
		//}
	}
}
