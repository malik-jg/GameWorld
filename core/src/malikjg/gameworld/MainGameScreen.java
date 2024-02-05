package malikjg.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGameScreen implements Screen{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	private Player player;
	
	private BitmapFont font = new BitmapFont();
	
	private Handler handler;
	private KeyInput keyInput;
	
	private World world;
	public MainGameScreen(SpriteBatch batch) {
		this.batch = batch;
		handler = new Handler();
		keyInput = new KeyInput(handler);
		camera = new OrthographicCamera(WIDTH, HEIGHT);
		Block.loadBlockProperties();
		Block.loadTextures();
		world = new World(handler, batch);
		world.generate();
		
	}
	@Override
	public void show() {
		player = new Player(handler);
		camera.position.set(player.getPosition().x + 64, player.getPosition().y + 64, 10);
	}

	@Override
	public void render(float delta) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		world.render(batch);
		//world.update(delta);
		player.render(batch);
		player.update(delta);
		keyInput.update();
		
		camera.position.set(player.getPosition().x + (player.getWidth() / 2), player.getPosition().y + (player.getHeight() / 2), 10);
		batch.end();
		
		if(handler.isZoomIn()) {
			camera.zoom += .40;
		}
		else if(handler.isZoomOut()) {
			camera.zoom -= .40;
		}
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {
		
	}

}
