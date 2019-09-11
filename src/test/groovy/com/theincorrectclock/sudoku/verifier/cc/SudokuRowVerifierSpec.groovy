package com.theincorrectclock.sudoku.verifier.cc

import spock.lang.Specification

class SudokuRowVerifierSpec extends Specification {

    def "verifies empty sudoku row as valid"() {
        given:
        SudokuRowVerifier rowVerifier = new SudokuRowVerifier()
        and:
        int[] row = [-1, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        when:
        boolean valid = rowVerifier.verify(row)
        
        then:
        true == valid
    }

    def "verifies valid sudoku row as valid"() {
        given:
        SudokuRowVerifier rowVerifier = new SudokuRowVerifier()
        and:
        int[] row = [-1, 1, 0, 0, 1, 1, 1, 0, 0, 0]

        when:
        boolean valid = rowVerifier.verify(row)

        then:
        true == valid
    }

    def "verifies invalid sudoku row as invalid"() {
        given:
        SudokuRowVerifier rowVerifier = new SudokuRowVerifier()
        and:
        int[] row = [-1, 1, 0, 0, 2, 0, 1, 0, 0, 0]

        when:
        boolean valid = rowVerifier.verify(row)

        then:
        false == valid
    }
}
