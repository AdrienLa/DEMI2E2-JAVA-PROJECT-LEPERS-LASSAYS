import java.util.ArrayList;


public class Soft_Majority implements Thug{
	private int prison_time;
	private ArrayList<Character> choice;
	
	public Soft_Majority(){
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
		
		int C_number = 0;
		int T_number = 0;
		if(round == 0){
			setChoice('C');
		}
		
		else if(round != 0){
			for(int i=0;i<round;i++){
		
				if(My_Accomplice.getChoiceRoundi(i)=='C'){
					C_number += 1;
				}
				if(My_Accomplice.getChoiceRoundi(i)=='T'){
					T_number += 1;
				}
			}
			if(C_number >= T_number){
				setChoice('C');
			}
			else if(C_number < T_number){
				setChoice('T');
			}
		}
		
	}

}
