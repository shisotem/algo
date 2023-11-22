class Main1_AdjacencyMatrix {
  public static void main(String args[]) {
      GraphMatrixWeight g = new GraphMatrixWeight(4);
  
      g.addEdge(0, 1, 2);
      g.addEdge(0, 2, 3);
      g.addEdge(1, 2, 2);
      g.addEdge(2, 3, 2);
      g.addEdge(3, 1, 5);
      g.printG();
    }
}
