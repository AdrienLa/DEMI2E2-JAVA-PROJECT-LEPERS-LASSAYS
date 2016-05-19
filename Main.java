import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		if (args.length==0){
			dispErreurArguments();
			return;
		}
		
		if (args[0].equals("-help")){
			dispHelp();
			return;
		}
		
		if (args.length < 3){
			dispErreurArguments();
			return;
		}
		
		//We ensure that <str1> and <str2> are valid
		ArrayList<String> strategies = new ArrayList<String>();
		strategies.add("tit");
		strategies.add("soft");
		strategies.add("grim");
		strategies.add("adapttit");
		strategies.add("hand");
		if (!strategies.contains(args[0]) || !!strategies.contains(args[1])){
			dispErreurArguments();
			return;
		}
		
		//We check that <nombre iteration> is an integer
		try {
			Integer.parseInt(args[2]);
		} catch (Exception e){
			System.out.println("<nombre iterations> doit être un entier");
			return;
		}
		
		//We create the 2 thugs
		Thug thug1 = new Defects_Always();
		Thug thug2 = new Defects_Always();
		
		
		if (args[0].equals("tit")) thug1 = new Tit_for_Tat();
		if (args[1].equals("tit")) thug2 = new Tit_for_Tat();
		
		if (args[0].equals("soft")) thug1 = new Soft_Majority();
		if (args[1].equals("soft")) thug2 = new Soft_Majority();
		
		if (args[0].equals("grim")) thug1 = new Grim_Trigger();
		if (args[1].equals("grim")) thug2 = new Grim_Trigger();
		
		if (args[0].equals("adapttit")) thug1 = new Adaptive_Tit_for_Tat();
		if (args[1].equals("adapttit")) thug2 = new Adaptive_Tit_for_Tat();
		
		if (args[0].equals("hand")) thug1 = new Handshake();
		if (args[1].equals("hand")) thug2 = new Handshake();
		
		//Loop
		for (int i; i<Integer.parseInt(args[2]); i++){
			thug1.chooseMoove(i, thug2);
			thug2.chooseMoove(i, thug1);
			thug1.applyResult(thug2);
			thug1.applyResult(thug1);
		}
	}
	
	
	
	public static void dispErreurArguments(){
		System.out.println("Arguments invalides, entrez l'argument -help pour en savoir plus");
	}
	
	public static void dispHelp(){
		System.out.println("usage: java Main.class [-help] <str1> <str2> <nombre iterations>\n"
				+ "\n"
				+ "str1: stratégies du prisonnier 1\n"
				+ "str2: stratégies du prisonnier 2\n"
				+ "\n"
				+ "Les stratégies disponibles sont:\n"
				+ "    tit    Tit for Tat\n"
				+ "    soft   Soft Majority\n"
				+ "    grim   Grim Trigger");
	}

}
