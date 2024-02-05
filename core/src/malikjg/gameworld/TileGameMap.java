package malikjg.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class TileGameMap extends GameMap{
	private Handler handler;
	private TiledMap tiledMap;
	public TileGameMap(Handler handler) {
		this.handler = handler;
		tiledMap = new TmxMapLoader().load("test_map.tmx");
	}
	@Override
	public void render(SpriteBatch batch) {
		
	}
	@Override
	public void update(float delta) {
		
	}
	public void loadMap() {
		TiledMapTileLayer layer = (TiledMapTileLayer) tiledMap.getLayers().get(0);
		for(int i = 0; i < getWidth(); i++) {
			for(int j = 0; j < getHeight(); j++) {
				TiledMapTileLayer.Cell cell = layer.getCell(i,j);
				
				if(cell != null) {
					int blockID = cell.getTile().getProperties().get("blockID", Integer.class);
					
					handler.blocks.add(new Block(handler, i * 64, j * 64, blockID));
				}
			}
		}
	}
	@Override
	public void dispose() {
		tiledMap.dispose();
	}
	@Override
	public Block getBlockByCoordinate(int layer, int column, int row) {
		return null;
	}
	@Override
	public int getWidth() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getWidth();
	}
	@Override
	public int getHeight() {
		return ((TiledMapTileLayer) tiledMap.getLayers().get(0)).getHeight();
	}
	@Override
	public int getLayers() {
		return tiledMap.getLayers().getCount();
	}
}
