package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    void whenPositionC8() {
        Cell startPos = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell resultPos = bishopBlack.position();
        assertThat(resultPos).isEqualTo(startPos);
    }

    @Test
    void whenPositionA1() {
        Cell startPos = Cell.A1;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell resultPos = bishopBlack.position();
        assertThat(resultPos).isEqualTo(startPos);
    }

    @Test
    void whenCopyC8toF5() {
        Cell startPos = Cell.C8;
        Cell copyPos = Cell.F5;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell resultPos = bishopBlack.copy(copyPos).position();
        assertThat(resultPos).isEqualTo(copyPos);
    }

    @Test
    void whenCopyH1toC6() {
        Cell startPos = Cell.H1;
        Cell copyPos = Cell.C6;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell resultPos = bishopBlack.copy(copyPos).position();
        assertThat(resultPos).isEqualTo(copyPos);
    }

    @Test
    void whenWayC1toG5() {
        Cell startPos = Cell.C1;
        Cell endPos = Cell.G5;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] result = bishopBlack.way(endPos);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenWayA6toD3() {
        Cell startPos = Cell.A6;
        Cell endPos = Cell.D3;
        BishopBlack bishopBlack = new BishopBlack(startPos);
        Cell[] expected = {Cell.B5, Cell.C4, Cell.D3};
        Cell[] result = bishopBlack.way(endPos);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenWayB1toB3ThenException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(Cell.B1).way(Cell.B3);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from B1 to B3");
    }

    @Test
    void whenG1toC5thenDiagonalIsTrue() {
        Cell startPos = Cell.G1;
        Cell endPos = Cell.C5;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isTrue();
    }

    @Test
    void whenC3toH8thenDiagonalIsTrue() {
        Cell startPos = Cell.C3;
        Cell endPos = Cell.H8;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isTrue();
    }

    @Test
    void whenA5toE1thenDiagonalIsTrue() {
        Cell startPos = Cell.A5;
        Cell endPos = Cell.E1;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isTrue();
    }

    @Test
    void whenF2toE1thenDiagonalIsTrue() {
        Cell startPos = Cell.F2;
        Cell endPos = Cell.E1;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isTrue();
    }

    @Test
    void whenA1toB4thenDiagonalIsFalse() {
        Cell startPos = Cell.A1;
        Cell endPos = Cell.B4;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isFalse();
    }

    @Test
    void whenC7toD5thenDiagonalIsFalse() {
        Cell startPos = Cell.C7;
        Cell endPos = Cell.D5;
        boolean expected = new BishopBlack(startPos).isDiagonal(startPos, endPos);
        assertThat(expected).isFalse();
    }
}