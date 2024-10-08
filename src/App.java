import processing.core.PApplet;

public class App extends PApplet {
    boolean alive = true;
    int Level = 0;
    int scene = 1;
    int fLane = 0;
    int sLane = 0;
    int fPointPos = 252;
    int sPointPos = 375;
    int tPointPos = 498;
    int score = 0;
    int obSpeed = 5;
    boolean win = true;
    int color = 0;
    String ifDied = "You Died";
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

        if(scene == 1){
            mainMenu();
        }else if (scene == 2) {
            background(150);
            rect(fLane, Level, 250, 100);
            rect(sLane, Level, 250, 100);
            textSize(30);
            text("score: " + score, 20, 40);
            Level += obSpeed;
            imputManager();
            colisionManager(); 
            delay(10);
            int ranNumF = ranGenSV();
            triangle(fPointPos,400, sPointPos, 300, tPointPos, 400);
            if(Level == 600) {
                score =+1;
                scoreManager();
                Level = 0;
                if (ranNumF == 0) {
                    fLane = 0;
                }else if(ranNumF == 1) {
                    fLane = 250;
                }else if(ranNumF == 2) {
                    fLane = 500;
                }else{
                }
                obGenS(ranNumF);
            }
        }else if (scene == 3) {
            gameOver(alive);
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
            if (key == 'w') {
                scene = 2;
            }
        }
    }

    public void scoreManager() {
        if (score == 20) {
            obSpeed = 12;
        }else if (score == 40) {
            obSpeed = 14;
        }else if (score == 60) {
            obSpeed = 16;
        }else if (score == 80) {
            obSpeed = 18;
        }else if (score == 100) {
            gameOver(true);
        }
    }
    public void blockManager() {

    }

    public void colisionManager() {
        if (sPointPos - 125 == fLane || sPointPos - 125 == sLane && Level > 300 && Level < 400 ) {
            gameOver(false);
        }
    }

    public void mainMenu() {
        
            background(0, 150, 0);
            ellipse(375, 400, 100, 100);
            triangle(355, 425, 355, 375, 400, 400);
            textSize(100);
            text("Lane Dash", 165, 200);
            imputManager();
            textSize(50);
            text("Press the spacebar to begen", 95, 300);
        }
    public void obGenS(int fGenPos) {
        int ranNumS = ranGenSV();
        if (fGenPos == 0) {
            if (ranNumS == 0) {
                sLane = 250;
            }else{
                sLane = 500;
            }
        }else if(fGenPos == 250) {
            if (ranNumS == 0) {
                sLane = 0;
            }else{
                sLane = 500;
            }
        }else if(fGenPos == 500) {
            if (ranNumS == 0) {
                sLane = 0;
            }else{
                sLane = 250;
            }
        }
    }

    public int ranGenTV() {
        return (int) random(0,1);
    }
    public int ranGenSV() {
        return (int) random(0,2);
    }
    public void gameOver(boolean win) {
        if (win == true) {
            ifDied = "You Win!!";
            scene = 1;
        }else{
            ifDied = "You Died";
        }
        color =+ 1;
        background(0, color, 0);
        textSize(100);
        text(ifDied, 165, 200);
        imputManager();
    }
}