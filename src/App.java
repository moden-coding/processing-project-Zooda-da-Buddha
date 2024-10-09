import javax.management.monitor.GaugeMonitor;

import processing.core.PApplet;

public class App extends PApplet {
    boolean alive = true;
    int level = 0;
    int scene = 1;
    int fObstical = 250;
    int sObstical = 250;
    int fPointPos = 252;
    int sPointPos = 375;
    int tPointPos = 498;
    int score = 0;
    int lastScore = 0;
    int obsticalSpeed = 5;
    boolean win = true;
    int color = 0;

    // f before capatial means first
    // s before capatial means second
    // Pos stands for Position

    final int MenuStageI = 1;
    final int GameStageI = 2;
    final int EndStageI = 3;

    String ifDied = "Error";
    public static void main(String[] args) {
        
        PApplet.main("App");

    }
    // settings runs once
    public void settings() {
        size(750,600);
    }
    // setup runs once
    public void setup() {
        scene = 1;
        background(150, 0, 0);
        }
        
    // draw runs continuisly
    
    public void draw() {

        if(scene == MenuStageI){
            menuStage();
        }else if (scene == GameStageI) {
            gameStage();
        }else if (scene == EndStageI) {
            endStage(alive);
        }else{
            background(0, 0, 200);
            textSize(100);
            text("Error", 165, 200);
        }
        
    }
    
    
    public void imputManager() {
        if (scene == 1) {
            if (key == ' ') {
                scene = 2;
            }
        }else if (scene == 2) {
            if (key == 'a') {
                fPointPos = 2;
                sPointPos = 125;
                tPointPos = 248;
            }else if (key == 's') {
                fPointPos = 252;
                sPointPos = 375;
                tPointPos = 498;
            }else if (key == 'd') {
                fPointPos = 502;
                sPointPos = 625;
                tPointPos = 748;
         }
        }else if (scene == 3) {
            if (key == ' ') {
                background(150);
                score = 0;
                scene = 2;
            }
        }
    }

    public void scoreManager() {
        score++;
        lastScore = score;
        if (score == 20) {
            obsticalSpeed = 12;
            lastScore = 20;
        }else if (score == 40) {
            obsticalSpeed = 14;
            lastScore = 40;
        }else if (score == 60) {
            obsticalSpeed = 16;
            lastScore = 60;
        }else if (score == 80) {
            obsticalSpeed = 18;
            lastScore = 80;
        }else if (score == 100) {
            lastScore = 100;
            endStage(true);
        }
    }
    public void gameStage() {
        background(150);
            textSize(30);
            text("score: " + score, 20, 40);
            level += obsticalSpeed;
            rect(fObstical, level, 250, 100);
            rect(sObstical, level, 250, 100);
            imputManager();
            colisionManager(); 
            delay(10);
            int ranNumF = ranGenSV();
            triangle(fPointPos,400, sPointPos, 300, tPointPos, 400);
            if(level == 600) {
                scoreManager();
                level = 0;
                if (ranNumF == 0) {
                    fObstical = 0;
                }else if(ranNumF == 1) {
                    fObstical = 250;
                }else if(ranNumF == 2) {
                    fObstical = 500;
                }else{
                }
                obGenS(ranNumF);
            }
    }

    public void colisionManager() {
        if (sPointPos - 125 == fObstical || sPointPos - 125 == sObstical) {
            if (level <= 400 && level >= 300) {
                scene = 3;
                alive = false;
                endStage(false);
            }
        }
    }

    public void menuStage() {
        
            background(0, 150, 0);
            ellipse(375, 400, 100, 100);
            triangle(355, 425, 355, 375, 400, 400);
            textSize(100);
            text("Lane Dash", 165, 200);
            imputManager();
            textSize(50);
            text("Press the spacebar to begin", 95, 300);
            textSize(25);
            text("Control the character with keys W, S, and D", 155, 520);
        }
    public void obGenS(int fGenPos) {
        int ranNumS = ranGenSV();
        if (fGenPos == 0) {
            if (ranNumS == 0) {
                sObstical = 250;
            }else{
                sObstical = 500;
            }
        }else if(fGenPos == 250) {
            if (ranNumS == 0) {
                sObstical = 0;
            }else{
                sObstical = 500;
            }
        }else if(fGenPos == 500) {
            if (ranNumS == 0) {
                sObstical = 0;
            }else{
                sObstical = 250;
            }
        }
    }

    public int ranGenTV() {
        return (int) random(0,1);
    }
    public int ranGenSV() {
        return (int) random(0,2);
    }
    public void endStage(boolean win) {
        obsticalSpeed = 5;
        score = 0;
        fObstical = 250;
        sObstical = 250;
        fPointPos = 252;
        sPointPos = 375;
        tPointPos = 498;
        level = 0;
        if (win == true) {
            
            ifDied = "You Win!";
            color = 125;
        }else if (win == false) {
            ifDied = "You Died";
            color = 0;
        }
        background(0, color, 0);
        textSize(100);
        text(ifDied, 185, 200);
        textSize(50);
        text("Your score was: " + lastScore, 190, 300);
        textSize(25);
        text("Press spacebar to continue", 225, 370);
        ellipse(375, 440, 100, 100);
        triangle(355, 465, 355, 415, 400, 440);
        imputManager();
    }
}