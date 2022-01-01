import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public abstract class StorageItem {


    String name;
    Date date;
    int size;
/**
     * initializes the the name of the storage item and random production date
     * * @param name: the name of the storage item
     */
    public StorageItem(String name) {
        this.name = name;
        this.date = random();
    }
/**
     * get the  creation Date of the storage item
     * @return : the  creation Date of the storage item
     */
    public Date getCreationDate() {
        return this.date;
    }
    /**
     * get the name of the storage item
     * @return : the name of the storage item
     */
    public String getName()
    {
        return this.name;

    }
/**
     * get the size of the storage item
     * @return : the size of the storage item
     */
    public abstract int getSize();

    public void printTree(SortingField sortBy) {

    }
    public boolean isEqual(StorageItem item)
    {
        return (this.name.equals(item.name));


    }
 /**
     * choose random date between 01.01.2017 - 31.12.2022
     * @return: the random date
     */

  public Timestamp random() {
        final Date minDate, maxDate;
        Timestamp rndDate;
        long range;
        minDate = new Date(117, Calendar.JANUARY, 1, 0, 0, 0);
        maxDate = new Date(122, Calendar.DECEMBER, 31, 23, 59, 59);
        range = maxDate.getTime() - minDate.getTime() ;

        rndDate = new Timestamp(minDate.getTime() + Math.abs(Main.rnd.nextLong() % range));
        return rndDate;

    }


}











