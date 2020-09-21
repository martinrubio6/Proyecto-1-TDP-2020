package Ejercicio_4;

public class TestPair {

	public static void main(String [] args) {
		
		Pair<Integer,String> p1 = new Pair<Integer,String>(23,"Juan");
		Pair<Float,Integer> p2 = new Pair<Float,Integer>(23.2f,21345);
		Pair<String,String> p3 = new Pair<String,String>("Tito","El Bambino");
		Pair<Float,Character> p4 = new Pair<Float,Character>(25.1f,'C');
		Pair<String,String> p5 = new Pair<String,String>("Hernan","El Carnicero");
		
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		System.out.println("p3: "+p3);
		System.out.println("p4: "+p4);
		System.out.println("p5: "+p5);
	}
}
