package malikjg.gameworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameWorld extends Game {
	private SpriteBatch batch;
	private MainGameScreen mainScreen;
	private FitViewport fit_viewport;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		mainScreen = new MainGameScreen(batch);
		setScreen(mainScreen);
		
		fit_viewport = new FitViewport(1280, 720);
		fit_viewport.apply();
	}
	public void resize(int width, int height) {
		fit_viewport.update(width, height);
	}
	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		super.dispose();
	}
}
