import java.util.ArrayList;


public class Adaptive_Tit_for_Tat implements Thug{
	 
	private static double r = 0.35;
	private double world = 0.85;
	private int prison_time;
	private ArrayList<Character> choice;
	
	public Adaptive_Tit_for_Tat(){
		prison_time = 0;
		choice = new ArrayList<Character>();
	}
	
	public int getPrisonTime(){
		return prison_time;
	}
	
	public void addYears(int time){
		prison_time -= time;
	}
	
	public void setChoice(char choice){
		this.choice.add(choice);
	}
	
	public ArrayList<Character> getAllChoices(){
		return choice;
	}
	public char getLastChoice(){
		return choice.get(-1);
	}
	public char getChoiceRoundi(int roundi){
		return choice.get(roundi);
	}
	
	public void chooseMove(int round,Thug My_Accomplice){
		if(round == 0)
			setChoice('C');
		else if(round > 0){
			
			if(My_Accomplice.getChoiceRoundi(round-1) == 'C')
				world = world + r*(1-world);
			else
				world = world + r*(0-world);
			if(world >= 0.5)
				setChoice('C');
			else
				setChoice('T');
		}
	}

}
