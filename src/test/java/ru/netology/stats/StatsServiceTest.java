package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    StatsService service = new StatsService();
    int[] salesByMonth = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};

    @Test
    void shouldAnnualSalesAmount() {

        int expected = 180;
        int actual = service.annualSalesAmount(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldAverageMonthlySales() {

        int expected = 15;
        int actual = service.averageMonthlySales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthWithMaximumSales() {

        int expected = 8;
        int actual = service.monthWithMaximumSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthWithMinimumSales() {

        int expected = 9;
        int actual = service.monthWithMinimumSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthsWithBelowAverageSales() {

        int expected = 5;
        int actual = service.monthsWithBelowAverageSales(salesByMonth);

        assertEquals(expected, actual);
    }

    @Test
    void shouldMonthsWithAboveAverageSales() {

        int expected = 5;
        int actual = service.monthsWithAboveAverageSales(salesByMonth);

        assertEquals(expected, actual);
    }
}