/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaNombre;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Empleado extends Persona{
    
    private int dni;
    private int cuil;
    private Date birthday;
    Scanner sc = new Scanner(System.in);
    
    public Empleado(){
       
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
   }

