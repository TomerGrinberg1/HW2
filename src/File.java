public class File extends StorageItem
{
 String ending;
 String content;
 
 
/**
     * initializes the name, end of file and the contents of the file
     * @param name: the name of the file
     * @param ending: the name of the end of the file
     */
 public File (String name, String ending)
 {
     super(name);
     this.content=null;
     this.ending=ending;

 }
 /**
     * create the name of the file on format of "name.ext"
     * @return : the name of the file on format of "name.ext"
     */
 public String getName()
 {
     return this.name+"."+this.ending;

 }

 public String getEnding(){
     return this.ending;
}
 /**
     * checking if two files have the same nama and ending
     * @param item: the file to compare with
     */

    public boolean isEqual(File item) {
        return super.isEqual(item)&&(this.ending.equals(item.ending)) ;
    }

 /**
     * add contents to the file contents
     * @param contentToAdd: the contents to add to the file contents
     */
    void addContent(String contentToAdd)
   {
       this.content+=contentToAdd;
   }

/**
     * get the size of the file contents
     * @return : the size of the file contents
     */
    @Override
    public int getSize() {
       if(content==null)
           return 0;
        return this.content.length();
    }
     public  void printContent()
    {
        System.out.println(getName()+" Size: " +getSize()+"MB "+ "Created:"+this.date);
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
