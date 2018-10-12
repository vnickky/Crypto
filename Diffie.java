/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diffie;
import java.util.Random;
import java.math.*;
import java.util.Scanner;

/**
 *
 * @author deathcandy
 */
public class Diffie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand=new Random();
        int p=rand.nextInt(100000);
        while((p==1||p==0)||(p==2))
        {
            
            p=rand.nextInt(100000);
        }
        p=primeMaker(p);
        int alpha=Primitive(p);
        System.out.println("Initial prime is "+p);
        System.out.println("Primitive root of "+p+" is "+alpha);
        
        int Xa=rand.nextInt(p-1);
        while(Xa==0)
        {
            Xa=rand.nextInt(50);
        }
        int Xb=rand.nextInt(p-1);
        while(Xb==0)
        {
            Xb=rand.nextInt(50);
        }
        if(Xa==Xb)
        Xb=XaXbDifferent(Xa,Xb,p);
        System.out.println("Private keys of Sender and Receiver are respectively "+Xa+" "+Xb+" ");
        BigInteger Ya,Yb,Ka,Kb;
        Ya=((BigInteger.valueOf(alpha)).pow(Xa));
        Ya=Ya.mod(BigInteger.valueOf(p));
        Yb=((BigInteger.valueOf(alpha)).pow(Xb));
        Yb=Yb.mod(BigInteger.valueOf(p));
        Ka=(Yb.pow(Xa)).mod(BigInteger.valueOf(p));
        Kb=(Ya.pow(Xb)).mod(BigInteger.valueOf(p));
      //  int ka=intValue(Ka);
        System.out.println("Sender Key is "+Ka);
        System.out.println("Receiver key is "+Kb);
        if(Ka.intValue()==Kb.intValue())
        {
            System.out.println("Diffie Hellman algorithm working fine !...");
        }
        
    }
    
    public static int XaXbDifferent(int Xa,int Xb,int p)
    {  
        Random rand=new Random();
        if(Xa==Xb)
        {
            Xb=rand.nextInt(p-1);
            XaXbDifferent(Xa,Xb,p);
        }
        else
            return Xb;
        return Xb;
    }
    public static int primeMaker(int k)
   {
       if(primeChecker(k)!=-1)
       {
           return k;
       }
       else
       {
           
           return primeMaker(k+1);
           
       }
       
   }
    public static int primeChecker(int n)
    {
        int c=0;
        for(int i=2;i<n;i++)
        {
            if(n%i==0)
            {
                c=-1;
                break;
            }
            else
            {
                c++;
            }
            
        }
        return c;
    }
    public static int Primitive(int n)
    {
        int alpha=0;
        BigInteger []b=new BigInteger[n-1];
        int []a=new int[n-1];
        for(int i=2;i<n;i++)
        {
            int c=0;
            for(int j=1;j<n;j++)
            {
                b[j-1]=(BigInteger.valueOf(i).pow(j)).mod(BigInteger.valueOf(n));
            }
            for(int j=1;j<n;j++)
            {
               a[j-1]=b[j-1].intValue();
            }
     
               sort(a, 0, a.length-1); 
        
       for(int j=1;j<n-1;j++)
            {
                if(a[j-1]==a[j])
                {
                    c=-1;
                    break;
                }
                else
                    c=0;
                        
            }
        if(c==0)
        {   alpha=i;
            break;
           
        }   
        }
        
        return alpha;
    }
    
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    }
    
    public static void merge(int arr[], int l, int m, int r)
    {
             // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    }
}

