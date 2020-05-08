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
           int dni = sc.nextInt();
           e.setDni(dni);
       
       }
       
       public void pedirCuil(){
           System.out.println("Por favor ingrese su número de CUIL");
           int cuil = sc.nextInt();
           e.setCuil(cuil);
           
       }
       
       public void pedirFechaNacimiento(){
 
        try {
            BufferedReader fecha = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fechaNacimieto = new BufferedReader(fecha);
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
            SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Por favor ingrese su fecha de nacimiento con el siguiente formato: dd-MM-yyyy");
            String fechita = fecha.readLine();
            Date birthday = null;
            String date = fechita;
            
            
            try {
                birthday = sfd.parse(date);
                e.setBirthday(birthday);
                
                
                
                
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
         
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         
 
       
       }
       
       public void darEdad(){
               Date calendario = new Date();
               DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
               int diaActual = calendario.getDate();
               int mesActual = calendario.getMonth()+1;
               int anioActual = calendario.getYear();
               int edad2 = 0;
               int edad = anioActual - e.getBirthday().getYear();
                
               if(e.getBirthday().getDate()>diaActual){
                   if(e.getBirthday().getMonth()>=mesActual){
                       if(anioActual>e.getBirthday().getYear()){
                           edad--;
                       }
                   }
               }
               
               System.out.println("Tu edad es:" + edad + "\n¡GRACIAS POR REGISTRARSE!");
       }
    public void imprimirRegistro(){
        
        String confirmar = "si";
        
        String negar = "no";
        
        int month = e.getBirthday().getMonth() + 1;
        
        
        String resultado = sc.nextLine();
        
        System.out.println("Usted se ha registrado con los siguientes datos: " +
                "\nNombre: "  + p.getName() +
                "\nApellido: " + p.getLastName() +
                "\nNúmero de teléfono: " + p.getPhoneNumber() +
                "\nNumero de documento: " + e.getDni() +
                "\nNúmero de CUIL: " + e.getCuil() +
                "\nFecha de nacimiento: " + e.getBirthday().getDate()+ "-" + month +"-" + e.getBirthday().getYear());
        System.out.println("¿Confirma que los datos ingresados son correctos?"+
                "Confirme con un 'Si', caso contrario indique un 'No'"); 
        resultado = sc.nextLine();
        if(resultado.equalsIgnoreCase(confirmar) == true){
            
            System.out.println("Usted se ha registrado con los siguientes datos: " +
                "\nNombre: " + p.getName().toUpperCase() +
                "\nApellido: " + p.getLastName().toUpperCase() +
                "\nNúmero de teléfono: " + p.getPhoneNumber() +
                "\nNúmero de documento: " + e.getDni() +
                "\nNumero de CUIL: " + e.getCuil() +
                "\nFecha de nacimiento: " + e.getBirthday().getDate() + "-"+ month + "-" + e.getBirthday().getYear());
        
        }else if
                (resultado.equalsIgnoreCase(negar)==true) {
            pedirNombre();
            pedirApellido();
            pedirTelefono();
            pedirDni();
            pedirCuil();
            pedirFechaNacimiento();
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
        rp.pedirFechaNacimiento();
        rp.pedirCuil();
        rp.imprimirRegistro();
        rp.darEdad();
    }
    }
  
       
      
  



