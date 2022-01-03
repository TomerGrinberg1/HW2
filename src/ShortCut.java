public class ShortCut extends StorageItem {
    StorageItem shortCut;

    /**
     * class constructor
     * @param item : file\folder
     */
    public ShortCut(StorageItem item) {
        super(item.name);
        shortCut=item;
    }

    /**
     * @return each shortcut contains only one item
     */
    @Override
    public int getSize() {
        return 1;
    }

    /**
     * @return a string composed with the item's name and "shortcut"
     */
    public String getName() {
        return this.shortCut.getName()+" [shortcut]";
    }

    /**
     * @return shortcut's name, lower case letters
     */
    public String getNameIgnoreCase() {
        return super.getNameIgnoreCase();
    }

    /**
     * @return : required shortcut
     */
    public StorageItem getItem(){
        return shortCut;
    }

    /**
     * @param sortBy: storageItem's enum
     */
    public void printTree(SortingField sortBy) {
        System.out.println(getName());
    }
}


