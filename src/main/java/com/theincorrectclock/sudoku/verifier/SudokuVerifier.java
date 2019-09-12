package com.theincorrectclock.sudoku.verifier;

import static java.util.stream.Stream.concat;
import static java.util.stream.Stream.of;

public class SudokuVerifier {

    private static final int PUZZLE_LENGTH = 81;
    private static final int ROW_LENGTH = 9;
    private static final int COLUMN_LENGTH = 9;
    private static final int BLOCK_SIZE_IN_COLUMNS = 3;
    private static final int BLOCK_SIZE_IN_ROWS = 3;
    private static final String INVALID = "INVALID";
    private static final String VALID = "VALID";

    private int[][] rows = new int[9][10];
    private int[][] columns = new int[9][10];
    private int[][] blocks = new int[9][10];

    private SudokuSegmentVerifier segmentVerifier;

    public SudokuVerifier() {
        this.segmentVerifier = new SudokuSegmentVerifier();
    }

    public SudokuVerifier(SudokuSegmentVerifier segmentVerifier) {
        this.segmentVerifier = segmentVerifier;
    }

    public String verify(String puzzle) {
        if (puzzle.length() < PUZZLE_LENGTH) {
            return INVALID;
        }

        String[] puzzleAsArray = puzzle.split("");
        for (int i = 0; i < PUZZLE_LENGTH; i++) {
            int column = calculateColumnNumber(i);
            int row = calculateRowNumber(i);
            int block = calculateBlockNumber(column, row);

            rows[row][Integer.parseInt(puzzleAsArray[i])]++;
            columns[column][Integer.parseInt(puzzleAsArray[i])]++;
            blocks[block][Integer.parseInt(puzzleAsArray[i])]++;
        }

        return (numberOfInvalidSegments() == 0) ? VALID : INVALID;
    }

    private long numberOfInvalidSegments() {
        return concat(concat(of(rows), of(columns)), of(blocks))
                .filter(segment -> !segmentVerifier.verify(segment))
                .count();
    }

    private int calculateBlockNumber(int column, int row) {
        return column / BLOCK_SIZE_IN_COLUMNS + (row / BLOCK_SIZE_IN_ROWS) * BLOCK_SIZE_IN_ROWS;
    }

    private int calculateRowNumber(int i) {
        return i / ROW_LENGTH;
    }

    private int calculateColumnNumber(int i) {
        return i % COLUMN_LENGTH;
    }
}
