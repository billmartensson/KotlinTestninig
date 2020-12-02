package se.magictechnology.mytesting

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun letsCheckoddEven()
    {

        assertEquals("Ojämn", FancyCalc().checkEven("1"))
        assertEquals("Jämn", FancyCalc().checkEven("2"))
        assertEquals("Ojämn", FancyCalc().checkEven("3"))
        assertEquals("Jämn", FancyCalc().checkEven("4"))
        assertEquals("Ojämn", FancyCalc().checkEven("473"))
        assertEquals("Jämn", FancyCalc().checkEven("836"))
        assertEquals("FEL", FancyCalc().checkEven("Banan"))
        assertEquals("FEL", FancyCalc().checkEven(""))
        assertEquals("Ojämn", FancyCalc().checkEven("-1"))



    }
}