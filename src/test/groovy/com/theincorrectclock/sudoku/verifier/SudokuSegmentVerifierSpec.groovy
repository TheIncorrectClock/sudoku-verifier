package com.theincorrectclock.sudoku.verifier

import spock.lang.Specification

class SudokuSegmentVerifierSpec extends Specification {

    def "verifies empty sudoku segment as valid"() {
        given:
        SudokuSegmentVerifier segmentVerifier = new BasicSudokuSegmentVerifier()
        and:
        int[] segment = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        when:
        boolean valid = segmentVerifier.verify(segment)

        then:
        true == valid
    }

    def "verifies valid sudoku segment as valid"() {
        given:
        SudokuSegmentVerifier segmentVerifier = new BasicSudokuSegmentVerifier()
        and:
        int[] segment = [0, 1, 0, 0, 1, 1, 1, 0, 0, 0]

        when:
        boolean valid = segmentVerifier.verify(segment)

        then:
        true == valid
    }

    def "verifies invalid sudoku segment as invalid"() {
        given:
        SudokuSegmentVerifier segmentVerifier = new BasicSudokuSegmentVerifier()
        and:
        int[] segment = [0, 1, 0, 0, 2, 0, 1, 0, 0, 0]

        when:
        boolean valid = segmentVerifier.verify(segment)

        then:
        false == valid
    }
}
