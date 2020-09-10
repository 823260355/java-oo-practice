package com.twu.user_character;

import com.twu.MenuManage;
import com.twu.pojo.HotEvent;
import com.twu.pojo.UserInfo;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMenu extends MenuManage implements UserOperating {
    HotEvent hotEvent;
     UserInfo userInfo;
    ArrayList<HotEvent> hotList;
     Scanner input = new Scanner(System.in);

     public UserMenu(UserInfo userInfo,ArrayList<HotEvent> hotList,HotEvent hotEvent){
        this.userInfo=userInfo;
        this.hotList=hotList;
        this.hotEvent=hotEvent;
     }
    public void menuUser() {
        System.out.println("您好，" + userInfo.getUserName() + ",你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
        System.out.println("请进行合法的输入（请输入数字1|2|3|4|5）");
        boolean isNum = input.hasNextInt();
        if (isNum) {
            int selectCharacter = input.nextInt();
            switch (selectCharacter) {
                case 1:
                    viewHotEventList(); //菜单选择1，查看热搜排行榜
                    break;
                case 2:
                    voteHotEvent();//菜单选择2，给热搜事件投票
                    break;
                case 3:
                    buyHotEvent();//菜单选择3，购买热搜
                    break;
                case 4:
                    addHotEvent();//菜单选择4，添加热搜
                    break;
                case 5:          //菜单选择5，是退出
                    System.out.println("您选择了退出，确定要退出吗？(y/n)");
                    Scanner scan = new Scanner(System.in);
                    String scanExit = scan.next();
                    if (scanExit.equals("y")) {
                        System.out.println("您已成功退出此界面！");
                        enter();
                    } else {
                        menuUser();
                    }
                    break;
                default:
                    menuUser();
                    break;
            }
        }
    }

    @Override
    public void viewHotEventList() {
         int num; //当前事件排行编号
         if (hotList.size()==0){
            System.out.println("当前还没有热搜事件");
            addHotEvent();
         }
         else {
            for(int i=0;i<hotList.size();i++) {
                num =i+1;
                System.out.println(num+"."+hotList.get(i).getName()+"  "+hotList.get(i).getVoteNum());
            }
             menuUser();

         }
    }

    @Override
    public void voteHotEvent() {
        System.out.println("请输入你要投票的热搜名称：");
        String hotName = input.next();
        for(int i=0;i<hotList.size();i++) {
            if (hotList.get(i).getName().equals(hotName)){
                System.out.println("请输入你要投的票数（你目前还是有"+ userInfo.getVoteNum() +"票）：");
                boolean flag = input.hasNextInt();
                if (flag) { //判断是否为合法数字
                    int voteNum = input.nextInt();
                    if (voteNum >= 1 && voteNum <= userInfo.getVoteNum()) { //判断投票数是否符合余票
                        userInfo.setVoteNum(userInfo.getVoteNum() - voteNum); //投票后，给用户剩余拥有票数重新赋值
                        hotList.get(i).setVoteNum(voteNum + hotList.get(i).getVoteNum()); //投票后，给当前事件热度重新赋值
                        menuUser();
                    }else {
                        System.out.println("投票失败！");
                        menuUser();
                    }
                }else {
                    System.out.println("输入不合法，投票失败！");
                    menuUser();
                }
            }
        }

    }

    @Override
    public void buyHotEvent() {

    }

    @Override
    public void addHotEvent() {
        System.out.println("请输入你要添加热搜事件的名字:");
        String name = input.next();
        hotEvent.setName(name);
        hotList.add(hotEvent);
        menuUser();
    }
}
