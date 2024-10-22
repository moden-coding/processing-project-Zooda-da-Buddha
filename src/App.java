import javax.management.monitor.GaugeMonitor;

import processing.core.PApplet;

public class App extends PApplet {
    boolean alive = true;
    boolean lastPOS = false;
    boolean spacePressed = true;
    boolean inTheMiddle = true;
    boolean inTheLeft = false;
    boolean inTheRight = false;
    char lastKey = ' ';
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
    int randTimr = 0;
    int RanGenTV = 0;
    int RanGenSV = 0;
    int fPRErANnUM = 0;
    int sPRErANnUM = 2;
    int retNum = 0;
    // f before capatial means first
    // s before capatial means second
    // Pos stands for Position

    final int MENUsTAGE = 1;
    final int GAMEsTAGE = 2;
    final int ENDsTAGE = 3;

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

        if(scene == MENUsTAGE){
            menuStage();
        }else if (scene == GAMEsTAGE) {
            gameStage();
            if (fPointPos < 2 && sPointPos < 125 && tPointPos < 248) {
                fPointPos = 2;
                sPointPos = 125;
                tPointPos = 248;
            }else if (fPointPos > 502 && sPointPos > 625 && tPointPos > 748) {
                fPointPos = 502;
                sPointPos = 625;
                tPointPos = 748;
            }
        }else if (scene == ENDsTAGE) {
            endStage(alive);
        }else{
            background(0, 0, 200);
            textSize(100);
            text("Error", 165, 200);
        }
        
    }
    
    
    public void imputManager() {
        if (scene == MENUsTAGE) {
            if (key == ' ') {
                scene = GAMEsTAGE;
            }
        }else if (scene == GAMEsTAGE) {
            if (key == 'a' && inTheMiddle == true) {
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
        }else if (scene == ENDsTAGE) {
            if (key == ' ') {
                background(150);
                score = 0;
                scene = GAMEsTAGE;
            }
            if (lastKey != 'l') {
                lastKey = key;
            }
            if (scene == GAMEsTAGE && score > 0) {
                lastKey = key;
            }
        }
    }

    public void scoreManager() {
        score++;
        lastScore = score;
        lastKey = key;
        if (score == 20) {
            obsticalSpeed = 6;
            lastScore = 20;
        }else if (score == 40) {
            obsticalSpeed = 7;
            lastScore = 40;
        }else if (score == 60) {
            obsticalSpeed = 8;
            lastScore = 60;
        }else if (score == 80) {
            obsticalSpeed = 9;
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
            if(level >= 600) {
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
                randTimr = 0;
            }
        }
    }

    public void menuStage() {
            randTimr++;
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

    public int PreRanNumGen() {
        return (int) random(0, 999);
    }

    public int ranGenTV() {
        fPRErANnUM = PreRanNumGen();
        sPRErANnUM = PreRanNumGen();
        if (fPRErANnUM < 500) {
            retNum = 0;
        }else{
            retNum = 1;
        }
        retNum += sPRErANnUM; 
        return (int) retNum;
    }
    public int ranGenSV() {
        fPRErANnUM = PreRanNumGen();
        sPRErANnUM = PreRanNumGen();
        if (fPRErANnUM < 333 && sPRErANnUM % 2 == 0) {
            retNum = 0;
        }else if (fPRErANnUM > 333 && fPRErANnUM < 666 && sPRErANnUM % 2 == 0) {
            retNum = 1;
        }else if (fPRErANnUM > 666 && sPRErANnUM % 2 == 0) {
            retNum = 2;
        }else if (fPRErANnUM < 333 && sPRErANnUM % 2 != 0) {
            retNum = 2;
        }else if (fPRErANnUM < 333 && sPRErANnUM % 2 != 0) {
            retNum = 0;
        }
        retNum += sPRErANnUM + randTimr;
        retNum %= 3;
        return (int) retNum;
    }
    public void endStage(boolean win) {
        if (lastKey == ' ' && score == 0) {
            key = 'g';
        }
        obsticalSpeed = 5;
        score = 0;
        fObstical = 250;
        sObstical = 250;
        fPointPos = 252;
        sPointPos = 375;
        tPointPos = 498;
        level = 0;
        randTimr = 0;
        if (win == true) {
            
            ifDied = "You Win!";
            color = 125;
        }else if (win == false) {
            ifDied = "You Died";
            color = 0;
        }
        color++;
        randTimr++;
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