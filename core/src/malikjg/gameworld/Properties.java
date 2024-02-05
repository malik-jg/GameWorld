package malikjg.gameworld;
public class Properties {
	private String block_type;
	private String name;
	private String texture_path;
	private int damage;
	public Properties(String block_type, String name, String texture_path, int damage) {
		this.block_type = block_type;
        this.name = name;
        this.texture_path = texture_path;
        this.damage = damage;
	}
	public Properties() {}
	public String getBlockType() {
		return block_type;
	}
	public String getName() {
		return name;
	}
	public String getTexturePath() {
		return texture_path;
	}
	public int getDamage() {
		return damage;
	}
}
