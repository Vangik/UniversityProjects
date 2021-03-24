package com.company.tasks;

import com.company.Tunnel;
import com.company.ships.Ship;
import com.company.ships.types.Type;

import javax.lang.model.element.TypeElement;

public class PierLoader implements Runnable {
    private Tunnel tunnel;
    private Type shipType;

    public PierLoader(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType = shipType;


    }

    @Override
    public void run() {
        while (true) {
            Thread.currentThread().setName("Loader" + shipType);

            try {
                Thread.sleep(500);
                Ship ship=tunnel.get(shipType);
                if(ship!=null)
                    while (ship.countCheck()){
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println(ship.getCount() + " Loaded ship. " + Thread.currentThread().getName());
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
