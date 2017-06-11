import java.util.Date;

public class ScoreEntry {
	private String name;
	private int score = 0;
	private Date date;
	
	public ScoreEntry(String n, int s, Date d) {
		name = n;
		score = s;
		date = d;
	}
	
	//returns name of player
	public String getName() {
		return name;
	}
	
	//returns score of player
	public int getScore() {
		return score;
	}
	
	//returns date of when score was recorded
	public Date getDate() {
		return date;
	}
	
	
	public String toString() {
		return "(" + name + " " + score + " " + date + ")";
	}
	
	
}