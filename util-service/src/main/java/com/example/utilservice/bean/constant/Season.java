package com.example.utilservice.bean.constant;

public enum Season {
    SPRING(1,"Spring","春季"),
    SUMMER(1,"Summer","夏季"),
    AUTUMN(1,"Autumn","秋季"),
    WINTER(1,"Winter","冬季");

    private int code;
    private String name;
    private String alias;

    private Season(int code,String name,String alias){
        this.code=code;
        this.name=name;
        this.alias=alias;
    }

    @Override
    public String toString() {
        return "Season{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                '}';
    }

    public static void main(String[] args) {
        for(Season s:Season.values()){
            System.out.println(s.toString());
        }
    }
}
