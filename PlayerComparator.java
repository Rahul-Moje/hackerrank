import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PlayerComparator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }

	}

}
class Player {
	
	int score;
	String name;
	
	public Player(String name,int score) {
		this.score = score;
		this.name = name;
	}
	
}
class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
        int score1 = a.score;
        int score2 = b.score;
        String name1 = a.name;
        String name2 = b.name;
        if(b.score > a.score)
            return 1;
        else if(b.score < a.score)
            return -1;
        else
            return name1.compareTo(name2);
        
    }
}