package T12;

public interface BSTInterface<T> {
	
	void insert(T toInsert);
	
	boolean search(T toSearch);
	
	void delete(T toDelete);
	
	/*---------------------------*/
	void DFS_PreOrder_Display();
	void DFS_InOrder_Display();
	void DFS_PostOrder_Display();
	void BFS_LevelOder_Display();
	
	
}
