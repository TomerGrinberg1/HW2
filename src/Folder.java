import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
/*
    public File findFile(String path) {


    }
*/
    public void sortList(SortingField field) {
        Comparator<StorageItem> comparatorField;
        switch (field) {
            case NAME:
                comparatorField = Comparator.comparing(StorageItem::getName);
                break;

            case SIZE:
                comparatorField = Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getName);
                break;

            default:

                comparatorField = Comparator.comparing(StorageItem::getCreationDate).thenComparing(StorageItem::getName);
        }
        Collections.sort(this.folder, comparatorField);
    }

    public void printTree(SortingField sortBy) {

        printTreeFolder(sortBy,1);
    }
    public void printTreeFolder(SortingField sortBy, int counter) {


        System.out.println(this.getName());
        if ( ! this.getName().contains(".") && ! this.getName().contains("[")){
            this.sortList(sortBy);
        }
        for(int i=0; i< this.folder.size(); i++){
            for(int j=0; j< counter; j++){
                System.out.print("|    ");
            }
            if(this.folder.get(i).getName().contains("[")){
                // Shortcut
                this.folder.get(i).printTree(sortBy);
            }

            if(this.folder.get(i).getName().contains(".")){
                // File
                this.folder.get(i).printTree(sortBy);
            }
            else{
                // Folder
                ((Folder)this.folder.get(i)).printTreeFolder(sortBy, counter+1);
            }
        }

    }
}