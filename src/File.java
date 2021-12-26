public class File extends StorageItem
{
 String ending;
 String content;
 public File (String name, String ending)
 {
     super(name);
     this.content=null;
     this.ending=ending;

 }
 public String getName()
 {
     return this.name+"."+this.ending;

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
       if(content==null)
           return 0;
        return this.content.length();
    }
     public  void printContent()
    {
        System.out.println(getName()+" Size: " +getSize()+"MB "+ "Created:"+this.date);
        System.out.println(this.content);

    }
}
