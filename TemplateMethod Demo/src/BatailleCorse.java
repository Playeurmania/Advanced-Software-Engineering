import java.util.ArrayList;

public class BatailleCorse extends JeuxCartes{
	
	public ArrayList<Carte> cartesJ1;
	public ArrayList<Carte> cartesJ2;
	int joueur;
	
	
	void initialisation(int joueur){
		System.out.println("La partie de bataille corse est initialisée !");
		ArrayList<Carte> cartesJ1 = null;
		ArrayList<Carte> cartesJ2 = null;
		
	}
	
	void startPlay(int joueur){
		System.out.println("Le joueur "+joueur+" joue !");
		ArrayList<Carte> Current = null;
		if (joueur == 0){
			Carte c = cartesJ1.remove(0);
			Current.add(c);
			int taille = Current.size();
			if (taille>0){
				if (Current.get(taille) == Current.get(taille-1)){
					cartesJ1.addAll(Current);
				} 
			}	
		} 
	}
	
	void débutJeu(){
		
	}
	
	void finJeu(){
		
	}
}
