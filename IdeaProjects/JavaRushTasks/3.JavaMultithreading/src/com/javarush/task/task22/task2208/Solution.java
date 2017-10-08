package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}

Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> stringMap = new LinkedHashMap<>();
        stringMap.put("name", "Ivanov");
        stringMap.put("country", "Russia");
        stringMap.put("city", "Moscow");
        stringMap.put("age", null);
        System.out.println(getQuery(stringMap));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (!params.isEmpty()) {
            for (Map.Entry entry :
                    params.entrySet()) {
                if (entry.getValue() != null) {
                    String key = (String) entry.getKey();
                    String value = (String) entry.getValue();
                    stringBuilder.append(key).append(" = '").append(value).append("'");
                    stringBuilder.append(" and ");
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.replace(stringBuilder.length() - 5, stringBuilder.length(), "");
            }
        }
        return stringBuilder.toString();
    }
}
