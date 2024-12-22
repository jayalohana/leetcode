class Solution {
    public int romanToInt(String s) {
            // Mapping of Roman numerals to their integer values
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int total = 0; // Variable to store the final result
        int prevValue = 0; // Variable to track the value of the previous numeral

        // Iterate through the string from left to right
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int currentValue = romanMap.get(currentChar);

            // If the previous value is less than the current value, handle subtractive notation
            if (prevValue < currentValue) {
                total += (currentValue - 2 * prevValue);
            } else {
                total += currentValue;
            }

            // Update the previous value for the next iteration
            prevValue = currentValue;
        }

        return total; // Return the final computed integer value
    }
}