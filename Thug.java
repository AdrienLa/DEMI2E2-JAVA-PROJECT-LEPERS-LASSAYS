import java.util.ArrayList;


public interface Thug {
	public void chooseMove(int round,Thug My_Accomplice);
	public int getPrisonTime();
	public void addYears(int time);
	public void setChoice(char choice);
	public ArrayList<Character> getAllChoices();
	public Character getLastChoice();
	public Character getChoiceRoundi(int roundi);
	public String resultat(Thug thug2, int roundi);
}
