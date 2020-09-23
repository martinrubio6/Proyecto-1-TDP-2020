package Proyecto1;

public class Tester {
	public static void main(String[] args) {
		Graph grafo = new Graph();
		int nodo1, nodo2;

		grafo.addNode(1);

		grafo.addNode(1);

		grafo.addEdge(1, 2);

		grafo.addNode(2);

		grafo.addEdge(1, 2);

		grafo.addNode(3);

		grafo.addNode(4);

		grafo.addNode(4);

		grafo.addEdge(1, 3);

		grafo.addEdge(1, 4);

		grafo.addEdge(2, 4);

		grafo.addEdge(2, 4);

		grafo.addEdge(3, 4);

		System.out.println("------------------- DATOS DEL GRAFO --------------------------");

		System.out.println("Los nodos del grafo son:");
		for (int nodo : grafo.nodos) {
			System.out.println(nodo);
		}

		System.out.println();

		System.out.println("Los arcos del grafo son:");
		for (Arco arco : grafo.arcos) {
			System.out.println(arco.toString());
		}

		System.out.println("------------------- Eliminacion de un Arco -------------------");
		nodo1 = 1;
		nodo2 = 2;

		grafo.removeEdge(nodo1, nodo2);

		System.out.println("Los arcos restantes del grafo son: ");
		for (Arco arco : grafo.arcos) {
			System.out.println(arco.toString());
		}

		nodo1 = 4;
		nodo2 = 2;

		grafo.removeEdge(nodo1, nodo2);

		System.out.println("------------------- Eliminacion de un Nodo -------------------");
		nodo2 = 5;
		grafo.removeNode(nodo2);

		grafo.removeNode(nodo1);

		System.out.println("Los nodos restantes del grafo despues de eliminar el nodo " + nodo1 + " son:");
		for (int nodo : grafo.nodos) {
			System.out.println(nodo);
		}

		System.out.println();

		System.out.println("Los arcos restantes del grafo despues de eliminar el nodo " + nodo1 + " son: ");
		for (Arco arco : grafo.arcos) {
			System.out.println(arco.toString());
		}

		System.out.println("---------------------------------------------------------------");
	}
}
