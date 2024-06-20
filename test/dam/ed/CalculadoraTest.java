package dam.ed;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.management.OperationsException;
import javax.naming.OperationNotSupportedException;

class CalculadoraTest {

    // Definimos el objeto para usarlo en todos los tests
    static Calculadora miCalculadora;

    @BeforeAll
    public static void setUpClass(){
        miCalculadora = new Calculadora();
    }

    @Test
    @DisplayName("Sumar dos números enteros")
    void testSumar() {
        assertEquals(5, miCalculadora.suma(2,3));
        assertEquals(5, miCalculadora.suma(5,0));
        assertEquals(8, miCalculadora.suma(4,4));
        assertEquals(-4, miCalculadora.suma(-5,1));
    }
    @Test
    @DisplayName("Sumar dos números")
    void testSumarConDecimales() {
        assertEquals(6, miCalculadora.suma(2.5,3.5),0.001);
        assertEquals(3.3, miCalculadora.suma(3.3,0),0.001);
        assertEquals(8.5, miCalculadora.suma(4.2,4.3),0.001);
        assertEquals(-4, miCalculadora.suma(-5.5,1.5),0.001);
    }

    @Test
    @DisplayName("Restar dos números enteros")
    void testRestar() {
        assertEquals(-1, miCalculadora.resta(2,3));
        assertEquals(5, miCalculadora.resta(5,0));
        assertEquals(0, miCalculadora.resta(4,4));
        assertEquals(-6, miCalculadora.resta(-5,1));
    }

    @Test
    @DisplayName("Restar dos números")
    void testRestarConDecimales() {
        assertEquals(-0.5, miCalculadora.resta(2.5,3),0.001);
        assertEquals(5.6, miCalculadora.resta(5.6,0),0.001);
        assertEquals(0.6, miCalculadora.resta(4.6,4 ),0.001);
        assertEquals(-6.5, miCalculadora.resta(-5.5,1),0.001);
    }


    @Test
    @DisplayName("Multiplica dos números")
    void testMultiplicar() {
        assertEquals(6, miCalculadora.multiplica(2,3));
        assertEquals(0, miCalculadora.multiplica(5,0));
        assertEquals(16, miCalculadora.multiplica(4,4));
        assertEquals(-5, miCalculadora.multiplica(-5,1));
    }

    @Test
    @DisplayName("Divisiones enteras y reales")
    void testDivisionesEnterasYReales() throws Exception, OperacionInvalidaException {
        assertEquals(2, miCalculadora.divide(4,2));
        assertEquals(2.5, miCalculadora.divide(10,4));
        assertEquals(4, miCalculadora.divide(10,2.5));
        assertEquals(3.2, miCalculadora.divide(8,2.5));
        assertEquals(0.5, miCalculadora.divide(2,4));
    }

    @Test
    @DisplayName("Divisiones positivos y negativos")
    void testDivisionesPositivosYNegativos() throws Exception, OperacionInvalidaException {
        assertTrue(miCalculadora.divide(4,2) > 0);
        assertTrue(miCalculadora.divide(4,-2)< 0);
        assertTrue(miCalculadora.divide(-4,2) < 0);
        assertTrue(miCalculadora.divide(-4,-2) > 0);
    }

    @Test
    @DisplayName("División por cero causa excepción")
    void testDivisionPorCero() {
        Exception thrown = assertThrows(OperacionInvalidaException.class, () -> {
            miCalculadora.divide(5,0);
        });

        assertEquals("El divisor es 0", thrown.getMessage());
    }

    @Test
    @DisplayName("potencias positivos y negativos")
    void testPotencias() throws Exception {
        assertEquals(16,miCalculadora.potencia(4,2));
        assertEquals(0.0625,miCalculadora.potencia(4,-2),0.001);
        assertEquals(16,miCalculadora.potencia(-4,2));
        assertEquals(-8,miCalculadora.potencia(-2,3));
        assertEquals(0.0625,miCalculadora.potencia(-4,-2),0.001);
    }
    @Test
    @DisplayName("Potencias positivos y negativos")
    void testPotenciasPositivosYNegativos() throws Exception {
        assertTrue(miCalculadora.potencia(4,2) > 0);
        assertTrue(miCalculadora.potencia(-4,-3)< 0);
        assertTrue(miCalculadora.potencia(-4,2) > 0);
        assertTrue(miCalculadora.potencia(-4,-2) > 0);
    }

    @Test
    @DisplayName("Raices positivos y negativos")
    void testRaices() throws Exception, OperacionInvalidaException {
        assertEquals(1,miCalculadora.raizCuadrada(1));
        assertEquals(0,miCalculadora.raizCuadrada(0));
        assertEquals(2,miCalculadora.raizCuadrada(4));
    }

    @Test
    @DisplayName("Numeros negativos causa excepción")
    void testRaizNegativa() {
        Exception thrown = assertThrows(OperacionInvalidaException.class, () -> {
            miCalculadora.raizCuadrada(-8);
        });

        assertEquals("El radicando no puede ser negativo", thrown.getMessage());
    }

}
