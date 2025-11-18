package com.example.cajeroautomatico;

import java.util.HashMap;

public class Usuario {
    String Nombre;
    String Pin;
    HashMap<String, String> usuarios = new HashMap<>();

    public Usuario(String nombre, String pin) {
        Nombre = nombre;
        Pin = pin;
    }

    public void agregarUsuario(){
        if(!usuarios.containsKey(Nombre)){

        }
    }

}
