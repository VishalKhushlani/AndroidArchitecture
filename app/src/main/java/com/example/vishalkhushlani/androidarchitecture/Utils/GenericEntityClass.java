package com.example.vishalkhushlani.androidarchitecture.Utils;

import java.util.ArrayList;

public class GenericEntityClass<T> {

    public GenericEntityClass() {
        }

    private T object;
    private ArrayList<T> arrayList;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public ArrayList<T> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }
}
