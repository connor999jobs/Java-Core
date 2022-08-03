package com.knubisoft.base.queue.car;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {

//        if (o1.getPrice() == o2.getPrice())
//            return 0;
//         if (o1.getPrice() < o2.getPrice())
//            return 1;
//        else if (o1.getPrice() > o2.getPrice())
//            return -1;
//        return 0;
//        else
//            return +1;
        return Double.compare(o1.getPrice(), o2.getPrice());

    }
}
