package gt.edu.umg.progra3.parcial1.pilas;

import java.util.Arrays;
import java.util.Collections;

public class NotationParser {

    private Pila pila1;
    private Pila pila2 = new PilaImplement();

    public NotationParser(Pila pila) {
        this.pila1 = pila;
    }

    public String posFixToInfix(String expression){
        pila1 = StringToPila(expression);
        return PostFijo(pila1);
    }
    private Pila StringToPila(String cadena){
        Pila resul = new PilaImplement();
        String[] strArray = cadena.split(" ");
        Collections.reverse(Arrays.asList(strArray));
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
    private String pilaToString(Pila pila){
        int t = pila.size();
        String resultado = "";
        resultado = pila.pop()+resultado;
        for(int x = 0;x<t-1;x++){
            resultado = pila.pop()+" "+resultado;
        }
        return resultado;
    }
}