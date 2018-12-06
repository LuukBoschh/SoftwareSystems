package ss.week2;

public class Year{
	int year;
	
	public Year(int year){
		this.year = year;
	}
	public boolean IsLeapYear() {
		boolean aLeapYear;
		if (year % 4 == 0)
			if(year % 100 ==0)
				aLeapYear =(year % 400 == 0 );
			else
				aLeapYear = true;
		else
			aLeapYear = false;
		return aLeapYear;
	}
}
