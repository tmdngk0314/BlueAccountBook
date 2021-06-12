package com.cookandroid.account_book;

import java.io.Serializable;

public class Memo implements Serializable { // 직렬화형태로 전송

    int seq;
    String maintext; //메모
    String subtext; //메모를 입력할 때 입력한 날짜를 자동으로 넣는다.
    int isdone; //메모의 완료여부

    public Memo(int seq, String maintext, String subtext, int isdone) {
        this.seq = seq;
        this.maintext = maintext;
        this.subtext = subtext;
        this.isdone = isdone;
    }

    public Memo(String maintext, String subtext, int isdone) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.isdone = isdone;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public int getIsdone() {
        return isdone;
    }

    public void setIsdone(int isdone) {
        this.isdone = isdone;
    }

}
