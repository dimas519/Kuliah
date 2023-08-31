
package latihan.pbo;

import java.io.IOException;

public class LatihanPbo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        tester<Integer> test1 = new tester();
        
        int s=test1.test2(1);
//        String l=test1.test2("dfaf");
        
        System.out.println(s);
//        System.out.println(l);
        
    }


}

class tester<t> {
    
    
    public  t test2  (t s ) throws IOException{
        return s;
    }
      
        
    }
    
    
    

