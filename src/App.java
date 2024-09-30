import processing.core.PApplet;

public class App extends PApplet {
    boolean alive = true;
    int FRect = 0;
    boolean showMainMenu = false;
    int lane = 0;
    int ranNumF = (int) random(0,2);
    int ranNumS = (int) random (0,1);
    int fPos = 0;
    int sPos = 250;
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
            rect(lane, FRect, 250, 100);
            FRect += 1;
            delay(10);
            triangle(X, Y, X, Y, X, Y);
            if(FRect == 600) {
                FRect = 0;
                if (ranNumF == 0) {
                    lane = fPos;
                }else if(ranNumF == 1) {
                    lane = sPos;
                }
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
    }
