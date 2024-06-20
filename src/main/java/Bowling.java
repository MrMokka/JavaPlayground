import java.util.*;

class ScoreFrame {
    int[] throwValues;
    int currentThrow = 0;
    public int totalScore = -1;
    public String scoreModifier = "";
    ScoreFrame previousFrame;
    public ScoreFrame(int totalThrows, ScoreFrame previousFrame) {
        throwValues = new int[totalThrows];
        this.previousFrame = previousFrame;
    }
    
    public void score(int value) {
        throwValues[currentThrow] = value;
        totalScore = totalScore == -1 ? value : totalScore + value;
        if(previousFrame != null) calculateScore();
    }
    
    public void calculateScore() {
        totalScore = previousFrame.totalScore + totalScore;
    }
    
    @Override
    public String toString() {
        String s = throwValues.length == 3 ? "" : "   ";
        for(int i = 0; i < throwValues.length; i++) {
            s += Util.padString("" + throwValues[i], 2);
            if(i != throwValues.length - 1) s += "|";
        }
        s += " - " + Util.padString(totalScore >= 0 ? "" + totalScore : "_", 3);
        return s;
    }
}

public class Bowling {
    
    int rounds = 3;
    int players = 2;
    int pins = 10;
    Scanner scanner = new Scanner(System.in);
    ArrayList<ArrayList<ScoreFrame>> scores = new ArrayList<>();
    
    int playerTurn = 1;
    int currentRound = 0;
    
    public Bowling() {
        ScoreFrame previousFrame = null;
        for(int p = 0; p < players; p++) {
            scores.add(new ArrayList<>());
            for(int i = 0; i < rounds; i++){
                if(i == rounds - 1)
                    previousFrame = new ScoreFrame(3, previousFrame);
                else
                    previousFrame = new ScoreFrame(2, previousFrame);
                scores.get(p).add(previousFrame);
            }
        }
        
        
        runGame();
    }
    
    public void runGame() {
        while(currentRound <= rounds){
            currentRound++;
            for(int p = 0; p < players; p++) {
                playerTurn = p + 1;
                System.out.println();
                System.out.println("Player turn: " + playerTurn);
                int totalThrows = 0;
                pins = 10;
                
                while(totalThrows < (currentRound == rounds ? 3 : 2)) {
                    System.out.println("Pins remaining: " + pins);
                    System.out.println("How many pins did you hit?");
                    int pinsHit = scanner.nextInt();
                    scores.get(p).get(currentRound - 1).score(pinsHit);
                    totalThrows++;
                    pins = pins - pinsHit;
                    if(pins <= 0) break;
                }
                System.out.println("Score so far:");
                printScores();
            }
            
            
        }
    }
    
    private void printScores() {
        for(int i = 0; i < rounds; i++) {
            StringBuilder line = new StringBuilder();
            for(int p = 0; p < players; p++) {
                line.append(scores.get(p).get(i).toString());
                if(p != players - 1) line.append(" --- ");
            }
            System.out.println(line);
        }
        
        
    }
    
    
    
}

class Util {
    public static String padString(String string, int length) {
        return String.format("%1$" + length + "s", string);
    }
}
