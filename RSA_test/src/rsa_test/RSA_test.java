

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_test;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;




public class RSA_test {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
         int r , n;
         //int p, q;
         double m;
         
            
         Scanner scan = new Scanner(System.in);
         //System.out.print("Enter p: "); 
         //p = scan.nextInt();
         //System.out.print("Enter q: ");
         //q = scan.nextInt();
         System.out.print("Enter your Messege: ");
         m = scan.nextInt();
         
         if(m <= 0 || m > Integer.MAX_VALUE){
         
             System.out.println("Messege is empty or too long");
             return;
         }
         


         
         final int num11 = GenerateRandomPrime(1,20,0);
         System.out.println(num11);
         final int num22 = GenerateRandomPrime(1,20,num11);
         System.out.println(num22);
         //Integer num11 = RandomP();
         //Integer num22 = RandomQ();
         //if (num11 == null || num22 == null){
           //  System.out.println("its composite");
             
         //}
         //double num3 = RandomM(99, 10000);
         
         //int num11 = (int) num1;
         //int num22 = (int) num2;
         //int num33 = (int) num3;
         boolean canBeEncDec = num11 != num22 && num11!= m && num22!= m;
         if(!canBeEncDec){
             System.out.println("Message cannot be encrypted or decrypted.");
         }
         while (canBeEncDec){
         
         if ((num11 * num22) > m){
         
         r = (num11-1) * (num22-1);
         n = num11 * num22;
          
         
        System.out.println("R equals : " + r);
        System.out.println("N equals : " + n);
        
       
        
        
        
            double num = RandomInteger(1, r);
            int num4 = (int) num;
	   //////Encryption***************
           
            double eea1 = EEA.EEA1(num4, r);
            int eea11 = (int) eea1; 
            System.out.println("K : " + eea11);
        
            
            double eea = EEA.EEA(num4, r);
            int eea0  = (int) eea;
            System.out.println("Xk : " + eea0);
            
            double X = Math.pow(-1, eea1) * eea0;
            double D = X + r;
            int D1 = (int) D;
            
            System.out.println("Public Key : " + "(n : " + n + " ,e : " + num4 + ")");
            System.out.println("Secret Key : " + D1);
            
            double C = Math.pow(m, num4) % n;
            int C1 = (int) C;
            System.out.println("Encryption : " + C1);
         
            ////////Decryption******//////////////
            
            double eea2 = EEA.EEA2(num11, num22);
            int eea22 = (int) eea2;
            System.out.println("Yk : " + eea22);
            
            double eea3 = EEA.EEA3(num11, num22);
            int eea33 = (int) eea3;
            System.out.println("Xk : " + eea33);
            
            
            double Mp = Math.pow(C, (D % (num11-1))) % num11;
            double Mq = Math.pow(C, (D % (num22-1))) % num22;
            
            int Mp1 = (int) Mp;
            int Mq1 = (int) Mq;
            
            double X1 = Math.pow(-1, eea1) * eea3;
            double Y1 = Math.pow(-1, (eea1+1)) * eea2;
            
            int X11 = (int) X1;
            int Y11 = (int) Y1;
            
            double M1 = ((Mp1 * Y11 * num22) + (Mq1 * X11 * num11)) % n;
            
            int M11 = (int) M1;
            
            System.out.println("Decryption : " + Math.abs(M11));
            
         
         }
         
         else{
         
                         
         r = (num11-1) * (num22-1);
         n = num11 * num22;
          
         
        System.out.println("R equals : " + r);
        System.out.println("N equals : " + n);
        
       
        
        
        
            double num = RandomInteger(1, r);
            int num4 = (int) num;
	   //////Encryption***************
           
            double eea1 = EEA.EEA1(num4, r);
            int eea1i = (int) eea1;
            System.out.println("K : " + eea1i);
        
            
            double eea = EEA.EEA(num4, r);
            int eeai = (int) eea;
            System.out.println("Xk : " + eeai);
            
            double X = Math.pow(-1, eea1) * eea;
            double D = X + r;
            int D1 = (int) D;
            
            System.out.println("Public Key : " + "(n : " + n + " ,e : " + 5 + ")");
            System.out.println("Secret Key : " + D1);
            
            double C = Math.pow(m, num4) % n;
            int Ci = (int) C;
            System.out.println("Encryption : " + Ci);
         
         }
         break;
         }
         
        
    }
    
  
    
        
      private static boolean isPrime(double inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0) 
            return inputNum == 2 || inputNum == 3; 
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0)) 
            divisor += 2; 
        return inputNum % divisor != 0; 
    }
      
      
      public static int GenerateRandomPrime(int min, int max, int repeat){
      
      Random rand = new Random();
         int val = Math.abs(rand.nextInt(max)) + 1;
         
         
          while (!isPrime1(val, 1000)) {
              val = Math.abs(rand.nextInt(max)) + 1;
          }
          if (val == repeat) {
              val = GenerateRandomPrime(min, max, repeat);
          }

      return val;
      
      }
      
      
       public static boolean isPrime1(long n, int iteration)
    {
        
        if (n == 0 || n == 1)
            return false;
        
        if (n == 2)
            return true;
        
        if (n % 2 == 0)
            return false;
 
        long s = n - 1;
        while (s % 2 == 0)
            s /= 2;
 
        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {

            long r = Math.abs(rand.nextLong());            
            long a = r % (n - 1) + 1, temp = s;
            long mod = modPow(a, temp, n);
            while (temp != n - 1 && mod != 1 && mod != n - 1)
            {
                mod = mulMod(mod, mod, n);
                temp *= 2;
            }
            if (mod != n - 1 && temp % 2 == 0)
                return false;
        }
        return true;        
    }
    /** Function to calculate (a ^ b) % c **/
    public static long modPow(long a, long b, long c)
    {
        long res = 1;
        for (int i = 0; i < b; i++)
        {
            res *= a;
            res %= c; 
        }
        return res % c;
    }
    /** Function to calculate (a * b) % c **/
    public static long mulMod(long a, long b, long mod) 
    {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }
      
      
      
     /*    private static Integer RandomP(){
                
             
       Random rand = new Random();

       double a = rand.nextInt(10) + 1;      
       double n = rand.nextInt(10) + 1;  
      
        double d = n - 1 % 2;
        double s = Math.log(n - 1 / d);
        double S = s - 1;
        int S1 = (int) S;
        
        //double myarray[] = {};
        for (int r = 0; r < S1; r++){
          
                    
            //myarray[r] = r;
            double a1 = Math.pow(2, r) * d;    
            if((Math.pow(a, d) % n) != 1 || (Math.pow(a, a1)) % n != -1){
                return null;
            }
        }
        
        int a1 = (int) a;
        System.out.println(a1);
        return a1;

    
         }*/
         /*private static Integer RandomQ(){
                
             
       Random rand = new Random();

       double a = rand.nextInt(10) + 1;      
       double n = rand.nextInt(10) + 1;  
      
        double d = n - 1 % 2;
        double s = Math.log(n - 1 / d);
        double S = s - 1;
        int S1 = (int) S;

        for (int r = 0; r < S1; r++){
            double a1 = Math.pow(2, r) * d; 
            if ((Math.pow(a, d) % n != 1 || (Math.pow(a,(Math.pow(2, a1) * d))) % n != -1)){
                return null;
            }
       
        }
        
        int n1 = (int) n;
        System.out.println(n1);
        return n1;

    
         }  
      */
        
              /*public static double RandomP(int min, int max){
        
                  
            Random O = new Random();
            int num1 = O.nextInt(max) + 1;
              while (isPrimeorNo()) {          
            num1 = O.nextInt(max) + 1;
                }
        System.out.println(num1);
            return num1;
        
        }
     */
    /*public static double RandomQ(int min, int max){
        
        
            Random O1 = new Random();
            int num2 = O1.nextInt(max) + 1;
              while (isPrimeorNo()) {          
            num2 = O1.nextInt(max) + 1;
                }
        System.out.println(num2);
            return num2;
        
        }
    */
     /*public static double RandomM(int min, int max){
        
        
            Random O2 = new Random();
            int num3 = O2.nextInt(max) + 1;
              while (!isPrime(num3)) {          
            num3 = O2.nextInt(max) + 1;
                }
        System.out.println(num3);
            return num3;
        
        }
       */ 
        public static double RandomInteger(int min, int max){
             
            Random x = new Random();
            int num = x.nextInt(max) + 1;
            while (!isPrime(num)) {          
            num = x.nextInt(max) + 1;
        }
            
           System.out.println(num);
            return num;
            
         }
        
    

    
    
    
}

    
    
    




          
         
        