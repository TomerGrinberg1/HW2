import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public abstract class StorageItem {
    protected String name;
    protected Date date;
    /**
     * initializes the name of the storage item and random production date
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
    public String getName() {
        return this.name;
    }
    /**
     * @return : the name of the storage in lower case letters
     */
    public String getNameIgnoreCase() {
        return this.name.toUpperCase().toLowerCase();
    }
    /**
     * get the size of the storage item
     * @return : the size of the storage item
     */
    public abstract int getSize();
    /**
     * @param sortBy: storageItem's enum
     * prints the files tree
     */
    public abstract void printTree(SortingField sortBy);
    /**
     * abstract method, compare to items
     * @return : the true if they are equals
     */
    public boolean isEqual(StorageItem item)
    {
        return (this.name.equals(item.name));
    }
    /**
     * choose random date between 01.01.2017 - 31.12.2022
     * @return : random time in range
     */
    public Timestamp random() {
        final Date minDate, maxDate;
        Timestamp rndDate;
        long range;
        minDate = new Date(117, Calendar.JANUARY, 1, 0, 0, 0);
        maxDate = new Date(122, Calendar.DECEMBER, 31, 23, 59, 59);
        range = maxDate.getTime() - minDate.getTime() ;

        rndDate = new Timestamp(minDate.getTime() +
                Math.abs(Main.rnd.nextLong() % range));
        return rndDate;
    }
}
