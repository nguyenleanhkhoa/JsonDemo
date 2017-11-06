package model;

import android.databinding.ObservableArrayList;
import android.view.View;

import java.net.ContentHandler;
import java.util.Observable;
import java.util.Random;

/**
 * Created by ADMIN on 11/01/17.
 */

public class ContactInforList {
    public ObservableArrayList<Contact>list=new ObservableArrayList<>();

    public int totalContact=500;
    public ContactInforList()
    {
        Random random=new Random();
        for (int i=0;i<totalContact;i++){
            Contact contact=new Contact();
            String ten="Tên "+i;
            String phone="098";
            for (int p=0;p<7;p++){
                phone+=random.nextInt(7);
            }
            contact.setName(ten);
            contact.setPhone(phone);
            add(contact);
        }
    }
    public void add(Contact contact){
        list.add(contact);
    }
    public void add(View view)
    {
        Random random=new Random();
        String ten="Tên"+(++totalContact);
        String phone="098";
        for (int p=0;p<7;p++){
            phone+=random.nextInt(7);
        }
        Contact contact=new Contact();
        contact.setName(ten);
        contact.setPhone(phone);
        add(contact);

    }
    public void remove()
    {
        if(!list.isEmpty()){
            list.remove(0);
        }
    }

}
