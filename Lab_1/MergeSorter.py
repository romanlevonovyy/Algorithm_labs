from datetime import datetime


class MergeSorter:
    start_time = 0
    compare_count = 0
    swap_count = 0

    @staticmethod
    def merge_sort_by_passengers_width(screens: list):
        MergeSorter.start_time = datetime.now().microsecond
        MergeSorter.compare_count = 0
        MergeSorter.swap_count = 0

        MergeSorter.sort(screens)

        print("Merge sort by descending width:")
        print("Time spent: %s mcs" % (datetime.now().microsecond - MergeSorter.start_time))
        print("Number of comparisons: " + str(MergeSorter.compare_count))
        print("Number of swaps: " + str(MergeSorter.swap_count))
        print("Final array:")
        for j in range(len(screens)):
            print(screens[j])

    @staticmethod
    def sort(arr):
        if len(arr) > 1:
            mid = len(arr) // 2
            left_half = arr[:mid]
            right_half = arr[mid:]

            MergeSorter.sort(left_half)
            MergeSorter.sort(right_half)

            left_iter = 0
            right_iter = 0
            temp_index = 0
            while left_iter < len(left_half) and right_iter < len(right_half):
                MergeSorter.compare_count += 1
                MergeSorter.swap_count += 1
                if left_half[left_iter].width > right_half[right_iter].width:
                    arr[temp_index] = left_half[left_iter]
                    left_iter += 1
                else:
                    arr[temp_index] = right_half[right_iter]
                    right_iter += 1
                temp_index += 1

            while left_iter < len(left_half):
                arr[temp_index] = left_half[left_iter]
                left_iter += 1
                temp_index += 1

            while right_iter < len(right_half):
                arr[temp_index] = right_half[right_iter]
                right_iter += 1
                temp_index += 1
