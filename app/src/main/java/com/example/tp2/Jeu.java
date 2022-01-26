package com.example.tp2;


public class Jeu {

    char[] grille = new char[9];
    int tour;
    int[][] combGagnantes = { {0, 1, 2}, {0, 4, 8}, {0, 3, 6},
            {6, 7, 8}, {6, 4, 2},
            {3, 4, 5},
            {1, 4, 7},
            {2, 5, 8}};

    // Constructeur sans param�tres
    public Jeu() {
    }

    // M�thode initialise
    public void initialise() {
        grille = new char[9];
        tour = 1;
    }

    public void setX( int cellule) {
        grille[cellule] = 'x';
    }

    public int getO() {
        switch(tour) {
            case 4:
                tour +=1;
                return bloquer();
            case 3:
                tour +=1;
                return bloquer();
            case 2:
                tour +=1;
                return bloquer();
            case 1:

                if ( grille[4] == 0 ) {
                    tour += 1;
                    grille[4] = 'o';
                    return 4;
                } else
                    tour += 1;
                grille[2] = 'o';
                return 2;

            default:
                tour += 1;
                if ( grille[4] == 0 ) {
                    grille[4] = 'o';
                    return 4;
                } else
                    grille[2] = 'o';
                return 2;
        }
    }

    public boolean gagnant(String joueur, int[] pos )  {
        if ( victoire() ) {
            pos[0] = lumiere1();
            pos[1] = lumiere2();
            pos[2] = lumiere3();
            return true;
        }
        else
            return false;
    }

    public boolean victoire() {
        if ( grille[0] == 'o' ) {
            if ( grille[1] == 'o' && grille[2] == 'o' )
                return true;
            else if ( grille[4] == 'o' && grille[8] == 'o' )
                return true;
            else if ( grille[3] == 'o' && grille[6] == 'o' )
                return true;
        } if ( grille[6] == 'o' ) {
            if ( grille[7] == 'o' && grille [8] == 'o' )
                return true;
            else if ( grille[4] == 'o' && grille[2] == 'o')
                return true;
        } if (grille[3] == 'o' && grille[4] == 'o' && grille[5] == 'o')
            return true;
        if (grille[1] == 'o' && grille[4] == 'o' && grille[7] == 'o')
            return true;
        if (grille[2] == 'o' && grille[5] == 'o' && grille[8] == 'o')
            return true;
        return false;
    }

    public int lumiere1() {
        if ( grille[0] == 'o' ) {
            if ( grille[1] == 'o' && grille[2] == 'o' )
                return 0;
            else if ( grille[4] == 'o' && grille[8] == 'o' )
                return 0;
            else if ( grille[3] == 'o' && grille[6] == 'o' )
                return 0;
        } if ( grille[6] == 'o' ) {
            if ( grille[7] == 'o' && grille [8] == 'o' )
                return 6;
            else if ( grille[4] == 'o' && grille[2] == 'o')
                return 6;
        } if (grille[3] == 'o' && grille[4] == 'o' && grille[5] == 'o')
            return 3;
        if (grille[1] == 'o' && grille[4] == 'o' && grille[7] == 'o')
            return 1;
        if (grille[2] == 'o' && grille[5] == 'o' && grille[8] == 'o')
            return 2;
        return 0;
    }

    public int lumiere2() {
        if ( grille[0] == 'o' ) {
            if ( grille[1] == 'o' && grille[2] == 'o' )
                return 1;
            else if ( grille[4] == 'o' && grille[8] == 'o' )
                return 4;
            else if ( grille[3] == 'o' && grille[6] == 'o' )
                return 3;
        } if ( grille[6] == 'o' ) {
            if ( grille[7] == 'o' && grille [8] == 'o' )
                return 7;
            else if ( grille[4] == 'o' && grille[2] == 'o')
                return 4;
        } if (grille[3] == 'o' && grille[4] == 'o' && grille[5] == 'o')
            return 4;
        if (grille[1] == 'o' && grille[4] == 'o' && grille[7] == 'o')
            return 4;
        if (grille[2] == 'o' && grille[5] == 'o' && grille[8] == 'o')
            return 5;
        return 0;
    }

    public int lumiere3() {
        if ( grille[0] == 'o' ) {
            if ( grille[1] == 'o' && grille[2] == 'o' )
                return 2;
            else if ( grille[4] == 'o' && grille[8] == 'o' )
                return 8;
            else if ( grille[3] == 'o' && grille[6] == 'o' )
                return 6;
        } if ( grille[6] == 'o' ) {
            if ( grille[7] == 'o' && grille [8] == 'o' )
                return 8;
            else if ( grille[4] == 'o' && grille[2] == 'o')
                return 2;
        } if (grille[3] == 'o' && grille[4] == 'o' && grille[5] == 'o')
            return 5;
        if (grille[1] == 'o' && grille[4] == 'o' && grille[7] == 'o')
            return 7;
        if (grille[2] == 'o' && grille[5] == 'o' && grille[8] == 'o')
            return 8;
        return 0;
    }

    public boolean isPartieNulle() {
        for (int i=0; i <= 8; i++)
            if (grille[i] == 0)
                return false;
        return true;}

    public void testDebug(int[] indicesCoups) {};

