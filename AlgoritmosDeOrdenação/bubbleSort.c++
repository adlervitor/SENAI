#include <iostream>

void bubbleSort (int arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr [j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int arr[] = {5, 2, 9, 1, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    bubbleSort(arr, size);

    std::cout << "Array ordenada usando Bubble Sort: ";
    for (int i = 0; i < size; ++i) {
        std::cout << arr[i] << " ";
    }

    std::cout << std::endl;

    return 0;
}