package test;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import test.MyDBConnection;
public class ManagerFrame implements ActionListener{
	Graphics g;
	MyDBConnection mydbcon;
	Connection conn;
	Statement stam;
	String accountNum;
	JFrame maf = new JFrame("选课管理系统——管理员");
	JSplitPane maf_sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane maf_sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane maf_sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane maf_sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane maf_sp5 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	
	JPanel maf_p1 = new JPanel();
	JPanel maf_p2 = new JPanel();
	JPanel maf_p3 = new JPanel();
	JPanel maf_p4 = new JPanel();
	JPanel maf_p5 = new JPanel();
	JPanel maf_p6 = new JPanel();
	JPanel maf_p7 = new JPanel();
	JPanel maf_p8 = new JPanel();
	JPanel maf_p9 = new JPanel();
	JPanel maf_p10 = new JPanel();
	JPanel maf_p11 = new JPanel();
	JPanel maf_p12 = new JPanel();
	JPanel maf_p13 = new JPanel();
	JPanel maf_p14 = new JPanel();
	JPanel maf_p15 = new JPanel();
	JPanel maf_p16 = new JPanel();
	JPanel maf_p17 = new JPanel();
	JPanel maf_p18 = new JPanel();
	JPanel maf_p19 = new JPanel();
	JPanel maf_p20 = new JPanel();
	JPanel maf_p21 = new JPanel();
	JPanel maf_p22 = new JPanel();
	JPanel maf_p23 = new JPanel();
	JPanel maf_p24 = new JPanel();
	JPanel maf_p25 = new JPanel();
	JPanel maf_p26 = new JPanel();
	JPanel maf_p27 = new JPanel();
	JPanel maf_p28 = new JPanel();
	JPanel maf_p29 = new JPanel();//
	JPanel maf_p30 = new JPanel();
	JPanel maf_p31 = new JPanel();
	JPanel maf_p32 = new JPanel();
	JPanel maf_p33 = new JPanel();//
	JPanel maf_p34 = new JPanel();
	JPanel maf_p35 = new JPanel();
	JPanel maf_p36 = new JPanel();
	JPanel maf_p37 = new JPanel();//
	JPanel maf_p38 = new JPanel();//查询界面开始使用的8个panel  
	JPanel maf_p39 = new JPanel();
	JPanel maf_p40 = new JPanel();
	JPanel maf_p41 = new JPanel();
	JPanel maf_p42 = new JPanel();
	JPanel maf_p43 = new JPanel();
	JPanel maf_p44 = new JPanel();
	JPanel maf_p45 = new JPanel();	

	JLabel maf_l1 = new JLabel();
	JLabel maf_l2 = new JLabel();
	JLabel maf_l3 = new JLabel("欢迎您！");
	JLabel maf_l5 = new JLabel("学号：");
	JLabel maf_l6 = new JLabel("姓名：");
	JLabel maf_l7 = new JLabel("班级：");
	JLabel maf_l8 = new JLabel("性别：");
	JLabel maf_l9 = new JLabel("年龄：");
	JLabel maf_l10 = new JLabel("专业：");
	JLabel maf_l11 = new JLabel("密码：");
	JLabel maf_l13 = new JLabel("工号：");
	JLabel maf_l14 = new JLabel("姓名：");
	JLabel maf_l15 = new JLabel("性别：");
	JLabel maf_l16 = new JLabel("年龄：");
	JLabel maf_l17 = new JLabel("职称：");
	JLabel maf_l18 = new JLabel("密码：");
	JLabel maf_l20 = new JLabel();
	JLabel maf_l21 = new JLabel("选课时间：2019.6.12————2019.6.20");
	JLabel maf_l22 = new JLabel("教师工号：");
	JLabel maf_l23 = new JLabel("学生学号：");
	JLabel maf_l24 = new JLabel("教师工号：");//查询里用
	JLabel maf_l25 = new JLabel("学生学号：");
	
