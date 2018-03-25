package com.example.etien.calculatrice;

/**
 * Created by etien on 03/03/2018.
 */

public class Calculatrice {

    public static String Returnresultat (String symbole, String operande1, String operande2)
    {
        String res;
        switch(symbole)
        {
            case "+":
                res = addition(operande1, operande2);
                break;
            case "-":
                res = soustraction(operande1, operande2);
                break;
            case "*":
                res = multiplication(operande1, operande2);
                break;
            case "/":
                res = division(operande1, operande2);
                break;
            case "R":
                res = divisionEuclidienne(operande1, operande2);
                break;
            default :
                res = "Syntaxe invalide";
                break;
        }
        return res;
    }

    public static String addition (String operande1, String operande2)
    {
        float floatoperande1, floatoperande2, res;
        floatoperande1 = Float.parseFloat(operande1);
        floatoperande2 = Float.parseFloat(operande2);
        res = floatoperande1+floatoperande2;
        if (Math.round(res) == res)
        {
            return Integer.toString(Math.round(res));
        }
        return Float.toString(res);
    }

    public static String soustraction (String operande1, String operande2)
    {
        float floatoperande1, floatoperande2, res;
        floatoperande1 = Float.parseFloat(operande1);
        floatoperande2 = Float.parseFloat(operande2);
        res = floatoperande1-floatoperande2;
        if (Math.round(res) == res)
        {
            return Integer.toString(Math.round(res));
        }
        return Float.toString(res);
    }

    public static String multiplication (String operande1, String operande2)
    {
        float floatoperande1, floatoperande2, res;
        floatoperande1 = Float.parseFloat(operande1);
        floatoperande2 = Float.parseFloat(operande2);
        res = floatoperande1*floatoperande2;
        if (Math.round(res) == res)
        {
            return Integer.toString(Math.round(res));
        }
        return Float.toString(res);
    }

    public static String division (String operande1, String operande2)
    {
        float floatoperande1, floatoperande2, res;
        floatoperande1 = Float.parseFloat(operande1);
        floatoperande2 = Float.parseFloat(operande2);
        res = floatoperande1/floatoperande2;
        if (Math.round(res) == res)
        {
            return Integer.toString(Math.round(res));
        }
        return Float.toString(res);
    }

    public static String divisionEuclidienne (String operande1, String operande2)
    {
        int intoperande1, intoperande2, reste, quotient;
        intoperande1 = Integer.parseInt(operande1);
        intoperande2 = Integer.parseInt(operande2);

        if (intoperande1<intoperande2)
        {
            return "0";
        }

        reste = intoperande1 % intoperande2;
        quotient = (intoperande1-reste)/intoperande2;

        String stringreste = Integer.toString(reste);
        String stringquotient = Integer.toString(quotient);

        return stringquotient+"R"+stringreste;
    }

}
