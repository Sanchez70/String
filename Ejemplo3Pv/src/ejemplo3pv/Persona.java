/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3pv;


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author KEVIN SANCHEZ
 */
public class Persona {

    private String nombre1;
    private String primerApellido;
    private String segundoApellido;
    static ArrayList<Persona> lista = new ArrayList<Persona>();

    public Persona() {
    }

    public Persona(String nombre1, String primerApellido, String segundoApellido) {
        this.nombre1 = nombre1;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre1=" + nombre1 + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + '}';
    }

    public static void leerTxt(String direccion) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String datos[];
            String bfread;
              Instant inicio = Instant.now();
            while ((bfread = bf.readLine()) != null) {
                datos = bfread.split(" ");
                Persona nuevo = new Persona();
                nuevo.setNombre1(datos[0]);
                nuevo.setPrimerApellido(datos[1]);
                nuevo.setSegundoApellido(datos[2]);
                lista.add(nuevo);

            }
            NewJFrame.tiempo.setText("El tiempo de lectura del archivo txt fue: " + String.valueOf(ChronoUnit.MILLIS.between(inicio, Instant.now())) + " MILLIS");

        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }
    }

}
