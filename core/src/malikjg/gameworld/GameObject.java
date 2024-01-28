package malikjg.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	public float xPosition;
	public float yPosition;
	public int width;
	public int height;
	public Texture image;
	
	public Vector2 position;
	
	public Handler handler;
	public OrthographicCamera camera;
	
	public Rectangle hitbox;
	
	public GameObject(Handler handler) {
		this.handler = handler;
	}
	
	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
	
	public float getXPosition() {
		return xPosition;
	}
	public void setXPosition(float xPosition) {
		this.xPosition = xPosition;
	}
	public float getYPosition() {
		return yPosition;
	}
	public void setYPosition(float yPosition) {
		this.yPosition = yPosition;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Vector2 getPosition() {
		return position;
	}
	public Rectangle getHitbox() {
		return hitbox;
	}
	
}
