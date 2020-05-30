/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa_test;



/**
 *
 * @author Mohsen
 */
public class EEA {
    
    public static double EEA(double a, double b){

        
          


	double RkOld  =  a,	 XkOld  =  1,		YkOld  =  0;
	double RkCur  =  b, 	XkCur  =  0, 		YkCur  =  1;
	double RkNew  =  0, 	XkNew  =  0, 		YkNew  =  0;

	while (0 < RkCur){
		double Qk1 = RkOld / RkCur;
                int Qk = (int) Qk1;
			
        RkNew = RkOld - Qk*RkCur; XkNew = XkOld - Qk*XkCur; YkNew = YkOld - Qk*YkCur;
	RkOld = RkCur;            XkOld = XkCur;            YkOld = YkCur;    
	RkCur = RkNew;            XkCur = XkNew;            YkCur = YkNew; 



			}

		
                
//                System.out.println(Math.abs(XkOld));
                return Math.abs(XkOld);
                



}
    
    
    
    
    public static double EEA1(double a, double b){

        
	double RkOld  =  a,	XkOld  =  1,		 YkOld  =  0;
	double RkCur  =  b, 	XkCur  =  0, 		YkCur  =  1;
	double RkNew  =  0, 	XkNew  =  0, 		YkNew  =  0;

        int count = 0;
	while (0 < RkCur){
		double Qk1 = RkOld / RkCur;
                int Qk = (int) Qk1;
			
    RkNew = RkOld - Qk*RkCur;  	XkNew = XkOld - Qk*XkCur;  YkNew = YkOld - Qk*YkCur;
    RkOld = RkCur;              XkOld = XkCur;         	YkOld = YkCur;    
    RkCur = RkNew;             	XkCur = XkNew;         	YkCur = YkNew; 
                  
                  count++;


			}

			
		
                
                
//                System.out.println(count);
                return count;



}
    
   public static double EEA2(double a , double b){
   
   
   
	double RkOld  =  a,	XkOld  =  1,		YkOld  =  0;
	double RkCur  =  b, 	XkCur  =  0, 		YkCur  =  1;
	double RkNew  =  0, 	XkNew  =  0, 		YkNew  =  0;

        
	while (0 < RkCur){
		double Qk1 = RkOld / RkCur;
                int Qk = (int) Qk1;
			
    RkNew = RkOld - Qk*RkCur;  	XkNew = XkOld - Qk*XkCur;   YkNew = YkOld - Qk*YkCur;
    RkOld = RkCur;              XkOld = XkCur;              YkOld = YkCur;    
    RkCur = RkNew;             	XkCur = XkNew;              YkCur = YkNew; 
                  
                


			}

	    
                
                
                return Math.abs(YkOld);


   
   } 
   
   
      public static double EEA3(double a , double b){
   
   
   
	double RkOld  =  a,	XkOld  =  1,		YkOld  =  0;
	double RkCur  =  b, 	XkCur  =  0, 		YkCur  =  1;
	double RkNew  =  0, 	XkNew  =  0, 		YkNew  =  0;

        
	while (0 < RkCur){
		double Qk1 = RkOld / RkCur;
                int Qk = (int) Qk1;
			
	 RkNew = RkOld - Qk*RkCur;  	XkNew = XkOld - Qk*XkCur;  YkNew = YkOld - Qk*YkCur;
	 RkOld = RkCur;               	XkOld = XkCur;         	YkOld = YkCur;    
	 RkCur = RkNew;             	XkCur = XkNew;         	YkCur = YkNew; 
                  
                


			}

	    
                
                
                return Math.abs(XkOld);


   
   } 
    
    
    
}