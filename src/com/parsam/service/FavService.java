package com.parsam.service;

public class FavService {
    private static FavService service = new FavService();
    public static FavService getService() {return service;}
    private FavService(){}


}
