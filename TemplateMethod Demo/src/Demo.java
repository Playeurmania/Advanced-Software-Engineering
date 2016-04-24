public class Demo {
	
   final void jouerUnePartie(int nombreDeJoueurs){
	     initialize();
	     int joueur = 0;
	     boolean fini = false;
	     while(!fini){
	       startPlay(joueur);
	       joueur = (joueur + 1) % nombreDeJoueurs;
	     }
	     proclamerLeVainqueur();
	   }
	
	public static void main(String[] args){
		jouerUnePartie(2);
	}
}
