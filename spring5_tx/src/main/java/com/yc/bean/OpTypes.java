package com.yc.bean;

public enum OpTypes {
    deposite("deposite",1),
    withdraw("withdarw",2),
    transfer("transfer",3);

    private String name;
    private int index;
    private OpTypes(String name, int i) {
        this.name=name;
        this.index=i;
    }

    @Override
    public String toString() {
        return this.index+"/"+this.name;
    }
    public String getName(){
        return this.name;
    }


}
