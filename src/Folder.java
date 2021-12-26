import java.util.ArrayList;

public class Folder extends StorageItem {
    ArrayList<StorageItem> folder;


    public Folder(String name) {
        super(name);
        this.folder = new ArrayList<>();
    }

    @Override
    public int getSize() {
        int sum = 0;
        for (StorageItem item : folder) {
            sum += item.getSize();
        }
        return sum;
    }

    public boolean addItem(StorageItem item) {
        for (StorageItem folderItem : folder) {
            if (folderItem.isEqual(item)) {

                return false;
            }

        }
        folder.add(item);
        return true;
    }
   public  File findFile (String path)
    {


    }

}
