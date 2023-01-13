import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MapData {
    public static final int TYPE_SPACE = 0;
    public static final int TYPE_WALL = 1;
    public static final int TYPE_GOAL = 2;
    public static final int TYPE_OTHERS = 3;
    private static final String mapImageFiles[] = {
            "png/SPACE.png",
            "png/WALL.png",
            "png/GOAL.png",
    };

    static public int xGoal;
    static public int yGoal;
    private Image[] mapImages;
    private ImageView[][] mapImageViews;
    private int[][] maps;
    private int width; // width of the map
    private int height; // height of the map

    MapData(int x, int y) {
        mapImages = new Image[3];
        mapImageViews = new ImageView[y][x];
        for (int i = 0; i < 3; i ++) {
            mapImages[i] = new Image(mapImageFiles[i]);
        }

        width = x;
        height = y;
        maps = new int[y][x];

        fillMap(MapData.TYPE_WALL);
        digMap(1, 3);
        setGOAL();
        setImageViews();
    }

    public void setGOAL(){
        int xrand = 0;
        int yrand = 0;

            while (getMap(xrand, yrand) != MapData.TYPE_SPACE){
            xrand = (int) (Math.random() * width/2  ) * 2 + 1;
            yrand = (int) (Math.random() * height/2 ) * 2 + 1;
        }
        xGoal = xrand;//GOALの座標
        yGoal = yrand;

        setMap(xGoal,yGoal, MapData.TYPE_GOAL);
    }

    // fill two-dimentional arrays with a given number (maps[y][x])
    private void fillMap(int type) {
        for (int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x++) {
                maps[y][x] = type;
            }
        }
    }

    // dig walls for making roads
    private void digMap(int x, int y) {
        setMap(x, y, MapData.TYPE_SPACE);
        int[][] dl = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
        int[] tmp;

        for (int i = 0; i < dl.length; i ++) {
            int r = (int) (Math.random() * dl.length);
            tmp = dl[i];
            dl[i] = dl[r];
            dl[r] = tmp;
        }

        for (int i = 0; i < dl.length; i ++) {
            int dx = dl[i][0];
            int dy = dl[i][1];
            if (getMap(x + dx * 2, y + dy * 2) == MapData.TYPE_WALL) {
                setMap(x + dx, y + dy, MapData.TYPE_SPACE);
                digMap(x + dx * 2, y + dy * 2);
            }
        }
    }

    public int getMap(int x, int y) {
        if (x < 0 || width <= x || y < 0 || height <= y) {
            return -1;
        }
        return maps[y][x];
    }

    public void setMap(int x, int y, int type) {
        if (x < 1 || width <= x - 1 || y < 1 || height <= y - 1) {
            return;
        }
        maps[y][x] = type;
    }

    public ImageView getImageView(int x, int y) {
        return mapImageViews[y][x];
    }

    public void setImageViews() {
        for (int y = 0; y < height; y ++) {
            for (int x = 0; x < width; x++) {
                mapImageViews[y][x] = new ImageView(mapImages[maps[y][x]]);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
