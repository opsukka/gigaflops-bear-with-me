package BearWithMe.rendering.ui;

import BearWithMe.rendering.textures.Texture;

public class SplashScreenDriver {
    
    private SplashScreen screen;
    
    public SplashScreenDriver() {
        screen = new SplashScreen(new Texture("splash"));
        screen.setLocationRelativeTo(null);
        screen.setMaxProgress(1000);
        screen.setVisible(true);
        
        for(int i = 0; i <= 1000; i++){
            for(int j = 0; j <= 50000; j++){
                String t = "ewf" + (i + j);
            }
            screen.setProgress(i);
        }
        
        screen.setVisible(false);
    }
    
}
