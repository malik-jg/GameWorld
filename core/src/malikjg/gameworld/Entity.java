package malikjg.gameworld;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity extends GameObject{
	
	public float xVelocity;
	public float yVelocity;
	public float xAcceleration;
	public float yAcceleration;
	public Vector2 velocity;
	public Vector2 acceleration;
	
	public Entity(Handler handler) {
		super(handler);
	}
}
