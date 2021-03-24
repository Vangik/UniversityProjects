package com.company;

import com.company.ships.Ship;
import com.company.ships.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Tunnel {
    private List<Ship> store;
    private static final int maxShipInTunel = 5;
    private static final int minShipInTunel = 0;
    private int shipCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {
        try {
            if (shipCounter < maxShipInTunel) {
                notifyAll();
                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s", store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipCounter++;
            } else {
                System.out.println();
                wait();
                return false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public synchronized Ship get(Type shipType) {

        try {
            if (shipCounter > minShipInTunel) {
                notifyAll();
                for (Ship ship : store) {
                    if (ship.getType() == shipType) {
                        shipCounter--;
                        System.out.println(store.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }

                }

            }
            System.out.println("0 < There are no ships in the tunnel");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}

