package com.mycompany.asdr;
import java.util.List;

public class ASDR implements Parser{

    private int i = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;


    public ASDR(List<Token> tokens){
        this.tokens = tokens;
        preanalisis = this.tokens.get(i);
    }

    @Override
    public boolean parse() {
        Q();

        if(preanalisis.tipo == TipoToken.EOF && !hayErrores){
            System.out.println("Consulta correcta");
            return  true;
        }else {
            System.out.println("Se encontraron errores");
        }
        return false;
    }

    // Q -> select D from T
    private void Q(){
        match(TipoToken.SELECT);
        D();
        match(TipoToken.FROM);
        T();
    }

    