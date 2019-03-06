package com.javacodeing.javassist;

import javassist.*;

import java.io.File;
import java.io.IOException;

/**
 * javassist技术生成字节码文件
 */
public class JavaSsist {

    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException {
        ClassPool classPool = ClassPool.getDefault();
        // 创建类
        CtClass userClass = classPool.makeClass("com.javacodeing.javassist.user");

        // 创建添加字段
        CtField nameField = CtField.make("private String name;", userClass);
        CtField ageField = CtField.make("private Integer age;", userClass);
        userClass.addField(nameField);
        userClass.addField(ageField);

        // 创建添加方法
        CtMethod setNameMethod = CtMethod.make("public void setName (String name) { this.name = name; }", userClass);
        CtMethod getNameMethod = CtMethod.make("public String getName () { return name; }", userClass);
        CtMethod setAgeMethod = CtMethod.make("public void setAge (String name) { this.name = name; }", userClass);
        CtMethod getAgeMethod = CtMethod.make("public Integer getAge () { return age; }", userClass);
        userClass.addMethod(setNameMethod);
        userClass.addMethod(getNameMethod);
        userClass.addMethod(setAgeMethod);
        userClass.addMethod(getAgeMethod);

        // 创建添加构造函数
        CtConstructor userConstructor = new CtConstructor(new CtClass[] { classPool.get("java.lang.String"), classPool.get("java.lang.Integer") }, userClass);
        userConstructor.setBody("{ this.name = name; this.age = age; }");
        userClass.addConstructor(userConstructor);

        // 生成字节码文件
        userClass.writeFile("D:" + File.separator);

    }

}
