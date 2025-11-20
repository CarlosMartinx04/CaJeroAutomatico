package com.example.cajeroautomatico;

public class Usuario {
    private String Nombre;
    private String Pin;
    private double Saldo;



    public Usuario(String nombre, String pin, double saldo) {
        this.Nombre = nombre;
        this.Pin = pin;
        this.Saldo = saldo;
    }

    public void agregarUsuario(Usuario usuario){

    }

//    public Usuario iniciarSesion(String nombre, String pin){
//        if(!usuarios.containsKey(nombre)){
//            System.out.println("Escribe un usuario correcto");
//        } else {
//            if(!Objects.equals(pin, usuarios.get(nombre).getPin())){
//                Usuario u = usuarios.get(nombre);
//                System.out.println("Accedido con la cuenta: "+u.getNombre());
//                return u;
//            } else {
//                System.out.println("Pin incorrecto");
//            }
//
//        }
//        System.out.println("Inicio Fallido");
//        return null;
//    }

    public String getNombre() {
        return Nombre;
    }

    public String getPin() {
        return Pin;
    }

    public String getSaldo() {
        return String.valueOf(Saldo);
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }
}
