package T13;

/**
 * The following java class UWGraph implements the data structure unweighed 
 * Graph. There should be at least 2 ways to instantiate a graph. 1)
 * provide nodes (char[]) and edges (char[][]), and 2) provides nodes (char[])
 * and adjacency matrix (int[][]). This UWGraph provides the a constructor
 * implementing the first way. Your assignment#4 asks you to use the second one.
 * But they are almost the same.
 * 
 * 
 */

public class UWGraph {

	private char[] mVexs; // Vertexes
	private int[][] mMatrix; // Adjacency Matrix

	/**
	 * @param vexs Given Vertexes:
	 * @param edges Given Edges;
	 */
	public UWGraph(char[] vexs, char[][] edges) {

		mVexs = new char[vexs.length];
		for (int i = 0; i < mVexs.length; i++)
			mVexs[i] = vexs[i];

		// convert the given edges to adjacency matrix
		mMatrix = new int[vexs.length][vexs.length];
		for (int i = 0; i < edges.length; i++) {
			int p1 = getPosition(edges[i][0]);
			int p2 = getPosition(edges[i][1]);

			mMatrix[p1][p2] = 1;
		}
	}

	/**
	 * Return the position of current node. 
	 * @param ch  Current Node.
	 * @return Index (position) of current node.
	 */
	private int getPosition(char ch) {
		for (int i = 0; i < mVexs.length; i++)
			if (mVexs[i] == ch)
				return i;
		return -1;
	}

	private int firstVertex(int v) {

		if (v < 0 || v > (mVexs.length - 1))
			return -1;

		for (int i = 0; i < mVexs.length; i++)
			if (mMatrix[v][i] == 1)
				return i;

		return -1;
	}

	private int nextVertex(int v, int w) {
		if (v < 0 || v > (mVexs.length - 1) || w < 0 || w > (mVexs.length - 1))
			return -1;

		for (int i = w + 1; i < mVexs.length; i++) {
			if (mMatrix[v][i] == 1) {
				return i;
			}
		}
		return -1;
	}

	/*-------------------------Recursive DFS Implementation-----------------*/
	public void DFS() {
		boolean[] visited = new boolean[mVexs.length]; //scope of visited is important.

		for (int i = 0; i < mVexs.length; i++){
			visited[i] = false;
		}

		System.out.printf("DFS: ");
		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i])
				DFS(i, visited);
		}
		System.out.println();
	}

	private void DFS(int i, boolean[] visited) {

		visited[i] = true;
		System.out.printf("%c ", mVexs[i]);
		for (int w = firstVertex(i); w >= 0; w = nextVertex(i, w)) {	
			if (!visited[w])
				DFS(w, visited);
		}
	}

	/*--------------------------BFS Implementation------------------------------*/
	public void BFS() {
		int head = 0;
		int rear = 0;
		int[] queue = new int[mVexs.length]; 
		boolean[] visited = new boolean[mVexs.length]; 

		for (int i = 0; i < mVexs.length; i++)
			visited[i] = false;

		System.out.printf("BFS: ");
		for (int i = 0; i < mVexs.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				System.out.printf("%c ", mVexs[i]);
				queue[rear++] = i; 
			}

			while (head != rear) {
				int j = queue[head++];
				for (int k = firstVertex(j); k >= 0; k = nextVertex(j, k)) {
					if (!visited[k]) {
						visited[k] = true;
						System.out.printf("%c ", mVexs[k]);
						queue[rear++] = k;
					}
				}
			}
		}
		System.out.println();
	}

	public void display() {
		System.out.printf("Martix Graph:\n");
		for (int i = 0; i < mVexs.length; i++) {
			for (int j = 0; j < mVexs.length; j++)
				System.out.printf("%d ", mMatrix[i][j]);
			System.out.println();
		}
	}

	/*-----------------------Graph Class Test----------------------------------*/
	public static void main(String[] args) {

		char[] vexs = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		char[][] edges = new char[][] { { 'A', 'B' }, { 'B', 'C' },
				{ 'B', 'E' }, { 'B', 'F' }, { 'C', 'E' }, { 'D', 'C' },
				{ 'E', 'B' }, { 'E', 'D' }, { 'F', 'G' } }; //unweighed, directed;
		
		UWGraph pG = new UWGraph(vexs, edges);

		pG.display();
		pG.DFS();
		pG.BFS();
	}
}
