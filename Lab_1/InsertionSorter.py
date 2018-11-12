from datetime import datetime


class InsertionSorter:
    @staticmethod
    def insertion_sort_by_height(screens: list):
        print("Insertion sort ascending by height:")
        start_time = datetime.now().microsecond
        comparing_times = 0
        change_times = 0
        for i in range(0, len(screens)):
            comparing_times = comparing_times + 1
            comparing_screen = screens[i]
            n = i
            while n >= 0 and comparing_screen.height < screens[n - 1].height:
                change_times = change_times + 1
                screens[n] = screens[n - 1]
                n = n - 1
            change_times = change_times + 1
            screens[n] = comparing_screen
        print("Comparisons number: " + str(comparing_times))
        print("Swaps number: " + str(change_times))
        print("Time spent: %s mcs" % (datetime.now().microsecond - start_time))
        for j in range(len(screens)):
            print(screens[j])
