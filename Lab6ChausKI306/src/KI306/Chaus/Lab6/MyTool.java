package KI306.Chaus.Lab6;
import java.util.ArrayList;

public class MyTool<T> implements Tool1<T> {

    @Override
    public void print_data(T data) {
        System.out.println(data);
    }

    public void print_data(int prefix) {
        System.out.println(prefix );
    }

    public void print_data(char suffix) {
        System.out.println(suffix);
    }

}
