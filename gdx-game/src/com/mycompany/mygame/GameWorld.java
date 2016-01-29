package com.mycompany.mygame;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;

public class GameWorld
{
	public Assets assets;
	Rectangle rect = new Rectangle(0,0,20,30);
	public block paddle;
	public Ball ball;
	public Rectangle lwall;
	public Rectangle rwall;
	public Rectangle twall;
	public Rectangle bwall;
	public List<Box> boxes = new ArrayList<Box>();
	public GameWorld(){
		assets = new Assets();
		paddle = new block(assets);
		ball = new Ball(assets, this);
		//paddle.setPosition(Gdx.graphics.getWidth(), 30);
		ball.setPosition(new Vector2(paddle.getPosition().x, paddle.getPosition().y + paddle.getHeight()/2 + ball.getHeight()/2));
		rwall = new Rectangle(0, 0, 100, 16000);
		lwall = new Rectangle(0, 0, 100, 16000);
		twall = new Rectangle(0, 0, 16000, 100);
		genBoxes();
	}
	
	public void update(){
		rect.x++;
        if (rect.x > 180) {
            rect.x = 0;
        }
	}
	
	public Rectangle getRect(){
		return rect;
	}
	void genBoxes(){
		for(int i = 0; i < 10; i++){
			boxes.add(new Box(assets, this));
		}
	}
	public void arrangeBoxes(OrthographicCamera cam){
		float x = boxes.get(0).getWidth()*1.5f;
		float y = cam.viewportHeight-300;
		for(Box b : boxes){
			b.setPosition(new Vector2(x,y));
			x = x+b.getWidth();
			if(x>4*b.getWidth()){
				x = boxes.get(0).getWidth()*1.5f;
				y=y-b.getHeight();
			}
		}
	}
}
