package malikjg.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
	
	private BitmapFont font = new BitmapFont();
	
	private final float max_velocity = 1000;
	
	private float coyoteTime = 0.08f;
	private float coyoteTimeCounter;
	private float jumpBufferTime = 0.08f;
	private float jumpBufferCounter;
	
	private Rectangle temp_hitbox;
	
	public Player(Handler handler) {
		super(handler);
		
		xPosition = 0;
		yPosition = 128;
		
		xVelocity = 0;
		yVelocity = 0;
		
		xAcceleration = 200;
		yAcceleration = 100;
		
		image = new Texture(Gdx.files.internal("character.png"));
		
		width = image.getWidth();
		height = image.getHeight();
		
		position = new Vector2(xPosition, yPosition);
		velocity = new Vector2(xVelocity, yVelocity);
		acceleration = new Vector2(xAcceleration, yAcceleration);
		
		hitbox = new Rectangle(position.x,position.y,image.getWidth(),image.getHeight());
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(image, position.x, position.y);
		
		font.draw(batch, "(PX,PY): (" + position.x + " , " + position.y + ")", position.x -100, position.y + 100);
		font.draw(batch, "(VX,VY): (" + velocity.x + " , " + yVelocity + ")", position.x -100, position.y + 200);
		font.draw(batch, "(AX,AY): (" + acceleration.x + " , " + yAcceleration + ")", position.x -100, position.y + 400);
		font.draw(batch, "(HX,HY): (" + hitbox.x + " , " + hitbox.y + ")", position.x -200, position.y + 600);
		
	}

	@Override
	public void update(float delta) {
		death();
		if(isGrounded()) {
			coyoteTimeCounter = coyoteTime;
		}
		else {
			coyoteTimeCounter -= delta;
		}
		movePlayer(delta);
		collision(delta);
	}
	public void movePlayer(float delta) {
		
		if(handler.isLeft() && !handler.isRight()){
			if(velocity.x <= 0) {
				if(Math.abs(velocity.x) < max_velocity) {
					velocity.x -= acceleration.x;	
				}
				else if(Math.abs(velocity.x) > max_velocity){
					velocity.x = -max_velocity;
				}
			}
			else if(velocity.x > 0) {
				velocity.x -= acceleration.x;
			}	
        }	
		
		if(handler.isRight() && !handler.isLeft()){
			if(velocity.x >= 0) {
				if(Math.abs(velocity.x) < max_velocity) {
					velocity.x += acceleration.x;
				}
				else if(Math.abs(velocity.x)> max_velocity) {
					velocity.x = max_velocity;
				}
			}
			else if(velocity.x < 0) {
				velocity.x += acceleration.x;
			}	
        }
		
		if(!handler.isLeft() && !handler.isRight()) {
			if(velocity.x!=0) {
				if(velocity.x > 0) {
					velocity.x -= acceleration.x;
				}
				else if(velocity.x < 0) {
					velocity.x += acceleration.x;
				}
			}
		}	
		
		if(handler.isLeft() && handler.isRight()) {
			velocity.x = 0;
		}
		 
		if(handler.isUp()) {
			jumpBufferCounter = jumpBufferTime;
		}
		else {
			jumpBufferCounter -= delta;
		}
		
		if(coyoteTimeCounter > 0f && jumpBufferCounter > 0f) {
			coyoteTimeCounter = 0f;
			jumpBufferCounter = 0f;
			velocity.y = 2250;
		}
	}
	public void collision(float delta) {	
		velocity.y -= acceleration.y;
		
		hitbox.x += velocity.x * delta;
		
		for(Block block: handler.getBlocks()) {
			if(hitbox.overlaps(block.getHitbox())) {
				hitbox.x -= velocity.x * delta;
				while(!block.getHitbox().overlaps(hitbox)) {
					hitbox.x += Math.signum(velocity.x) * delta;
				}
				hitbox.x -= Math.signum(velocity.x) * delta;		
				velocity.x = 0;
				position.x = hitbox.x;
			}	
		}
		
		hitbox.y += velocity.y * delta;
		
		for(Block block: handler.getBlocks()) {
			if(hitbox.overlaps(block.getHitbox())) {
				hitbox.y -= velocity.y * delta;
				while(!block.getHitbox().overlaps(hitbox)) {
					hitbox.y += Math.signum(velocity.y) * delta;
				}
				hitbox.y -= Math.signum(velocity.y) * delta;		
				velocity.y = 0;
				position.y = hitbox.y;
			}
		}
		
		position.x += velocity.x * delta;
		position.y += velocity.y * delta;
		
		hitbox.x = position.x;
		hitbox.y = position.y;
	}
	
	public boolean isGrounded() {
		temp_hitbox = new Rectangle(position.x,position.y,image.getWidth(),image.getHeight());
		temp_hitbox.y --;
		for(Block block: handler.getBlocks()) {
			if(block.getHitbox().overlaps(temp_hitbox)) {
				return true;
			}
		}
		return false;
	}
	
	
	public void death() {
		if(position.y <= -1000) {
			velocity.x = 0;
			velocity.y = 0;
			position.x = 0;
			position.y = 128;
		}
	}
}
