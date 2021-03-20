package CryptCompiler.node.interfaces;

import java.util.List;

public interface Call extends Expression{
    List<Void/*Argument*/> getArguments();
    String getIdentifier();
}
