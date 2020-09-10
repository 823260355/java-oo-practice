package com.twu.admin_character;

import com.twu.MenuManage;
import com.twu.pojo.AdminInfo;
import com.twu.pojo.HotEvent;


import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu extends MenuManage implements AdminOperating {
    HotEvent hotEvent;
    AdminInfo adminInfo;
    ArrayList<HotEvent> hotList;
    Scanner input=new Scanner(System.in);
    public AdminMenu(AdminInfo adminInfo, ArrayList<HotEvent> hotList,HotEvent hotEvent){
        this.adminInfo=adminInfo;
        this.hotList=hotList;
        this.hotEvent=hotEvent;
    }
    public void menuAdmin() {
        System.out.println("您好，" + adminInfo.getName() + ",你可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
        System.out.println("请进行合法的输入（请输入数字1|2|3|4）");
        boolean isNum = input.hasNextInt();
        if (isNum) {
            int selectCharacter = input.nextInt();
            switch (selectCharacter) {
                case 1:
                    viewHotEventListAdmin(); //菜单选择1，查看热搜排行榜
                    break;
                case 2:
                     addHotEventAdmin();//菜单选择2，添加热搜
                    break;
                case 3:
                     addSuperHotEventAdmin();//菜单选择3，添加超级热搜
                    break;

                case 4:          //菜单选择4，是退出
                    System.out.println("您选择了退出，确定要退出吗？(y/n)");
                    Scanner scan = new Scanner(System.in);
                    String scanExit = scan.next();
                    if (scanExit.equals("y")) {
                        System.out.println("您已成功退出此界面！");
                        enter();
                    } else {
                        menuAdmin();
                    }
                    break;
                default:
                    menuAdmin();
                    break;
            }
        }
    }

    @Override
    public void viewHotEventListAdmin() {
        int num; //当前事件排行编号
        if (hotList.size()==0){
            System.out.println("当前还没有热搜事件");
            addHotEventAdmin();
        }
        else {
            for(int i=0;i<hotList.size();i++) {
                num =i+1;
                System.out.println(num+"."+hotList.get(i).getName()+"  "+hotList.get(i).getVoteNum());
            }
            menuAdmin();

        }
    }

    @Override
    public void addHotEventAdmin() {
        System.out.println("请输入你要添加热搜事件的名字:");
        String name = input.next();
        hotEvent.setName(name);
        hotList.add(hotEvent);
        menuAdmin();
    }

    @Override
    public void addSuperHotEventAdmin() {

    }
}
