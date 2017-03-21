# dice-roller

A dice rolling program intended for use with D&D and various tabletop games. 
The program uses a minimal GUI that allows users to quickly roll some common dice used
in tabletop games and displays the result of the roll. The user can also enter full rolls in the right panel. 

Full rolls can be executed by specifying the dice quantity, type, and any modifiers in the full roll text box
in the given format. For example, "1d6+0" would roll one dice with six sides and add zero to the total, and 
"2d8+4" would roll two dice with eight sides and add four to the total. At this time the user cannot directly
enter a negative modifer, but this can be worked around by entering something like "3d4+-4" for a modifier of -4. 
This rolls 3d4 and subtracts 4.