	JButton maf_b1 = new JButton("用户管理");
	JButton maf_b2 = new JButton("添加教师");
	JButton maf_b3 = new JButton("添加学生");
	JButton maf_b4 = new JButton("选课通知");
	JButton maf_b5 = new JButton("确定");
	JButton maf_b6 = new JButton("确定");
	JButton maf_b7 = new JButton("删除老师");
	JButton maf_b8 = new JButton("删除学生");
	JButton maf_b9 = new JButton("确定删除");
	JButton maf_b10 = new JButton("确定删除");
	JButton maf_b11 = new JButton("查询教师");//
	JButton maf_b12 = new JButton("查询学生");
	JButton maf_b13 = new JButton("查询所有老师");
	JButton maf_b14 = new JButton("确认查询该老师");
	JButton maf_b15 = new JButton("查询所有学生");
	JButton maf_b16 = new JButton("确认查询该学生");
	
	JTextField maf_t1 = new JTextField(20);
	JTextField maf_t2 = new JTextField(20);
	JTextField maf_t3 = new JTextField(20);
	JTextField maf_t4 = new JTextField(20);
	JTextField maf_t5 = new JTextField(20);
	JTextField maf_t6 = new JTextField(20);
	JTextField maf_t7 = new JTextField(20);
	JTextField maf_t8 = new JTextField(20);
	JTextField maf_t9 = new JTextField(20);
	JTextField maf_t10 = new JTextField(20);
	JTextField maf_t11 = new JTextField(20);
	JTextField maf_t12 = new JTextField(20);
	JTextField maf_t13 = new JTextField(20);
	JTextField maf_t14 = new JTextField(20);
	JTextField maf_t15 = new JTextField(20);
	JTextField maf_t16 = new JTextField(20);//
	JTextField maf_t17 = new JTextField(20);
	JTextField maf_t18 = new JTextField(20);//查询里用
	JTextField maf_t19 = new JTextField(20);
	
	ImageIcon img1 = new ImageIcon("src/test/4.jpg");
	ImageIcon img2 = new ImageIcon("src/test/5.jpg");
	ImageIcon img3 = new ImageIcon("src/test/6.jpg");
	
