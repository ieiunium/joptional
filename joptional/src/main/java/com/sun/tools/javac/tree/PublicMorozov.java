package com.sun.tools.javac.tree;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class PublicMorozov
{
  public static JCTree.JCMethodDecl jCMethodDecl( JCTree.JCModifiers jcModifiers, Name name,
    JCTree.JCExpression jcExpression,
    List<JCTree.JCTypeParameter> list, JCTree.JCVariableDecl jcVariableDecl, List<JCTree.JCVariableDecl> list1,
    List<JCTree.JCExpression> list2, JCTree.JCBlock jcBlock, JCTree.JCExpression jcExpression1,
    Symbol.MethodSymbol methodSymbol )
  {
    return new JCTree.JCMethodDecl(
      jcModifiers, name, jcExpression, list, jcVariableDecl, list1, list2,
      jcBlock, jcExpression1, methodSymbol );
  }


  public static <T> T newInstance( Class<T> tClass, Object... args )
  {
    try {

      Constructor<T> constructor = (Constructor<T>)tClass.getDeclaredConstructors()[0];
      constructor.setAccessible( true );
      return constructor.newInstance( args );
    } catch( IllegalAccessException | InstantiationException | InvocationTargetException e ) {
      e.printStackTrace();
      throw new RuntimeException( e );
    }
  }
}
