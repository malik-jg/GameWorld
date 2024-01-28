package malikjg.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block extends GameObject{
	
	private Texture block = new Texture(Gdx.files.internal("block.png"));
	public Block(Handler handler, int x, int y) {
		super(handler);
		this.xPosition = x;
		this.yPosition = y;
		hitbox = new Rectangle(xPosition, yPosition, block.getWidth(), block.getHeight());
	}
	public void render(SpriteBatch batch) {
		batch.draw(block, xPosition, yPosition);
	}
	public void update(float delta) {
		
	}
}
