package com.example.peter.pryanikchallenge.utils;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.peter.pryanikchallenge.Network.InternetConnection;
import com.example.peter.pryanikchallenge.models.Base;
import com.example.peter.pryanikchallenge.models.Data;
import com.example.peter.pryanikchallenge.models.DataStruct;
import com.example.peter.pryanikchallenge.models.Variant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataUtils {

    @Nullable
    private static List<DataStruct> list;

    @Nullable
    public static List<DataStruct> convertToList(Base base) {
        list = new ArrayList<>();
        list = base.getData();
        return list;
    }

    @NonNull
    public static List<String> baseToView(Base base){
        List<String> viewList = new ArrayList<>();
        viewList = base.getView();
        return viewList;
    }

    public static int getStructPosition(String variant, List<DataStruct> list){


        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(variant)){
               return i;
            }
        }
        return 0;
    }

    public static List<String> fillVariants(List<Variant> list){
        final List<String> listVar = new ArrayList<>();
        for(Variant variant: list ){
            listVar.add(variant.getText());
        }
        return listVar;
    }

    public static int getPos(List<String> listVar){
        Random rnd = new Random();
        return rnd.nextInt(listVar.size());
    }

    public static String getVariant(DataStruct dataStruct, int position){
        List<Variant> listVar = dataStruct.getData().getVariants();
        Variant variant = listVar.get(position);
        return variant.getText();
    }

    public static Boolean internetConnection(Context context){

        return InternetConnection.checkConnection(context) ? true : false;
    }




}
