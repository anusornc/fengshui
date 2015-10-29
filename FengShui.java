package crru.scit.ce;

public class FengShui {
	char year[];
	boolean isMan;
	int level;
	
	FengShui(String yearCode,boolean isMan,int level) {
		
		year = new char[4];
		year = yearCode.toCharArray();
		this.isMan = isMan;
		this.level = level;
	}
	
	public String getDetailCode(int code) {
		
		if (code == 1 ) 
			return "Water";
		else if (code == 2 || code == 5 || code == 8)
			return "Earth";
		else if (code == 3 || code == 4)
			return "Wood";
		else if (code == 6 || code == 7)
			return "Gold";
		else if (code == 9 )
			return "Fire";
		else
			return "N/A";
	}
	
	public int getNewCode(int code) {
		if (code == 1 ) 
			return 1; //Water
		else if (code == 2 || code == 5 || code == 8)
			return 2; //Earth
		else if (code == 3 || code == 4)
			return 3; //Wood
		else if (code == 6 || code == 7)
			return 4; //Gold
		else if (code == 9 )
			return 5; //Fire
		else
			return 0; //N/A
	}
	
	public int getHumanCode() {
		
		String tmp="";
		
		int totalYear = 0;
		for( char y : year ) {
			totalYear += Character.getNumericValue(y);
		}

		if (totalYear > 9) {
			char year2[] = new char[2];
			tmp = Integer.toString(totalYear);
			totalYear = 0;
			year2 = tmp.toCharArray();
			
			for (char y:year2) {
				totalYear += Character.getNumericValue(y);
			}
		}
	
		if (isMan) 
			return 14 - totalYear;
		else
			return totalYear + 1;
		
		
	}
	
	public int getCondoLevelCode() {
		if (this.level > 9) {
			String tmp = Integer.toString(this.level);
			return Character.getNumericValue(tmp.charAt(tmp.length()-1));
		} else 
			return this.level;

	}
	
	public String getDecode(int CondoCode, int HumanCode) {
		String reaction = "";
		System.out.println("Condo Level code =" + getDetailCode(CondoCode)+" Human code = " + getDetailCode(HumanCode));
		System.out.println("COMPARE Condo Level -> Human Code");
		
		int cCode = getNewCode(CondoCode);
		int hCode = getNewCode(HumanCode);
		
		
		if (cCode == 2 && hCode == 4) 
			reaction = "Very Good.";
		else if (cCode == 4 && hCode == 1)
			reaction = "Very Good";
		else if (cCode == 1 && hCode == 3) 
			reaction = "Very Good";
		else if (cCode == 3 && hCode == 5)
			reaction = "Very Good";
		else if (cCode == 5 && hCode == 2)
			reaction = "Very Good";
		else if (cCode == 2 && hCode == 1) 
			reaction = "Very Bad.";
		else if (cCode == 1 && hCode == 5)
			reaction = "Very Bad.";
		else if (cCode == 5 && hCode == 4) 
			reaction = "Very Bad.";
		else if (cCode == 4 && hCode == 3)
			reaction = "Very Bad.";
		else if (cCode == 3 && hCode == 2)
			reaction = "Very Bad.";
		else if (cCode == hCode)
			reaction = "Good.";
		
		if (reaction == "") {
			System.out.println("NOT FOUND SOLUTION.");
			System.out.println("");
			System.out.println("COMPARE HumanCode -> Condo Level");
		}
		
		if (hCode == 2 && cCode == 4) 
			reaction = "Bad.";
		else if (hCode == 4 && cCode == 1)
			reaction = "Bad.";
		else if (hCode == 1 && cCode == 3) 
			reaction = "Bad.";
		else if (hCode == 3 && cCode == 5)
			reaction = "Bad.";
		else if (hCode == 5 && cCode == 2)
			reaction = "Bad.";
		else if (hCode == 2 && cCode == 1) 
			reaction = "Good (Try Hard).";
		else if (hCode == 1 && cCode == 5)
			reaction = "Good (Try Hard).";
		else if (hCode == 5 && cCode == 4) 
			reaction = "Good (Try Hard).";
		else if (hCode == 4 && cCode == 3)
			reaction = "Good (Try Hard).";
		else if (hCode == 3 && cCode == 2)
			reaction = "Good (Try Hard).";

		return reaction;
	}
	
}
