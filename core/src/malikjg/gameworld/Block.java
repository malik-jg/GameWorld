package malikjg.gameworld;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Json;

public class Block extends GameObject{
	
	private Texture texture; //= new Texture(Gdx.files.internal("block.png"));
	
	
	private static BlockProperties[] blockPropertiesArray;
	private static Texture[] textureArray = new Texture[2];
	private BlockProperties properties;
	
	
	public Block(Handler handler, int x, int y, int id) {
		super(handler);
		this.xPosition = x;
		this.yPosition = y;
		
		properties = getPropertiesFromArray(id);
		
		this.texture = textureArray[id];
		
		
		hitbox = new Rectangle(xPosition, yPosition, texture.getWidth(), texture.getHeight());
	}
	public static void loadBlockProperties() {
		Json json = new Json();
		FileHandle file = Gdx.files.internal("BlockProperties.json");
	    String jsonString = file.readString();
	    blockPropertiesArray = json.fromJson(BlockProperties[].class, jsonString);
	}
	public void JSONString() {
		for(BlockProperties properties : blockPropertiesArray){
	        System.out.println("ID: " + properties.getID());
	        System.out.println("Block Type: " + properties.getProperty().getBlockType());
	        System.out.println("Name: " + properties.getProperty().getName());
	        System.out.println("Texture: " + properties.getProperty().getTexturePath());
	        System.out.println("Damage: " + properties.getProperty().getDamage());
	        System.out.println("---------------");
	    }
	}
	public static void loadTextures() {
		for(int i = 0; i < blockPropertiesArray.length; i++) {
			textureArray[i] = new Texture(Gdx.files.internal(blockPropertiesArray[i].getProperty().getTexturePath()));
			System.out.println(textureArray[i].toString());
		}
	}
	public BlockProperties getPropertiesFromArray(int id) {
		for(BlockProperties properties : blockPropertiesArray) {
			if(id == properties.getID()) {
				return properties;
			}
		}
		return null;
	}
	public void render(SpriteBatch batch) {
		batch.draw(texture, xPosition, yPosition);
	}
	public void update(float delta) {

	}
}
