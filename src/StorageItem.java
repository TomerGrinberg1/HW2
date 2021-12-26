import java.util.Calendar;
import java.util.Date;

public abstract class StorageItem {
    Date minDate, maxDate;

    minDate = new Date(117, Calendar.JANUARY,1,0,0,0);
    Date(122, Calendar.DECEMBER,31,23,59,59);

    String name;
    Date date;
    int size;

    public StorageItem(String name) {
        this.name = name;
        date = new Date(Main.rnd);
    }
    public abstract int getSize();
    public void printTree(SortingField sortBy){

    }














}
