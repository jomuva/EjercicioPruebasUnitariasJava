package org.example;

public class Registry {

    private static final int EDAD_MINIMA = 18;
    private static final int EDAD_MAXIMA = 120;

    public RegisterResult registerVoter(Persona p) {
        if (p == null) {
            return RegisterResult.INVALID_AGE; // proteger contra datos vacíos
        }
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        if (p.getAge() < 0 || p.getAge() > EDAD_MAXIMA) {
            return RegisterResult.INVALID_AGE;
        }
        if (p.getAge() < EDAD_MINIMA) {
            return RegisterResult.UNDERAGE;
        }
        return RegisterResult.VALID;
    }
}