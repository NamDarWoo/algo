package algorithm;
/*
 * �ùķ��̼� ����, ����Լ�
 * �ҿ�ð� 1�ð� 50�� 
 */
import java.util.Scanner;

public class a {

	static int test_case;
	static int r, y;
	static int current_robot_r;
	static int current_robot_y;
	static int[][] array;
	static int pan_n;
	static int[] pan_number;
	static int change_count;
	static String direction;
	static int which;
	static int nn;
	static int next_start_point = 0;
	static int remain_go = 0;
	static int hap = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		test_case = sc.nextInt();
		for (int z = 1; z <= test_case; z++) {

			y = sc.nextInt();
			r = sc.nextInt();
			array = new int[r][y];
			current_robot_y = sc.nextInt() - 1;
			current_robot_r = sc.nextInt() - 1;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < y; j++) {
					array[i][j] = sc.nextInt();
				}
			}
			hap = hap + array[current_robot_r][current_robot_y];
			array[current_robot_r][current_robot_y] = 0;

			pan_n = sc.nextInt();
			pan_number = new int[pan_n];
			for (int i = 0; i < pan_n; i++) {
				pan_number[i] = sc.nextInt();
			}
			change_count = sc.nextInt();
			for (int i = 0; i < change_count; i++) {
				direction = sc.next();
				which = sc.nextInt();
				nn = sc.nextInt();
				if (which == 2) {//�ݽð� ������ �� �� ĭ �̵��ؾ��ϴ��� ã�� ����
					remain_go = pan_number[(next_start_point + nn) % pan_n];
					next_start_point = (next_start_point + nn) % pan_n;

				} else {//�ð� ������ �� �� ĭ �̵��ؾ��ϴ��� ã�� ����(�ð���� ������ ����� ���µ� �ð��� ���� �ɷȴ�)

					remain_go = pan_number[Math.abs(next_start_point + pan_n - nn)];
					next_start_point = Math.abs(next_start_point + pan_n - nn);

				}

				go(direction, remain_go, current_robot_r, current_robot_y);

			}
			System.out.println("#"+z+" "+ hap + " " + (current_robot_y + 1) + " " + (current_robot_r + 1));
			//���� �׽�Ʈ���̽��� ���� �ʱ�ȭ 
			next_start_point=0;
			hap=0;
			remain_go=0;
		}

	}

	private static void go(String di, int r_g, int c_r, int c_y) {
		// TODO Auto-generated method stub
		if (r_g == 0) {//ĭ �̵� �Ϸ� ����
			return;
		} else {
			if (di.equals("N")) {
				if (current_robot_r - 1 >= 0 && array[current_robot_r - 1][current_robot_y] != -1) {//-1������ �� �Լ� �״�� ��������
					hap = hap + array[current_robot_r - 1][current_robot_y];
					array[current_robot_r - 1][current_robot_y] = 0;
					current_robot_r = current_robot_r - 1;
					r_g = r_g - 1;

					go(di, r_g, current_robot_r, current_robot_y);
				}
			} else if (di.equals("S")) {
				if (current_robot_r + 1 < r && array[current_robot_r + 1][current_robot_y] != -1) {
					hap = hap + array[current_robot_r + 1][current_robot_y];
					array[current_robot_r + 1][current_robot_y] = 0;
					current_robot_r = current_robot_r + 1;
					r_g = r_g - 1;

					go(di, r_g, current_robot_r, current_robot_y);
				}

			} else if (di.equals("W")) {
				if (current_robot_y - 1 >= 0 && array[current_robot_r][current_robot_y - 1] != -1) {
					hap = hap + array[current_robot_r][current_robot_y - 1];
					array[current_robot_r][current_robot_y - 1] = 0;
					current_robot_y = current_robot_y - 1;
					r_g = r_g - 1;
					go(di, r_g, current_robot_r, current_robot_y);
				}

			} else if (di.equals("E")) {
				if (current_robot_y + 1 < y && array[current_robot_r][current_robot_y + 1] != -1) {
					hap = hap + array[current_robot_r][current_robot_y + 1];
					array[current_robot_r][current_robot_y + 1] = 0;
					current_robot_y = current_robot_y + 1;
					r_g = r_g - 1;
					go(di, r_g, current_robot_r, current_robot_y);
				}

			}
		}

	}

}