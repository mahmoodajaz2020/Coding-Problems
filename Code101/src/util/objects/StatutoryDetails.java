package util.objects;

import java.util.Collection;

public class StatutoryDetails  {
    public int a;
    public String b;
    @Override
    public StatutoryDetails clone()  {
        return new StatutoryDetails();
    }
}
