package com.elevenfiftyfive.hack.View;

/**
 * Hello world!
 *
 */

import com.elevenfiftyfive.hack.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameCli {

    CarbGame game;
    Scanner scanner;

    public GameCli() {
        super();
        game = new CarbGame();

    }

    public void start() {
        boolean stop = false;

        displayMyShip();
        // do {

        // System.out.println("Option \n myship \n enemy");

        /*
         * switch(input.next()) { case "myship":
         * 
         * 
         * 
         * break;
         * 
         * }
         */

        // stop = input.next() == "stop";

        // } while (!stop);

    }

    public void displayMyShip() {
        String input;

        do {

            System.out.print("\033[H\033[2J");

            game.battle.update();

            System.out.print(game.battle.getPlayer().toString());

            System.out.print("\n");
            System.out.print("\n --------------------- \n");

            scanner = new Scanner(System.in);

            input = scanner.next();

            if (input.equals("task")) {
                task();
            }

        } while (!input.equals("q"));

    }

    public void task() {
        String usingUtil = scanner.next();

        String taskType = scanner.next();
        if (taskType.equals("repair")) {
            game.battle.setRepairTask(usingUtil, scanner.next());
        } else if (taskType.equals("setup")) {
            game.battle.setSetup(usingUtil, scanner.next());
        } else if (taskType.equals("shoot")) {
            game.battle.shoot(usingUtil, scanner.next(), scanner.next());
        }
    }
}