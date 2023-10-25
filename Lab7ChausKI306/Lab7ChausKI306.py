def generate_jagged_arr(size, symbol):
    jagged_arr = [[' ' for _ in range(i + 1)] if i >= size // 2 else None for i in range(size)]
    for i in range(size // 2, size):
        spaces = abs(i - size + 1)
        for j in range(spaces, size - spaces):
            jagged_arr[i][j] = symbol
    return jagged_arr


def print_array(arr):
    for row in arr:
        if not row:
            print()
        else:
            for c in row:
                print(c, end=' ')
            print()


def write_to_text_file(arr, n_rows):
    with open('MyFile.txt', 'w') as fout:
        for row in arr:
            if not row:
                fout.write('\n')
            else:
                fout.write(' '.join(row) + '\n')
        print('\nData written to MyFile.txt')

def main():
    n_rows = int(input("Enter size of square matrix: "))
    filler = input("Enter character to fill matrix: ")

    if filler != ' ':
        arr = generate_jagged_arr(n_rows, filler)
        print_array(arr)
        write_to_text_file(arr, n_rows)
    else:
        print("\nNo character entered. Placeholder")

if __name__ == "__main__":
    main()
