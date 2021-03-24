package com.company;

import com.company.ships.Ship;
import com.company.ships.types.Size;
import com.company.ships.types.Type;
import com.company.tasks.PierLoader;
import com.company.tasks.ShipGenetator;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        ShipGenetator shipGenerator = new ShipGenetator(tunnel,100);

        PierLoader pierLoader1 = new PierLoader(tunnel, Type.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.MEAL);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.BANANA);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);

        service.shutdown();

    }
}
