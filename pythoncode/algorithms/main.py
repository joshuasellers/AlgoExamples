from pythoncode.algorithms.miscAlgorithms import MiscAlgorithms


def test_algorithm():
    """Test function to validate the algorithm."""
    print("Testing the algorithm...")
    # Here you can add test cases to validate the algorithm's correctness.
    misc_algo = MiscAlgorithms()
    test_string = "babad"
    result = misc_algo.longestPalindrome(test_string)
    result1 = misc_algo.longestPalindromeManacher(test_string)
    print(f"Longest palindromic substring in '{test_string}' is: '{result}'")
    print(f"Longest palindromic substring in '{test_string}' using Manacher's algorithm is: '{result1}'")
    test_string = "cbbd"
    result = misc_algo.longestPalindrome(test_string)
    result1 = misc_algo.longestPalindromeManacher(test_string)
    print(f"Longest palindromic substring in '{test_string}' is: '{result}'")
    print(f"Longest palindromic substring in '{test_string}' using Manacher's algorithm is: '{result1}'")
    test_string = "a"
    result = misc_algo.longestPalindrome(test_string)
    result1 = misc_algo.longestPalindromeManacher(test_string)
    print(f"Longest palindromic substring in '{test_string}' is: '{result}'")
    print(f"Longest palindromic substring in '{test_string}' using Manacher's algorithm is: '{result1}'")
    test_string = "ac"
    result = misc_algo.longestPalindrome(test_string)
    result1 = misc_algo.longestPalindromeManacher(test_string)
    print(f"Longest palindromic substring in '{test_string}' is: '{result}'")
    print(f"Longest palindromic substring in '{test_string}' using Manacher's algorithm is: '{result1}'")
    test_string = "aaaa"
    result = misc_algo.longestPalindrome(test_string)
    result1 = misc_algo.longestPalindromeManacher(test_string)
    print(f"Longest palindromic substring in '{test_string}' is: '{result}'")
    print(f"Longest palindromic substring in '{test_string}' using Manacher's algorithm is: '{result1}'")

def main():
    """Main function to execute the algorithm."""
    print("Hello, World! This is the main function of the algorithm.")
    test_algorithm()

if __name__ == "__main__":
    main()
