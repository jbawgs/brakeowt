package com.mycompany.mygame;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.utils.viewport.*;
import com.badlogic.gdx.math.*;
import com.badlogic.gdx.utils.*;

public class MyGdxGame extends Game
{
	GameWorld world;
	GameRenderer renderer; 
	MenuScreen menu;
	Assets assets;
	
    @Override
	public void create()
	{
		world = new GameWorld();
		renderer = new GameRenderer(world);
		assets = new Assets();
		//menu = new MenuScreen(this, assets);
		//setScreen(menu);
		
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		world.update();
		renderer.update();
		//getScreen().render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
	
}
