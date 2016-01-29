package com.mycompany.mygame;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.graphics.*;

public class Assets extends AssetManager
{
	public Texture box;
	public Texture orange;
	public Texture blue;
	public Texture red;
	public Texture green;
	public Texture logo;
	public Texture playbutton;
	public Texture vibrantd;
	public Texture ball;
	public Texture hwall;
	public Texture vwall;
	public Assets(){
		super();
		this.load("paddle.png", Texture.class);
		this.load("redblock.png", Texture.class);
		this.load("greenblock.png", Texture.class);
		this.load("blueblock.png", Texture.class);
		this.load("orangeblock.png", Texture.class);
		this.load("ball.png", Texture.class);
		this.load("logo.png", Texture.class);
		this.load("playbutton.png", Texture.class);
		this.load("vibrantd.png", Texture.class);
		//this.load("horizontalwall.png", Texture.class);
		//this.load("verticalwall.png", Texture.class);
		this.finishLoading();
		
		assign();
	}
	
	void assign(){
		box = this.get("paddle.png", Texture.class);
		logo = this.get("logo.png", Texture.class);
		playbutton = this.get("playbutton.png", Texture.class);
		vibrantd=this.get("vibrantd.png", Texture.class);
		ball = this.get("ball.png", Texture.class);
		red = this.get("redblock.png", Texture.class);
		green = this.get("greenblock.png", Texture.class);
		blue = this.get("blueblock.png", Texture.class);
	    orange = this.get("orangeblock.png", Texture.class);
		//hwall=this.get("horizontalwall.png", Texture.class);
		//vwall=this.get("verticalwall.png", Texture.class);
	}
}
