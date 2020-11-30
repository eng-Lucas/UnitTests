import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Calculos.class)
public class CalculosTests
{
    Calculos calculos = new Calculos();

    //region Fatorial
    @Test
    public void Fatorial(){
        //arrange
        int atual = 0;
        int esperado = 24;

        //act
        atual = calculos.Fatorial(4);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void FatorialNegativo(){
        //arrange
        int atual = 0;
        int esperado = -1;

        //act
        atual = calculos.Fatorial(-1);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void FatorialZero(){
        //arrange
        int atual = 0;
        int esperado = 1;

        //act
        atual = calculos.Fatorial(0);

        //assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void FatorialPositivo(){
        //arrange
        int atual = 0;
        int esperado = 1;

        //act
        atual = calculos.Fatorial(1);

        //assert
        Assert.assertEquals(esperado, atual);
    }
    //endregion

    //region Seno com cateto e hipotenusa
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void SenoInvalido() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Seno(0,0);
    }

    @Test
    public void SenoHipotenusaInvalida() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Seno(1,0);
    }

    @Test
    public void SenoCatetoOpostoInvalido() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Seno(0,1);
    }

    @Test
    public void SenoNegativo() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Seno(-1,-1);
    }

    @Test
    public void SenoCatetoOpostoMaiorQueHipotenusa() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("A hipotenusa deve ser maior que o cateto oposto");

        calculos.Seno(2,1);
    }

    @Test
    public void SenoValido() throws Exception {
        //arrange
        double atual = 0;
        double esperado = 0.714;

        //act
        atual = calculos.Seno(10,14);

        //assert
        Assert.assertEquals(esperado, atual, 0.001);
    }
    //endregion

    //region Tangente
    @Test
    public void TangenteInvalido() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Tangente(0,0);
    }

    @Test
    public void TangenteCatetoAdjacenteInvalido() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Tangente(1,0);
    }

    @Test
    public void TangenteCatetoOpostoInvalido() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Tangente(0,1);
    }

    @Test
    public void TangenteNegativa() throws Exception {
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Os valores devem ser maiores que 0");

        calculos.Tangente(-1,-1);
    }

    @Test
    public void TangenteValida() throws Exception {
        //arrange
        double atual = 0;
        double esperado = 0.333;

        //act
        atual = calculos.Tangente(1,3);

        //assert
        Assert.assertEquals(esperado, atual, 0.001);
    }
    //endregion

    //region Teste de quadrantes e seus limites
    @Test
    public void SenoAnguloPrimeiroQuadrante() {
        //arrange
        double atual = 0;
        double esperado = 0.7071;

        //act
        atual = calculos.Seno(45);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAngulo90() {
        //arrange
        double atual = 0;
        double esperado = 1;

        //act
        atual = calculos.Seno(90);

        //assert
        Assert.assertEquals(esperado, atual, 1);
    }

    @Test
    public void SenoAnguloSegundoQuadrante() {
        //arrange
        double atual = 0;
        double esperado = 0.7071;

        //act
        atual = calculos.Seno(135);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAngulo180() {
        //arrange
        double atual = 0;
        double esperado = 0;

        //act
        atual = calculos.Seno(180);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAnguloTerceiroQuadrante() {
        //arrange
        double atual = 0;
        double esperado = -0.7071;

        //act
        atual = calculos.Seno(225);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAngulo270() {
        //arrange
        double atual = 0;
        double esperado = -1;

        //act
        atual = calculos.Seno(270);

        //assert
        Assert.assertEquals(esperado, atual, 1);
    }

    @Test
    public void SenoAnguloQuartoQuadrante() {
        //arrange
        double atual = 0;
        double esperado = -0.7071;

        //act
        atual = calculos.Seno(315);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region Limites 0
    @Test
    public void SenoAnguloNegativo() {
        //arrange
        double atual = 0;
        double esperado = -0.017452;

        //act
        atual = calculos.Seno(-1);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAnguloZero() {
        //arrange
        double atual = 0;
        double esperado = 0.0;

        //act
        atual = calculos.Seno(0);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAnguloPositivo() {
        //arrange
        double atual = 0;
        double esperado = 0.017452;

        //act
        atual = calculos.Seno(1);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region Valores baixos negativos
    @Test
    public void SenoAnguloMuitoBaixo() {
        //arrange
        double atual = 0;
        double esperado = 0.98475;

        //act
        atual = calculos.Seno(-100000);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region Limites -360
    @Test
    public void SenoAnguloMenorQue360Negativo() {
        //arrange
        double atual = 0;
        double esperado = -0.01745;

        //act
        atual = calculos.Seno(-361);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAngulo360Negativo() {
        //arrange
        double atual = 0;
        double esperado = 0;

        //act
        atual = calculos.Seno(-360);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAnguloMaiorQue360Negativo() {
        //arrange
        double atual = 0;
        double esperado = 0.01745;

        //act
        atual = calculos.Seno(-359);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region limites 360
    @Test
    public void SenoAnguloMenorQue360Positivo() {
        //arrange
        double atual = 0;
        double esperado = -0.01745;

        //act
        atual = calculos.Seno(359);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAngulo360Positivo() {
        //arrange
        double atual = 0;
        double esperado = 0;

        //act
        atual = calculos.Seno(360);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }

    @Test
    public void SenoAnguloMaiorQue360Positivo() {
        //arrange
        double atual = 0;
        double esperado = 0.01745;

        //act
        atual = calculos.Seno(361);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region Valores altos positivos
    @Test
    public void SenoAnguloMuitoAlto() {
        //arrange
        double atual = 0;
        double esperado = -0.98475;

        //act
        atual = calculos.Seno(100000);

        //assert
        Assert.assertEquals(esperado, atual, 0.00001);
    }
    //endregion

    //region Mock
    @Test
    public void SenoNotavelMock30() throws Exception {
        //arrange
        double atual = 0;
        double esperado = 0.5;
        final String METHOD = "getAnguloNotavel";

        Calculos spy = PowerMockito.spy(calculos);
        PowerMockito.when(spy, METHOD).thenReturn((double) 30);

        //act
        atual = spy.SenoNotavel();

        //assert
        Assert.assertEquals(esperado, atual, 0.001);

        PowerMockito.verifyPrivate(spy, Mockito.times(2));
    }

    @Test
    public void SenoNotavelMock60() throws Exception {
        //arrange
        double atual = 0;
        double esperado = 0.866;
        final String METHOD = "getAnguloNotavel";

        Calculos spy = PowerMockito.spy(calculos);
        PowerMockito.when(spy, METHOD).thenReturn((double) 60);

        //act
        atual = spy.SenoNotavel();

        //assert
        Assert.assertEquals(esperado, atual, 0.001);

        PowerMockito.verifyPrivate(spy, Mockito.times(2));
    }
    //endregion
}
