package slidingwindow;

public class FindLongestRepeatingReplacementFunction {
	// Sliding window methods
    public int characterReplacement(String s, int k) {
        int start = 0;
        int currentBiggest = 0;
        
        // Since only A-Z
        int[] map = new int[26];
        
        // Start will only move when we can't replace to get the max anymore
        for(int end = 0; end < s.length(); end++){
            map[s.charAt(end) - 'A']++;
            
            currentBiggest = Math.max(currentBiggest, map[s.charAt(end) - 'A']);
            
            // currentBiggest + k is the limit of current sliding windows
            if(currentBiggest + k < end - start + 1){
                map[s.charAt(start) - 'A']--;
                start++; 
            }
        }
        
        return s.length() - start;
    }
    
    // A longer way of sliding windows, using extra space to store the max length
    public int characterReplacement1(String s, int k) {
        int maxCurrentUniqueCount = 0;
        int start = 0;
        int maxLength = 0;
        
        // Since only cap letters from A-Z
        int[] counts = new int[26];
        
        // Start and end sliding window
        for(int end = 0; end < s.length(); end++){
            counts[s.charAt(end) - 'A']++;
            
            // Current largest unique letter
            maxCurrentUniqueCount = Math.max(maxCurrentUniqueCount, counts[s.charAt(end) - 'A']);
            
            // If we already reach the max window, move the start pointer now
            if(end - start + 1 - maxCurrentUniqueCount > k){
                counts[s.charAt(start)- 'A']--;
                
                start++;
            }
            
            // Keep track of the max counts
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
