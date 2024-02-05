package malikjg.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	private Handler handler;
	private TileGameMap gameMap;
	public World(Handler handler, SpriteBatch batch) {
		this.handler = handler;
		gameMap = new TileGameMap(handler);
		
	}
	public void render(SpriteBatch batch) {
		for(GameObject block: handler.blocks) {
			block.render(batch);
		}
	}
	public void update(float delta) {
		for(GameObject block: handler.getBlocks()) {
			block.update(delta);
		}
	}
	public void generate() {
		gameMap.loadMap();
	}
	
}
