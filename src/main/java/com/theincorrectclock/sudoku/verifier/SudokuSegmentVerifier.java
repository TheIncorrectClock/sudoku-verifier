package com.theincorrectclock.sudoku.verifier;

class SudokuSegmentVerifier {

    private static final int FIRST_ELEMENT_INDEX = 1;
    private static final int LAST_ELEMENT_INDEX = 9;

    boolean verify(int[] segment) {
        for (int i = FIRST_ELEMENT_INDEX; i <= LAST_ELEMENT_INDEX; i++) {
            if (segment[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
