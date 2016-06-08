package pruebacerticamara;

import java.util.Scanner;

/**
 *
 * @author james
 */
public class PruebaCerticamara {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
        int filas=0;
        int columnas=0;
        int posicionActualX=0;
        int posicionActualY=0;
        
        System.out.print("\nDigite tamaño de la matrix filas: ");
        filas=in.nextInt();
        System.out.print("\nDigite tamaño de la matrix columnas: ");
        columnas=in.nextInt();
        
        //int  [][] matriz = new int [filas][columnas];
        
        ControlRemoto cr = new ControlRemoto(posicionActualX,posicionActualY,filas,columnas);
        
        String ruta="";
        int  op =0;
        String menu="";
        do{
            menu="\n";
            menu+="****** Opciones ******\n";
            menu+="1. Nueva posicion \n";
            menu+="2. Salir \n";
            menu+="Elia una opción: ";
            System.out.print(menu);
            
            op=PruebaCerticamara.opcion(in.next());
            
            if(op==1){
                System.out.print("\n Digite rutas: ");
                ruta=in.next();
                String[] posiciones = ruta.split(";");
                if(posiciones.length == 0){
                    System.out.println("No se ingresaron rutas");                    
                }
                
                cr.ControlRemoto(posiciones);                
            }
        }while(op!=2);
        
    }
    
    public static int opcion(String str){  
        int d=0;
        try {  
            d = Integer.parseInt(str);  
        }  
        catch(NumberFormatException nfe){ 
            System.out.println("Opcion incorrecta");
            return 0;  
        }  
        return d;  
    }
}
