package com.myProject.Quests.questState;

import com.myProject.Driver.Player;
import com.myProject.Quests.Quest;

import java.util.Queue;

public class mazeState implements State {
    private final Queue<String> path;

    public mazeState(Queue<String> path) {
        this.path = path;
    }

    private void printPath() {
        switch (path.element()) {
            case "Up":
                System.out.println("Go Straight (Phone face up)");
                break;
            case "Left":
                System.out.println("Go Left (Phone face left)");
                break;
            case "Right":
                System.out.println("Go Right (Phone face right)");
                break;
            default:
                break;
        }
    }

    @Override
    public void next(Quest quest, Player player, String[] str) throws InterruptedException {
        if(str[0].equals("socket")) {
            if (str[2].equals(path.element())) {
                path.remove();
                if (path.isEmpty()) {
                    player.getLocation().setQuestDone();
                    player.switchConsoleToTerminal();
                } else printPath();
            } else {
                quest.setActive(false);
                System.out.println("You Lost the dwarf :c");
                quest.setState(new defaultState());
                System.out.println("Type [start] to try Again");
                player.switchConsoleToTerminal();
            }
        } else {
            player.switchConsoleToSocket();
            printPath();
        }
        Thread.sleep(2000);
    }

    @Override
    public void printStatus() {
        System.out.println("Follow the dwarf through this maze to catch him!");
        System.out.println("Type [aight] to initiate :)");
    }
}
