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
