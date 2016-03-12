package com.example.danielbastos.msn.Chat.Model;

/**
 * Created by rafael on 10/03/2016.
 */
public class Mensagem {

    private int id;

    private String mensagemId;
    private String origem;
    private String destino;
    private String mensagem;
    private String data;

    public Mensagem(int id, String mensagemId, String origem, String destino, String mensagem, String data) {
        this.id = id;
        this.mensagemId = mensagemId;
        this.origem = origem;
        this.destino = destino;
        this.mensagem = mensagem;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMensagemId() {
        return mensagemId;
    }
    public void setMensagemId(String mensagemId) {
        this.mensagemId = mensagemId;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public boolean isMinhaMensagem(String email) {
        if (email.equals(this.origem)) {
            return true;
        }
        return false;
    }
}