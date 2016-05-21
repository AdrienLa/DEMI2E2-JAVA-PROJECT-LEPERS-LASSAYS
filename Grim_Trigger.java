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
	public Character getLastChoice(){
		return choice.get(-1);
	}
	public Character getChoiceRoundi(int roundi){
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
