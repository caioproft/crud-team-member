package com.invillia.cadastraTImesSpring.excepction;

public class TeamNotFoundException extends RuntimeException {

    public TeamNotFoundException(String message){
        super ("Time não encontrado, ID " + message);
    }
}
