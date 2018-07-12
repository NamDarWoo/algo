package algorithm;
/*
 * 시뮬레이션 문제, 재귀함수
 * 소요시간 1시간 50분 
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
				if (which == 2) {//반시계 방향일 때 몇 칸 이동해야하는지 찾는 수식
					remain_go = pan_number[(next_start_point + nn) % pan_n];
					next_start_point = (next_start_point + nn) % pan_n;

				} else {//시계 방향일 때 몇 칸 이동해야하는지 찾는 수식(시계방향 수식을 만들어 내는데 시간이 오래 걸렸다)

					remain_go = pan_number[Math.abs(next_start_point + pan_n - nn)];
					next_start_point = Math.abs(next_start_point + pan_n - nn);

				}

				go(direction, remain_go, current_robot_r, current_robot_y);

			}
			System.out.println("#"+z+" "+ hap + " " + (current_robot_y + 1) + " " + (current_robot_r + 1));
			//다음 테스트케이스를 위한 초기화 
			next_start_point=0;
			hap=0;
			remain_go=0;
		}

	}

	private static void go(String di, int r_g, int c_r, int c_y) {
		// TODO Auto-generated method stub
		if (r_g == 0) {//칸 이동 완료 종료
			return;
		} else {
			if (di.equals("N")) {
				if (current_robot_r - 1 >= 0 && array[current_robot_r - 1][current_robot_y] != -1) {//-1만나면 이 함수 그대로 빠져나감
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