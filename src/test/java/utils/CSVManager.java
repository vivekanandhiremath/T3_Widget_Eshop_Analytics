package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVManager {

    public static void readCSV(String filepath) {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            String[] csvValues;
            while ((csvValues = reader.readNext()) != null) {
                for (String csvValue : csvValues) {
                    System.out.println(csvValue);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filepath);
            e.printStackTrace();
        } catch (CsvValidationException | IOException e) {
            System.err.println("Error reading the CSV file: " + filepath);
            e.printStackTrace();
        }
    }


    public static String readCellByHeader(String filepath, int rowIndex, String headerName) {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {

            String[] headers = reader.readNext();
            if (headers == null) {
                System.err.println("No headers found in the file.");
                return null;
            }

            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(headerName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex == -1) {
                System.err.println("Header not found: " + headerName);
                return null;
            }

            String[] csvValues;
            int currentRow = 0;
            while ((csvValues = reader.readNext()) != null) {
                if (currentRow == rowIndex) {
                    if (columnIndex < csvValues.length) {
                        return csvValues[columnIndex];
                    } else {
                        System.err.println("Column index out of bounds.");
                        return null;
                    }
                }
                currentRow++;
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filepath);
            e.printStackTrace();
        } catch (CsvValidationException | IOException e) {
            System.err.println("Error reading the CSV file: " + filepath);
            e.printStackTrace();
        }

        System.err.println("Row index out of bounds.");
        return null;
    }


    public static void writeCellByHeader(String filepath, int rowIndex, String headerName, String newValue) {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            String[] headers = reader.readNext();
            if (headers == null) {
                System.err.println("No headers found in the file.");
                return;
            }

            int columnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase(headerName)) {
                    columnIndex = i;
                    break;
                }
            }

            if (columnIndex == -1) {
                System.err.println("Header not found: " + headerName);
                return;
            }

            List<String[]> data = new ArrayList<>();
            String[] csvValues;
            while ((csvValues = reader.readNext()) != null) {
                data.add(csvValues);
            }

            if (rowIndex >= 0 && rowIndex < data.size()) {
                data.get(rowIndex)[columnIndex] = newValue;
            } else {
                System.err.println("Row index out of bounds.");
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
                writer.write(String.join(",", headers));
                writer.newLine();

                for (String[] row : data) {
                    writer.write(String.join(",", row));
                    writer.newLine();
                }

            }

            System.out.println("File updated successfully.");

        } catch (IOException | CsvValidationException e) {
            System.err.println("Error processing the CSV file: " + filepath);
            e.printStackTrace();
        }
    }


    /// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Map<String, String> flattenEventFields(Map<String, String> eventFields) {
        Map<String, String> flattenedFields = new HashMap<>();
        for (Map.Entry<String, String> entry : eventFields.entrySet()) {
            if (entry.getValue().startsWith("{") && entry.getValue().endsWith("}")) {
                Map<String, Object> nestedMap = parseToMap(entry.getValue());
                flattenedFields.putAll(flattenMap(nestedMap, entry.getKey()));
            } else {
                flattenedFields.put(entry.getKey(), entry.getValue());
            }
        }
        return flattenedFields;
    }

    private Map<String, Object> parseToMap(String str) {
        Map<String, Object> map = new HashMap<>();
        str = str.substring(1, str.length() - 1);
        String[] keyValuePairs = str.split(", ");
        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split("=");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }

    private Map<String, String> flattenMap(Map<String, Object> nestedMap, String parentKey) {
        Map<String, String> flattenedMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : nestedMap.entrySet()) {
            String key = parentKey + "." + entry.getKey();
            Object value = entry.getValue();

            if (value instanceof Map) {
                flattenedMap.putAll(flattenMap((Map<String, Object>) value, key));
            } else {
                flattenedMap.put(key, value.toString());
            }
        }
        return flattenedMap;
    }

    public void writeExpectedAndActualToCSV(String filePath, Map<String, String> expectedEventFields, Map<String, String> actualEventFields) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {

            writer.writeNext(new String[]{"Expected Data Key", "Expected Data Value", "Actual Data Key", "Actual Data Value"});

            for (Map.Entry<String, String> expectedEntry : expectedEventFields.entrySet()) {
                String expectedKey = expectedEntry.getKey();
                String expectedValue = expectedEntry.getValue();
                String result = "Failed";
                if (actualEventFields.containsKey(expectedKey)) {
                    String actualValue = actualEventFields.get(expectedKey);
                    if (expectedValue.equals(actualValue)) {
                        result = "Passed";
                    }
                    writer.writeNext(new String[]{expectedKey, expectedValue, expectedKey, actualValue, result});
                    System.out.println("Appended: " + expectedKey + ", Expected: " + expectedValue + ", Actual: " + actualValue + ", Result: " + result);
                } else {
                    writer.writeNext(new String[]{expectedKey, expectedValue, expectedKey, "", result});
                    System.out.println("Appended: " + expectedKey + ", Expected: " + expectedValue + ", Actual: (Not Found)" + result);
                }
            }

            for (Map.Entry<String, String> actualEntry : actualEventFields.entrySet()) {
                String actualKey = actualEntry.getKey();
                if (!expectedEventFields.containsKey(actualKey)) {
                    String actualValue = actualEntry.getValue();
                    System.out.println("Extra field found: " + actualKey + " = " + actualValue);
                }
            }

        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }


    public Map<String, String> loadExpectedEventFieldsFromCSV(String filePath, int keyIndex, int valueIndex) {
        Map<String, String> eventFields = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            reader.readNext();
            String[] headers = reader.readNext();

            if (headers == null || headers.length < 2 || !headers[0].equals("key") || !headers[1].equals("value")) {
                System.err.println("CSV file doesn't have expected header row 'key,value'");
                return eventFields;
            }

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine.length >= 2) {
                    String key = nextLine[keyIndex].trim();
                    String value = nextLine[valueIndex].trim();
                    eventFields.put(key, value);
                    System.out.println("Loaded CSV pair: " + key + " = " + value);
                } else {
                    System.err.println("Skipping malformed row: " + String.join(",", nextLine));
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
            System.err.println("Error reading CSV file: " + e.getMessage());
        }

        return eventFields;
    }

}
