package malikjg.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
public abstract class GameMap {
	public abstract void render(SpriteBatch batch);
	public abstract void update(float delta);
	public abstract void dispose();
	
	public Block getBlockByLocation(int layer, float x, float y) {
		return this.getBlockByCoordinate(layer, (int) (x / 64), (int) (y / 64));
	}
	
	public abstract Block getBlockByCoordinate(int layer, int column, int row) ;
	public abstract int getLayers();
	public abstract int getWidth();
	public abstract int getHeight();
}
