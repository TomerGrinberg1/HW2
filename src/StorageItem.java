import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public abstract class StorageItem {


    String name;
    Date date;
    int size;

    public StorageItem(String name) {
        this.name = name;
        this.date = random();
    }

    public Date getCreationDate() {
        return this.date;
    }
    public String getName()
    {
        return this.name;

    }

    public abstract int getSize();

    public void printTree(SortingField sortBy) {

    }
    public boolean isEqual(StorageItem item)
    {
        return (this.name.equals(item.name));


    }


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











