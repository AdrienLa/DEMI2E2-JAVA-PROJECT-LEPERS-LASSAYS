import java.util.ArrayList;


public class Handshake implements Thug{
	
	private int prison_time;
	private ArrayList<Character> choice;
	
	public Handshake(){
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
			setChoice('T');
		}
		else if(round == 1){
			setChoice('C');
		}
		else{
			if(My_Accomplice.getChoiceRoundi(0) == 'T' && My_Accomplice.getChoiceRoundi(1) == 'C')
				setChoice('C');
			else
				setChoice('T');
		}
	}

}
