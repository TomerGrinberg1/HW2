import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Folder extends StorageItem {
    protected ArrayList<StorageItem> folder;

    /**
     * initializes the name of the folder and the list of storage item
     * @param name: the name of the folder
     */
    public Folder(String name) {
        super(name);
        this.folder = new ArrayList<>();
    }
    /**
     * get the size of all the storage item in the folder
     * @return : the size of the folder
     */
    @Override
    public int getSize() {
        int sum = 0;
        for (StorageItem item : folder)
            sum += item.getSize();
        return sum;
    }
    /**
     * add the item to the storageItem if there is no another item with the same name in the list
     * @param item: object from StorageItem type
     * @return : if there is storageItem with equal name return false, otherwise true
     */
    public boolean addItem(StorageItem item) {
        for (StorageItem folderItem : folder)
            if (folderItem.isEqual(item))
                return false;
        folder.add(item);
        return true;
    }
    /**
     * add the item to the storageItem  if there is no another item with the same name in the list
     * @param path: the path of the file
     * @return : the file that it's path transferred, null if not found
     */
    public  File findFile (String path) {
        String[] splitPath = path.split("/");
        for (String stringItem : splitPath) {
            for (int i = 0; i < this.folder.size(); i++) {
                if (stringItem.equals(this.folder.get(i).getName())) {
                    if (this.folder.get(i) instanceof File)
                        return (File) folder.get(i);
                    else if (this.folder.get(i) instanceof Folder) {
                        String innerPath = "";
                        for (int j = 1; j < splitPath.length; j++) {
                            if (j == splitPath.length - 1)
                                innerPath += splitPath[j];
                            else
                            innerPath += splitPath[j] + "/";
                        }
                         return ((Folder) folder.get(i)).findFile(innerPath);
                    }
                }
            }
        }
        return null;
    }
    /**
     * sort the list according to the given method
     * @param field: the method according to print the tree
     */
    public void sortList(SortingField field) {
        Comparator<StorageItem> comparatorField;
        switch (field) {
            case NAME:
                comparatorField = Comparator.
                        comparing(StorageItem::getNameIgnoreCase);
                break;
            case SIZE:
                comparatorField = Comparator.
                        comparing(StorageItem::getSize).
                        thenComparing(StorageItem::getNameIgnoreCase);
                break;
            default:
                comparatorField = Comparator.
                        comparing(StorageItem::getCreationDate).
                        thenComparing(StorageItem::getNameIgnoreCase);
        }
        Collections.sort(this.folder, comparatorField);
    }
    /**
     * print tree of all the files as requested
     * @param sortBy: the method according to print the tree
     */
    public void printTree(SortingField sortBy) {
        printTreeFolder(sortBy,1);
    }
    /**
     * print tree of all the Folders as requested
     * @param sortBy: the method according to print the tree
     * @param counter: number of tubs we need to add to the print
     */
    public void printTreeFolder(SortingField sortBy, int counter) {
        System.out.println(this.getName());
        if ( ! this.getName().contains(".") && ! this.getName().contains("[")){
            this.sortList(sortBy);
        }
        for(int i=0; i< this.folder.size(); i++){
            for(int j=0; j< counter; j++){
                System.out.print("|    ");
            }
            if(this.folder.get(i) instanceof ShortCut){
                // Shortcut
                this.folder.get(i).printTree(sortBy);
                continue;
            }
            if(this.folder.get(i) instanceof File){
                // File
                this.folder.get(i).printTree(sortBy);
                continue;
            }
                // Folder
            ((Folder)this.folder.get(i)).printTreeFolder(sortBy,
                    counter+1);
        }
    }
}
