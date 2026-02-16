
class MiscAlgorithms:
    """A class to contain miscellaneous algorithms."""
    def __init__(self):        
        pass

    '''
    Given a string s, return the longest palindromic substring in s.
    Example 1:
    Input: s = "babad"
    Output: "aba"
    Note: "aba" is also a valid answer.

    Steps:
    1. Iterate through each character in the string as a potential center of a palindrome.
    2. For each character, expand around the center to find the longest odd-length palindrome
         and the longest even-length palindrome.
    3. Keep track of the longest palindrome found and its starting and ending indices.
    4. Return the longest palindromic substring using the recorded indices.

    Time Complexity: O(n^2) - In the worst case, we might have to expand around each character and check all characters.
    Space Complexity: O(1) - We are using a constant amount of space to store the indices and the maximum length.
    '''
    def longestPalindrome(self, s: str) -> str:
        """Find the longest palindromic substring in the given string."""
        maximum = 0
        maxL = 0
        maxR = 0
        for i in range(0, len(s)):
            isEven = True
            isOdd = True
            leftOdd = i
            rightOdd = i
            leftEven = i - 1
            rightEven = i
            oddLen = 0
            evenLen = 0
            while (isEven or isOdd):
                if leftOdd < 0 or rightOdd >= len(s):
                    isOdd = False
                if leftEven < 0 or rightEven >= len(s):
                    isEven = False
                if isOdd:
                    if s[leftOdd] == s[rightOdd]:
                        if oddLen == 0:
                            oddLen = 1
                        else:
                            oddLen += 2
                        leftOdd -= 1
                        rightOdd += 1
                    else:
                        isOdd = False
                if isEven:
                    if s[leftEven] == s[rightEven]:
                        evenLen += 2
                        leftEven -= 1
                        rightEven += 1
                    else:
                        isEven = False
  
            if (oddLen >= evenLen):
                if oddLen > maximum:
                    maximum = oddLen
                    maxL = leftOdd+1 
                    maxR = rightOdd
            else:
                if evenLen > maximum:
                    maximum = evenLen
                    maxL = leftEven+1
                    maxR = rightEven
        return s[maxL:maxR]
    

    '''
    Manacher's algorithm is an efficient way to find the longest palindromic substring in linear time. It works by transforming the input string to handle even-length palindromes uniformly and then
    using a clever approach to expand around potential centers while keeping track of the longest palindrome found.
    Time Complexity: O(n) - Each character is processed at most twice.
    Space Complexity: O(n) - We use an auxiliary array to store the radius of palindromes centered at each position in the transformed string.
    
    Steps:
    1. Transform the input string by inserting a special character (e.g., '#') between each character and at the beginning and end of the string. This allows us to treat even-length palindromes as odd-length ones.
    2. Create an array to store the radius of the longest palindrome centered at each position in the transformed string.
    3. Iterate through the transformed string and for each position, attempt to expand around it to find the longest palindrome. Use previously computed values to skip unnecessary expansions.
    4. Keep track of the longest palindrome found and its starting index in the original string.
    5. Return the longest palindromic substring using the recorded indices.
    '''
    def longestPalindromeManacher(self, s: str) -> str:
        """Find the longest palindromic substring in the given string using Manacher's algorithm."""
        radi = self.runManacher(s)
        maxLen = 1
        bestStart = 0
        for i in range(1, len(s)):
            # check odd-length palindromes
            oddLen = self.getLongest(i, 1, radi)
            if oddLen > maxLen:
                maxLen = oddLen
                bestStart = i - maxLen // 2
            # check even-length palindromes
            evenLen = self.getLongest(i, 0, radi)
            if evenLen > maxLen:
                maxLen = evenLen
                bestStart = i - maxLen // 2 + 1

        return s[bestStart:bestStart + maxLen]

    
    # returns length of longest palindrome centered 
    # at 'cen' in original string
    # 'odd' = 1 → check for odd-length, 'odd' = 0 → even-length
    def getLongest(self, cen, odd, radi):
        # map original index to transformed string index
        pos = 2 * cen + 2 + (0 if odd else 1)
        return radi[pos]


    def runManacher(self, s: str) -> str:
        # Set up the string for Manacher's algorithm
        algoString = "@"
        for c in s:
            algoString += "#" + c
        algoString += "#$"

        radi = [0] * len(algoString)

        # run Manacher's algorithm
        n = len(algoString)
        l = r = 0
        for i in range(1, n - 1):
            # mirror of i around center (l + r)/2
            mirror = l + r - i

            # initialize radi[i] based on its mirror
            if i < r:
                radi[i] = min(r - i, radi[mirror])

            # expand around center i
            while algoString[i + (1 + radi[i])] == algoString[i - (1 + radi[i])]:
                radi[i] += 1
            
            # update l and r if the palindrome centered at i expands past r
            if i + radi[i] > r:
                l = i - radi[i]
                r = i + radi[i]
        return radi
        