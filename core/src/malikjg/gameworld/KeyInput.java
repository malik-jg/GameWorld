package malikjg.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;


public class KeyInput{
	
	Music music = null;
	Music[] musicSoundtracks = new Music[3];
	Music battle = Gdx.audio.newMusic(Gdx.files.internal("battle_theme_WIP.ogg"));
	Music overworld = Gdx.audio.newMusic(Gdx.files.internal("overworld_WIP.ogg"));
	Music calm = Gdx.audio.newMusic(Gdx.files.internal("calm_WIP.ogg"));
	private int musicCounter = 0;
	boolean noMusic = true;
	
	
	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
		
		musicSoundtracks[0] = battle;
		musicSoundtracks[1] = overworld;
		musicSoundtracks[2] = calm;
		music = musicSoundtracks[musicCounter];
	}	
	public void update() {
		movement();
	}
	public void movement() {
		//player_movement
		if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			handler.setUp(true);
		}	
		else {
			handler.setUp(false);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			handler.setLeft(true);
		}
		else {
			handler.setLeft(false);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			handler.setDown(true);
		}
		else {
			handler.setDown(false);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			handler.setRight(true);
		}
		else {
			handler.setRight(false);
		}	
		//zooms
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
			handler.setZoomIn(true);
		}
		else {
			handler.setZoomIn(false);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.E)) {
			handler.setZoomOut(true);
		}
		else {
			handler.setZoomOut(false);
		}
		
		//temp music
		if(Gdx.input.isKeyPressed(Input.Keys.P)) {
			music.play();
			noMusic = false;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.O)) {
			music.stop();
			noMusic = true;
			music.dispose();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.I)) {
			music.pause();
		}
		if(Gdx.input.isKeyPressed(Input.Keys.N) && noMusic == true) {
			musicCounter++;
			if(musicCounter == 3) musicCounter = 0;
			music = musicSoundtracks[musicCounter];
		}
		
		
	}
}
