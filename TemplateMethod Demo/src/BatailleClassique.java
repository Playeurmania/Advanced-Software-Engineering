import java.util.ArrayList;

public class BatailleClassique extends JeuxCartes{
	
	public boolean fini = false;
	private ArrayList<Carte> pot = new ArrayList<Carte>();
	int compteur = 0;
	
	void initialisation(int nbJoueurs){
		System.out.println("La partie de bataille corse est initialisée !");
		joueurs = new Joueur[nbJoueurs];
		for (int i=0; i<joueurs.length; i++){
			joueurs[i] = new Joueur(i);
		}
		distribution();		
	}
	
	void tour(){
		
		Joueur joueur = joueurs[compteur%joueurs.length]; // C'est à ce joueur de jouer.
		System.out.println("Le joueur "+joueur.numero+" joue !");
		/**
		 * Jouer une carte
		 */
			Carte c = joueur.main.remove(0);
			pot.add(c);
			System.out.println("Le joueur "+joueur.numero+" a joué la carte "+c.toString());
			
			/**
			 * Duel?
			 */
			int taille = pot.size();
			if (taille>1){ // On vérifie qu'il y a au moins deux cartes dans le pot.
				if (pot.get(taille-1).valeur > pot.get(taille-2).valeur){ // Les deux dernières cartes sont identiques
						joueur.main.addAll(pot);
						pot.clear();
					}
					else{
						joueurs[(compteur+1)%joueurs.length].main.addAll(pot);
						pot.clear();
					}	
				} 
			/**
			 * Gagnant?
			 */
			if (joueur.main.size() == 0){
				fini = true;
			}
			/**
			 * Passage au joueur suivant
			 */
			compteur+=1;
	}
	
	void débutJeu(int nbJoueurs){
		
		initialisation(nbJoueurs);
	    	while(!fini){
		      tour();
	     	}
	    finJeu();
	   }
	
	void finJeu(){
		System.out.println("La partie est terminée !");
	}
}
