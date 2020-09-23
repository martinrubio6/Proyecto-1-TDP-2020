package Proyecto1;

import java.util.logging.*;
import java.util.LinkedList;

public class Graph {

	protected LinkedList<Arco> arcos;
	protected LinkedList<Integer> nodos;
	protected static Logger logger;

	public Graph() {
		arcos = new LinkedList<Arco>();
		nodos = new LinkedList<Integer>();

		if (logger == null) {

			logger = Logger.getLogger(Graph.class.getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);

			logger.setLevel(Level.WARNING);

			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}

	public void addNode(int node) {
		if (estaNodo(node))
			logger.warning("El nodo " + node + " ya se encuentra en el grafo");
		else {
			nodos.addLast(node);
			logger.info("El nodo " + node + " fue ingresado al grafo");
		}
	}

	public void addEdge(int node1, int node2) {
		Arco edge;
		if (estaNodo(node1) && estaNodo(node2)) {
			if (!estaArco(node1, node2)) {
				edge = new Arco(node1, node2);
				arcos.addLast(edge);
				logger.info("El arco de " + node1 + " a " + node2 + " ha sigo agregado");
			} else
				logger.warning("El arco de " + node1 + " a " + node2 + " ya esta en el grafo");
		} else {
			logger.warning("No se puede agregar el arco dado que " + node1 + " y/o " + node2 + " no estan en el grafo");
		}
	}

	public void removeNode(int node) {
		LinkedList<Integer> lista_index = new LinkedList<Integer>();
		boolean encontreNodo = false;
		int puntero;
		int indice = 0;

		//Elimino el Nodo//
		for (int i = 0; i < nodos.size() && !encontreNodo; i++) {
			if (nodos.get(i) == node) {
				encontreNodo = true;
				nodos.remove(i);
				logger.info("El nodo " + node + " ha sido eliminado del grafo");
			}
		}
		if (!encontreNodo) {
			logger.warning("No se puede eliminar el nodo " + node + " ya que no pertenece al grafo");
		}

		// Busco los indices de la lista arcos, donde hay arcos con el nodo eliminado//
		if (encontreNodo) {
			for (Arco arco : arcos) {
				if (arco.getOrigen() == node || arco.getDestino() == node) {
					lista_index.addLast(indice);
				}
				indice++;
			}
			// Elimino por primera vez un arco//
			puntero = lista_index.removeLast();
			arcos.remove(puntero);
			
			// Elimino los arcos restantes//
			while (!lista_index.isEmpty()) {
				indice = lista_index.removeLast();
				arcos.remove(indice);
			}
		}

	}

	public void removeEdge(int node1, int node2) {
		boolean encontre = false;
		for (Arco buscar : arcos) {
			if (buscar.getOrigen() == node1 && buscar.getDestino() == node2) {
				encontre = true;
				arcos.remove(buscar);
				logger.info("El arco de " + node1 + " a " + node2 + " ha sido eliminado");
				break;
			}
		}
		if (!encontre) {
			logger.warning(
					"No se puede eliminar el arco de " + node1 + " a " + node2 + " ya que no pertenece al grafo");
		}
	}

	private boolean estaNodo(int node) {
		boolean esta = false;
		for (int buscar : nodos) {
			if (buscar == node) {
				esta = true;
				break;
			}
		}
		return esta;
	}

	private boolean estaArco(int node1, int node2) {
		boolean esta = false;
		for (Arco buscar : arcos) {
			if (buscar.getOrigen() == node1 && buscar.getDestino() == node2) {
				esta = true;
				break;
			}

		}
		return esta;
	}
}
