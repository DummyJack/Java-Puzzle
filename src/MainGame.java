import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
  
import javax.imageio.ImageIO;
import javax.swing.*;
  
public class MainGame extends JFrame implements MouseListener, ActionListener{

  private JButton choice_easy, choice_hard, restore, end; // p2的介面按鈕
  private button button1[] = new button[9]; // label
  private button button2[] = new button[9];

  // 拼圖的行列
  private int row = 3;
  private int col = 3;

  JLabel text_content; // label
  ImageIcon icon1 = null;
  int j = 0;

  JPanel p1 = new JPanel(); 
  JPanel p2 = new JPanel();
  JPanel p3 = new JPanel();

  public MainGame() {

    BufferedImage buf = null;
    BufferedImage new_buf = null;
    ImageIcon icon = null;

    int w = 0;
    int h = 0;
    int m = 0;      

    p1.setLayout(new GridLayout(3, 3));  // 設置中間流式布局

    // 圖片讀取和分割
    try {
      buf = ImageIO.read(new File("./img/3.jpg")); // 讀取圖片
      w = buf.getWidth() / col;
      h = buf.getHeight() / row;
      setSize(buf.getWidth(), buf.getHeight()+100); // JFrame設置大小屬性
    } catch (IOException e) {
      e.printStackTrace();
    }
    for(int i = 0; i < 3 ;i++)  {
      for(int j = 0; j < 3; j++)  { 
        m = j*3+i; // 當前的圖片座標id，在數組中的下標         
        new_buf = buf.getSubimage(w*i, h*j, w, h);
        icon = new ImageIcon(new_buf); // 圖片轉圖標
        button1[m] = new button(icon, m, w, h, i, j, m);
        button1[m].setLocation(w*j, h*i);
        button2[m] = new button(icon, m, w, h, i, j, m);
        button2[m].setLocation(w*j, h*i);                
        if(m == 8) {  // 最後一張放白色的圖片
          icon = new ImageIcon("./img/white.jpg"); // 白色的圖片             
          button1[m] = new button(icon, m, w, h, i, j, m);
          button2[m] = new button(icon,m, w, h, i, j, m);
        }
      }
    }
    
    p2.add(choice_easy = new JButton("簡單模式"));
    p2.add(choice_hard = new JButton("困難模式"));
    p2.add(restore = new JButton("還原")); 
    p2.add(end = new JButton("結束遊戲"));

    choice_easy.addActionListener(this);
    choice_hard.addActionListener(this); 
    restore.addActionListener(this);
    end.addActionListener(this);

    p3.add(text_content = new JLabel("系統提示：請選擇遊戲難度"));  
    icon1 = (ImageIcon) button1[8].geticon();
    
    set_button();
    setTitle("動漫拼圖"); 
    setLocationRelativeTo(null);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setResizable(false);  
  }
 
  // 設置按鈕
  public void set_button() {
    for(int a = 0; a < 9; a++) {      // 放入圖片                  
      p1.add(button1[a]);
      button1 [a].addMouseListener(this); // 設置鼠標
    }

    // 介面位置
    add(p1, BorderLayout.CENTER);
    add(p2, BorderLayout.PAGE_START);
    add(p3, BorderLayout.PAGE_END); 
  }

