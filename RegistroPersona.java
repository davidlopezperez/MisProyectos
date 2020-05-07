package SistemaNombre;


 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class RegistroPersona {
    
    String name;
    String lastName;
    String phoneNumber;
    int validCharacters = 10;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    LocalDate ahora = LocalDate.now();
    Persona p = new Persona();
    Empleado e = new Empleado();
    
    
    
    public void pedirNombre(){
        System.out.println("Ingresa por favor tu nombre");
        name = sc.nextLine();
        p.setName(name);
        
        while(name.isEmpty()){
            System.out.println("El campo nombre no puede estar vacio");
            System.out.println("Ingresa un nombre válido");
            name = sc.nextLine();
            p.setName(name);
        }while(name.length() > validCharacters){
            System.out.println("El campo nombre no puede contener más de 10 caracteres");
            System.out.println("Ingresa un nombre válido");
            name = sc.nextLine();
            p.setName(name);
        }
            
        
        }
    public void pedirApellido(){
        System.out.println("Ingresa por favor tu apellido");
        lastName = sc.nextLine();
        p.setLastName(lastName);
        
        while(lastName.isEmpty()){
            System.out.println("El campo apellido no puede estar vacio");
            System.out.println("Ingresa un apellido válido");
            lastName = sc.nextLine();
            p.setName(lastName);
        }while(lastName.length()>validCharacters){
            System.out.println("El campo apellido no puede contener mas de 10 caracteres");
            System.out.println("Ingresa un apellido valido");
            lastName = sc.nextLine();
            p.setLastName(lastName);
        }
    }
    
    public void pedirTelefono(){
       
        System.out.println("Ingresa por favor tu número de teléfono");
        phoneNumber = sc.nextLine();
        p.setPhoneNumber(phoneNumber);
        
        while(phoneNumber.isEmpty() ){
            System.out.println("El campo número de teléfono no puede estar vacio");
            System.out.println("Ingresa un número de teléfono válido");
            phoneNumber = sc.nextLine();
            p.setPhoneNumber(phoneNumber);
        }while(phoneNumber.length() > validCharacters){
            System.out.println("El campo número de teléfono no puede contener más de 10 caracteres");
            System.out.println("Ingresa un número de teléfono válido");
            phoneNumber = sc.nextLine();
            p.setPhoneNumber(phoneNumber);
            
        }while(isNumeric(phoneNumber) == false){
            System.out.println("El campo número de telefono solo puede contener números");
            System.out.println("Ingrese un número de teléfono válido");
            phoneNumber = sc.nextLine();
            p.setPhoneNumber(phoneNumber);
        }
  
    }
     
       
       public void pedirDni(){
           System.out.println("Por favor ingrese su número de Documento");
           e.setDni(sc.nextInt());
           
       }
       
       public void pedirCUIL(){
           System.out.println("Por favor ingrese su número de CUIL");
           e.setCuil(sc.nextLine());
           
       }
       
       public void pedirFechaNacimiento(){
           
           
        try {
            BufferedReader fecha = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fechaNacimieto = new BufferedReader(fecha);
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
            SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println("Por favor ingrese su fecha de nacimiento con el siguiente formato: yyyy-MM-dd");
            String fechita = fecha.readLine();
            Date birthday = null;
            String date = fechita;
            
            
            try {
                birthday = sfd.parse(date);
                e.setBirthday(birthday);
                
                
                
                
            } catch (ParseException ex) {
                Logger.getLogger(RegistroPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
         
        } catch (IOException ex) {
            Logger.getLogger(RegistroPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
         
 
       
       }
       
       public void darEdad(){
               int edad;
               ahora.getYear();
               edad = ahora.getYear()-1900 - e.getBirthday().getYear(); 
               System.out.println("Tu edad es:" + edad);
               if(edad >= 130){
                   System.out.println("Tu edad es invalida");
                   pedirFechaNacimiento();
               } 
 
       }
    public void imprimirRegistro(){
        
        int resultado = JOptionPane.showConfirmDialog(null, "¿Los datos ingresados son correctos?");
        
        System.out.println("Usted se ha registrado con los siguientes datos: " +
                "\nNombre: "  + p.getName() +
                "\nApellido: " + p.getLastName() +
                "\nNúmero de teléfono: " + p.getPhoneNumber() +
                "\nNumero de documento: " + e.getDni());
        if(resultado == 0){
            
            System.out.println("Usted se ha registrado con los siguientes datos: " +
                "\nNombre: " + p.getName().toUpperCase() +
                "\nApellido: " + p.getLastName().toUpperCase() +
                "\nNúmero de teléfono: " + p.getPhoneNumber() +
                "\nNúmero de documento: " + e.getDni() +
                "\nNumero de CUIL: " + e.getCuil() +
                "\nFecha de nacimiento: " + e.getBirthday().getDate() + "-"+e.getBirthday().getMonth()+1 + "-" + e.getBirthday().getYear()+
                    
                "\n¡GRACIAS POR REGISTRARSE!");
        }else{
            pedirNombre();
            pedirApellido();
            pedirTelefono();
        }
    }
      public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }
    public static void main(String[] args) {
        RegistroPersona rp = new RegistroPersona();
        Persona p = new Persona();
        Empleado e = new Empleado();
        rp.pedirNombre();
        rp.pedirApellido();
        rp.pedirTelefono();
        rp.pedirDni();
        rp.pedirCUIL();
        rp.pedirFechaNacimiento();
        rp.imprimirRegistro();
        rp.darEdad();
        
    }
    }
  
       
      
  



