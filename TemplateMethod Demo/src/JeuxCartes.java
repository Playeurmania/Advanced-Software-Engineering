import java.util.ArrayList;

public abstract class JeuxCartes {
	
	abstract void initialisation(int nbJoueurs);
	abstract void débutJeu(int nbJoueurs);
	abstract void finJeu();
	
	public int[] valeurs = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	public String[] familles = {"Pique", "Coeur", "Trèfle", "Carreau"};
	public Joueur[] joueurs = {new Joueur(1), new Joueur(2)};

	
	
	public class Carte{
		
		private int valeur;
		private String famille;
		
		private Carte(int val, String fam){
			this.valeur = val;
			this.famille = fam;
		}
		
		public String toString(){
			return this.valeur+" de "+this.famille;
		}
	}
	
	public class Joueur{
		ArrayList<Carte> main;
		ArrayList<Carte> défausse;
		int numero;
		
		public Joueur(int i){
			
			this.main = new ArrayList<Carte>();
			this.défausse = new ArrayList<Carte>();
			this.numero=i;
		}
		
		
		
	}
	
	public final void jeu(int nbjoueurs){
		initialisation(nbjoueurs);
		débutJeu(nbjoueurs);
		finJeu();
	}
	
	public final void distribution(){
		
		/**
		 * Création du jeu de cartes
		 */
		
		System.out.println("Création des cartes");
		Carte[] deck = new Carte[(valeurs.length)*(familles.length)];
		int u = 0;
		for (int i : valeurs){	
			for(String j : familles){
				deck[u]=new Carte(i,j);
				u++;
			}
		}
		System.out.println("Deck complet");
		
		/**
		 * Mélange du deck
		 */
        for(int i=0;i<deck.length;i++){
            
        	Carte c;
            int j = (int)Math.floor(Math.random()*(deck.length-i) + i);
            c = deck[i];
            deck[i] = deck[j];
            deck[j] = c;
        }
        System.out.println("Deck mélangé");
        
        /**
         * Distribution des cartes
         */
        for (Joueur j : joueurs){
        	for (int i=0; i<(deck.length/joueurs.length); i++){
        		j.main.add(deck[j.numero+i]);
        	}
        }
	}
} 
