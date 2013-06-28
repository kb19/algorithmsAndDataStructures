package _Tests;

//http://stackoverflow.com/questions/9880786/build-a-max-heap-for-an-array
public class Heap 
{
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
    
    public static void buildheap(int []a){
        n = a.length - 1;
        
        for(int i = n / 2; i >= 0; i--) {
            maxheap(a,i);
        }
    }	
    
    public static void maxheap(int[] a, int i){ 
        left = 2 * i + 1;
        right = 2 * i + 2;
        
        // Find the largest between the left, right and i indexes
        // and swap it with the element we are looking at
        if(left <= n && a[left] > a[i]) {
            largest=left;
        }
        else {
            largest=i;
        }
        
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        
        if(largest != i){
            swap(i,largest);
            maxheap(a, largest);
        }
    }
    
    public static void swap(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
    }
    
    public static void sort(int []a0){
        a=a0;
        buildheap(a);
        
        for(int i = n; i > 0; i--) {
            swap(0, i);
            
            n = n-1;
            
            maxheap(a, 0);
        }
    }
    
    public static void main(String[] args) {
        int []a1={4,1,3,2,16,9,10,14,8,7};
        
        sort(a1);
        
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
    }
}