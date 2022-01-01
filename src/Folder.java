import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Folder extends StorageItem {
    ArrayList<StorageItem> folder;

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
        for (StorageItem item : folder) {
            sum += item.getSize();
        }
        return sum;
    }
/**
     * add the item to the storageItem if there is no another item with the same name in the list
     * @param item: object from StorageItem type
     * @return : if there is storageItem with equal name return false, otherwise true
     */
    public boolean addItem(StorageItem item) {
        for (StorageItem folderItem : folder) {
            if (folderItem.isEqual(item)) {

                return false;
            }

        }
        folder.add(item);
        return true;
    }
 /**
     * add the item to the storageItem  if there is no another item with the same name in the list
     * @param path: the path of the file
     * @return : the file that his path transferred
     */
    public  File findFile (String path) {
        String[] splittedPath = path.split("/");
        int branch=0;
        for(String stringItem: splittedPath) {
            for (int i=0; i<this.getSize(); i++) {
                if (stringItem.equals(folder.get(i).name)){
                    if(folder.get(i) instanceof File)
                        return (File)folder.get(i);
                    else if(folder.get(i) instanceof Folder){
                        String innerPath ="";
                        for(int i=1;i<splittedPath.length; i++){
                            if(i== splittedPath.length-1)
                                innerPath += splittedPath[i];
                            innerPath += (splittedPath[i] + "/");
                        }
                        ((Folder) folder.get(i)).findFile(innerPath);


                    }
                }
            }
        }

    }

    /**
     * sort the list according to the given method
     * @param field: the method according to print the tree
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
/**
     * print tree of all the Folders as requested
     * @param field: the method according to print the tree
     * @param counterTabs: number of tubs we need to add to the print
     */
    public void printTree(SortingField sortBy) {

        printTreeFolder(sortBy,1);
    }
   public void printTreeFolder(SortingField sortBy, int counter) {


        System.out.println(this.getName());
        if ( ! this.getName().contains(".") && ! this.getName().contains("[")){
            this.sortList(sortBy);
        }
        for(int i=0; i< this.folder.size(); i++) {
            for (int j = 0; j < counter; j++) {
                System.out.print("|    ");
            }
            if (this.folder.get(i) instanceof ShortCut) {
                // Shortcut
                this.folder.get(i).printTree(sortBy);
            } else {
                if (this.folder.get(i) instanceof File)
                    {
                        // File
                        this.folder.get(i).printTree(sortBy);
                    }
            else
                    // Folder
                    ((Folder) this.folder.get(i)).printTreeFolder(sortBy, counter + 1);
                }
            }
        }
    }
