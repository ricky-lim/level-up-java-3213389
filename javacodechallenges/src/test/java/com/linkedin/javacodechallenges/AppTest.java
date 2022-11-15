package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private final ByteArrayOutputStream gamePrintOut = new ByteArrayOutputStream();

    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(gamePrintOut));
    }

    @After
    public void restoreStream() {
        System.setOut(System.out);
    }

    @Test
    public void askUserToContinue_Y() {
        String input = "Y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothing game = new DoubleOrNothing();
        assertTrue(game.getIsPlaying());

        game.askUserToContinue();
        assertTrue(game.getIsPlaying());
    }

    @Test
    public void askUserToContinue_N() {
        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        DoubleOrNothing game = new DoubleOrNothing();
        assertTrue(game.getIsPlaying());

        game.askUserToContinue();
        assertFalse(game.getIsPlaying());
    }
}
