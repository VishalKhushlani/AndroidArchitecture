package com.example.vishalkhushlani.androidarchitecture.Utils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GenericBaseEntity<T> {

    @SerializedName("result")
    ArrayList<T> result;

    public ArrayList<T> getResult() {
        return result;
    }

}
