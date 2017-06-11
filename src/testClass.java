import java.util.Date;

public class testClass {
	
	
	public static void main(String arg[]) {
		
		ScoreEntry entry1 = new ScoreEntry("Mike", 200, new Date());
		ScoreEntry entry2 = new ScoreEntry("Thai", 199, new Date());
		ScoreEntry entry3 = new ScoreEntry("Bin", 132, new Date());
		Scoreboard score = new Scoreboard(5);
		
		//System.out.printf("Player: %s\n" ,entry.getName());
		//System.out.printf("Score: %s\n" ,entry.getScore());
		//System.out.print(" " + entry.getDate());
		
		
		
		
		score.addEntry(entry1);
		score.addEntry(entry2);
		score.addEntry(entry3);
		score.clearEntries();
		//for(int i = 0; i < 3;  i++) {
			//System.out.printf(i + " score is " + score.getEntry(i).toString() + "\n");
		//}
		
		
		
		
		System.out.printf("Number of entries: %d", score.getSize());
		
		
	}
	
	
}
