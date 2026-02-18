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

    i = intervals.Intervals([[1, 3], [4, 5], [8, 10]])
    new_interval = [2, 6]
    merged_intervals = i.insertIntervals(new_interval)
    print(f"Merged intervals after inserting {new_interval}: {merged_intervals}")

    i = intervals.Intervals([[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]])
    new_interval = [4, 8]
    merged_intervals = i.insertIntervals(new_interval)
    print(f"Merged intervals after inserting {new_interval}: {merged_intervals}")


def main():
    """Main function to execute the algorithm."""
    print("Hello, World! This is the main function of the algorithm.")
    test_algorithm()

if __name__ == "__main__":
    main()
