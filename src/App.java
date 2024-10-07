import processing.core.PApplet;

public class App extends PApplet {
    boolean alive = true;
    int Level = 0;
    boolean showMainMenu = false;
    int fLane = 0;
    int sLane = 0;
    int fPointPos = 252;
    int sPointPos = 375;
    int tPointPos = 498;
    public static void main(String[] args) {
        
        PApplet.main("App");

    }
    // settings runs once
    public void settings() {
        size(750,600);
    }
    // setup runs once
    public void setup() {
        showMainMenu = true;
        // while (showMainMenu == true) {
        //     mainMenu();
        // }
        background(150, 0, 0);
        }
        
    // draw runs continuisly
    
    public void draw() {

        if(showMainMenu){
            mainMenu();
        }else{
            background(150);
            rect(fLane, Level, 250, 100);
            rect(sLane, Level, 250, 100);
            Level += 2;
            delay(1);
            int ranNumF = ranGenSV();
            triangle(fPointPos,400, sPointPos, 300, tPointPos, 400);
            if (key == 'a') {
                fPointPos = 2;
                sPointPos = 125;
                tPointPos = 248;
            }
            if (key == 's') {
                fPointPos = 252;
                sPointPos = 375;
                tPointPos = 498;
            }
            if (key == 'd') {
                fPointPos = 502;
                sPointPos = 625;
                tPointPos = 748;
            }
            if(Level == 600) {
                Level = 0;
                if (ranNumF == 0) {
                    fLane = 0;
                }else if(ranNumF == 1) {
                    fLane = 250;
                }else if(ranNumF == 2) {
                    fLane = 500;
                }else{
                    mainMenu();
                }
                obGenS(ranNumF);
            }
        }
        
    }
    
    
    public void keyPressed() {}

    public void mainMenu() {
        
            background(0, 150, 0);
            ellipse(375, 400, 100, 100);
            triangle(355, 425, 355, 375, 400, 400);
            textSize(100);
            text("Lane Dash", 165, 200);
        if (key == ' ') {
            showMainMenu = false;
            
        }
        }
    public void obGenS (int fGenPos) {
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
}