package syntaxExamples;//packages are how InteliJ refers to folders

/**
 * Created by Claudiu on 5/9/2016.
 */
public class StringConcatenation
{
    private String s1;
    private String s2;

    public StringConcatenation(String s1, String s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }

    public String stringAdd(){

        return s1+s2;

    }


}
