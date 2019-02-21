package com.javacodeing.designmode.builder;

/**
 * 建造者模式:将复杂对象的构建与它的表示分离,使之同样的构建过程可以创建不同的表示
 * 使用场景:需要生成的对象具有复杂的内部结构,内部属性本身互相依赖
 * 与工厂模式的区别是建造者模式更关注零件(对象属性)装配的顺序
 */
public class RoleBuilderClient {

    public static void main(String[] args) {
        RoleDressDirector roleDressDirector = new RoleDressDirector();
        // 建造盲僧角色服饰
        RoleDress leesinRoleDress = roleDressDirector.createRoleDress(new LeeSinRoleDressBuilder());
        // 建造EZ角色服饰
        RoleDress ezrealRoleDress = roleDressDirector.createRoleDress(new EzrealRoleDressBuilder());

        System.out.println(leesinRoleDress.toString());
        System.out.println(ezrealRoleDress.toString());
    }

}
