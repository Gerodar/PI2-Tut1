import java.io.BufferedReader;
import java.io.IOException;

public class Auto
{
    private static int autoID;
    private int ctr = 0;
    private double kosten;
    public String marke;
    public boolean gebraucht;
    public int gefahren;

    public Auto()
    {

    }

    public Auto(String marke, double kosten, boolean gebraucht, int gefahren)
    {
        Auto.autoID++;
        if(this.setKosten(kosten))
        {
            this.setKosten(kosten);
        }
        else
        {
            if(this.getCtr() == 0)
            {
                this.setCtr(-1);
            } else
            {
                this.setCtr(-4);
            }
        }

        this.marke = marke;
        this.gebraucht = gebraucht;

        if(this.gebraucht)
        {
            if(gefahren > 0)
            {
                this.gefahren = gefahren;
            } else
            {
                if(this.getCtr() == 0)
                {
                    this.setCtr(-2);
                } else
                {
                    this.setCtr(-4);
                }
            }
        } else
        {
            if(gefahren > 0)
            {
                if(this.getCtr() == 0)
                {
                    this.setCtr(-3);
                } else
                {
                    this.setCtr(-4);
                }

            } else
            {
                this.setGefahren(gefahren);
            }
        }

        if(this.getCtr() == 0)
        {
            this.setCtr(1);
        }
    }

    public Auto csv2Auto(String csv) throws NumberFormatException
    {
        String delim = ";";
        Auto auto = null;
        String[] werte = csv.split(delim);

        if(werte.length != 4)
        {
            return null;
        }

        auto = new Auto(werte[0], Double.parseDouble(werte[1]), Boolean.parseBoolean(werte[2]), Integer.parseInt(werte[3]));
        if(auto.getCtr() != 1)
        {
            return null;
        } else
        {
            return auto;
        }
    }

    public String autoAus()
    {
        String ausgabe = this.getMarke() + ";" + this.getKosten() + ";" + this.isGebraucht() + ";" + this.getGefahren();
        return ausgabe;
    }

    public int getCtr()
    {
        return ctr;
    }

    public double getKosten()
    {
        return kosten;
    }

    public String getMarke()
    {
        return marke;
    }

    public boolean isGebraucht()
    {
        return gebraucht;
    }

    public int getGefahren()
    {
        return gefahren;
    }

    private static boolean setAutoID(int autoID)
    {
        if(autoID > 0)
        {
            Auto.autoID = autoID;
            return true;
        }
        return false;
    }

    private void setCtr(int ctr)
    {
        this.ctr = ctr;
    }

    public boolean setKosten(double kosten)
    {
        if(kosten >= 1000.0)
        {
            this.kosten = kosten;
            return true;
        }
        return false;
    }

    public void setMarke(String marke)
    {
        this.marke = marke;
    }

    public void setGebraucht(boolean gebraucht)
    {
        this.gebraucht = gebraucht;
    }

    public void setGefahren(int gefahren)
    {
        this.gefahren = gefahren;
    }

    public static int getAutoID()
    {
        return autoID;
    }
}
