package com.invillia.cadastraTImesSpring.excepction;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String message){
        super ("Membro não encontrado - ID: " + message);
    }
}