	String[] columnNames1 = {"工号","姓名","性别","年龄","职称","密码","权限"};
	String[] columnNames2 = {"学号","姓名","班级","性别","年龄","专业","密码","权限"};
	String [][] data1 = { };
	//创建表格并设置表格只读
	DefaultTableModel model1 = new DefaultTableModel(data1, columnNames1) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
		    return false;
		  }
	};
	String [][] data2 = { };
	//创建表格并设置表格只读
	DefaultTableModel model2 = new DefaultTableModel(data2, columnNames2) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
		    return false;
		  }
	};	
	JTable table1= new JTable(model1);
	JTable table2= new JTable(model2);
	JScrollPane scroll1 = new JScrollPane(table1);
	JScrollPane scroll2 = new JScrollPane(table2);

	public ManagerFrame(MyDBConnection mydbcon,String accountNum) {
		this.mydbcon  = mydbcon;
		this.conn = mydbcon.getMyConnection();
		this.stam = mydbcon.getMyStatement();
		this.accountNum = accountNum;
		drawUI();
		maf_b1.addActionListener(this);
		maf_b2.addActionListener(this);
		maf_b3.addActionListener(this);
		maf_b4.addActionListener(this);
		maf_b5.addActionListener(this);
		maf_b6.addActionListener(this);
		maf_b7.addActionListener(this);
		maf_b8.addActionListener(this);
		maf_b9.addActionListener(this);
		maf_b10.addActionListener(this);
		maf_b11.addActionListener(this);
		maf_b12.addActionListener(this);
		maf_b13.addActionListener(this);
		maf_b14.addActionListener(this);
		maf_b15.addActionListener(this);
		maf_b16.addActionListener(this);
	}

	private void drawUI() {
		maf.setVisible(true);
		maf.setSize(1000, 800);
		maf.setLocationRelativeTo(null);
		maf.setDefaultCloseOperation(maf.DISPOSE_ON_CLOSE);
		img1.setImage(img1.getImage().getScaledInstance(1000, 100,Image.SCALE_DEFAULT));
		maf_l1.setIcon(img1);
		maf_sp1.setLeftComponent(maf_l1);
		maf_sp1.setDividerLocation(100);
		maf_sp1.setDividerSize(8);		
		maf_sp2.setLeftComponent(maf_sp4);
		maf_sp2.setRightComponent(maf_p2);//右部显示界面
		maf_sp2.setDividerLocation(250);
		maf_sp2.setDividerSize(8);
		maf_sp2.setOneTouchExpandable(true);
		maf_sp2.setContinuousLayout(true);
		maf_sp1.setRightComponent(maf_sp2);
		maf.add(maf_sp1);
		
		maf_sp3.setLeftComponent(maf_p3);
		maf_sp3.setRightComponent(maf_p4);
		maf_sp3.setDividerLocation(250);
		maf_sp3.setDividerSize(8);
		maf_sp3.setOneTouchExpandable(true);
		maf_sp3.setContinuousLayout(true);
		maf_sp4.add(maf_sp3);
		
		maf_p3.setLayout(new GridLayout(2,1));
		maf_p3.add(maf_p5);maf_p3.add(maf_p6);
		img2.setImage(img2.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		maf_l2.setIcon(img2);
		maf_p5.add(maf_l2);
		maf_l3.setFont(new Font("Dialog", 1, 25));
		JLabel maf_l4 = new JLabel("管理员"+accountNum);
		maf_l4.setFont(new Font("Dialog", 1, 25));
		maf_p6.add(maf_l3);maf_p6.add(maf_l4);
		
		maf_p4.setLayout(new GridLayout(3,1));
		maf_p4.add(maf_p7);maf_p4.add(maf_p8);maf_p4.add(maf_p9);
		maf_p8.setLayout(new GridLayout(3,1));
		maf_p8.add(maf_p27);maf_p8.add(maf_p28);maf_p8.add(maf_p37);
		maf_b1.setPreferredSize(new Dimension(150,30));
		maf_b4.setPreferredSize(new Dimension(150,30));
		maf_p7.add(maf_b1);
		maf_p9.add(maf_b4);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==maf_b1) {
			maf_p27.add(maf_b2);maf_p27.add(maf_b3);
			maf_p28.add(maf_b7);maf_p28.add(maf_b8);
			maf_p37.add(maf_b11);maf_p37.add(maf_b12);
			maf_p27.revalidate();
			maf_p28.revalidate();
		}else if(e.getSource() == maf_b2) {
			drawAddTeacher();
		}else if(e.getSource() == maf_b3) {
			drawAddStudent();
		}else if(e.getSource() == maf_b4) {
			drawAttention();
		}else if(e.getSource() == maf_b5) {
			insertStudent();
		}else if(e.getSource() == maf_b6) {
			insertTeacher();
		}else if(e.getSource() == maf_b7) {
			drawDeleteTeacher();
		}else if(e.getSource() == maf_b8) {
			drawDeleteStudent();
		}else if(e.getSource() == maf_b9) {
			deleteTeacher();
		}else if(e.getSource() == maf_b10) {
			deleteStudent();
		}else if(e.getSource() == maf_b11) {
			drawSelectTeacher();
		}else if(e.getSource() == maf_b12) {
			drawSelectStudent();
		}else if(e.getSource() == maf_b13) {
			selectAllTeacher();
		}else if(e.getSource() == maf_b14) {
			selectOneTeacher();
		}else if(e.getSource() == maf_b15) {
			selectAllStudent();
		}else if(e.getSource() == maf_b16) {
			selectOneStudent();
		}	
	}

	private void selectOneStudent() {
		String myaccount = maf_t19.getText();
		String sql = "select * from tb_Student where Sno =  "+myaccount+"";
		if(judgeStudentInlog()) {
			Vector Data = new Vector();
			Vector ColumnName = new Vector();
			ColumnName.add("学号");
			ColumnName.add("姓名");
			ColumnName.add("班级");
			ColumnName.add("性别");
			ColumnName.add("年龄");
			ColumnName.add("专业");
			ColumnName.add("密码");
			ColumnName.add("权限");
			try {
				ResultSet rs = stam.executeQuery(sql);
				while(rs.next()) {
					Vector Row = new Vector();
					String Sno=rs.getString(1);
					String Sname=rs.getString(2);
					String Class_no=rs.getString(3);
					String Ssex = rs.getString(4);
					int Sage=Integer.parseInt(rs.getString(5).trim());
					String major = rs.getString(6);
					String code = rs.getString(7);
					String Spower = rs.getString(8);
					Row.add(Sno);
					Row.add(Sname);
					Row.add(Class_no);
					Row.add(Ssex);
					Row.add(Sage);
					Row.add(major);
					Row.add(code);
					Row.add(Spower);
					Data.add(Row);
				}	
				model2.setDataVector(Data,ColumnName);
				}catch (SQLException e) {
					e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null, "未找到该账号！","提示",2);
		}
	}

	private boolean judgeStudentInlog() {
		String myaccount = maf_t19.getText();
		String sql = "select account from tb_logging";
		try {
			ResultSet rs = stam.executeQuery(sql);
			while(rs.next()) {
				String realAccount= rs.getString("account");
				if(myaccount.equals(realAccount)) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void selectAllStudent() {
		String sql1 = "select * from tb_Student";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("学号");
		ColumnName.add("姓名");
		ColumnName.add("班级");
		ColumnName.add("性别");
		ColumnName.add("年龄");
		ColumnName.add("专业");
		ColumnName.add("密码");
		ColumnName.add("权限");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Sno=rs.getString(1);
				String Sname=rs.getString(2);
				String Class_no=rs.getString(3);
				String Ssex = rs.getString(4);
				int Sage=Integer.parseInt(rs.getString(5).trim());
				String major = rs.getString(6);
				String code = rs.getString(7);
				String Spower = rs.getString(8);
				Row.add(Sno);
				Row.add(Sname);
				Row.add(Class_no);
				Row.add(Ssex);
				Row.add(Sage);
				Row.add(major);
				Row.add(code);
				Row.add(Spower);
				Data.add(Row);
			}	
			model2.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		
	}

	private void drawSelectStudent() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(2,1));
		maf_p2.add(maf_p42);maf_p2.add(scroll2);//
		maf_p42.setLayout(new GridLayout(2,1));
		maf_p42.add(maf_p44);maf_p42.add(maf_p45);
		maf_p44.add(maf_l25);maf_p44.add(maf_t19);
		maf_p45.add(maf_b15);maf_p45.add(maf_b16);
		maf_l25.setFont(new Font("Dialog", 1, 25));
		maf_p2.revalidate();
		
	}

	private void selectOneTeacher() {
		String myaccount = maf_t18.getText();
		String sql = "select * from tb_Teacher where Tno =  "+myaccount+"";
		if(judgeTeacherInLog()) {
			Vector Data = new Vector();
			Vector ColumnName = new Vector();
			ColumnName.add("工号");
			ColumnName.add("姓名");
			ColumnName.add("性别");
			ColumnName.add("年龄");
			ColumnName.add("职称");
			ColumnName.add("密码");
			ColumnName.add("权限");
			try {
				ResultSet rs = stam.executeQuery(sql);
				while(rs.next()) {
					Vector Row = new Vector();
					String Tno=rs.getString(1);
					String Tname=rs.getString(2);
					String Tsex=rs.getString(3);
					int Tage=Integer.parseInt(rs.getString(4).trim());
					String work = rs.getString(5);
					String code = rs.getString(6);
					String Tpower = rs.getString(7);
					Row.add(Tno);
					Row.add(Tname);
					Row.add(Tsex);
					Row.add(Tage);
					Row.add(work);
					Row.add(code);
					Row.add(Tpower);
					Data.add(Row);
				}	
				model1.setDataVector(Data,ColumnName);
				}catch (SQLException e) {
					e.printStackTrace();
			}	
		}else {
			JOptionPane.showMessageDialog(null, "未找到该账号！","提示",2);
		}
		
	}

	private boolean judgeTeacherInLog() {
		String myaccount = maf_t18.getText();
		String sql = "select account from tb_logging";
		try {
			ResultSet rs = stam.executeQuery(sql);
			while(rs.next()) {
				String realAccount= rs.getString("account");
				if(myaccount.equals(realAccount)) {
					return true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void selectAllTeacher() {
		String sql1 = "select * from tb_Teacher";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("工号");
		ColumnName.add("姓名");
		ColumnName.add("性别");
		ColumnName.add("年龄");
		ColumnName.add("职称");
		ColumnName.add("密码");
		ColumnName.add("权限");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Tno=rs.getString(1);
				String Tname=rs.getString(2);
				String Tsex=rs.getString(3);
				int Tage=Integer.parseInt(rs.getString(4).trim());
				String work = rs.getString(5);
				String code = rs.getString(6);
				String Tpower = rs.getString(7);
				Row.add(Tno);
				Row.add(Tname);
				Row.add(Tsex);
				Row.add(Tage);
				Row.add(work);
				Row.add(code);
				Row.add(Tpower);
				Data.add(Row);
			}	
			model1.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}	
	}

	private void drawSelectTeacher() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(2,1));
		maf_p2.add(maf_p38);maf_p2.add(scroll1);//
		maf_p38.setLayout(new GridLayout(2,1));
		maf_p38.add(maf_p40);maf_p38.add(maf_p41);
		maf_p40.add(maf_l24);maf_p40.add(maf_t18);
		maf_p41.add(maf_b13);maf_p41.add(maf_b14);
		maf_l24.setFont(new Font("Dialog", 1, 25));
		maf_p2.revalidate();
	}

	private void deleteStudent() {
		String getAccount = maf_t17.getText();
		String sql1 = "";
		String sql = "delete from tb_logging where account = "+getAccount+"";
		if(deleteJudgeStudent()) {
			try {
				stam.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "删除成功！","提示",2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
		{
			JOptionPane.showMessageDialog(null, "未找到此账号","提示",2);
		}
	}

	private boolean deleteJudgeStudent() {
		String sql = "select account from tb_logging";
		try {
			ResultSet re = stam.executeQuery(sql);
			while(re.next()) {
				String myaccount = re.getString("account");
				if(myaccount.equals(maf_t17.getText())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void deleteTeacher() {
		String getAccount = maf_t16.getText();
		String sql = "delete from tb_logging where account = "+getAccount+"";
		if(deleteJudgeTeacher()) {
			try {
				stam.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "删除成功！","提示",2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else
		{
			JOptionPane.showMessageDialog(null, "未找到此账号","提示",2);
		}
	}

	private boolean deleteJudgeTeacher() {
		String sql = "select account from tb_logging";
		try {
			ResultSet re = stam.executeQuery(sql);
			while(re.next()) {
				String myaccount = re.getString("account");
				if(myaccount.equals(maf_t16.getText())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void drawDeleteStudent() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(3,1));
		maf_p2.add(maf_p33);maf_p2.add(maf_p34);
		maf_p34.setLayout(new GridLayout(2,1));
		maf_p34.add(maf_p35);maf_p34.add(maf_p36);
		maf_l23.setFont(new Font("Dialog", 1, 25));
		maf_p35.add(maf_l23);maf_p35.add(maf_t17);
		maf_p36.add(maf_b10);
		maf_p2.revalidate();
		
	}

	private void drawDeleteTeacher() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(3,1));
		maf_p2.add(maf_p29);maf_p2.add(maf_p30);
		maf_p30.setLayout(new GridLayout(2,1));
		maf_p30.add(maf_p31);maf_p30.add(maf_p32);
		maf_l22.setFont(new Font("Dialog", 1, 25));
		maf_p31.add(maf_l22);maf_p31.add(maf_t16);
		maf_p32.add(maf_b9);
		maf_p2.revalidate();
	}

	private void insertTeacher() {
		String teacherNum = maf_t9.getText();
		String teacherName = maf_t10.getText();
		String teacherSex = maf_t11.getText();
		int teacherAge = Integer.parseInt(maf_t12.getText().trim());
		String teacherWork = maf_t13.getText();
		String teacherPwd = maf_t14.getText();
		String teacherRight = "2";
		String sql3 = "insert into tb_Teacher values('"+teacherNum+"','"+teacherName+"','"+teacherSex+"',"+teacherAge+",'"+teacherWork+"','"+teacherPwd+"','"+teacherRight+"')";
		String sql5 = "insert into tb_logging values('"+teacherNum+"','"+teacherPwd+"','"+teacherRight+"')";
		try {
				if(judge()) {
					JOptionPane.showMessageDialog(null, "已存在该账号！！！","提示",2);
				}else {
						stam.executeUpdate(sql3);
						//stam.executeUpdate(sql5);
						JOptionPane.showMessageDialog(null, "插入成功！","提示",2);
						System.out.println("已插入！");	
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private boolean judge() {
		String sql1 = "select account from tb_logging";
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				String myaccount = re.getString("account").trim();
				if(myaccount.equals(maf_t9.getText())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void insertStudent() {
		String stuNum = maf_t1.getText();
		String stuName = maf_t2.getText();
		String classno = maf_t3.getText();
		String stuSex = maf_t4.getText();
		int stuAge = Integer.parseInt(maf_t5.getText().trim());
		String major = maf_t6.getText();
		String stuPwd = maf_t7.getText();
		String stuRight = "3";
		String sql2 = "insert into tb_Student values('"+stuNum+"','"+stuName+"','"+classno+"','"+stuSex+"',"+stuAge+",'"+major+"','"+stuPwd+"','"+stuRight+"')";
		String sql4 = "insert into tb_logging values('"+stuNum+"','"+stuPwd+"','"+stuRight+"')";
		try {
				if(judge2()) {
					JOptionPane.showMessageDialog(null, "已存在该账号！！！","提示",2);
				}else {
						stam.executeUpdate(sql2);
						//stam.executeUpdate(sql4);
						JOptionPane.showMessageDialog(null, "插入成功！","提示",2);
						System.out.println("已插入！");		
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private boolean judge2() {
		String sql1 = "select account from tb_logging";
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				String myaccount = re.getString("account").trim();
				if(myaccount.equals(maf_t1.getText())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	private void drawAttention() {
		maf_p2.removeAll();
		maf_p2.repaint();
		img3.setImage(img3.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT));
		maf_l20.setIcon(img3);
		maf_l21.setFont(new Font("Dialog", 1, 25));
		maf_p2.add(maf_l20);maf_p2.add(maf_l21);
		maf_p2.revalidate();
	}

	private void drawAddStudent() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(9,1));
		maf_p2.add(maf_p10);maf_p2.add(maf_p11);maf_p2.add(maf_p12);maf_p2.add(maf_p13);
		maf_p2.add(maf_p14);maf_p2.add(maf_p15);maf_p2.add(maf_p16);maf_p2.add(maf_p17);
		maf_p2.add(maf_p18);
		maf_l5.setFont(new Font("Dialog", 1, 25));
		maf_l6.setFont(new Font("Dialog", 1, 25));
		maf_l7.setFont(new Font("Dialog", 1, 25));
		maf_l8.setFont(new Font("Dialog", 1, 25));
		maf_l9.setFont(new Font("Dialog", 1, 25));
		maf_l10.setFont(new Font("Dialog", 1, 25));
		maf_l11.setFont(new Font("Dialog", 1, 25));
		maf_b5.setPreferredSize(new Dimension(150,30));
		maf_p10.add(maf_l5);maf_p10.add(maf_t1);
		maf_p11.add(maf_l6);maf_p11.add(maf_t2);
		maf_p12.add(maf_l7);maf_p12.add(maf_t3);
		maf_p13.add(maf_l8);maf_p13.add(maf_t4);
		maf_p14.add(maf_l9);maf_p14.add(maf_t5);
		maf_p15.add(maf_l10);maf_p15.add(maf_t6);
		maf_p16.add(maf_l11);maf_p16.add(maf_t7);
		
		maf_p18.add(maf_b5);
		maf_p2.revalidate();
	}

	private void drawAddTeacher() {
		maf_p2.removeAll();
		maf_p2.repaint();
		maf_p2.setLayout(new GridLayout(8,1));
		maf_p2.add(maf_p19);maf_p2.add(maf_p20);maf_p2.add(maf_p21);maf_p2.add(maf_p22);
		maf_p2.add(maf_p23);maf_p2.add(maf_p24);maf_p2.add(maf_p25);maf_p2.add(maf_p26);
		maf_l13.setFont(new Font("Dialog", 1, 25));
		maf_l14.setFont(new Font("Dialog", 1, 25));
		maf_l15.setFont(new Font("Dialog", 1, 25));
		maf_l16.setFont(new Font("Dialog", 1, 25));
		maf_l17.setFont(new Font("Dialog", 1, 25));
		maf_l18.setFont(new Font("Dialog", 1, 25));
		maf_b6.setPreferredSize(new Dimension(150,30));
		maf_p19.add(maf_l13);maf_p19.add(maf_t9);
		maf_p20.add(maf_l14);maf_p20.add(maf_t10);
		maf_p21.add(maf_l15);maf_p21.add(maf_t11);
		maf_p22.add(maf_l16);maf_p22.add(maf_t12);
		maf_p23.add(maf_l17);maf_p23.add(maf_t13);
		maf_p24.add(maf_l18);maf_p24.add(maf_t14);
		
		maf_p26.add(maf_b6);
		maf_p2.revalidate();
	}
}
