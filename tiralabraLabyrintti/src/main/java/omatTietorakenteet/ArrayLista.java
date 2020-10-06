
package omatTietorakenteet;


public class ArrayLista {

    private int koko;
    private Object[] lista;
    int vikai;
    public ArrayLista(int koko){
        lista = new Object[koko];
        vikai = 0;
        koko = 0;
    }

    public void lisaa(Object o){
        lista[vikai] = o;
        vikai++;
        koko++;
    }

    public Object hae(Object ob){

      for(Object o : lista){
          if (o.equals(ob)){
              return o;
          }

      }
return null;



    }


    public void poista(Object ob){

        for (int i = 0; i < koko; i++) {
            if(lista[i].equals(ob)){
                koko--;
                    siirraVasemmalle(i);


            }
        }

    }


    private void siirraVasemmalle(int index){
        for (int i = index+1; i <= koko; i++) {
            lista[i-1] = lista[i];

        }

        vikai--;


    }



    public int GetKoko(){
        return koko;
    }

    public String toString(){
        String s = "";

        for (int i = 0; i < koko; i++) {
            s += lista[i];
        }

        return s;
    }







}
