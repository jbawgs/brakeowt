package com.mycompany.mygame;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.*;
import java.util.*;
public class GameRenderer
{
	GameWorld world;
	OrthographicCamera cam;
	ShapeRenderer shapeRenderer;
	float camWidth = Gdx.graphics.getWidth()*3f;
	float camHeight = Gdx.graphics.getHeight()*3f;
	SpriteBatch batch;
	List<Box> removed = new ArrayList<Box>();
	public GameRenderer(GameWorld world){
		this.world=world;
		cam = new OrthographicCamera();
		
		cam.setToOrtho(false, camWidth, camHeight);
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		positionObjectsToCam();
	}
	
	public void update(){
		checkIfAlive();
		Vector3 touch = cam.unproject( new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		world.paddle.setPosition(
	      new Vector2(touch.x, world.paddle.getPosition().y)
		);
		updateBoxes();
		world.ball.update(Gdx.graphics.getDeltaTime());
		
		batch.begin();
		world.paddle.draw(batch);
		world.ball.draw(batch);
		for(Box b : world.boxes){
			b.draw(batch);
		}
		batch.end();
		renderShape();
	}
	
	
	
	void updateBoxes(){
		for(Box b : world.boxes){
			b.update(Gdx.graphics.getDeltaTime());
			if(b.strength <= 0){
				b.setPosition(new Vector2(-1000, -1000));
				b.strength=b.maxStr;
				if(!removed.contains(b)){
					removed.add(b);
				}
				
			}
			if(removed.size()==world.boxes.size()){
				removed.clear();
				positionObjectsToCam();
			}
		}
	}
	
	void positionObjectsToCam(){
		world.rwall.setPosition(cam.viewportWidth, 0);
		world.lwall.setPosition(0-world.lwall.getWidth(),0);
		world.twall.setPosition(0, cam.viewportHeight);
		world.paddle.setPosition(new Vector2(cam.viewportWidth/2, 200));
		world.ball.setPosition(cam.viewportWidth/2, 150);
		world.arrangeBoxes(cam);
	}
	
	void checkIfAlive(){
		if(world.ball.dead==true){
			//Gdx.app.exit();
			world.ball.txt = "died";
			world.ball.setPosition(cam.viewportWidth/2, 150);
			world.ball.direction=new Vector2(0,1);
			world.ball.dead=false;
		}
	}
	public void renderShape(){
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(1f, 0f, 0f, .1f);
		//shapeRenderer.circle(world.ball.circ.x, world.ball.circ.y, world.ball.circ.radius);
		//shapeRenderer.rect(world.paddle.rect.x, world.paddle.rect.y, world.paddle.rect.width, world.paddle.rect.height);
		//shapeRenderer.rect(world.lwall.x, world.lwall.y, world.lwall.width, world.lwall.height);
		//shapeRenderer.rect(world.rwall.x, world.rwall.y, world.rwall.width, world.rwall.height);
		//shapeRenderer.rect(world.twall.x, world.twall.y, world.twall.width, world.twall.height);
		//shapeRenderer.setColor(0f,0f,1f, 1f);
		//shapeRenderer.circle(world.paddle.center.x, world.paddle.center.y, 50);
		for(Box b : world.boxes){
			//shapeRenderer.rect(b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		shapeRenderer.end();
	}
}
