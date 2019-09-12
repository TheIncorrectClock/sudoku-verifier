package com.theincorrectclock.sudoku.verifier

import spock.lang.Specification

class SudokuVerifierSpec extends Specification {

    def "verifies empty sudoku puzzle as valid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())
        and:
        def puzzle = "000000000000000000000000000000000000000000000000000000000000000000000000000000000"

        when:
        def valid = verifier.verify(puzzle)

        then:
        "VALID" == valid
    }

    def "verifies correctly filled sudoku puzzle as valid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())

        when:
        def valid = verifier.verify(puzzle)

        then:
        "VALID" == valid

        where:
        puzzle                                                                              || _
        "123456789789123456456789123312845967697312845845697312231574698968231574574968231" || _
    }

    def "verifies incorrectly filled sudoku puzzle as invalid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())
        "123456789789123456456789123312845963697312845845697312231574698968231574574968231"

        when:
        def valid = verifier.verify(puzzle)

        then:
        "INVALID" == valid

        where:
        puzzle                                                                              || _
        "123456789789123456456789123312845963697312845845697312231574698968231574574968231" || _
    }

    def "verifies correctly partially filled sudoku puzzle as valid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())

        when:
        def valid = verifier.verify(puzzle)

        then:
        "VALID" == valid

        where:
        puzzle                                                                              || _
        "120006789700000000456700003000005967690000005845690000000574690000230004570000001" || _
    }

    def "verifies incorrectly partially filled sudoku puzzle as invalid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())

        when:
        def valid = verifier.verify(puzzle)

        then:
        "INVALID" == valid

        where:
        puzzle                                                                              || _
        "120006789700000000456700003000005967690000005855690000000574690000230004570000001" || _
    }

    def "verifies incomplete sudoku puzzle as invalid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())
        and:
        def puzzle = "123456789000000000980000000"

        when:
        def valid = verifier.verify(puzzle)

        then:
        "INVALID" == valid
    }
}
