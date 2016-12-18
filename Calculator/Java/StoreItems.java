package perusu.mobolutions.com.mycalculator;

/**
 * Created by perusu on 29/11/16.
 */
public class StoreItems {

    private int imageId;
    private String title;
    private String desc;

    public StoreItems(){

    }

    public StoreItems(String title){
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
