package exercise.furnitureappui;

public class ShopItem {
    public static final int TYPE_HOT_DEAL = 0;
    public static final int TYPE_PRODUCT = 1;
    private int viewType;
    private String title;
    private String price;
    private String location;
    private String soldCount;
    private int imageResId;
    // Constructor
    public ShopItem(int viewType, String title, String price,
                    String location, String soldCount, int imageResId) {
        this.viewType = viewType;
        this.title = title;
        this.price = price;
        this.location = location;
        this.soldCount = soldCount;
        this.imageResId = imageResId;
    }
    // getters
    public int getViewType() { return viewType; }
    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public String getLocation() { return location; }
    public String getSoldCount() { return soldCount; }
    public int getImageResId() { return imageResId; }
}

