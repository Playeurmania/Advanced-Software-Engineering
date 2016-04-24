
public abstract class JeuxCartes {
	
	abstract void initialisation(int nbJoueurs);
	abstract void débutJeu();
	abstract void finJeu();
	
	public Carte[] Jeu;
	
	
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
	
	public final void jeu(int nbjoueurs){
		
	}
	
	public final void distribution(int nbjoueurs){
		
		/**
		 * Création du jeu de cartes: 40 carte
		 */
		
	}


}
