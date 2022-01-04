public class File extends StorageItem
{
     protected String ending;
     protected String content;
     /**
     * initializes the name, end of file and the contents of the file
     * @param name: the name of the file
     * @param ending: the name of the end of the file
     */
    public File (String name, String ending) {
        super(name);
        this.content="";
        this.ending=ending;

    }
    /**
     * create the name of the file on format of "name.ext"
     * @return : the name of the file on format of "name.ext"
     */
    public String getName() {
         return this.name+"."+this.ending;

    }
    /**
     * @return file's name in lower case letters
     */
    public String getNameIgnoreCase() {
         return super.getNameIgnoreCase()+"."+this.ending.toLowerCase();
    }
    /**
     * @return file's ending type
     */
    public String getEnding(){
        return this.ending;
    }

    /**
     * checking if two files have the same nama and ending
     * @param item: the file to compare with
     */
    public boolean isEqual(File item) {
        return super.isEqual(item)&&(this.getEnding().equals(item.ending)) ;
    }
    /**
     * add contents to the file contents
     * @param contentToAdd: the contents to add to the file contents
     */
    void addContent(String contentToAdd) {
       this.content+=contentToAdd;
   }
    /**
     * get the size of the file contents
     * @return : the size of the file contents
     */
    @Override
    public int getSize() {

        return (this.content.length());
    }
    /**
     * prints file's name, size and last modified date
     */
     public void printContent()
    {
        System.out.println(getName()+" Size: " +getSize()+"MB "+
                "Created: "+this.date);
        System.out.println(this.content);

    }
    /**
     * print tree of File as requested
     * @param sortBy: the method according to print the tree
     */
    public void printTree(SortingField sortBy) {
        System.out.println(this.getName());

    }
}
