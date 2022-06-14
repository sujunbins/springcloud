package com.junbin.springcloud.Commom.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/*
 *
 * 生成和处理验证码图片的工具类
 * */

public class ValidCode {


    private static String code = null;

    public static String drawRandomText(int width, int hight, BufferedImage img) {
        //创建画笔
        Graphics2D graphics2D = (Graphics2D) img.getGraphics();
        graphics2D.setColor(Color.WHITE);  //设置画笔颜色  验证码背景颜色
        graphics2D.fillRect(0, 0, width, hight);  //填充背景
        graphics2D.setFont(new Font("微软雅黑", Font.BOLD, 30));
        String text = getsalt(4);
        StringBuffer stringBuffer = new StringBuffer();
        String change = "";
        Random random = new Random();
        int x = 10;  //旋转原点的 x 坐标
        for (int i = 0; i < 4; i++) {
            graphics2D.setColor(getRandomColor());
            change = text.charAt(i) + "";
            int degree = new Random().nextInt() % 30;  //角度小于30度
            stringBuffer.append(change);
            //正向旋转

            graphics2D.rotate(degree * Math.PI / 180, x, 45);
            graphics2D.drawString(change, x, 40);
            //反向旋转
            graphics2D.rotate(-degree * Math.PI / 180, x, 45);
            x = x + 48;

        }
        //画干扰线
        for (int i = 0; i < 6; i++) {
            graphics2D.setColor(getRandomColor());

            //随机画线

            graphics2D.drawLine(random.nextInt(width), random.nextInt(hight),
                    random.nextInt(width), random.nextInt(hight));


        }

        for (int i = 0; i < 30; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(hight);
            graphics2D.setColor(getRandomColor());
            graphics2D.fillRect(x1, y1, 2, 2);
        }
        return stringBuffer.toString();

    }

    /*
     * 随机取色
     * */

    private static Color getRandomColor() {

        Random random = new Random();
        Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }


    public static String getsalt(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}



