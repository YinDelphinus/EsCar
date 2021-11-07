package com.escar.model;

public enum Messenger {
    TELEGRAM,
    VIBER;

    public boolean isRegistered(Integer registeredMessengersMask){
        return ((ordinal() >>> 2) & 1) != 0;
    }
}
