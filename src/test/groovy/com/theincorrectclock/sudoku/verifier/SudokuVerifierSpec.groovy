package com.theincorrectclock.sudoku.verifier

import spock.lang.Specification

class SudokuVerifierSpec extends Specification {

    def "verifies empty sudoku puzzle as valid"() {
        given:
        SudokuVerifier verifier = new SudokuVerifier(new SudokuSegmentVerifier())

        when:
        def valid = verifier.verify(puzzle)

        then:
        "VALID" == valid

        where:
        puzzle                                                                                    || _
        "000000000000000000000000000000000000000000000000000000000000000000000000000000000"       || _
        "000000000000000000000000000000000000000000000000000000000000000000000000000000000111111" || _ // longer than 81
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
        "512346789769128354483597126135982467627451938894673512976215843258734691341869275" || _
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
        "512346789769128354483597126135982467627451938894673512976215843258734691541869275" || _
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
        "500000000000028300000007126000000007627451900000000000000000843258734600000000005" || _
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
        "500000000000000000000000000000000000000000000000000000000000000000000000500000000" || _  // same number in column
        "000000000000000000000000000000000000000000000000000000000000000000000000500000005" || _  // same number in row
        "000000000000000000000000000000000000000000000000000000000000000000000500000000005" || _  // same number in block
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
