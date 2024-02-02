package malikjg.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	
	private Handler handler;
	
	public World(Handler handler, SpriteBatch batch) {
		this.handler = handler;
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
		for(int i = -1000; i <= 1000; i+=64) {
			handler.blocks.add(new Block(handler, i,-100));
		}	
		for(int i = 1200; i <= 2000; i+=128) {
			handler.blocks.add(new Block(handler, i,-100));
		}	
		for(int i = 1250; i <= 2050; i+=128) {
			handler.blocks.add(new Block(handler, i, 300));
		}
		for(int i = 1200; i <= 2050; i+=128) {
			handler.blocks.add(new Block(handler, i, 700));
		}
		for(int i = 1250; i <= 2050; i+=128) {
			handler.blocks.add(new Block(handler, i, 1100));
		}
		for(int i = 0; i <= 2050; i+=256) {
			handler.blocks.add(new Block(handler, i, 1300));
		}
		for(int i = 0; i <= 2050; i+=512) {
			handler.blocks.add(new Block(handler, i, 1700));
		}
		for(int i = 0; i <= 2050; i+=1024) {
			handler.blocks.add(new Block(handler, i, 2000));
		}
		for(int i = 800; i <= 2050; i+=1024) {
			handler.blocks.add(new Block(handler, i, 2300));
		}
		for(int i = 0; i <= 2050; i+=300) {
			handler.blocks.add(new Block(handler, i, 2500));
		}
		for(int i = 0; i <= 2050; i+=150) {
			handler.blocks.add(new Block(handler, i, 2800));
		}
		for(int i = 2150; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 3100));
		}
		for(int i = 2150; i <= 4000; i+=256) {
			handler.blocks.add(new Block(handler, i, 3400));
		}
		for(int i = 2406; i <= 4000; i+=256) {
			handler.blocks.add(new Block(handler, i, 3700));
		}
		for(int i = 0; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 4000));
		}
		for(int i = 0; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 4300));
		}
		for(int i = 0; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 4600));
		}
		for(int i = 256; i <= 4256; i+=512) {
			handler.blocks.add(new Block(handler, i, 4900));
		}
		for(int i = 0; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 5200));
		}
		for(int i = 256; i <= 4256; i+=512) {
			handler.blocks.add(new Block(handler, i, 5500));
		}
		for(int i = 0; i <= 4000; i+=512) {
			handler.blocks.add(new Block(handler, i, 5800));
		}
	}
	
}
