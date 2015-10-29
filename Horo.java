package crru.scit.ce;

import java.util.Scanner;

public class Horo {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Birth Year:");	String yearStr = keyboard.nextLine();
		System.out.print("Sex [0 = Women, 1= Men] : ");String sexType = keyboard.nextLine();
		System.out.print("Level of Condo :");	int level = keyboard.nextInt();
		
		boolean sex;
		if (sexType == "0" ) sex = false; else sex = true;
		
		FengShui m = new FengShui(yearStr, sex, level);
		
		System.out.println(m.getDecode(m.getCondoLevelCode(),m.getHumanCode()));
		System.out.println();
		
		
		keyboard.close();

	}


}
