package org.example;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    @Test
    public void deberiaRegistrarPersonaValida() {
        Registry registro = new Registry();
        Persona persona = new Persona("Ana", 1, 30, Gender.FEMALE, true);

        RegisterResult resultado = registro.registerVoter(persona);

        Assert.assertEquals(RegisterResult.VALID, resultado);
    }
    @Test
    public void deberiaRechazarPersonaFallecida() {
        // PREPARAR
        Registry registro = new Registry();
        Persona muerto = new Persona("Carlos", 2, 40, Gender.MALE, false);

        // ACTUAR
        RegisterResult resultado = registro.registerVoter(muerto);

        // VERIFICAR
        Assert.assertEquals(RegisterResult.DEAD, resultado);
    }
    @Test
    public void deberiaRechazarMenorDeEdad() {
        Registry registro = new Registry();
        Persona joven = new Persona("Lucia", 3, 17, Gender.FEMALE, true);

        RegisterResult resultado = registro.registerVoter(joven);

        Assert.assertEquals(RegisterResult.UNDERAGE, resultado);
    }
    @Test
    public void deberiaRechazarEdadInvalida() {
        Registry registro = new Registry();
        Persona rara = new Persona("Error", 4, -1, Gender.UNIDENTIFIED, true);

        RegisterResult resultado = registro.registerVoter(rara);

        Assert.assertEquals(RegisterResult.INVALID_AGE, resultado);
    }
}