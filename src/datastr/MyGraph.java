package datastr;

public class MyGraph<T> {
	private MyVerticeNode[] graphElements;
	private final int DEFAULT_ARRAY_SIZE = 10;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyGraph() {
		graphElements = new MyVerticeNode[arraySize];
	}
	public MyGraph(int inputArraySize) {
		if (inputArraySize > 0) {
			arraySize = inputArraySize;
		}
		graphElements = new MyVerticeNode[arraySize];
	}
	
	public boolean isFull() {
		return (elementCounter >= arraySize);
	}
	public boolean isEmpty() {
		return (elementCounter == 0);
	}
	public int howManyElements() {
		return elementCounter;
	}
	public void increaseArray() {
		int newArraySize = (arraySize > 100)? (int)(arraySize *1.5) : arraySize * 2;
		MyVerticeNode[] newElements = new MyVerticeNode[newArraySize];
		
		for (int i = 0; i < elementCounter; i++) {
			newElements[i] = graphElements[i];
		}
		graphElements = newElements;
		arraySize = newArraySize;
	}
	
	public void addVertice(T inputElement) throws Exception {
		if (inputElement == null) {
			throw (new Exception("Not real vertice"));
		}
		
		for (int i = 0; i < elementCounter; i++) {
			if (inputElement == graphElements[i].getElement()) {
				throw (new Exception("Vertice is already in graph"));
			}
		}
		
		graphElements[elementCounter++] = new MyVerticeNode<T>(inputElement);
	}
	
	public void addEdge(T elementFrom, T elementTo, float edgeWeight) throws Exception {
		if (elementFrom == null || elementTo == null || edgeWeight <= 0) {
			throw (new Exception("Incorrect arguments"));
		}
		
		int indexOfElementFrom = searchVertice(elementFrom);
		int indexOfElementTo = searchVertice(elementTo);
		
		if (indexOfElementFrom < 0 || indexOfElementTo < 0) {
			throw (new Exception("One or both vertices are not in Graph"));
		}
		if (graphElements[indexOfElementFrom].getFirstEdge() == null) {
			MyEdgeNode newNode = new MyEdgeNode(indexOfElementTo, edgeWeight);
			if (graphElements[indexOfElementFrom].getFirstEdge() == null) {
				graphElements[indexOfElementFrom].setFirstEdge(newNode);
			}
			else {
				MyEdgeNode temp = graphElements[indexOfElementFrom].getFirstEdge();
				
				while (temp.getNext() != null) {
					temp = temp.getNext();
				}
				temp.setNext(newNode);
			}
		}
	}
	
	private int searchVertice(T inputElement) {
		for (int i = 0; i < elementCounter; i++) {
			if (inputElement.equals(graphElements[i].getElement())) {
				return i;
			}
		}
		return -1;
	}
}
