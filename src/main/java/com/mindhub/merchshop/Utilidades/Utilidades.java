package com.mindhub.merchshop.Utilidades;

import java.util.Random;

public class Utilidades {

    public static String generarNumeroCompra() {
        Random rand = new Random();
        int num = rand.nextInt(900000000) + 100000000;
        return "AH-" + String.valueOf(num);
    }

}
