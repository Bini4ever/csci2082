package poject1;
import java.util.ArrayList;

 /**
 * @author biniam lemma and Ismail Abiola
 *
 */
class IndexArrayList {
	private ArrayList<Integer> list;
	
	/*************************************************************
	 * define a constructor and an instance of the arraylist
	 *************************************************************/
	public IndexArrayList(){
		list = new ArrayList<>();
	}
	
	/*************************************************************
	 * add to the arraylist
	 *************************************************************/
	public void addInt(int newInt){
		if(!searchInt(newInt)){
			list.add(newInt);
		}
	}
	
	/*************************************************************
	 * search the arraylist
	 *************************************************************/
	public boolean searchInt(int target){
		if (list.contains(target)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * to clear the arraylist
	 *************************************************************/
	public void clearList(){
			list.clear();
	}
	
	/*************************************************************
	 * returns the size of the arraylist
	 *************************************************************/
	public int getSize(){
		return list.size();
	}
	
	/*************************************************************
	 * check if the arraylist contains the first row indexes
	 *************************************************************/
	public boolean checkFirstRow(){
		if (list.contains(0) && list.contains(1) && list.contains(2)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the second row indexes
	 *************************************************************/
	public boolean checkSecondRow(){
		if (list.contains(3) && list.contains(4) && list.contains(5)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the third row indexes
	 *************************************************************/
	public boolean checkThirdRow(){
		if (list.contains(6) && list.contains(7) && list.contains(8)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the first column indexes
	 *************************************************************/
	public boolean checkFirstColm(){
		if (list.contains(0) && list.contains(3) && list.contains(6)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the second column indexes
	 *************************************************************/
	public boolean checkSecondColm(){
		if (list.contains(1) && list.contains(4) && list.contains(7)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the third column indexes
	 *************************************************************/
	public boolean checkThirdColm(){
		if (list.contains(2) && list.contains(5) && list.contains(8)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the first diagonal indexes
	 *************************************************************/
	public boolean checkFirstDiagonal(){
		if (list.contains(0) && list.contains(4) && list.contains(8)){
			return true;
		}
		return false;
	}
	
	/*************************************************************
	 * check if the arraylist contains the second diagonal indexes
	 *************************************************************/
	public boolean checkSecondDiagonal(){
		if (list.contains(2) && list.contains(4) && list.contains(6)){
			return true;
		}
		return false;
	}
}
