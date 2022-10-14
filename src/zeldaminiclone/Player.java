package zeldaminiclone;


import java.awt.Graphics;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Player extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//animalçoes do sprite
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	public boolean shoot = false;
	public int dir = 1;
	//
	public static ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	
	//velocidade e direção
	public int spd = 4;
	public boolean right, up, down, left;
	
	public Player(int x, int y) {
		super(x,y,32,32);
	}
	
	public void tick() {
		boolean moved = false;
		if(right && World.isFree(x+spd, y)) {
			x+=spd;
			dir = 1;
		}else if(up && World.isFree(x, y-spd)) {
			y-=spd;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
			moved = true;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
			dir=-1;
		}
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.playerFront.length) {
					curAnimation =0;
				}
				
			}
			
		}
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x,y,dir));
		}
		for(int i = 0; i<bullets.size();i++) {
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.blue);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.playerFront[curAnimation], x,y,32,32, null);
		for(int i = 0; i<bullets.size();i++) {
			bullets.get(i).render(g);
		}
		
	}
	
}