    public int bloquer() {
        // bloquage de l'exception des x a 4 et 7
        if (grille[1] == 'o' && grille[2] == 'o' && grille[4] == 'x' && grille[7] == 'x' && grille[0] == 0) {
            grille[0] = 'o';
            return 0;
        }

        // bloquage de l'exception des x a 3 et 4
        if (grille[2] == 'o' && grille[5] == 'o' && grille[3] == 'x' && grille[4] == 'x' && grille[8] == 0) {
            grille[8] = 'o';
            return 8;
        }

        // bloquage de l'exception des x a 3, 4 et 8
        if (grille[0] == 'o' && grille[2] == 'o' && grille[5] == 'o' && grille[3] == 'x' && grille[4] == 'x' && grille[7] == 'x' && grille[8] == 'x' && grille[1] == 0) {
            grille[1] = 'o';
            return 1;
        }

        // bloquage de l'exception des x dans deux coins oppos�s
        if ( grille[2] == 'x' && grille[6] == 'x' && grille[4] == 'o' && tour <= 3) {
            grille[7] = 'o';
            return 7;
        }

        // bloquage horizontal
        if (grille[0] == 'x' && grille[1] == 'x' && grille[2] == 0) {
            grille[2] = 'o';
            return 2;
        } else if (grille[0] == 'x' && grille[2] == 'x' && grille[1] == 0) {
            grille[1] = 'o';
            return 1;
        } else if (grille[1] == 'x' && grille[2] == 'x' && grille[0] == 0) {
            grille[0] = 'o';
            return 0;
        } else if (grille[3] == 'x' && grille[4] == 'x' && grille[5] == 0) {
            grille[5] = 'o';
            return 5;
        } else if (grille[3] == 'x' && grille[5] == 'x' && grille[4] == 0) {
            grille[4] = 'o';
            return 4;
        } else if (grille[4] == 'x' && grille[5] == 'x' && grille[3] == 0) {
            grille[3] = 'o';
            return 3;
        } else if (grille[6] == 'x' && grille[7] == 'x' && grille[8] == 0) {
            grille[8] = 'o';
            return 8;
        } else if (grille[6] == 'x' && grille[8] == 'x' && grille[7] == 0) {
            grille[7] = 'o';
            return 7;
        } else if (grille[7] == 'x' && grille[8] == 'x' && grille[6] == 0) {
            grille[6] = 'o';
            return 6;
        }

        // bloquage vertical
        else if (grille[0] == 'x' && grille[3] == 'x' && grille[6] == 0) {
            grille[6] = 'o';
            return 6;
        } else if (grille[0] == 'x' && grille[6] == 'x' && grille[3] == 0) {
            grille[3] = 'o';
            return 3;
        } else if (grille[3] == 'x' && grille[6] == 'x' && grille[0] == 0) {
            grille[0] = 'o';
            return 0;
        } else if (grille[1] == 'x' && grille[4] == 'x' && grille[7] == 0) {
            grille[7] = 'o';
            return 7;
        } else if (grille[1] == 'x' && grille[7] == 'x' && grille[4] == 0) {
            grille[4] = 'o';
            return 4;
        } else if (grille[4] == 'x' && grille[7] == 'x' && grille[1] == 0) {
            grille[1] = 'o';
            return 1;
        } else if (grille[2] == 'x' && grille[5] == 'x' && grille[8] == 0) {
            grille[8] = 'o';
            return 8;
        } else if (grille[2] == 'x' && grille[8] == 'x' && grille[5] == 0) {
            grille[5] = 'o';
            return 5;
        } else if (grille[5] == 'x' && grille[8] == 'x' && grille[2] == 0) {
            grille[2] = 'o';
            return 2;
        }

        //bloquage diagonal
        else if (grille[0] == 'x' && grille[4] == 'x' && grille[8] == 0) {
            grille[8] = 'o';
            return 8;
        } else if (grille[0] == 'x' && grille[8] == 'x' && grille[4] == 0) {
            grille[4] = 'o';
            return 4;
        } else if (grille[4] == 'x' && grille[8] == 'x' && grille[0] == 0) {
            grille[0] = 'o';
            return 0;
        } else if (grille[2] == 'x' && grille[4] == 'x' && grille[6] == 0) {
            grille[6] = 'o';
            return 6;
        } else if (grille[2] == 'x' && grille[6] == 'x' && grille[4] == 0) {
            grille[4] = 'o';
            return 4;
        } else if (grille[4] == 'x' && grille[6] == 'x' && grille[2] == 0) {
            grille[2] = 'o';
            return 2;
        }


        // bloquage de l'exception du coin
        else if (grille[1] == 'x' && grille[3] == 'x' && grille[0] == 0) {
            grille[0] = 'o';
            return 0;
        }

        // lorsque un bloquage n'est pas n�cessaire
        else if ( grille[8] == 0 ) {
            grille[8] = 'o';
            return 8;
        } else if ( grille[7] == 0 ) {
            grille[7] = 'o';
            return 7;
        } else if ( grille[6] == 0 ) {
            grille[6] = 'o';
            return 6;
        }	else if ( grille[5] == 0 ) {
            grille[5] = 'o';
            return 5;
        } else if ( grille[3] == 0 ) {
            grille[3] = 'o';
            return 3;
        } else if ( grille[2] == 0 ) {
            grille[2] = 'o';
            return 2;
        } else if ( grille[1] == 0 ) {
            grille[1] = 'o';
            return 1;
        } else {
            grille[0] = 'o';
            return 0;
        }
    }
}
