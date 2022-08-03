package com.knubisoft.base.queue;

import com.knubisoft.base.queue.car.Car;
import com.knubisoft.base.queue.car.CarComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Tests {
    public static void main(String[] args) throws NullPointerException {

        Car mercedes = new Car("Mercedes", 10000.500);
        Car vw = new Car("Volkswagen", 6000.250);
        Car bmw = new Car("BWM", 9500.0);
        Car mazda = new Car("Mazda", 6500.150);
        Car hyundai = new Car("Hyundai", 5000.175);
        Car toyota = new Car("Toyota", 7000.190);
        List<Car> carList = new ArrayList<>(Arrays.asList(mercedes,vw,bmw,mazda,hyundai,toyota));
        PriorityQueue<Car> queue = new PriorityQueue<Car>(6, new CarComparator());
        queue.add(mercedes);
        queue.add(vw);
        queue.add(bmw);
        queue.add(mazda);
        queue.add(hyundai);
        queue.add(toyota);



        while (!queue.isEmpty()){
            System.out.println(queue.poll().getPrice());
        }
    }
}
