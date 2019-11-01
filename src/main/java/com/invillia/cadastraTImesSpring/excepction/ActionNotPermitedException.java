package com.invillia.cadastraTImesSpring.excepction;

public class ActionNotPermitedException extends RuntimeException {

    public ActionNotPermitedException(String message){
        super("Ação não permitida!");
    }
}
