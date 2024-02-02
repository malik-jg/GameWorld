package malikjg.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block extends GameObject{
	
	private Texture block = new Texture(Gdx.files.internal("block.png"));
	private double state;
	float maxHeight;
	float minHeight;
	int velocityY = -1;
	public Block(Handler handler, int x, int y) {
		super(handler);
		this.state = Math.random();
		if(state < 0.8) {
			state = 0;
		}
		else {
			state = 1;
		}
		this.xPosition = x;
		this.yPosition = y;
		hitbox = new Rectangle(xPosition, yPosition, block.getWidth(), block.getHeight());
		
		maxHeight = this.yPosition + 128;
		minHeight = this.yPosition - 128;
	}
	public void render(SpriteBatch batch) {
		batch.draw(block, xPosition, yPosition);
	}
	public void update(float delta) {
		if(state == 1) {
			yPosition += velocityY;
			hitbox.y += velocityY;
			if(yPosition < minHeight) {
				yPosition = minHeight + 1;
				velocityY = 1;
			}
			else if(yPosition > maxHeight) {
				yPosition = maxHeight -1;
				velocityY = -1;
			}
			
		}
	}
}
