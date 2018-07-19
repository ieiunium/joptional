package by.kir;

public class Tuple<T>
{
  private T t;

  private Tuple( T t )
  {
    this.t = t;
  }

  public static <T> Tuple<T> of(T t){
    return new Tuple<>( t );
  }
}
