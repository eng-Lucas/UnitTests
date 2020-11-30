public class Calculos
{
    public int Fatorial(int num)
    {
        if (num < 0)
        {
            return -1;
        }
        else
        {
            int fatorial = 1;
            for (int i = 1; i <= num; i++)
            {
                fatorial *= i;
            }
            return fatorial;
        }
    }

    public double Seno(double catetoOposto, double hipotenusa) throws Exception {
        if (catetoOposto <= 0 || hipotenusa <= 0)
            throw new ArithmeticException("Os valores devem ser maiores que 0");
        else if (catetoOposto > hipotenusa)
            throw new ArithmeticException("A hipotenusa deve ser maior que o cateto oposto");
        else {
            return catetoOposto / hipotenusa;
        }
    }

    public double Tangente(double catetoOposto, double catetoAdjacente)
    {
        if (catetoOposto <= 0 || catetoAdjacente <= 0)
            throw new ArithmeticException("Os valores devem ser maiores que 0");
        else
            return catetoOposto/catetoAdjacente;
    }

    //region metodos para Mock

    double anguloNotavel;

    public double getAnguloNotavel() { return anguloNotavel; }

    public double SenoNotavel()
    {
        return Seno(getAnguloNotavel());
    }

    //endregion

    public double verificarAngulo(double angulo)
    {
        //Valores fora dos limites
        if(angulo <= -360)
        {
            angulo = angulo - (((int) (angulo / 360)) * 360);
        }
        else if(angulo > -360 && angulo < 0)
        {
            angulo = angulo + 360;
        }
        else if(angulo >= 360)
        {
            angulo = angulo - (((int) (angulo / 360)) * 360);
        }

        //Regras do circulo trigonométrico
        if (angulo < 0)
        {
            angulo = 360 + angulo;
        }
        if (angulo > 90 && angulo < 180)
        {
            angulo = angulo - 90;
        }
        if (angulo >= 180 && angulo < 270)
        {
            angulo = 180 - angulo;
        }
        if (angulo >= 270 && angulo < 360)
        {
            angulo = angulo - 360;
        }

        return angulo;
    }

    //Não utilizei Math.sin para adicionar uma maior complexidade e condicionais
    public double Seno(double angulo)
    {
        double anguloX = verificarAngulo(angulo);

        //Cálculo do seno
        double x = (anguloX/360) * (2 * Math.PI);
        double sinX = 0;
        int j = 0;
        for(int i = 1; i < 8; i = i + 2)
        {
            sinX += Math.pow(-1,j++) * (Math.pow(x, i)/Fatorial(i));
        }
        return sinX;
    }
}
