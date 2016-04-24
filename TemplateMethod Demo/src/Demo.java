public class Demo {
	
   final static void jouerUnePartieDeBatailleCorse(int nombreDeJoueurs){
	     JeuxCartes game = new BatailleCorse();
	   	 game.jeu(nombreDeJoueurs);
	     
   }
   
   final static void jouerUnePartieDeBataille(int nombreDeJoueurs){
	   JeuxCartes game = new BatailleClassique();
	   game.jeu(nombreDeJoueurs);
   }
	
	public static void main(String[] args){
		//jouerUnePartieDeBatailleCorse(2);
		
		jouerUnePartieDeBataille(2);
	}
}
