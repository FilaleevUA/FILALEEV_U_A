package ru.vsuet.Task37;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> eliminatedPlayers = new ArrayList<Integer>();
        int numPlayers, startingPlayer;

        System.out.print("Enter the number of players: ");
        numPlayers = input.nextInt();

        System.out.print("Enter the number of the player the game starts with: ");
        startingPlayer = input.nextInt();

        for(int i=1; i<=numPlayers; i++) {
            players.add(i);
        }
        int winner = players.get(0);
        int currentEliminatedPlayers = 0;
        int currentPlayerIndex = startingPlayer - 1;
        while(players.size() >= 1) {
            currentPlayerIndex = (currentPlayerIndex + 2) % players.size();
            currentEliminatedPlayers = players.get(currentPlayerIndex);
            eliminatedPlayers.add(players.remove(currentPlayerIndex));
            System.out.println(players + " => " + currentEliminatedPlayers + " is counted out and goes into the result " + eliminatedPlayers);
            if (players.size() == 1) {
                winner = players.get(0);
            }
        }

        System.out.println("Winner: Player #" + winner);
    }
}
