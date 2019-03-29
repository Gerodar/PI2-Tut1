import java.io.*;

public class AutoAnw
{
    public static void main(String[] args)
    {
        try
        {
            String csv, eingabe, delim = ";";
            Auto[] autoList = new Auto[0];
            Auto auto;
            FileReader fr1 = new FileReader("autoEin.txt");
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw1 = new FileWriter("autoAus.txt");
            PrintWriter pw1 = new PrintWriter(fw1);

            csv = br1.readLine();
            while(csv != null)
            {
                auto = new Auto();
                try
                {
                    auto = auto.csv2Auto(csv);
                } catch(NumberFormatException ex)
                {
                    auto = null;
                    System.out.println("Es gab einen Umwandlungsfehler!");
                }
                if(auto != null)
                {
                    System.out.println(auto.autoAus());
                    autoList = autoAnhaengen(autoList, auto);
                } else
                {
                    System.out.println("Auto wurde nicht richtig angelegt");
                }
                csv = br1.readLine();
            }

            br1.close();
            fr1.close();

            System.out.println("\nDie korrekten Autos sind:");
            for(Auto autoAus : autoList)
            {
                System.out.println(autoAus.autoAus());
            }

            do
            {
                System.out.println("\nBitte einen CSV-Datensatz im Format MMMM;KKKK;GEBR;GEFA eingeben");
                eingabe = in.readLine();

                auto = new Auto();
                try
                {
                    auto = auto.csv2Auto(eingabe);
                } catch(NumberFormatException ex)
                {
                    auto = null;
                    eingabe = "";
                    System.out.println("Ein eingegebener Wert war keine Nummer");
                }

                if(auto != null)
                {
                    autoList = autoAnhaengen(autoList, auto);
                }
            } while(eingabe.split(delim).length != 4 || auto == null);

            in.close();

            for(Auto autoAus : autoList)
            {
                System.out.println(autoAus.autoAus());
                pw1.println(autoAus.autoAus());
            }

            //pw1.flush();

            pw1.close();
            fw1.close();

        } catch (IOException ex)
        {
            System.out.println("IOException");
        }
    }

    private static Auto[] autoAnhaengen(Auto[] autoList, Auto auto)
    {
        Auto[] temp = new Auto[autoList.length + 1];
        for(int i = 0; i < autoList.length; i++)
        {
            temp[i] = autoList[i];
        }

        temp[autoList.length] = auto;
        return temp;
    }
}