  // 移動方法
  public void moves(button b) { // 圖片的編號
    int a = b.getnowID(); // 按鈕的位置
    icon1 = new ImageIcon("./img/white.jpg");

    if(a == 0) {  
      if(button1[a+1].getID() == 8) {  // 判斷相鄰是否為標記的白色圖片
        button1[a+1].setIcon(b.geticon()); 
        button1[a+1].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon()); 
        button1[a+3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }   
    }

    if(a == 1) {  
      if(button1[a+1].getID() == 8) {  
        button1[a+1].setIcon(b.geticon()); 
        button1[a+1].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon()); 
        button1[a+3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon()); 
        button1[a-1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      } 
    }

    if(a == 2) {  
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon()); 
        button1[a+3].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon());
        button1[a-1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      } 
    }
    
    if(a == 3) {  
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon());
        button1[a+3].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
      if(button1[a-3].getID() == 8) {  
        button1[a-3].setIcon(b.geticon());
        button1[a-3].ID = b.getID();
        b.setIcon(icon1);
        b.ID=8;
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+1].getID()==8) {  
        button1[a+1].setIcon(b.geticon()); 
        button1[a+1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      }     
    }

    if(a == 4) { 
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon());
        button1[a+3].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
      if(button1[a-3].getID() == 8) {
        button1[a-3].setIcon(b.geticon());
        button1[a-3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+1].getID() == 8) {  
        button1[a+1].setIcon(b.geticon());
        button1[a+1].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      } 
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon()); 
        button1[a-1].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
    }

    if(a==5) {  
      if(button1[a+3].getID() == 8) {  
        button1[a+3].setIcon(b.geticon()); 
        button1[a+3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+3].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
      if(button1[a-3].getID() == 8) {  
        button1[a-3].setIcon(b.geticon());
        button1[a-3].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++;
      }   
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon()); 
        button1[a-1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      }
    }

    if(a == 6) {  
      if(button1[a-3].getID() == 8) {  
        button1[a-3].setIcon(b.geticon()); 
        button1[a-3].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+1].getID() == 8) {  
        button1[a+1].setIcon(b.geticon()); 
        button1[a+1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      }    
    }

    if(a == 7) {  
      if(button1[a-3].getID() == 8) {  
        button1[a-3].setIcon(b.geticon());
        button1[a-3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++;
      }
      if(button1[a+1].getID() == 8) {  
        button1[a+1].setIcon(b.geticon()); 
        button1[a+1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a+1].icon = b.icon;
        b.icon = icon1;
        j++;
      } 
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon()); 
        button1[a-1].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
    }

    if(a == 8) {  
      if(button1[a-3].getID() == 8) {  
        button1[a-3].setIcon(b.geticon()); 
        button1[a-3].ID = b.getID();   
        b.setIcon(icon1);
        b.ID = 8;     
        button1[a-3].icon = b.icon;
        b.icon = icon1;
        j++; 
      }
      if(button1[a-1].getID() == 8) {  
        button1[a-1].setIcon(b.geticon()); 
        button1[a-1].ID = b.getID();
        b.setIcon(icon1);
        b.ID = 8;
        button1[a-1].icon = b.icon;
        b.icon = icon1;
        j++;
      }  
    } 
  }

  // 圖片移動
  public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    button b = (button) e.getSource();
    moves(b);

    // 假如達成勝利條件，顯示你贏了
    if(win() && j != 0) { 
      j = 0;
      JOptionPane.showConfirmDialog(null, "恭喜你完成！要再來一局嗎 " ,"動漫拼圖", JOptionPane.CANCEL_OPTION); 
    }            
  }

  // 判斷勝利的方法
  private boolean win() {
    int sum = 0;
    for(int s = 0; s < 9; s++) {
      if(button1[s].ID == button1[s].nowID) {
        sum++;
      }
    }
    if(sum == 9) {
      text_content.setText("系统通知：你赢了");
      return true;
    }
    else {
      return false;
    }
  }

  // p2介面的每個按鈕實現的功能
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource() == choice_easy) { // 簡單按鈕
      Out_of_order1(); // 打亂
      String s = "簡單模式";
      text_content.setText(s);
      for(int a = 0; a < 9; a++) {
        if(button1[a].ID == 8) {
          System.out.println(0); 
          continue;
        }
        System.out.println(button1[a].ID+1);
      }
    } 

    if(e.getSource() == choice_hard) { // 困難按鈕
      Out_of_order2(); // 打亂
      String s = "困難模式";
      text_content.setText(s);
      for(int a = 0; a < 9; a++) {
        if(button1[a].ID == 8) {
          System.out.println(0); 
          continue;
        }
        System.out.println(button1[a].ID+1);
      }  
    }

    if(e.getSource() == restore) { // 還原按鈕
      String s = "系统通知：已還原，請重新選擇遊戲模式";
      text_content.setText(s);
      try {
        reduction();
      } catch (IOException e1) {
        e1.printStackTrace();
      }              
    }

    if(e.getSource() == end) { // 結束按鈕
      System.exit(1);
    }   
  } 

  // 還原方法
  private void reduction() throws IOException {
    j = 0;
    for(int a = 0; a < 9; a++) { // 顯示圖
      button1[button1[a].ID].setIcon(button1[a].geticon());  
    }

    for(int i = 0; i < 9 ;i++) { // 還原圖
      button1[i].icon = button2[i].icon;
    }

    for(int i = 0; i < 9 ;i++) { // 還原標記點
      button1[i].ID = button1[i].nowID = i;
    }  
  }

  // 打亂順序(easy mode)
  private void Out_of_order1() {
    for(int a = 0; a < 50; a++) {
      int b = (int) (Math.random()*9);
      moves(button1[b]);
    }   
  }

  // 打亂順序(hard mode)
  private void Out_of_order2() {
    for(int a = 0; a < 10000; a++) {
      int b = (int) (Math.random()*9);
      moves(button1[b]);
    }   
  }

  // 設置圖片
  public void setIcon(String file, JButton iconButton) {  
    ImageIcon icon = new ImageIcon(file);  
    icon.getImage();
    Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(), Image.SCALE_DEFAULT);  
    icon = new ImageIcon(temp);  
    iconButton.setIcon(icon);   
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
  }
}

  