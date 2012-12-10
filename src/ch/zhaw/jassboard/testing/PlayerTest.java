package ch.zhaw.jassboard.testing;

import ch.zhaw.jassboard.persist.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created with IntelliJ IDEA.
 * User: Tobias
 * Date: 10.12.12
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
public class PlayerTest {
    Player testplayer;
    @Before
    public void setUp() throws Exception {
        testplayer = new Player("Testplayer");
    }

    @Test
    public void testGetGamesPlayed() throws Exception {
        testplayer.setGamesPlayedSchieber(75);
        testplayer.setGamesPlayedCoiffeur(150);
        testplayer.setGamesPlayedDifferenzler(25);
        Assert.assertEquals(250, testplayer.getGamesPlayed());
    }

    @Test
    public void testGetGamesWon() throws Exception {
        testplayer.setGamesWonSchieber(25);
        testplayer.setGamesWonDifferenzler(27);
        testplayer.setGamesWonCoiffeur(98);
        Assert.assertEquals(150, testplayer.getGamesWon());
    }

    @Test
    public void testGetRoundsPlayed() throws Exception {
        testplayer.setRoundsPlayedSchieber(34);
        testplayer.setRoundsPlayedDifferenzler(22);
        testplayer.setRoundsPlayedCoiffeur(144);
        Assert.assertEquals(200, testplayer.getRoundsPlayed());
    }

    @Test
    public void testGetRoundsWon() throws Exception {
        testplayer.setRoundsWonSchieber(24);
        testplayer.setRoundsWonDifferenzler(64);
        testplayer.setRoundsWonCoiffeur(36);
        Assert.assertEquals(124, testplayer.getRoundsWon());
    }

    @Test
    public void testGetPointsMax() throws Exception {
        testplayer.setPointsMaxSchieber(1570);
        testplayer.setPointsMaxCoiffeur(1770);
        testplayer.setPointsMaxDifferenzler(404);
        Assert.assertEquals(3746, testplayer.getPointsMax());
    }

    @Test
    public void testGetPointsMade() throws Exception {
        testplayer.setPointsMadeSchieber(1145);
        testplayer.setPointsMadeCoiffeur(2486);
        testplayer.setPointsMadeDifferenzler(115);
        Assert.assertEquals(3746, testplayer.getPointsMade());

    }

    @Test
    public void testGetGamesWonPercent() throws Exception {
        Assert.assertEquals(60, testplayer.getGamesWonPercent());
    }

    @Test
    public void testGetRoundsWonPercent() throws Exception {
        Assert.assertEquals(62, testplayer.getRoundsWon());
    }

    @Test
    public void testGetPointsMadePercent() throws Exception {
        Assert.assertEquals(100, testplayer.getPointsMadePercent());
    }

    @Test
    public void testGetSchieberGamesWonPercent() throws Exception {
        Assert.assertEquals(33, testplayer.getSchieberGamesWonPercent());
    }

    @Test
    public void testGetSchieberRoundsWonPercent() throws Exception {
        Assert.assertEquals(70, testplayer.getSchieberRoundsWonPercent());
    }

    @Test
    public void testGetSchieberPointsMadePercent() throws Exception {
        Assert.assertEquals(72, testplayer.getSchieberPointsMadePercent());
    }

    @Test
    public void testGetCoiffeurGamesWonPercent() throws Exception {
        Assert.assertEquals(65, testplayer.getCoiffeurGamesWonPercent());
    }

    @Test
    public void testGetCoiffeurRoundsWonPercent() throws Exception {
        Assert.assertEquals(25, testplayer.getCoiffeurRoundsWonPercent());
    }

    @Test
    public void testGetCoiffeurPointsMadePercent() throws Exception {
        Assert.assertEquals(35, testplayer.getCoiffeurPointsMadePercent());
    }

    @Test
    public void testGetDifferenzlerGamesWonPercent() throws Exception {
        Assert.assertEquals(101, testplayer.getDifferenzlerGamesWonPercent());
    }

    @Test
    public void testGetDifferenzlerRoundsWonPercent() throws Exception {
        Assert.assertEquals(300, testplayer.getDifferenzlerRoundsWonPercent());
    }

    @Test
    public void testGetDifferenzlerPointsMadePercent() throws Exception {
        Assert.assertEquals(26, testplayer.getDifferenzlerPointsMadePercent());
    }
}
