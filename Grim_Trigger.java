import java.util.ArrayList;


public class Grim_Trigger implements Thug {
	
	private int prison_time;
	private ArrayList<Character> choice;
	
	public Grim_Trigger(){
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
		if(round == 0){
			setChoice('C');
		}
		else if(round > 0){
			if(getChoiceRoundi(round - 1) == 'T'){
				setChoice('T');
			}
			else if(getChoiceRoundi(round - 1) == 'C'){
				if(My_Accomplice.getChoiceRoundi(round - 1)=='T') setChoice('T');
				else if(My_Accomplice.getChoiceRoundi(round - 1)=='C') setChoice('C');
			}
		}
	}
}
