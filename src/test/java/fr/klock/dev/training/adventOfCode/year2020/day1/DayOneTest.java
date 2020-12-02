package fr.klock.dev.training.adventOfCode.year2020.day1;

import fr.klock.dev.training.adventOfCode.FileUtils;
import fr.klock.dev.training.adventOfCode.year2020.day1.DayOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Advent Of Code 2020 - Day 1")
public class DayOneTest {

    @Test
    void find2EntriesThatSumTo2020() {
        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find2EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
        assertThat(entriesThatSumTo2020).isNotNull();
        assertThat(entriesThatSumTo2020.length).isEqualTo(2);
        assertThat(entriesThatSumTo2020[0]).isEqualTo(1721);
        assertThat(entriesThatSumTo2020[1]).isEqualTo(299);
    }

    @Test
    void productOf2ExpenseReportEntriesPartOne() {
        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find2EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
        int product = dayOne.multiplyExpenseReportEntries(entriesThatSumTo2020);
        assertThat(product).isEqualTo(514579);
    }

    @Test
    void testPuzzleInputPartOne() throws IOException {
        String[] expenseReportAsString = FileUtils.loadInput(this, "expense-report.txt");
        int[] expenseReportAsInteger = Arrays.stream(expenseReportAsString)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream().mapToInt(i -> i).toArray();

        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find2EntriesThatSumTo2020(expenseReportAsInteger);
        int result = dayOne.multiplyExpenseReportEntries(entriesThatSumTo2020);

        assertThat(result).isEqualTo(618144);
    }

    @Test
    void find3EntriesThatSumTo2020() {
        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find3EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
        assertThat(entriesThatSumTo2020).isNotNull();
        assertThat(entriesThatSumTo2020.length).isEqualTo(3);
        assertThat(entriesThatSumTo2020[0]).isEqualTo(979);
        assertThat(entriesThatSumTo2020[1]).isEqualTo(366);
        assertThat(entriesThatSumTo2020[2]).isEqualTo(675);
    }

    @Test
    void productOf3ExpenseReportEntriesPartTwo() {
        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find3EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
        int product = dayOne.multiplyExpenseReportEntries(entriesThatSumTo2020);
        assertThat(product).isEqualTo(241861950);
    }

    @Test
    void testPuzzleInputPartTwo() throws IOException {
        String[] expenseReportAsString = FileUtils.loadInput(this, "expense-report.txt");
        int[] expenseReportAsInteger = Arrays.stream(expenseReportAsString)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream().mapToInt(i -> i).toArray();

        DayOne dayOne = new DayOne();
        int[] entriesThatSumTo2020 = dayOne.find3EntriesThatSumTo2020(expenseReportAsInteger);
        int result = dayOne.multiplyExpenseReportEntries(entriesThatSumTo2020);

        assertThat(result).isEqualTo(173538720);
    }
}
