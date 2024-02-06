public class Lesson7 {
    //Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    // При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    // Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    // Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
    // должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
    // В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
    // и вывести результат расчета.
    public static void main(String[] args) {
        String[][] trueArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        String[][] bigArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };
        String[][] falseArray = {
                {"1", "a", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        try {
            int result = sumArrayElements(trueArray);
            System.out.println("Сумма элементов массива: " + result);
            //result = sumArrayElements(bigArray);
            result = sumArrayElements(falseArray);
        } catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива");
        } catch (MyArrayDataException e) {
            System.out.println("Неверные данные в ячейке: " + e.getErrorAddress()[0] + ", " + e.getErrorAddress()[1]);
        }
    }

    public static int sumArrayElements(String[][] df) throws MyArraySizeException, MyArrayDataException {
        int rows = df.length;
        int columns = df[0].length;
        int sum = 0;

        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int element = Integer.parseInt(df[i][j]);
                    sum += element;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
    }
}

class MyArrayDataException extends Exception {
    private int[] errorAddress = new int[2];

    public MyArrayDataException(int row, int column) {
        errorAddress[0] = row;
        errorAddress[1] = column;
    }

    public int[] getErrorAddress() {
        return errorAddress;
    }
}
