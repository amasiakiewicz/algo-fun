package sorting.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return score == player.score &&
                name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}

class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
        final int result = 0;

        final int scoreCompare = -Integer.compare(a.score, b.score);
        final int nameCompare = a.name.compareTo(b.name);

        return scoreCompare != 0 ? scoreCompare : nameCompare;
    }
}


public class Solution {

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