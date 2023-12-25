package com.example.springserver;

import com.example.springserver.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;

@SpringBootApplication
public class SpringServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringServerApplication.class, args);
        double number = 12345.02020;

        // Chuyển số thành chuỗi
        String numberString = Double.toString(number);

        // Bỏ đi các số 0 không cần thiết ở cuối chuỗi
        String trimmedNumber = trimTrailingZeros(numberString);

        System.out.println(trimmedNumber);
    }
    private static String trimTrailingZeros(String input) {
        // Sử dụng biểu thức chính quy để bỏ đi các số 0 ở cuối chuỗi và dấu chấm nếu cần
        input = input.replaceAll("\\.?0*$", "");

        return input;
    }
}
