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