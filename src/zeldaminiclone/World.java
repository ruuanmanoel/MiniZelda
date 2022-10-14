package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class World {
	
	public static ArrayList<Blocks> blocos = new ArrayList<Blocks>();
	
	public World() {
		for(int xx = 0; xx<15*2;xx++) {
			blocos.add(new Blocks(xx*32,0));
			blocos.add(new Blocks(xx*32,448));
		}
		for(int xy = 1; xy<15*2;xy++) {
			blocos.add(new Blocks(0,xy*32));
			blocos.add(new Blocks(640-32,xy*32));
		}
	}
	
	public static boolean isFree(int x,int y) {
		for(int i=0; i<blocos.size(); i++) {
			Blocks blocoAtual = blocos.get(i); 
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))) {
				return false;
			}
		}
		return true;
	}
	
	
	public void render(Graphics g) {
		for(int i =0; i<blocos.size();i++) {
			blocos.get(i).render(g);
		}
	}
}
