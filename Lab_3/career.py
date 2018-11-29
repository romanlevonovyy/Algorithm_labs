def solve(points, max_levels):
    solutions = points[-1]
    for i in range(max_levels - 1, -1, -1):
        for j in range(i):
            solutions[j] = max(solutions[j], solutions[j + 1]) + points[i - 1][j]
    return solutions[0]


def main():
    with open('career.in', 'r') as fl:
        max_levels = int(fl.readline())
        points = [[int(num) for num in ln.split()] for ln in fl.readlines()]

    result = solve(points, max_levels)

    print(str(result))


if __name__ == '__main__':
    main()
