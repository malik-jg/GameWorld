package malikjg.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	private Handler handler;
	
	public World(Handler handler, SpriteBatch batch) {
		this.handler = handler;
		for(int i = -1000; i <= 1000; i+=64) {
			handler.blocks.add(new Block(handler, i,-100));
		}	
		for(int i = 1200; i <= 2000; i+=128) {
			handler.blocks.add(new Block(handler, i,-100));
		}	
	}
	public void render(SpriteBatch batch) {
		for(GameObject block: handler.blocks) {
			block.render(batch);
		}
	}
	public void update(float delta) {
		
	}
}
