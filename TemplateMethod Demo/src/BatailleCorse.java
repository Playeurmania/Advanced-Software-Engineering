import java.util.ArrayList;

public class BatailleCorse extends JeuxCartes{
	
	public boolean fini = false;
	
	void initialisation(int nbJoueurs){
		System.out.println("La partie de bataille corse est initialisée !");
		distribution();
		
	}
	
	void startPlay(Joueur joueur, Joueur autreJoueur){
		System.out.println("Le joueur "+joueur.numero+" joue !");
			Carte c = joueur.main.remove(0);
			System.out.println("Le joueur "+joueur.numero+" a joué la carte "+c.toString());
			joueur.défausse.add(c);
			int taille = joueur.défausse.size();
			if (taille>0){
				if (joueur.défausse.get(taille) == joueur.défausse.get(taille-1)){
					joueur.main.addAll(joueur.défausse);
					joueur.défausse.clear();
				} 
			}
			if (joueur.main.size() == 0){
				fini = true;
			}
		autreJoueur.défausse = joueur.défausse;
	}
	
	void débutJeu(){
		
		Joueur joueur;
		Joueur autreJoueur;
	    	while(!fini){
		      startPlay(joueur, autreJoueur);
		      Joueur alter = joueur;
		      joueur = autreJoueur;
		      autreJoueur=alter;
	     	}
	   }
	
	void finJeu(){
		System.out.println("La partie est terminée !");
	}
}
