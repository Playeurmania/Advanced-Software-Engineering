public class BatailleCorse extends JeuxCartes{
	
	public String[] cartesJ1;
	public String[] cartesJ2;
	int joueur;
	
	
	void initialize(){
		System.out.println("La partie de bataille corse est initialisée !");
		String[] cartesJ1 = {"Pi:3", "Ca:4"};
		String[] cartesJ2 = {"Pi:7", "Co:12"};
		
	}
	
	void startPlay(int joueur){
		System.out.println("Le joueur "+joueur+" joue !");
		String[] current;
		if (joueur == 0){
			//On retire la première carte du tas du joueur
			//On l'ajoute à current
			if (/*current[n] == current[n-1]*/true){
				//On rajoute current au tas du J1
			} 		
		} else {
			//On fait l'inverse
		}
	}
	
	void endplay(){
		
	}
}
