package com.theincorrectclock.sudoku.verifier.cc;

class SudokuRowVerifier {

    private static final int FIRST_ELEMENT = 1;
    private static final int LAST_ELEMENT = 10;

    boolean verify(int[] row) {
        for (int i = FIRST_ELEMENT; i < LAST_ELEMENT; i++) {
            if (row[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
