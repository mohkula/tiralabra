
package labyrintti.tiralabralabyrintti;

    import java.util.LinkedList; 
import java.util.Queue; 
public class ReitinHakija {
    
Labyrintti l = new Labyrintti();
int[][] reittiLaby;
    public ReitinHakija(){
        
    }
    
    
    public int[][] LuoReittiLaby(int[][] laby, String reitti,int x, int y){
        reittiLaby = new int[laby.length][laby.length];
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby.length; j++) {
                reittiLaby[i][j] = laby[i][j];
                
            }
        }
        
        for (int i = 0; i < reitti.length(); i++) {
            switch(reitti.charAt(i)){
                
                case 'o':
                    for (int i2 = 0; i2 < 3; i2++) {
                    reittiLaby[y][x] = 3;
                    reittiLaby[y+1][x] = 3;
                    x++;
                    }
                        reittiLaby[y][x] = 3;
                    reittiLaby[y+1][x] = 3;
                      reittiLaby[y][x+1] = 3;
                    reittiLaby[y+1][x+1] = 3;
                   
                    
                    break;
                    
                    case 'y':
                        
                      
                 for (int i2 = 0; i2 < 3; i2++) {
                    reittiLaby[y][x] = 3;
                    reittiLaby[y][x+1] = 3;
                    y--;
                    }
                
                 
                    break;
                    
                    case 'v':
                      
                for (int i2 = 0; i2 < 3; i2++) {
                    reittiLaby[y][x] = 3;
                    reittiLaby[y+1][x] = 3;
                    x--;
                    }
              
                    break;
                    
                    case 'a':
                   for (int i2 = 0; i2 < 3; i2++) {
                    reittiLaby[y][x] = 3;
                    reittiLaby[y][x+1] = 3;
                    y++;
                    }
                       reittiLaby[y][x] = 3;
                    reittiLaby[y][x+1] = 3;
                   reittiLaby[y+1][x] = 3;
                     reittiLaby[y+1][x+1] = 3;
          
                  
                    break;
                
            }
            
            
        }
    return reittiLaby;
    
    
    }
    
    
   
    
    
    
    public String HaeReittiLeveysHaulla(int x, int y, int[][] laby, int maaliX, int maaliY){
        
        
        
        if(laby[y][x] == 1 || laby[maaliY][maaliX] == 1) return null;
        
            boolean[][] kayty = new boolean[laby.length][laby.length];

            Queue<Kulkija> jono   = new LinkedList<>();
            
            Kulkija k = new Kulkija(x,y);
            jono.add(k);
            kayty[x][y] = true;
            
            while(!jono.isEmpty()){
               k = jono.poll();
               
               if(k.x ==  maaliX && k.y == maaliY){
                   return k.getReitti();
               }
                
               if(k.y + 3 < laby.length && laby[k.x][k.y + 2] == 0 && !kayty[k.x][k. y + 3 ]){
                   Kulkija uusiKulkija = new Kulkija(k.x, k.y + 3);
                   String s = k.getReitti();
                   s += 'o';
                   uusiKulkija.lisaaReittiin(s);
//                   System.out.println(k.x + " " + k.y + 'o');
                   jono.add(uusiKulkija);
                   
                   kayty[k.x][k. y + 3 ] = true;
                   
               } 
               
                if( k.x - 3 >= 0 && laby[k.x - 2][k.y] == 0 && !kayty[k.x - 3][k.y]){
                     Kulkija uusiKulkija = new Kulkija(k.x - 3, k.y );
                   String s = k.getReitti();
                   s += 'y';
                   uusiKulkija.lisaaReittiin(s);
//System.out.println(k.x + " " + k.y + 'y');
                   jono.add(uusiKulkija);
                   
                   kayty[k.x -3][k.y] = true;
               } 
                
                 if( k.y - 3 >= 0 &&  laby[k.x][k.y - 2] == 0 && !kayty[k.x][k. y - 3 ]){
                   Kulkija uusiKulkija = new Kulkija(k.x, k.y - 3);
                   String s = k.getReitti();
                   s += 'v';
                   uusiKulkija.lisaaReittiin(s);
//System.out.println(k.x + " " + k.y + 'v');
                   jono.add(uusiKulkija);
                   
                   kayty[k.x][k. y - 3 ] = true;
               } 
                 
                  if( k.x + 3 < laby.length && laby[k.x + 2][k.y] == 0 && !kayty[k.x + 2][k.y ]){
                     Kulkija uusiKulkija = new Kulkija(k.x + 3, k.y);
                   String s = k.getReitti();
                   s += 'a';
                   uusiKulkija.lisaaReittiin(s);
//System.out.println(k.x + " " + k.y + 'a');
                   jono.add(uusiKulkija);
                   
                   kayty[k.x + 3][k.y] = true;
               } 
               
               
            }
            
        
        
        
        System.err.println("Reittiä ei löytynyt");
        
        return null;
    }
    
}

class Kulkija{
    int x, y;
    String reitti;
    
    public Kulkija(int x, int y){
        this.x = x; 
        this.y = y;
        
        reitti = "";
    }
    
    public String getReitti(){
        return reitti;
    }
    
    public void lisaaReittiin(String s){
        reitti += s;
    }
    
    
    
}