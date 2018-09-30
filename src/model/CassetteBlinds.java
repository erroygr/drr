package model;

import java.awt.*;

//кассетные жалюзи
public class CassetteBlinds extends ClothesForWindows{

        public CassetteBlinds(double length, double width, String Name, String Color ) {

            this.length = length;
            this.width = width;
            this.Name = Name;
            this.Color=Color;
        }



        @Override
        public String getName() {
            return Name;
        }

        @Override
        public String info() {
            return getName()+"(Цвет: "+Color+". Длина: "+length+" м. Ширина: "+width+" м. Площадь: "+area()+" m^2)\n";
        }
}
