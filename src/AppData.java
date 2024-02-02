import java.io.*;
import java.util.Arrays;

public class AppData {

    //Реализовать сохранение данных в csv файл; Реализовать загрузку данных из csv файла. Файл читается целиком.
    //Структура csv файла:
    //Строка заголовок с набором столбцов
    //Набор строк с целочисленными значениями
    //Разделитель между столбцами - символ точка с запятой (;)

    //Для хранения данных использовать класс вида:
    //public class AppData {
    //   private String[] header;
    //   private int[][] data;
    //}
    //Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
    private String[] header;
    private int[][] data;

    public static void main(String[] args) {
        AppData table = new AppData();
        table.header = new String[]{"value1", "value2", "value3"};
        table.data = new int[][]{{100, 300, 123}, {200, 400, 500},};
        table.save(table, "table.csv");
        AppData tableLoad = AppData.load("table.csv");

        System.out.println(Arrays.toString(tableLoad.header));
        for (int i = 0; i < tableLoad.data.length; i++) {
            System.out.println(Arrays.toString(tableLoad.data[i]));
        }
    }

    public void save(AppData data, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            // Записываем заголовок
            for (int i = 0; i < data.header.length; i++) {
                writer.append(data.header[i]);
                if (i < data.header.length - 1) {
                    writer.append(";");
                } else {
                    writer.append("\n");
                }
            }
            // Записываем данные
            for (int[] row : data.data) {
                for (int i = 0; i < data.header.length; i++) {
                    writer.append(String.valueOf(row[i]));
                    if (i < data.header.length - 1) {
                        writer.append(";");
                    } else {
                        writer.append("\n");
                    }
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AppData load(String filename) {
        AppData appData = new AppData();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Считываем заголовок
            String[] header = br.readLine().split(";");
            appData.header = header;
            // Считываем данные
            String line;
            int rowCount = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (rowCount == 0) {
                    appData.data = new int[values.length - 1][appData.header.length];
                }
                for (int i = 0; i < values.length; i++) {
                    appData.data[rowCount][i] = Integer.valueOf(values[i]);
                }
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appData;
    }
}
