public class Solution {

    public boolean isHappy(int n) {
      	  
 // use ArrayList to check infinite loop, need extra space //
 
        if(n==0) return false;
        
        int happy = n;
        
        List<Integer> happyList = new ArrayList<Integer>();
        
        while(happy!=1)
        {
            int sum = 0;
            
            if(happyList.contains(happy)) return false;
            
            happyList.add(happy);
            
            while(happy>=1)
            {
                sum += Math.pow((happy % 10),2);
                happy = happy / 10;
            }
            happy = sum;
        }
        return true;
    }

/*-----------------------------------------------------------------------*/

    public boolean isHappy(int n) {

// use HashSet to check infinite loop, need extra space //

        Set<Integer> inLoop = new HashSet<Integer>();
        
    	while (inLoop.add(n)) {
    	    
    		int sum = 0;
    		
    		while (n > 0) {
                sum += Math.pow((n % 10),2);
                n = n / 10;
    		}
    		
    		if (sum == 1)	return true;
    		
    		else n = sum;
    
    	}
    	return false;
	
    }
}
