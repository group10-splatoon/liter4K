import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Item {
    private final String itemImageFile = "png/KEY.png";

    private int posX;
    private int posY;

    private MapData mapData;
    private ImageView[] itemImageView;

    Item(int startX, int startY, MapData mapData) {
        this.mapData = mapData;

        itemImageView = new ImageView[1];
        itemImageView[0] = new ImageView(itemImageFile);

        posX = startX;
        posY = startY;
    }

    // getter: direction of the item
    public ImageView getItemImageView() {
        return itemImageView[0];
    }

    // getter: x-positon of the item
    public int getPosX() {
        return posX;
    }

    // getter: y-positon of the item
    public int getPosY() {
        return posY;
    }

}
