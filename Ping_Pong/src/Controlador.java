
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heatscar
 */

class Controlador extends JPanel implements Runnable, KeyListener {
	private double xbol;
	private double ybol;
	private double xp1;
	private double yp1;
	private double xp2;
	private double yp2;
	private double speed = 6.0;
	private double vel = 5.0;
	private int player1 = 1;
	private int player2 = 1;
	private int bolitaX = 1;
	private int bolitaY = 1;
	private int countP1 = 0;
	private int countP2 = 0;
	private int vidasP1 = 5;
	private int vidasP2 = 5;

	protected Controlador() {
		super();
		this.xbol = 30;
		this.ybol = 0;
		this.xp1 = 565;
		this.yp1 = 180;
		this.xp2 = 10;
		this.yp2 = 180;
	}

	public void paint(Graphics gr) {
		super.paint(gr);
		Graphics2D g = (Graphics2D)gr;
		g.setColor(Color.gray);
		g.fill(new Ellipse2D.Double(this.xbol, this.ybol, 20, 20));
		g.setColor(Color.black);
		g.fill(new Rectangle2D.Double(this.xp1, this.yp1, 15, 60));
		g.setColor(Color.black);
		g.fill(new Rectangle2D.Double(this.xp2, this.yp2, 15, 60));
		return;
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();

		switch (c) {
			case KeyEvent.VK_DOWN:
				this.player1 = 0;
				break;
			case KeyEvent.VK_UP:
				this.player1 = 1;
				break;
			case KeyEvent.VK_Z:
				this.player2 = 0;
				break;
			case KeyEvent.VK_A:
				this.player2 = 1;
				break;
		}

		super.repaint();
		return;
	}

	public void keyReleased(KeyEvent e) {
		return;
	}

	public void keyTyped(KeyEvent e) {
		return;
	}

	public void run() {

		while (true) {
			if (player1 == 0) {
				this.yp1 += this.speed;
				if (this.yp1 > 315) {
					this.yp1 = 315;
				}
			}
			if (player1 == 1) {
				this.yp1 -= this.speed;
				if (this.yp1 < 0) {
					this.yp1 = 0;
				}
			}

			if (player2 == 0) {
				this.yp2 += this.speed;
				if (this.yp2 > 315) {
					this.yp2 = 315;
				}
			}
			if (player2 == 1) {
				this.yp2 -= this.speed;
				if (this.yp2 < 0) {
					this.yp2 = 0;
				}
			}

			if (bolitaX == 0) {
				this.xbol -= this.vel;
				if (this.xbol < 0) {
					this.bolitaX = 1;
					this.xbol = 100; //
					System.out.print("Player1 > Vidas restantes: ");
					this.vidasP2 -= 1;
					System.out.println(this.vidasP2);
				}
			}
			if (bolitaX == 1) {
				this.xbol += this.vel;
				if (this.xbol > 570) {
					this.bolitaX = 0;
					this.xbol = 360; //
					System.out.print("Player2 > Vidas restantes: ");
					this.vidasP1 -= 1;
					System.out.println(this.vidasP1);
				}
			}
			if (bolitaY == 0) {
				this.ybol -= this.vel;
				if (this.ybol < 0) {
					this.bolitaY = 1;
				}
			}
			if (bolitaY == 1) {
				this.ybol += this.vel;
				if (this.ybol > 350) {
					this.bolitaY = 0;
				}
			}

			if(this.vidasP1 < 0) {
				System.out.println("Ganador del juego >> Player1");
				System.exit(1);
			}

			if(this.vidasP2 < 0) {
				System.out.println("Ganador del juego >> Player2");
				System.exit(1);
			}

			try {
				Thread.sleep((int)Math.round(30));
			} catch (Exception e) {}

			double check1 = this.yp1-15;
			while (check1 <= this.yp1+60) {
				if (this.xp1 == this.xbol+20 && check1 == this.ybol) {
					System.out.print("Player2 > Puntos: ");
					this.countP1 += 1;
					System.out.println(this.countP1);
					if (player1 == 0) {
						this.bolitaX = 0;
						this.bolitaY = 1;
					}
					if (player1 == 1) {
						this.bolitaX = 0;
						this.bolitaY = 0;
					}
				}
				check1 += 1.0;
			}

			double check2 = this.yp2-15;
			while (check2 <= this.yp2+60) {
				if (this.xp2+15 == this.xbol && check2 == this.ybol) {
					System.out.print("Player1 > Puntos: ");
					this.countP2 += 1;
					System.out.println(this.countP2);
					if (player2 == 0) {
						this.bolitaX = 1;
						this.bolitaY = 1;
					}
					if (player2 == 1) {
						this.bolitaX = 1;
						this.bolitaY = 0;
					}
				}
				check2 += 1.0;
			}

			super.repaint();
		}
	}
}