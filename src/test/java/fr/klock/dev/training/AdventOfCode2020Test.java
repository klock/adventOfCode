package fr.klock.dev.training;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Advent Of Code 2020")
public class AdventOfCode2020Test {

    @Nested
    @DisplayName("Day One")
    class DayOne {

        @Test
        void find2EntriesThatSumTo2020() {
            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find2EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
            assertThat(entriesThatSumTo2020).isNotNull();
            assertThat(entriesThatSumTo2020.length).isEqualTo(2);
            assertThat(entriesThatSumTo2020[0]).isEqualTo(1721);
            assertThat(entriesThatSumTo2020[1]).isEqualTo(299);
        }

        @Test
        void productOf2ExpenseReportEntriesPartOne() {
            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find2EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
            int product = adventOfCode2020.multiplyExpenseReportEntries(entriesThatSumTo2020);
            assertThat(product).isEqualTo(514579);
        }

        @Test
        void testPuzzleInputPartOne() throws IOException {
            String input = loadInput("2020", "day-one.txt");
            String[] expenseReportAsString = input.split("\r\n");
            int[] expenseReportAsInteger = Arrays.stream(expenseReportAsString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
                    .stream().mapToInt(i -> i).toArray();

            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find2EntriesThatSumTo2020(expenseReportAsInteger);
            int result = adventOfCode2020.multiplyExpenseReportEntries(entriesThatSumTo2020);

            assertThat(result).isEqualTo(618144);
        }

        @Test
        void find3EntriesThatSumTo2020() {
            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find3EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
            assertThat(entriesThatSumTo2020).isNotNull();
            assertThat(entriesThatSumTo2020.length).isEqualTo(3);
            assertThat(entriesThatSumTo2020[0]).isEqualTo(979);
            assertThat(entriesThatSumTo2020[1]).isEqualTo(366);
            assertThat(entriesThatSumTo2020[2]).isEqualTo(675);
        }

        @Test
        void productOf3ExpenseReportEntriesPartTwo() {
            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find3EntriesThatSumTo2020(new int[]{1721, 979, 366, 299, 675, 1456});
            int product = adventOfCode2020.multiplyExpenseReportEntries(entriesThatSumTo2020);
            assertThat(product).isEqualTo(241861950);
        }

        @Test
        void testPuzzleInputPartTwo() throws IOException {
            String input = loadInput("2020", "day-one.txt");
            String[] expenseReportAsString = input.split("\r\n");
            int[] expenseReportAsInteger = Arrays.stream(expenseReportAsString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
                    .stream().mapToInt(i -> i).toArray();

            AdventOfCode2020 adventOfCode2020 = new AdventOfCode2020();
            int[] entriesThatSumTo2020 = adventOfCode2020.find3EntriesThatSumTo2020(expenseReportAsInteger);
            int result = adventOfCode2020.multiplyExpenseReportEntries(entriesThatSumTo2020);

            assertThat(result).isEqualTo(173538720);
        }
    }

    private String loadInput(String domain, String resourcePath) throws IOException {
        return IOUtils.toString(this.getClass().getResourceAsStream(domain + "/" + resourcePath), StandardCharsets.UTF_8);
    }
}
