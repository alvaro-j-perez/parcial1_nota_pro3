package gt.edu.umg.progra3.parcial1.pilas;

import java.util.Arrays;
import java.util.Collections;

public class NotationParser {

   private Pila pila1;
    private Pila pila2 = new PilaImplement();

    public NotationParser(Pila pila) {
        this.pila1 = pila;
    }

    public String posFixToInfix(String expression){ // aqui recibe la funcion desordenada
        pila1 = StringToPila(expression);//convierte el string a una pila
        return PostFijo(pila1);
    }
    private Pila StringToPila(String cadena){// recibe la cadena del string
        Pila resul = new PilaImplement();//y crea una nueva pila
        String[] strArray = cadena.split(" ");//este metodo separa los caracteres que se estan pasando
        Collections.reverse(Arrays.asList(strArray));//funcion que invierten los datos
        for(String x:strArray){
            resul.push(x);
        }
        return resul;
    }
    private String PostFijo(Pila pila){
        String Signo, Numero;
        String Resultado = "";
        while(!pila.isEmpty()){
            pila2.push(pila1.pop());
            String ultimo = pila2.peek();

            //esta funcion lo que hace es que ordena de la manera en que quiero que me duvuelva los datos
            //
            if(ultimo.equals("+")||ultimo.equals("*")||ultimo.equals("-")||ultimo.equals("/")){
                Signo = pila2.pop();
                Numero = pila2.pop();
                pila2.push(Signo);
                pila2.push(Numero);
            }
        }
        Resultado = pilaToString(pila2);
        return Resultado;
    }

    //convierte la pila ya ordena a un string
    private String pilaToString(Pila pila){
        int t = pila.size();
        String resultado = "";
        resultado = pila.pop()+resultado;

        //este for recorre todos lo valores y los va metiendo en el resultado final
        //convierte la pila a un string
        for(int x = 0;x<t-1;x++){
            resultado = pila.pop()+" "+resultado;
        }
        return resultado;
    }
}