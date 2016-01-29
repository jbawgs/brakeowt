package com.mycompany.mygame;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.graphics.*;

public class MenuScreen implements Screen
{
	Sprite logo;
	Sprite playbutton;
	Stage stage;
	public MenuScreen (MyGdxGame game, Assets assets){
		stage = new Stage();
		stage.addActor(new LogoActor(assets));
		stage.addActor(new ButtonActor(assets));
	}

	@Override
	public void render(float p1)
	{
		// TODO: Implement this method
		stage.draw();
	}

	@Override
	public void resize(int p1, int p2)
	{
		// TODO: Implement this method
	}

	@Override
	public void show()
	{
		// TODO: Implement this method
	}

	@Override
	public void hide()
	{
		// TODO: Implement this method
	}

	@Override
	public void pause()
	{
		// TODO: Implement this method
	}

	@Override
	public void resume()
	{
		// TODO: Implement this method
	}

	@Override
	public void dispose()
	{
		// TODO: Implement this method
	}
	
	public class LogoActor extends Actor{
		TextureRegion logo;
		public LogoActor(Assets assets){
			logo = new TextureRegion(assets.logo);
		}
		@Override
		public void draw (Batch batch, float parentAlpha) {
			Color color = getColor();
			batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
			batch.draw(logo, getX(), getY(), getOriginX(), getOriginY(),
					   getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		}
	}
	public class ButtonActor extends Actor{
		TextureRegion playbutton;
		public ButtonActor(Assets assets){
			playbutton = new TextureRegion(assets.playbutton);
		}
		@Override
		public void draw (Batch batch, float parentAlpha) {
			Color color = getColor();
			batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
			batch.draw(playbutton, getX(), getY(), getOriginX(), getOriginY(),
					   getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
		}
	}

}
