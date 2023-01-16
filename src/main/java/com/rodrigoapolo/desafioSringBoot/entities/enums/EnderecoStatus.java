package com.rodrigoapolo.desafioSringBoot.entities.enums;

public enum EnderecoStatus {

    MAIN(1),
    SECONDARY(2);
    private int code;

    private EnderecoStatus(int code) {
        this.code = code;
    }

    public int getCod(){
        return code;
    }

    public static EnderecoStatus valueOf(int code){
        for(EnderecoStatus value : EnderecoStatus.values()){
            if(value.getCod() == code){
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid EnderecoStatus code!");
    }
}
