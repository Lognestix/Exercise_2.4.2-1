# В pom.xml добавлены поддержка junit-jupiter и подходящий ему maven-surefire-plugin, в свойства добавлена кодировка для работы с Maven без IDEA

```xml
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.22.2</version>
            </plugin>
        </plugins>
    </build>
```

# Код Java находящийся в этом репозитории

```Java
package ru.netology.stats;

public class StatsService {
    public int annualSalesAmount(int[] sales) {             //Сумма годовых продаж
        int annualSalesAmount = 0;                          //Инициализация начальной суммы
        for (int sale : sales) {
            annualSalesAmount += sale;
        }
        return (annualSalesAmount);
    }

    public int averageMonthlySales(int[] sales) {           //Средняя сумма продаж за месяц
        return (annualSalesAmount(sales) / sales.length);
    }

    public int monthWithMaximumSales(int[] sales) {         //Номер месяца, в котором был пик продаж
        int monthWithMaximumSales = 0;
        int month = 0;                                      //Инициализация индекса
        for (int sale : sales) {
            if (sale >= sales[monthWithMaximumSales]) {     //Продажи в месяце monthWithMaximumSales
                monthWithMaximumSales = month;
            }
            month++;                                        //Повышение индекса на единицу
        }
        return (monthWithMaximumSales + 1);
    }

    public int monthWithMinimumSales(int[] sales) {         //Номер месяца, в котором был минимум продаж
        int monthWithMinimumSales = 0;
        int month = 0;                                      //Инициализация индекса
        for (int sale : sales) {
            if (sale <= sales[monthWithMinimumSales]) {     //Продажи в месяце monthWithMinimumSales
                monthWithMinimumSales = month;
            }
            month++;                                        //Повышение индекса на единицу
        }
        return (monthWithMinimumSales + 1);
    }

    public int monthsWithBelowAverageSales(int[] sales) {   //Кол-во месяцев, в которых продажи были ниже среднего
        int monthsWithBelowAverageSales = 0;
        int average = averageMonthlySales(sales);           //Инициализация среднего значения
        for (int sale : sales) {
            if (sale < average) {
                monthsWithBelowAverageSales++;
            }
        }
        return (monthsWithBelowAverageSales);
    }

    public int monthsWithAboveAverageSales(int[] sales) {   //Кол-во месяцев, в которых продажи были ниже среднего
        int monthsWithAboveAverageSales = 0;
        int average = averageMonthlySales(sales);           //Инициализация среднего значения
        for (int sale : sales) {
            if (sale > average) {
                monthsWithAboveAverageSales++;
            }
        }
        return (monthsWithAboveAverageSales);
    }
}
```
```Java
package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    @Test
    void shouldAnnualSalesAmount() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 180;

        int actual = service.annualSalesAmount(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldAverageMonthlySales() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 15;

        int actual = service.averageMonthlySales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthWithMaximumSales() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 8;

        int actual = service.monthWithMaximumSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthWithMinimumSales() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 9;

        int actual = service.monthWithMinimumSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthsWithBelowAverageSales() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 5;

        int actual = service.monthsWithBelowAverageSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthsWithAboveAverageSales() {
        StatsService service = new StatsService();

        int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        int expected = 5;

        int actual = service.monthsWithAboveAverageSales(salesByMonth);

        assertEquals(expected, actual);
    }
}
```