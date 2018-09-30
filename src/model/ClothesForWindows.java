package model;

import java.awt.*;

public abstract class ClothesForWindows {

    protected double length;  //длина окна
    protected double width;   //ширина окна
    protected String Name;    //наименование жалюзи
    protected String Color;   //цвет


    protected double area() {   //подсчет площади материала
        return length * width;
    }


    public abstract String getName();
    public abstract String info();


}
