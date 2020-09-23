package Proyecto1;

public class Arco {

	protected int origen;
	protected int destino;

	public Arco(int ori, int des) {
		origen = ori;
		destino = des;
	}

	public int getOrigen() {
		return origen;
	}

	public int getDestino() {
		return destino;
	}

	public String toString() {
		return "( " + origen + "," + destino + " )";
	}
}
