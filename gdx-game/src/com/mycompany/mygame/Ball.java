package com.mycompany.mygame;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;

public class Ball extends Sprite
{
	public Circle circ;
	public Vector2 position;
	public Vector2 direction;
	public float speed = 2000f;
	public String txt;
	public BitmapFont font;
	public SpriteBatch batch;
	public float s = 1f;
	public boolean dead = false;
	GameWorld world;
	public Ball(Assets assets, GameWorld world){
		super(assets.ball);
		this.setSize(this.getWidth()/2, this.getHeight()/2);
		circ = new Circle(this.getOriginX(), this.getOriginY(), this.getWidth()/2);
		position = Vector2.Zero;
		direction = new Vector2(0f, 1f);
		this.world=world;
		txt = " ";
		font = new BitmapFont();
		batch = new SpriteBatch();
	}
	public Vector2 getPosition(){

		return new Vector2(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
	}

	public void setPosition(Vector2 pos){
		position = pos;
		this.setPosition(pos.x - this.getWidth()/2, pos.y - this.getHeight()/2);
		circ.setPosition(this.getPosition());
	}
	public void update(float dt){
		if(this.getPosition().y<1f){
			dead=true;
		}
		position = this.getPosition();
		txt = "pos = " + position + " dead= " + dead;
		checkWalls();
		drawTxt();
		Vector2 tf = new Vector2((direction.x * speed * dt), direction.y * speed * dt);
		//this.setPosition(tf);
		this.translate(tf.x, tf.y);
		circ.setPosition(this.getPosition());
	}
	 void checkWalls(){
		 if(Intersector.overlaps(circ, world.lwall) || Intersector.overlaps(circ, world.rwall)){
			 direction = new Vector2(direction.x*-1, direction.y);
			 
		 }
		 if(Intersector.overlaps(circ, world.twall)){
			 //this.setPosition(this.getPosition().x, this.getPosition().y-100);
			 direction = new Vector2(direction.x, direction.y*-1);
		 }
		 if(Intersector.overlaps(circ, world.paddle.rect)){
			 float d = ((position.x+(this.getWidth()/2))-world.paddle.position.x);
			 s = Math.signum(d);
			 d = (d/500);
			 direction = new Vector2(d, direction.y*-1);
			 txt = "pos = " + position + "paddlepos= " + world.paddle.position + " s= " + s + " xdir= " + (direction.x * speed)*s;
		 }
		 for(Box b : world.boxes){
			 if(Intersector.overlaps(circ, b.rect)){
				 direction=new Vector2(direction.x, direction.y*-1);
				 b.strength-=1;
				 //txt = b.getColor().toString();
				 //txt = "intersected";
			 }
		 }
	 }
	 void drawTxt(){
		 batch.begin();
		 font.setColor(0,0,0,1);
		 font.setScale(2f);
		 font.draw(batch,txt, 100, 100);
		 batch.end();
	 }
}
