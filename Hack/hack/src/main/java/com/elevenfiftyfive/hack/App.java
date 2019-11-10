package com.elevenfiftyfive.hack;

import com.elevenfiftyfive.hack.View.GameCli;

/**
 * Hello world!
 *
 */

import com.elevenfiftyfive.hack.model.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    
   
    public App() {
        super();

    }
    public static void main(String[] args) {
        
        ArrayList<String> a = new ArrayList<String>();

        System.out.println(a.get(0));
        GameCli gameCli = new GameCli();
        gameCli.start();
    }


}
