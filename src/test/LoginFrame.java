package test;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import test.MyDBConnection;
import test.ManagerFrame;
public class LoginFrame implements ActionListener{

	JFrame logF = new JFrame();
	JPanel log_p1 = new JPanel();
	JPanel log_p2 = new JPanel();
	JPanel log_p3 = new JPanel();
	JPanel log_p4 = new JPanel();
	JPanel log_p5 = new JPanel();
	JPanel log_p6 = new JPanel();
	JPanel log_p7 = new JPanel();
	JLabel log_l1 = new JLabel();
	JLabel log_l2 = new JLabel();
	JLabel log_l3 = new JLabel();
	JLabel log_l4 = new JLabel("账号：");
	JLabel log_l5 = new JLabel("密码：");
	JTextField log_t1 = new JTextField(25);
	JPasswordField log_t2= new JPasswordField(25);
	JButton log_b1 = new JButton("登  陆");
	int judgeNum;
	MyDBConnection mydbcon;
	Connection conn ;
	Statement stam ;

	public LoginFrame(MyDBConnection mydbcon) {
		this.mydbcon = mydbcon;
		this.conn = mydbcon.getMyConnection();
		this.stam = mydbcon.getMyStatement();
		drawUI();
		log_b1.addActionListener(this);
	}
	private void drawUI() {
		logF.setVisible(true);
		logF.setSize(550, 400);
		logF.setLocationRelativeTo(null);
		logF.setDefaultCloseOperation(logF.EXIT_ON_CLOSE);
		logF.add(log_p1,BorderLayout.NORTH);
		logF.add(log_p2,BorderLayout.WEST);
		logF.add(log_p3,BorderLayout.CENTER);
		logF.add(log_p4,BorderLayout.EAST);
		logF.add(log_p5,BorderLayout.SOUTH);
		ImageIcon img1 = new ImageIcon("src/test/1.jpg");
		ImageIcon img2 = new ImageIcon("src/test/2.jpg");
		img1.setImage(img1.getImage().getScaledInstance(550, 200,Image.SCALE_DEFAULT));
		img2.setImage(img2.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		log_l1.setIcon(img1);log_l2.setIcon(img2);
		log_l4.setFont(new Font("Dialog", 1, 20));
		log_l5.setFont(new Font("Dialog", 1, 20));
		log_b1.setPreferredSize(new Dimension(150,30));
		log_p1.add(log_l1);log_p2.add(log_l2);
		log_l1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		log_p3.setLayout(new GridLayout(2,1));
		log_p3.add(log_p6);log_p3.add(log_p7);
		log_p6.add(log_l4);log_p6.add(log_t1);log_p7.add(log_l5);log_p7.add(log_t2);
		log_p5.add(log_b1);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == log_b1) {
			if(judge() == 1) {
				System.out.println("管理员已登录！");
				new ManagerFrame(mydbcon,log_t1.getText());
				//this.logF.setVisible(false);
			}else if(judge()== 2) {
				System.out.println("教师已登录！");
				new TeacherFrame(mydbcon,log_t1.getText());
			}else if(judge() == 3) {
				System.out.println("学生已登录！");
				new StudentFrame(mydbcon,log_t1.getText());
				//this.logF.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null, "账户或密码错误","提示",2);
				log_t2.setText("");
			}
		}
	}
	private int judge() {
		String sql = "select * from tb_logging";
		try {
			ResultSet re = stam.executeQuery(sql);
			while(re.next()) {
				String usernum = re.getString("account").trim();
				String userpwd=re.getString("code").trim();
				int right = re.getInt("_power");
				if(usernum.equals(log_t1.getText())&&userpwd.equals(new String(log_t2.getPassword()))&&right == 1) {
					judgeNum=1;break;
				}else if(usernum.equals(log_t1.getText())&&userpwd.equals(new String(log_t2.getPassword()))&&right == 2) {
					judgeNum=2;break;
				}else if(usernum.equals(log_t1.getText())&&userpwd.equals(new String(log_t2.getPassword()))&&right == 3) {
					judgeNum=3;break;
				}else {
					judgeNum=4;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return judgeNum;
	}
}
