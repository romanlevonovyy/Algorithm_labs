import csv
from InsertionSorter import InsertionSorter
from MergeSorter import MergeSorter
from Screens import Screen


def read_data_from_file():
    screen_list = []
    try:
        with open('screens.txt') as csvin:
            reader = csv.reader(csvin)
            for row in reader:
                new_screen = Screen(int(row[0]), row[1], int(row[2]), (row[3]))
                screen_list.append(new_screen)
    except FileNotFoundError:
        print("File not found!")
    return screen_list


if __name__ == "__main__":
    screen_list = read_data_from_file()
    print("Initial list:")
    for j in range(len(screen_list)):
        print(screen_list[j])

    InsertionSorter.insertion_sort_by_height(screen_list)
    MergeSorter.merge_sort_by_width(screen_list)
