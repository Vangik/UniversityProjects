package com.company.tasks;

import com.company.Tunnel;
import com.company.ships.Ship;
import com.company.ships.types.Size;
import com.company.ships.types.Type;

import javax.lang.model.element.TypeElement;
import java.security.Signature;
import java.util.DoubleSummaryStatistics;
import java.util.Random;

public class ShipGenetator implements Runnable {
    private Tunnel tunnel;
    private int shipCount;

    public ShipGenetator(Tunnel tunnel, int shipCounter){
        this.tunnel=tunnel;
        this.shipCount=shipCounter;

    }

    @Override
    public void run(){
        int count=0;
        while (count<shipCount){
            Thread.currentThread().setName(" Generate Ship");
            count++;
            tunnel.add(new Ship(getRandomSize(),getRandomType()));
            System.out.println("Ship generated");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public Type getRandomType(){
        Random rand=new Random();
        return Type.values()[rand.nextInt(Type.values().length)];
    }

    public Size getRandomSize(){
        Random rand=new Random();
        return Size.values()[rand.nextInt(Size.values().length)];
    }

}
