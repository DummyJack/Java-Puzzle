// p1介面每個按鈕對象具備的功能

import javax.swing.Icon;
import javax.swing.JButton;

public class button extends JButton {

    // 按鈕的寬度和長度大小
    private int image_width; 
    private int image_height;

    // 按鈕的指向座標
    int ID;
    int nowID;

    private int nowx;
    private int nowy;
    Icon icon;

    public button(Icon icon) {
        this.setIcon(icon);
    }

    public button(Icon icon, int id, int imagewidth, int height,int nowx,int nowy,int nowid) { //func初始化，傳入兩個參數，一個是圖像的圖標，一個是按鈕的ID array
        this.setIcon(icon);
        this.ID = id;
        this.nowID = nowid;
        this.image_width = imagewidth;
        this.image_height = height;
        this.setSize(image_width, image_height);
        this.nowx = nowx;
        this.nowy = nowy;
        this.icon = icon;    
    }

    public Icon geticon() {
        return icon;
    }

    public int getID() {
        return ID;
    }

    public int getnowID() {
        return nowID;
    }

    public int getx() {
        return this.getBounds().x;
    }
      
    public int gety() {
        return this.getBounds().y;
    }

    public int getnowx() {
        return nowx;
    }

    public int getnowy() {
        return nowy;
    }
}