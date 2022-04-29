package dud.model


enum Building(stringRepresentation: String):
    override def toString = stringRepresentation  
    case S1 extends Building("+---------+\n" + 
        "!_________!\n" + "___________\n" + "|         |\n" + "+---------+\n")
    case S2 extends Building("+--| ¦ |--+\n" + 
        "!__| ¦ |__!\n" + "___     ___\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
    case S3 extends Building("+--| ¦ |--+\n" +
        "|  | ¦ |o |\n" + "|  | ¦ || |\n" + "|  | ¦ |  |\n" + "+--| ¦ |--+\n")
    case H1 extends Building("+---------+\n" + 
        "|    ,^¦  |\n"+ "|   /# #\\ |\n" + "|   |# 1| |\n" + "+---------+\n")
    case H2 extends Building("+---------+\n" + 
        "|   __    |\n" + "|  /#  \\  |\n" + "|  |2 ¦|  |\n" + "+---------+\n")
    case H3 extends Building("+---------+\n" + 
        "| ___     |\n" + "| |# \\_   |\n" +"| |# 3 |  |\n" + "+---------+\n")
    case H4 extends Building("+---------+\n" + 
        "|     ~°  |\n" + "|  ,--|¦. |\n" + "|  |# 4 | |\n" + "+---------+\n")
    case Empty extends Building("+---------+\n" + 
        "|         |\n"+ "|         |\n" + "|         |\n" + "+---------+\n")
    case N1 extends Building("           \n" + 
        "           \n"+ "     1     \n" + "           \n" + "           \n")


