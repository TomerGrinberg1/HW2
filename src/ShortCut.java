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
        //if(this.shortCut instanceof File || this.shortCut instanceof Folder)
        return this.shortCut.getName()+" [shortcut]";
        //else
        //return this.name+" [shortcut]";
    }
    public String getNameIgnoreCase()
    {
        return this.name.toUpperCase().toLowerCase();
    }

    public StorageItem getItem(){
    return shortCut;

    }
    public void printTree(SortingField sortBy) {
        System.out.println(getName());
    }

    }


