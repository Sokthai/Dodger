import java.util.Date;

public class Scoreboard {
	private int numOfEntries = 0;
	private ScoreEntry[] board; //ScoreEntry objects to hold name score and date
	
	public Scoreboard(int cap) {
		board = new ScoreEntry[cap];
	}
	
	//adding an entry
	public void addEntry(ScoreEntry e) {
		
		int newScore = e.getScore();
		//if scoreboard is not at capacity and if score qualifies
		if(numOfEntries < board.length || newScore > board[numOfEntries - 1].getScore()) {
			if(numOfEntries < board.length)		//no score drops from board
				numOfEntries++;		
			
			//shift lower scores rightward 
			int j = numOfEntries - 1;
			while(j > 0 && board[j - 1].getScore() < newScore) {
				board[j] = board[j - 1];
				j--;
			}
			board[j] = e;
		}
	}
	
	//removing an entry
	public ScoreEntry removeEntry(int index) {
		//check if index is vali
		if(index < 0 || index > numOfEntries)
			throw new IndexOutOfBoundsException("Invalid index:"  + index);
		
		ScoreEntry temp = board[index];
		
		//shifts entries up one
		for(int j = index; j < numOfEntries - 1; j++) {
			board[j] = board[j + 1];
		}
		
		//nulls out old last entry
		board[numOfEntries - 1] = null;
		numOfEntries--;	
		
		return temp;
	}
	
	
	//clear all entries
	public void clearEntries() {
		//checks if there are entries 
		while(numOfEntries > 0) {
			for(int i = 0; i < numOfEntries - 1; i++) 
				board[i] = null; //removes entries at each index
			numOfEntries = 0;
		}
	}
	
	//returns the entry of a certain index
	public ScoreEntry getEntry(int index) {
		return board[index];
	}
	
	
	//get size of entries
	public int getSize() {
		return numOfEntries;
	}
	
	
}
