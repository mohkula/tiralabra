
package labyrintti.tiralabralabyrintti;
import java.util.ArrayDeque;
import java.util.Random;

public class Labyrintinluoja {
    
       ArrayDeque<pari> pino = new ArrayDeque<pari>();
       boolean[][] kayty;
       Random rand = new Random();
         int[][] uusiLaby;
       
    
    public int[][] peruuttavaHaku(int[][] laby){
         uusiLaby = new int[laby.length][laby.length];
        for (int i = 0; i < uusiLaby.length; i++) {
            for (int j = 0; j < uusiLaby.length; j++) {
                uusiLaby[i][j] = laby[i][j];
            }
        }
        
        kayty = new boolean[laby.length][laby.length];
        
        
//        pino.push(1);
//                pino.push(2);
//
//                        pino.push(3);
//
//        
//        System.out.println(pino.pop());
//         System.out.println(pino.pop());
//          System.out.println(pino.pop());
          
    pino.add(new pari(0,0));
    kayty[0][0] = true;
    while(!pino.isEmpty()){
    int r = rand.nextInt(4);
    
    pari p = pino.peek();
    
    switch(r){
        case 0:
            
           if (suunta('o',p)){
               
           }
           
           else if(suunta('y',p)){
              
           }
           
           else if(suunta('v',p)){
               
           }
               
               
             else if(suunta('a',p)){
               
           }
           
             else{
                 pino.pop();
             }
            
            
            break;
            
        case 1:
           if (suunta('y',p)){
               
           }
           
           else if(suunta('v',p)){
              
           }
           
           else if(suunta('a',p)){
               
           }
               
               
             else if(suunta('o',p)){
               
           }
           
             else{
                 pino.pop();
             }
            break;
            
        case 2:
             if (suunta('v',p)){
               
           }
           
           else if(suunta('a',p)){
              
           }
           
           else if(suunta('o',p)){
               
           }
               
               
             else if(suunta('y',p)){
               
           }
           
             else{
                 pino.pop();
             }
           
            break;
            
        case 3:
             if (suunta('a',p)){
               
           }
           
           else if(suunta('o',p)){
              
           }
           
           else if(suunta('y',p)){
               
           }
               
               
             else if(suunta('v',p)){
               
           }
           
             else{
                 pino.pop();
             }
            break;
    }
    }
    
    
    
    
//        for (int i = 0; i < kayty.length; i++) {
//            
//            for (int j = 0; j < kayty.length; j++) {
//                if(kayty[i][j]){
//                    System.out.print("T ");
//                }
//                else{
//                    System.out.print("E ");
//                }
//            }
//            System.out.println("");
//            
//        }
    

    

    
        return uusiLaby;
    }
    
    public int[][] getLaby(){
        return uusiLaby;
    }
    
    
    private boolean suunta(char s,pari p){
        if(s == 'o'){
            if(p.x+3 < uusiLaby.length){
            if(!kayty[p.x+3][p.y]){
                kayty[p.x+3][p.y]=true;
                pino.add(new pari(p.x+3,p.y));
                
                poistaSeinat(p.x+2, p.y);
                poistaSeinat(p.x+2, p.y+1);
                
                
                return true;
            }
            
            return false;
            
           
            
            }
            return false;
        }
        
        else if(s=='y'){
                           if(p.y-3 > 0){
            if(!kayty[p.x][p.y-3]){
                kayty[p.x][p.y-3]=true;
                pino.add(new pari(p.x,p.y-3));
                
                 poistaSeinat(p.x, p.y-1);
                poistaSeinat(p.x+1, p.y-1);
                
                
                return true;

            }
            return false;
            
            }
                           return false;
        }
        
        else if(s == 'v'){
                           if(p.x-3 > 0){
            if(!kayty[p.x-3][p.y]){
                kayty[p.x-3][p.y]=true;
                pino.add(new pari(p.x-3,p.y));
                
                   poistaSeinat(p.x-1, p.y);
                poistaSeinat(p.x-1, p.y+1);
                
                return true;

            }
            return false;
            
            }
                           return false;
            
        }
        
        else if(s=='a'){
                          if(p.y+3 < uusiLaby.length){
            if(!kayty[p.x][p.y+3]){
                kayty[p.x][p.y+3]=true;
                pino.add(new pari(p.x,p.y+3));
                
                   poistaSeinat(p.x, p.y+2);
                poistaSeinat(p.x+1, p.y+2);
                
                return true;

            }
            return false;
            
            }
                           return false;
        }
        
        else{
            System.out.println("ei oikea suunta");
        }
    return false;}
    
 private void poistaSeinat(int x, int y){

     
    uusiLaby[x][y] = 0;
}
    
    
}




class pari{
    int x,y;
    
    
    public pari(int x,int y){
        this.x = x;
        this.y = y;
    }
}

