
package omatTietorakenteet;


public class Pino {
    
    int size, ekai;
    Object[] lista;
    public Pino(int koko){
       
        lista = new Object[koko];
        size = 0;
        
    }
    
    
    public void lisaa(Object o){
        if(onkoTyhja()){
            lista[0] = o;
            ekai = 0;
        }
        else{
        lista[ekai +1] = o;
        ekai++;
        }
        
        size ++;
    }
    
    public Object PalautaEka(){
        
        Object o = lista[ekai];
    return o;}
    
    public void poistaEka(){
        
        if(ekai >= 0){
        lista[ekai] = null;
        ekai--;    
        }
        size--;
        
    }
    
    
    
    public boolean onkoTyhja(){
        if(getSize() == 0) return true;
        
        return false;
    }
    
    
    public int getSize(){
        return size;
    }
}

