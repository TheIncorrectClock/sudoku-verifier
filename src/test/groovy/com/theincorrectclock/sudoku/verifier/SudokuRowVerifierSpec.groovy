package com.theincorrectclock.sudoku.verifier

import spock.lang.Specification

class SudokuRowVerifierSpec extends Specification {

    def "verifies valid sudoku row as valid"() {
        then:
        false
    }

    def "verifies invalid sudoku row as invalid"() {
        then:
        false
    }
}
