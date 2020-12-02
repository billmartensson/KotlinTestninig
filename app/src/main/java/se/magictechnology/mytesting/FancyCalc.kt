package se.magictechnology.mytesting

class FancyCalc
{
    fun checkEven(numbertext : String) : String
    {
        // "23" -> "Ojämn"
        // "12" -> "Jämn"
        // "Banan" -> "FEL"

        val siffa = numbertext.toIntOrNull()

        if(siffa == null)
        {
            return "FEL"
        }

        // 7 / 2 = 3.5 ..... 3*2=6.... 7-6=1 i rest dvs ojämnt
        // 6 / 2 = 3 .... 3*2=6... 6-6=0 i rest dvs jämt

        if(siffa!! %2 == 0)
        {
            return "Jämn"
        } else {
            return "Ojämn"
        }



    }
}