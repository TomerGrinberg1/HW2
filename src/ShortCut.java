public class ShortCut extends StorageItem{
    StorageItem shortCut;
    //String name;
    public ShortCut(StorageItem item)
    {
        super(item.name);
        shortCut=item;
    }

    @Override
    public int getSize() {
        return 1;
    }
    public String getName() {
        return this.name+"[shortcut]";
    }
    public StorageItem getItem(){
    return shortCut;

    }
    public void printTree(SortingField sortBy) {
        System.out.println(getName());
    }

    }


