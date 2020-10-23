package com.company;

import java.awt.event.MouseAdapter;
import java.util.Random;

public class Main {

    public static double F(double x1, double x2){
        return Math.pow(Math.pow(x1,2)+x2-11,2) + Math.pow(Math.pow(x2,2)+x1-7,2);
    }

    public static void BlindSearch(double a, double b){
        Random r = new Random();
        double x1 = a + (b - a) * r.nextDouble();
        double x2 = a + (b - a) * r.nextDouble();
        double current = F(x1,x2);
        System.out.println("Current:"+current+" X1,X2:"+x1+" "+x2);
        double x11=x1;
        double x12=x2;
        for (int i = 1; i <1000 ; i++) {
            x1 = a + (b - a) * r.nextDouble();
            x2 = a + (b - a) * r.nextDouble();
            double nextX = F(x1,x2);
            if (current<nextX){x11=x1; x12=x2;}
            System.out.println("Next:"+nextX+" X1,X2:"+x1+" "+x2);
            current= Math.max(current,nextX);
            System.out.println("Current:"+current+" X1,X2:"+x11+" "+x12+"\n");


        }

    }

    public static void RDirection(double a, double b,double x1,double x2 ){
        Random r = new Random();
        //double h = 1 + (10 - 0) * r.nextDouble();
        double h =0.5;
        double alpha1 = a + (b - a) * r.nextDouble();
        double alpha2 = a + (b - a) * r.nextDouble();
        int count =0;
        System.out.println("Start point: "+F(x1,x2));
        double x11,x12;
        for (int i = 0; i <200; i++) {
            x11=x1+h*alpha1;
            x12=x2+h*alpha2;
            System.out.println("F("+x1+" ; "+x2+") = "+F(x1,x2)+" F("+x11+" ; "+x12+") = "+F(x11,x12));

            if (F(x11,x12)<F(x1,x2)){

                    System.out.println("Changing the direction"+alpha1+"  "+alpha2);
                    alpha1 = a + (b - a) * r.nextDouble();
                    alpha2 = a + (b - a) * r.nextDouble();
                    System.out.println("Next: "+alpha1+"  "+alpha2);
                    continue;
            }
            x1 = x11;
            x2 = x12;
        }
    }

    public static void main(String[] args) {
    //RDirection(-1,10, 2,1);
    }

}
