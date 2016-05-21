import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		if (args.length==0){
			System.out.println("Arguments invalides, entrez l'argument -help pour en savoir plus");
			return;
		}
		
		if (args[0].equals("-help")){
			dispHelp();
			return;
		}
		
		if (args.length < 3){
			System.out.println("Mauvais nombre d'arguments, entrez l'argument -help pour en savoir plus");;
			return;
		}
		
		//We ensure that <str1> and <str2> are valid
		ArrayList<String> strategies = new ArrayList<String>();
		strategies.add("defect");
		strategies.add("tit");
		strategies.add("soft");
		strategies.add("grim");
		strategies.add("adapttit");
		strategies.add("hand");
		if (!strategies.contains(args[0]) || !strategies.contains(args[1])){
			System.out.println("<str1> ou <str2> est incorrect, entrez l'argument -help pour en savoir plus");
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
		for (int i=0; i < Integer.parseInt(args[2]); i++){
			thug1.chooseMove(i, thug2);
			thug2.chooseMove(i, thug1);
			
			System.out.println(thug1.resultat(thug2, i));
		}
	}
	
	
	public static void dispHelp(){
		System.out.println("usage: java Main [-help] <str1> <str2> <nombre iterations>\n\n"
				+ "str1: stratégies du prisonnier 1\n"
				+ "str2: stratégies du prisonnier 2\n"
				+ "\n\n"
				+ "Les stratégies disponibles sont:\n"
				+ "    tit      Tit for Tat (Coopérer lors de la première confrontation, puis choisir la décision que le complice a pris à l’itération précédente)\n\n"
				+ "    soft     Soft Majority (Coopérer si et seulement si l’autre joueur a coopéré au moins autant de fois qu’il a trahi)\n\n"
				+ "    grim     Grim Trigger (Coopérer jusqu’à ce que l’autre joueur trahisse, puis toujours trahir)\n\n"
				+ "    defect   Defect Always (Trahis toujours)\n\n" 
				+ "    adapttit Adaptive Tit for Tat(voir http://www.prisoners-dilemma.com/strategies.html, on utilise r=0.35 et word=0.85)\n\n"
				+ "    hand     Handshake (Trahis au premier tour et coopère au second, si son opposant a fait la même chose alors il coopère toujours sinon il trahis toujours");
	}

}
