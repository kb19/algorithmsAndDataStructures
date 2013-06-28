package sorting;

public class Sorts {
	/* Insertion sort for integers */

	void insertion( int a[], int n ) {
	/* Pre-condition: a contains n items to be sorted */
	    int i, j, v;
	    
	    /* Initially, the first item is considered 'sorted' */
	    /* i divides a into a sorted region, x<i, and an
	       unsorted one, x >= i */
	    for(i=1; i<n; i++) {
	    	
	        /* Select the item at the beginning of the
	           as yet unsorted section */
	        v = a[i];
	        
	        /* Work backwards through the array, finding where v 
	           should go */
	        j = i;
	        
	        /* If this element is greater than v, move it up one */
	        while ( a[j-1] > v ) {
	          a[j] = a[j-1]; 
	          j = j-1;
	          
	          if ( j <= 0 ) 
	        	  break;
	        }
	        
	        /* Stopped when a[j-1] <= v, so put v at position j */
	        a[j] = v;
	    }
	} 
	
	void bubble( int a[], int n ) {
	/* Pre-condition: a contains n items to be sorted */
	    int i, j;
	    /* Make n passes through the array */
	    for(i=0;i<n;i++)
	        {
	        /* From the first element to the end
	           of the unsorted section */
	        for (j=1; j<(n-i); j++)
	           {
	           /* If adjacent items are out of order, swap them */
	           if( a[j-1]>a[j] ) {
	        	   int t; 
	        	   t=a[j-1]; 
	        	   a[j-1]=a[j]; 
	        	   a[j]=t;
	        	   
	           }
	           }
	        }
	    }  
	
	public static void SelectionSort ( int [ ] num )
	{
	     int i, j, first, temp;  
	     for ( i = num.length - 1; i > 0; i-- )  
	     {
	          first = 0;   //initialize to subscript of first element
	          
	          for(j = 1; j <= i; j ++)   //locate smallest element between positions 1 and i.
	          {
	               if( num[ j ] < num[ first ] )         
	                 first = j;
	          }
	          
	          temp = num[ first ];   //swap smallest found with element in position i.
	          num[ first ] = num[ i ];
	          num[ i ] = temp; 
	      }           
	}
	
}
