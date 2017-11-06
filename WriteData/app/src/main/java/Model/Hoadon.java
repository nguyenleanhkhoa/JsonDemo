package Model;

/**
 * Created by ADMIN on 9/11/2017.
 */

public class Hoadon {
    public String ID;
    public String BillNumber;
    public String Date;
    public String Final;
    public String Money;
    public String Note;
    public String Origin;
    public String Time;
    public String Type;

    public Hoadon() {
    }

    public Hoadon(String ID, String billNumber, String date, String aFinal, String money, String note, String origin, String time, String type) {
        this.ID = ID;
        BillNumber = billNumber;
        Date = date;
        Final = aFinal;
        Money = money;
        Note = note;
        Origin = origin;
        Time = time;
        Type = type;
    }
}