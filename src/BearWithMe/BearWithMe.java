package BearWithMe;

import javax.swing.JFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import BearWithMe.audio.MusicPlayer;
import BearWithMe.rendering.ui.SplashScreenDriver;
import BearWithMe.utils.ThreadPool;

public class BearWithMe {
    
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(2);
        new SplashScreenDriver();
        final Game game = new Game();
        JFrame frame = new JFrame(Game.TITLE);
        frame.add(game);
        frame.setSize(Game.WIDTH, Game.HEIGHT);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.err.println("Exiting Game");
                game.stop();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        MusicPlayer player = new MusicPlayer("musiikki");
        pool.runTask(player);
        pool.runTask(game);
        pool.join();
    }

}
