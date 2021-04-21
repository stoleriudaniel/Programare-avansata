package laborator;

import laborator.dao.Actors;
import laborator.dao.Genres;
import laborator.dao.Movies;

import java.io.*;

public class Tools {
    private String row;
    public Tools(){}
    public static void insertRowsFromIMDbFile()
    {
        FileReader fileReader = null;
        try{
            fileReader = new FileReader("D:\\AplicatiiJava\\Laborator8\\IMDb_movies.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            System.out.println(line);
            int ind=0;
            while(line!=null) {
                ind++;
                System.out.println("ind:" + ind + " " + line);
                int position=0;
                String imdbTitleId[]=getInfo(line,position);
                position=nextPosition(line,position);
                String title[]=getInfo(line,position);
                position=nextPosition(line,position);
                String originalTitle[]=getInfo(line,position);
                position=nextPosition(line,position);
                String year[] = getInfo(line,position);
                position=nextPosition(line,position);
                String datePublished[] = getInfo(line,position);
                position=nextPosition(line,position);
                String genre[] = getInfo(line,position);
                position=nextPosition(line,position);
                String duration[] = getInfo(line,position);
                position=nextPosition(line,position);
                String country[] = getInfo(line,position);
                position=nextPosition(line,position);
                String language[] = getInfo(line,position);
                position=nextPosition(line,position);
                String director[] = getInfo(line,position);
                position=nextPosition(line,position);
                String writer[] = getInfo(line,position);
                position=nextPosition(line,position);
                String productionCompany[] = getInfo(line,position);
                position=nextPosition(line,position);
                String actors[] = getInfo(line,position);
                position=nextPosition(line,position);
                String description[] = getInfo(line,position);
                position=nextPosition(line,position);
                String avgVote[] = getInfo(line,position);
                position=nextPosition(line,position);
                String votes[] = getInfo(line,position);
                position=nextPosition(line,position);
                String budget[] = getInfo(line,position);
                position=nextPosition(line,position);
                String usaGrossIncome[] = getInfo(line,position);
                position=nextPosition(line,position);
                String worldwideGrossIncome[] = getInfo(line,position);
                position=nextPosition(line,position);
                String metascore[] = getInfo(line,position);
                position=nextPosition(line,position);
                String reviewsFromUsers[] = getInfo(line,position);
                Movies.init();
                if(votes[0].length()==0)
                    votes[0]="0";
                Movies.insertNewRow(title[0],datePublished[0],Integer.parseInt(duration[0]),Integer.parseInt(votes[0]),Singleton.getConnection());
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fisierul lipseste!");
        } catch (IOException e) {
            System.out.println("Eroare la citirea din fisier!");
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.err.println("Eroare la inchiderea fisierului!");
                }
            }
        }
    }
    public static int nextPosition(String line, int position)
    {
        if(line.charAt(position)==',' && position<line.length()-1 &&  line.charAt(position+1)=='"')
        {
            position=position+2;
            while(line.charAt(position)!= '"' && position<line.length())
            {
                position++;
            }
            position++;
        }
        else if(line.charAt(position)==',' && position<line.length())
        {
            position++;
            while(line.charAt(position)!=',' && position<line.length())
            {
                position++;
            }
        }
        else if(position==0){
            while(line.charAt(position)!=',')
            {
                position++;
            }
        }
        return position;
    }
    public static String[] getInfo(String line, int position)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if(line.charAt(position)==',' && position<line.length()-1 && line.charAt(position+1)=='"')
        {
            position=position+2;
            while(line.charAt(position)!= '"' && position<line.length())
            {
                stringBuilder.append(line.charAt(position));
                position++;
            }
            position++;
        }
        else if(line.charAt(position)==',' && position<line.length())
        {
            position++;
            while(line.charAt(position)!=',' && position<line.length())
            {
                stringBuilder.append(line.charAt(position));
                position++;
            }
        }
        else if(position==0){
            while(line.charAt(position)!=',')
            {
                stringBuilder.append(line.charAt(position));
                position++;
            }
        }
        String[] strArrOf = stringBuilder.toString().split(",");
        return strArrOf;
    }
    public void printArrOfStr(String[] arr)
    {
        for(String str : arr)
            System.out.print(str+" ");
        System.out.println();
    }
}
