public class File extends StorageItem
{
 String ending;
 String content;
 public File (String name, String ending)
 {
     super(name);
     this.content="";
     this.ending=ending;

 }
 public String getName()
 {
     return this.name+"."+this.ending;

 }
    public String getNameIgnoreCase()
    {
        return this.name.toUpperCase().toLowerCase()+"."+this.ending.toLowerCase();
    }

 public String getEnding(){
     return this.ending;
}


    public boolean isEqual(File item) {
        return super.isEqual(item)&&(this.ending.equals(item.ending)) ;
    }

    void addContent(String contentToAdd)
   {
       this.content+=contentToAdd;
   }

    @Override
    public int getSize() {

        return (this.content.length());
    }
     public  void printContent()
    {
        System.out.println(getName()+" Size: " +getSize()+"MB "+ "Created: "+this.date);
        System.out.println(this.content);

    }

    public void printTree(SortingField sortBy) {
        System.out.println(this.getName());

    }

}
