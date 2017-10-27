package BearWithMe;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import BearWithMe.entity.Player;
import BearWithMe.enums.GameState;
import BearWithMe.input.KeyInput;
import BearWithMe.input.MouseInput;
import BearWithMe.libs.Colors;
import BearWithMe.libs.ObjectIds;
import BearWithMe.libs.Reference;
import BearWithMe.objects.Block;
import BearWithMe.screens.Menu;
import BearWithMe.utils.ResourceLoader;
import BearWithMe.utils.Texture;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 7458074837380935751L;

	private static JFrame frame = new JFrame();
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH / 4 * 3;
	public static final String VERSION = "0.2.0";
	public static final String TITLE = "BearWithMe" + VERSION;
	private static Game game = new Game();
	public static GameState state = GameState.MENU;

	private boolean running = false;
	private Thread thread;
	private Render gfx;
	public static Menu menu;
	public static Graphics g;

	private Controller controller = new Controller();
	private Texture texture;

	public static Game getInstance() {
		return game;
	}

	public Controller getController() {
		return controller;
	}

	public void init() {
		ObjectIds.initIds();
		ResourceLoader.loadImages();
		ResourceLoader.loadFonts();
		texture = new Texture();
		menu = new Menu();
		menu.create();
		gfx = new Render();
		MouseInput mouse = new MouseInput();
		this.addMouseListener(mouse);
		this.addMouseMotionListener(mouse);
		int x = 0;
		for(int k = 1; k <= 20; k++){
			Controller.addObject(new Block(x,HEIGHT - 50, ObjectIds.id.get("grass"), texture, texture.blockGrass,32,32));
			x+=32;
		}

		
		
		Controller.addObject(new Player(100,100,ObjectIds.id.get("player"),texture, 30, 70));
		this.addKeyListener(new KeyInput());

	}

	public void tick() {
		if (state == GameState.GAME) {
			controller.tick();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Colors.TAN);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		gfx.renderBackground(g);
		gfx.renderForeground(g);

		g.dispose();
		bs.show();
	}

	@Override
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double numTicks = 60.0;
		double n = 1000000000 / numTicks;
		double delta = 0;
		int frames = 0;
		int ticks = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / n;
			lastTime = currentTime;

			if (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " Ticks, FPS: " + frames);
				ticks = 0;
				frames = 0;
			}
		}
		stop();
	}

	public static void main(String args[]) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image icon = toolkit.getImage(Reference.SPRITE_LOCATION + "Icon.png");
		Image cursor = toolkit.getImage(Reference.SPRITE_LOCATION + "cursor.gif");
		frame.add(game);
		frame.setTitle(TITLE);
		frame.setIconImage(icon);
		frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(), frame.getY()), "cursor"));
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.pack();
		game.start();
	}

	private synchronized void start() {
		if (running) {
			return;
		} else {
			running = true;
			thread = new Thread(this);
			thread.start();
		}

	}

	private synchronized void stop() {
		if (!running) {
			return;
		} else {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.exit(1);
		}
	}

}