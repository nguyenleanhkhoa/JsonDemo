package com.example.admin.recyclerview;

/**
 * Created by ADMIN on 9/1/2017.
 */

public class product {
    public String tenSP;
    public int Hinh;

    public product() {
    }

    public product(String tenSP,int hinh) {
        this.tenSP = tenSP;
        Hinh = hinh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
