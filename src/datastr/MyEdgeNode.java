package datastr;

public class MyEdgeNode {
	private int indexOfVertice;
	private float weight;
	private MyEdgeNode next;
	
	public int getIndexOfVertice() {
		return indexOfVertice;
	}
	public void setIndexOfVertice(int indexOfVertice) {
		if (indexOfVertice >= 0) {
			this.indexOfVertice = indexOfVertice;
		} else {
			this.indexOfVertice = -1;
		}
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		if (weight > 0 && weight < 43000) {
			this.weight = weight;
		} else {
			this.weight = 0;
		}
	}
	public MyEdgeNode getNext() {
		return next;
	}
	public void setNext(MyEdgeNode next) {
		this.next = next;
	}
	
	public MyEdgeNode(int indexOfVertice, float weight) {
		setIndexOfVertice(indexOfVertice);
		setWeight(weight);
	}
	
	public String toString() {
		return "" + weight;
	}
}
