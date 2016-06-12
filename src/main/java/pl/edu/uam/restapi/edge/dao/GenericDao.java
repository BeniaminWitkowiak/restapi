package pl.edu.uam.restapi.edge.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ben_a_000 on 2016-06-07.
 */
public class GenericDao<T> implements Serializable{
    protected List<T> objects = new ArrayList<>();

    public void save(T t){
        this.objects.add(t);
    }



    public List<T> getAll(){
        return objects;
    }

}
