import miscAlgorithms
import intervals


def test_algorithm():
    """Test function to validate the algorithm."""
    print("Testing the algorithm...")
    # Here you can add test cases to validate the algorithm's correctness.

    # Test cases for longest palindromic substring
    misc_algo = miscAlgorithms.MiscAlgorithms()
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

    # Test cases for intervals
    i = intervals.Intervals([[0, 30], [5, 10], [15, 20]])
    can_attend = i.canAttendMeetings()
    print(f"Can attend meetings: {can_attend}")

    i = intervals.Intervals([[7, 10], [2, 4]])
    can_attend = i.canAttendMeetings()
    print(f"Can attend meetings: {can_attend}")


def main():
    """Main function to execute the algorithm."""
    print("Hello, World! This is the main function of the algorithm.")
    test_algorithm()

if __name__ == "__main__":
    main()
