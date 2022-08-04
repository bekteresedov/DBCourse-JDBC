package run;

import java.util.Scanner;

public class UmumiRun {

	public static void main(String[] args) throws Exception {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("1-Student\n2-Teacher\n3-Lesson\n4-Payment");
			int number = sc.nextInt();
			switch (number) {
			case 1:
				RunStudent.runStudent();
				break;
			case 2:
				RunTeacher.runTeacher();
				break;
			case 3:
				RunLesson.runLesson();
				break;
			case 4:
				RunPayment.runPayment();
				break;
			default:
				System.err.println("Data not found");
				break;
			}
		} catch (Exception e) {
			System.err.println("Data not found");
		}
		

	}

}
