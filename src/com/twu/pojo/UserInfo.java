package com.twu.pojo;

public class UserInfo {
    String userName; //用户名
    int voteNum=10; //用户剩余票数

    public UserInfo() {
    }

    public UserInfo(String userName, int voteNum) {
        this.userName = userName;
        this.voteNum = voteNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }
}
