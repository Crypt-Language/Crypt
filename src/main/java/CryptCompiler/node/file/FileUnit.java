package CryptCompiler.node.file;

import CryptCompiler.node.interfaces.Statement;

import java.util.Collections;
import java.util.List;

public class FileUnit {
    private final List<Statement> statements;

    public FileUnit(List<Statement> statements){
        this.statements = statements;
    }

    public List<Statement> getStatements(){
        return Collections.unmodifiableList(statements);
    }

    /*
    Functions and fields will be implemented in later stages

    private final List<Void> fields;
    private final List<Void> functions;

    public FileUnit(List<Void> fields, List<Void> functions){
        this.fields = fields;
        this.functions = functions;
    }

    public List<Void> getFields() {
        return Collections.unmodifiableList(fields);
    }

    public List<Void> getFunctions() {
        return Collections.unmodifiableList(functions);
    }
     */
}
