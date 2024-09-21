/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion.Component;

import java.util.Random;

/**
 *
 * @author skevi
 */
public class BoletoGenerator {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    
    public static String generarNumeroSerie() {
        int longitud = 8;
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(index));
        }
        
        return builder.toString();
    }

    public static int generarNumeroControl(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    
    public static void main(String[] args) {
        String numeroSerie = generarNumeroSerie();
        int numeroControl = generarNumeroControl(1000, 9999);
        
        System.out.println("Número de serie generado: " + numeroSerie);
        System.out.println("Número de control del asiento generado: " + numeroControl);
    }
}
