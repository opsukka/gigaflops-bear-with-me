import java.awt.*;

public class Game extends Canvas implements Runnable {
	private boolean running = false;
	
	public void init() {
		
	}
	
	public void render() {
		
	}
	
	public void tick() {
		
	}
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0; 
		long timer = System.currentTimeMillis();
		
		while(running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;
			
			if(delta >= 1) {
				tick();
				ticks++;
				delta--;
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				System.out.println("hehexd");
				ticks = 0;
				frames = 0;
			}
		}
	}
}

