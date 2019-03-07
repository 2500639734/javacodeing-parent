package com.javacodeing.jvm.javassist;

import javassist.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * javassist技术动态修改字节码文件
 */
public class JavaSsistaUpdate {

    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 动态修改方法
        ClassPool classPool = ClassPool.getDefault();
        CtClass userClass = classPool.get("com.javacodeing.jvm.javassist.User");
        CtMethod ctMethod = new CtMethod(CtClass.intType, "sum", new CtClass[]{ CtClass.intType, CtClass.intType }, userClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        ctMethod.setBody("{ return $1 + $2; }");
        userClass.addMethod(ctMethod);
        userClass.writeFile("D:" + File.separator);

        // 调用方法
        Class userClazz = userClass.toClass();
        Method method = userClazz.getDeclaredMethod("sum", int.class, int.class);
        Object userObj = userClazz.newInstance();
        Object result = method.invoke(userObj, 1, 1);

        System.out.printf("sum = %d", result);

    }

}
