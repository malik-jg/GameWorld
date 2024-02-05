package malikjg.gameworld;
public class BlockProperties {
	private int id;
	private Properties properties;
	public BlockProperties(int id, Properties properties) {
		this.id = id;
        this.properties = properties;
	}
	public BlockProperties() {}
	public int getID() {
		return id;
	}
	public Properties getProperty() {
		return properties;
	}
}
