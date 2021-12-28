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

    public  File findFile (String path) {
        String[] splittedPath = path.split("/");
        //int branch = 0;
        for (String stringItem : splittedPath) {
            for (int i = 0; i < this.folder.size(); i++) {
                if (stringItem.equals(this.folder.get(i).getName())) {
                    if (this.folder.get(i) instanceof File)
                        return (File) folder.get(i);
                    else if (this.folder.get(i) instanceof Folder) {
                        String innerPath = "";
                        for (int j = 1; j < splittedPath.length; j++) {
                            if (j == splittedPath.length - 1)
                                innerPath += splittedPath[j];
                            else
                            innerPath += splittedPath[j] + "/";
                        }
                         return ((Folder) folder.get(i)).findFile(innerPath);


                    }
                }
            }
        }
        return null;
    }

    public void sortList(SortingField field) {
        Comparator<StorageItem> comparatorField;
        switch (field) {
            case NAME:
                comparatorField = Comparator.comparing(StorageItem::getNameIgnoreCase);
                break;

            case SIZE:
                comparatorField = Comparator.comparing(StorageItem::getSize).thenComparing(StorageItem::getNameIgnoreCase);
                break;

            default:

                comparatorField = Comparator.comparing(StorageItem::getCreationDate).thenComparing(StorageItem::getNameIgnoreCase);
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
                ((Folder)this.folder.get(i)).printTreeFolder(sortBy, counter+1);
            }
        }

    }
