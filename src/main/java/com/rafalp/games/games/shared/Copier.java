package com.rafalp.games.games.shared;

import org.springframework.util.SerializationUtils;

public class Copier {

    public static <T> T deepCopie(T t){
        byte[] stream = SerializationUtils.serialize(t);
        return (T)SerializationUtils.deserialize(stream);
    }
}
