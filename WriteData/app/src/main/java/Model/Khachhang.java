package Model;

/**
 * Created by ADMIN on 9/12/2017.
 */

public class Khachhang {
    public String ID;
    public String Firstname;
    public String Lastname;
    public String Address;
    public String Phone;

    public Khachhang() {
    }

    public Khachhang(String ID, String firstname, String lastname, String address, String phone) {
        this.ID = ID;
        Firstname = firstname;
        Lastname = lastname;
        Address = address;
        Phone = phone;
    }
}
