package com.twu;

import com.twu.admin_character.AdminMenu;
import com.twu.pojo.AdminInfo;
import com.twu.pojo.HotEvent;
import com.twu.pojo.UserInfo;
import com.twu.user_character.UserMenu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 主界面
 * 1.用户
 * 2.管理员
 * 3.退出
 */
public class MenuManage {
    HotEvent hotEvent = new HotEvent();
    UserInfo userInfo=new UserInfo();
    AdminInfo adminInfo=new AdminInfo();
    ArrayList<HotEvent> hotList=new ArrayList();
    Scanner input = new Scanner(System.in);
    public void enter() {
        System.out.println("欢迎来到热搜排行榜，你是？");
        System.out.println("1.用户");
        System.out.println("2.管理员");
        System.out.println("3.退出");
        System.out.println("请进行合法的输入（请输入数字1|2|3）");
        boolean isNum = input.hasNextInt();
        if (isNum){
            int selectCharacter = input.nextInt();
            switch(selectCharacter)
            {
                case 1:
                    userEnter(); //菜单选择1，是用户进入界面
                    break;
                case 2:
                    adminEnter();//菜单选择1，是管理员进入界面
                    break;
                case 3:          //菜单选择3，是退出
                    System.out.println("您选择了退出，确定要退出吗？(y/n)");
                    Scanner scan=new Scanner(System.in);
                    String scanExit=scan.next();
                    if(scanExit.equals("y")){
                        System.out.println("您已成功退出，欢迎您再次使用！");
                        System.exit(-1);
                    }else {
                        enter();
                    }
                    break;
                default:
                    enter();
                    break;
            }
        }
    }

    private void userEnter() {
        UserMenu userMenu = new UserMenu(userInfo,hotList,hotEvent);
        System.out.println("请输入您的昵称：");
        String userName = input.next();
        userInfo.setUserName(userName);
        userMenu.menuUser();
    }
    private void adminEnter() {
        AdminMenu adminMenu = new AdminMenu(adminInfo,hotList,hotEvent);
        System.out.println("请输入管理员名称：");
        String adminName = input.next();
        System.out.println("请输入管理员密码：");
        String adminPassword = input.next();
        if (adminInfo.getName().equals(adminName)&&adminInfo.getPassword().equals(adminPassword)){
          adminMenu.menuAdmin();
        }else {
            System.out.println("用户名或密码错误，请重新输入！");
            adminEnter();
        }
    }
}
