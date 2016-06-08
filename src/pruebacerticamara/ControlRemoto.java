/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebacerticamara;



/**
 *
 * @author james
 */
public class ControlRemoto {
    
    int posicionActualX;
    int posicionActualY;
    int filas;
    int columnas;
    
    public ControlRemoto(int posicionActualX,int posicionActualY, int filas, int columnas){
        this.posicionActualX=posicionActualX;
        this.posicionActualY=posicionActualY;
        this.filas=filas;
        this.columnas=columnas;
    }
    
    public void ControlRemoto(String[] posiciones){
        for(int i=0;i<posiciones.length;i++){
                                        
            int desplazamiento=0;
            String Direccion= "";

            String[] rutaActual = posiciones[i].split(","); 
            if(rutaActual.length != 2){
                System.out.println("Error en formato de comando");
                break;
            }

            if(esEntero(rutaActual[0]) && (rutaActual[1].equals("N") || rutaActual[1].equals("S") ||
                    rutaActual[1].equals("E") || rutaActual[1].equals("O"))){

                desplazamiento=Integer.parseInt(rutaActual[0]);
                Direccion= rutaActual[1] ;
                System.out.println("\nComando Ejecutado: "+desplazamiento+","+Direccion);
            }
            else{
                System.out.println("Error en formato de comando");
                break;
            }

            if(Direccion.equals("N")) {
                if(desplazamiento>=0 && desplazamiento + posicionActualY<filas){
                    posicionActualY=posicionActualY+desplazamiento;
                    System.out.println("Posicion Actual: "+(posicionActualX)+","+(posicionActualY));
                }
                else{
                    System.out.println("Se ha detenido el avance por salir de los límites");
                    break;
                }
            }
            else if(Direccion.equals("S")){
                if(desplazamiento>=0 && posicionActualY - desplazamiento  >=0){
                    posicionActualY=posicionActualY-desplazamiento;
                    System.out.println("Posicion Actual: "+(posicionActualX)+","+(posicionActualY));
                }
                else{
                    System.out.println("Se ha detenido el avance por salir de los límites");
                    break;
                }
            }
            else if(Direccion.equals("E")){
                if(desplazamiento>=0 && posicionActualX + desplazamiento  <columnas){
                    posicionActualX=posicionActualX+desplazamiento;
                    System.out.println("Posicion Actual: "+(posicionActualX)+","+(posicionActualY));
                }
                else{
                    System.out.println("Se ha detenido el avance por salir de los límites");
                    break;
                }
            }
            else if(Direccion.equals("O")){
                if(desplazamiento>=0 && posicionActualX - desplazamiento  >=0){
                    posicionActualX=posicionActualX-desplazamiento;
                    System.out.println("Posicion Actual: "+(posicionActualX)+","+(posicionActualY));
                }
                else{
                    System.out.println("Se ha detenido el avance por salir de los límites");
                    break;
                }
            }
            else{
                 System.out.println("Error en formato de comando");
                 break;
            }
        }
    }
    
    public static boolean esEntero(String str){  
        try {  
            int d = Integer.parseInt(str);  
        }  
        catch(NumberFormatException nfe){  
            return false;  
        }  
        return true;  
    }
    
}
