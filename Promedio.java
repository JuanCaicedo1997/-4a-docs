import java.util.Scanner;
import java.util.ArrayList;

public class Promedio {
    public String user;
    public int evaluacion;
    
    //Constructor
    
    public Promedio(String user, int evaluacion){
        this.user = user;
        this.evaluacion = evaluacion;
           
    }
    
    public static double[] leerNotas (int evaluacion){
        Scanner sc = new Scanner(System.in);
        double[] nota= new double[evaluacion];
        
        for (int i=1;i<=evaluacion;i++){
            System.out.print("Digite nota "+i+": ");
            nota[i-1]=sc.nextDouble();
        }
        
        return nota;
    }
    
    public static double[] leerPorcentajes (int evaluacion){
        Scanner sc = new Scanner(System.in);
        double[] Porcentajes= new double[evaluacion];
        
        for (int i=1;i<=evaluacion;i++){
            System.out.print("Digite porcentaje "+i+": ");
            Porcentajes[i-1]=sc.nextDouble();
        }
        
        return Porcentajes;
    }
    
    public void resultado(double[] notas, double[] porcentaje, int evaluacion){
        double numerador=0;
        double denominador=0;
        
        for(int i=0;i<evaluacion;i++){
            numerador = numerador + notas[i]*porcentaje[i];
            denominador = denominador + porcentaje[i];
        }
        
        double promedio = numerador/denominador;
        
        System.out.println("Hola "+user+", las calificaciones de esta materia son "+evaluacion+" y su promedio en la materia es de: "+promedio);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite su nombre: ");
        String user = sc.nextLine();
        System.out.print("Digite el número de pruebas: ");
        int evaluacion = sc.nextInt();
        
        Promedio usuario1 = new Promedio(user, evaluacion);
        
        double[] nota=usuario1.leerNotas(evaluacion);
        double[] porcentaje=usuario1.leerPorcentajes(evaluacion);
        
        usuario1.toString();
        usuario1.resultado(nota,porcentaje,evaluacion);
             
    }
}
