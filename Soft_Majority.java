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
	public Character getLastChoice(){
		return choice.get(-1);
	}
	public Character getChoiceRoundi(int roundi){
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
	
	public String resultat(Thug thug2, int roundi){
		if (choice.get(roundi).equals('C') && thug2.getChoiceRoundi(roundi).equals('C')){
			addYears(1);
			thug2.addYears(1);
			return "C C "+getPrisonTime()+thug2.getPrisonTime();
		}
		if (choice.get(roundi).equals('C') && thug2.getChoiceRoundi(roundi).equals('T')){
			addYears(10);
			thug2.addYears(0);
			return "C T "+getPrisonTime()+thug2.getPrisonTime();
		}
		if (choice.get(roundi).equals('T') && thug2.getChoiceRoundi(roundi).equals('C')){
			addYears(0);
			thug2.addYears(10);
			return "T C "+getPrisonTime()+thug2.getPrisonTime();
		}
		addYears(5);
		thug2.addYears(5);
		return "T T "+getPrisonTime()+thug2.getPrisonTime();
	}

}
