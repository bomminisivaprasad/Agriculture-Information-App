package com.example.agriculture.helpline;

public class MyHelpLine {
    String Name;
    String Mobile;
    String desi;
    String work;

    public MyHelpLine(String name, String mobile, String desi, String work) {
        Name = name;
        Mobile = mobile;
        this.desi = desi;
        this.work = work;
    }

    public String getName() {
        return Name;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getDesi() {
        return desi;
    }

    public String getWork() {
        return work;
    }
}
