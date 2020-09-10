package com.twu.pojo;

public class HotEvent {
    String name; //热搜事件名称
    int rank=0; //热搜事件排名
    int voteNum=0;//热搜事件的票数
    int buyCurrentMoney=0; //当前热搜事件的购买金额，默认为0
    boolean superEvent=false; //是否为超级热搜，默认为 否

    public HotEvent() {

    }
    public HotEvent(String name, int rank, int voteNum, int buyCurrentMoney) {
        this.name = name;
        this.rank = rank;
        this.voteNum = voteNum;
        this.buyCurrentMoney = buyCurrentMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public int getBuyCurrentMoney() {
        return buyCurrentMoney;
    }

    public void setBuyCurrentMoney(int buyCurrentMoney) {
        this.buyCurrentMoney = buyCurrentMoney;
    }
}

