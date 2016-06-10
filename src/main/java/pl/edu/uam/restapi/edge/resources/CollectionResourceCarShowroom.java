package pl.edu.uam.restapi.edge.resources;

import pl.edu.uam.restapi.edge.model.Car;
import pl.edu.uam.restapi.edge.model.CarShowroom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-09.
 */
public class CollectionResourceCarShowroom {
    private int count;
    private List<CarShowroom> result = new ArrayList<>();

    public CollectionResourceCarShowroom(List<CarShowroom> result) {
        this.result = result;
        this.count = result.size();
    }

    public List<CarShowroom> getResult() {
        return result;
    }

    public void setResult(List<CarShowroom> result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
