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

public class TeacherFrame implements ActionListener{
	Graphics g;
	MyDBConnection mydbcon;
	Connection conn;
	Statement stam;
	String accountNum;
	String accountName;
	String Tno; 
	String Tname;
	String Tsex;
	int Tage;
	String work;
	String code;
	String Tpower;
	
	
	
	
	
	JFrame stf = new JFrame("选课管理系统——教师");
	
	JSplitPane stf_sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane stf_sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	JSplitPane stf_sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	JSplitPane stf_sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	
	JPanel stf_p1 = new JPanel();
	JPanel stf_p2 = new JPanel();
	JPanel stf_p3 = new JPanel();
	JPanel stf_p4 = new JPanel();
	JPanel stf_p5 = new JPanel();
	JPanel stf_p6 = new JPanel();
	JPanel stf_p7 = new JPanel();//按钮主界面
	JPanel stf_p8 = new JPanel();
	JPanel stf_p9 = new JPanel();
	JPanel stf_p10 = new JPanel();
	JPanel stf_p11 = new JPanel();//修改信息界面
	JPanel stf_p12 = new JPanel();
	JPanel stf_p13 = new JPanel();
	JPanel stf_p14 = new JPanel();
	JPanel stf_p15 = new JPanel();
	JPanel stf_p16 = new JPanel();
	JPanel stf_p17 = new JPanel();
	JPanel stf_p18 = new JPanel();
	JPanel stf_p19 = new JPanel();//
	JPanel stf_p20 = new JPanel();//第一界面
	JPanel stf_p21 = new JPanel();
	JPanel stf_p22 = new JPanel();
	JPanel stf_p23 = new JPanel();
	JPanel stf_p24 = new JPanel();
	JPanel stf_p25 = new JPanel();
	JPanel stf_p26 = new JPanel();
	JPanel stf_p27 = new JPanel();//
	JPanel stf_p28 = new JPanel();//写成绩面板
	JPanel stf_p29 = new JPanel();
	JPanel stf_p30 = new JPanel();
	JPanel stf_p31 = new JPanel();//
	JPanel stf_p32 = new JPanel();//开课界面
	JPanel stf_p33 = new JPanel();
	JPanel stf_p34 = new JPanel();
	JPanel stf_p35 = new JPanel();
	JPanel stf_p36 = new JPanel();//
	
	JLabel stf_l1 = new  JLabel();
	JLabel stf_l2 = new  JLabel();
	JLabel stf_l3 = new  JLabel("欢迎您！");
	JLabel stf_l4 = new  JLabel("课程号:");
	JLabel stf_l5 = new  JLabel("课程名:");
	JLabel stf_l6 = new  JLabel("开课时间");
	JLabel stf_l7 = new  JLabel("学分");
	JLabel stf_l8 = new  JLabel("地点");
	JLabel stf_l9 = new  JLabel("年份");
	JLabel stf_l10 = new  JLabel("学期");
	
	JLabel stf_l16 = new  JLabel("选择学号：");
	JLabel stf_l17 = new  JLabel("课程名：+");
	JLabel stf_l18 = new  JLabel("成绩：");
	JLabel stf_l19 = new  JLabel("课程号");
	
	
	
	JButton stf_b1 = new JButton("修改信息");
	JButton stf_b2 = new JButton("开课");
	JButton stf_b3 = new JButton("写成绩");
	JButton stf_b4 = new JButton("查询开课");
	JButton stf_b5 = new JButton("创建课程");
	JButton stf_b6 = new JButton("修改密码");
	JButton stf_b7 = new JButton("录入成绩");
	JButton stf_b8 = new JButton("我的课程");
	JButton stf_b9 = new JButton("全部课程");
	JButton stf_b10 = new JButton("加入课程");
	JButton stf_b11 = new JButton("清除课程人员");
	JButton stf_b12 = new JButton("查询");
	JButton stf_b13 = new JButton("查询课程");
	JButton stf_b14 = new JButton("退出课程");
	
	JTextField stf_t1 = new JTextField(20);
	JTextField stf_t2 = new JTextField(20);
	JTextField stf_t3 = new JTextField(20);
	JTextField stf_t4 = new JTextField(20);
	JTextField stf_t5 = new JTextField(20);
	JTextField stf_t6 = new JTextField(20);
	JTextField stf_t7 = new JTextField(20);
	JTextField stf_t8 = new JTextField(20);
	JTextField stf_t9 = new JTextField(20);
	JTextField stf_t10 = new JTextField(20);
	JTextField stf_t11 = new JTextField(20);
	JTextField stf_t12 = new JTextField(20);
	JTextField stf_t13 = new JTextField(15);
	JTextField stf_t14 = new JTextField(20);
	JTextField stf_t15 = new JTextField(15);
	/*JTextField stf_t16 = new JTextField(20);//
	JTextField stf_t17 = new JTextField(20);
	JTextField stf_t18 = new JTextField(20);//
	JTextField stf_t19 = new JTextField(20);*/
	
	ImageIcon img1 = new ImageIcon("src/test/4.jpg");
	ImageIcon img2 = new ImageIcon("src/test/5.jpg");
	
	String[] columnNames1 = {"课程号","课程名","上课时间","地点","学分","开设学年","开设学期","已选人数"};
	String[] columnNames2 = {"学号","姓名","成绩"};
	
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
	
	public TeacherFrame(MyDBConnection mydbcon,String accountNum) {
		this.mydbcon = mydbcon;
		this.conn = mydbcon.getMyConnection();
		this.stam = mydbcon.getMyStatement();
		this.accountNum = accountNum;
		drawUI();
		stf_b1.addActionListener(this);
		stf_b2.addActionListener(this);
	    stf_b3.addActionListener(this);
		stf_b4.addActionListener(this);
		stf_b5.addActionListener(this);
		stf_b6.addActionListener(this);
		stf_b7.addActionListener(this);
		stf_b8.addActionListener(this);
		stf_b9.addActionListener(this);
		stf_b10.addActionListener(this);
		stf_b11.addActionListener(this);
		stf_b12.addActionListener(this);
		stf_b13.addActionListener(this);
		stf_b14.addActionListener(this);
	}
	private void drawUI() {
		stf.setVisible(true);
		stf.setSize(1000, 800);
		stf.setLocationRelativeTo(null);
		stf.setDefaultCloseOperation(stf.DISPOSE_ON_CLOSE);
		
		img1.setImage(img1.getImage().getScaledInstance(1000, 100,Image.SCALE_DEFAULT));
		stf_l1.setIcon(img1);
		stf_sp1.setLeftComponent(stf_l1);
		stf_sp1.setDividerLocation(100);
		stf_sp1.setDividerSize(8);		
		stf_sp2.setLeftComponent(stf_sp4);
		stf_sp2.setRightComponent(stf_p2);//右部显示界面
		stf_sp2.setDividerLocation(250);
		stf_sp2.setDividerSize(8);
		stf_sp2.setOneTouchExpandable(true);
		stf_sp2.setContinuousLayout(true);
		stf_sp1.setRightComponent(stf_sp2);
		stf.add(stf_sp1);
		stf_sp3.setLeftComponent(stf_p3);
		stf_sp3.setRightComponent(stf_p4);
		stf_sp3.setDividerLocation(250);
		stf_sp3.setDividerSize(8);
		stf_sp3.setOneTouchExpandable(true);
		stf_sp3.setContinuousLayout(true);
		stf_sp4.add(stf_sp3);
		
		stf_p3.setLayout(new GridLayout(2,1));
		stf_p3.add(stf_p5);stf_p3.add(stf_p6);
		img2.setImage(img2.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		stf_l2.setIcon(img2);
		stf_p5.add(stf_l2);
		
		stf_l3.setFont(new Font("Dialog", 1, 25));
		selecetAccountName();
		Teacherinformation();
		JLabel stf_l4 = new JLabel(accountName+"教师");
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_p6.add(stf_l3);stf_p6.add(stf_l4);
		
		stf_p4.setLayout(new GridLayout(4,1));
		stf_p4.add(stf_p7);	stf_p4.add(stf_p8);	stf_p4.add(stf_p9);	stf_p4.add(stf_p10);
		stf_p7.add(stf_b1); stf_p8.add(stf_b2);	stf_p9.add(stf_b3);	stf_p10.add(stf_b4);
		
		
		
		
		
	}
	private void selecetAccountName() {
		String sql = "select * from tb_Teacher where Tno = "+accountNum.trim()+"";
		try {
			ResultSet re = stam.executeQuery(sql);
			re.next();
			accountName = re.getString("Tname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Teacherinformation() {
		String sql = "select * from tb_Teacher where Tno = "+accountNum.trim()+"";
		try {
			ResultSet re = stam.executeQuery(sql);
			re.next();
			Tno = re.getString("Tno");
			Tname = re.getString("Tname");
			Tsex = re.getString("Tsex");
			Tage = re.getInt("Tage");
			work = re.getString("work");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==stf_b1) {
			System.out.println("*****");
			drawinformation();
		}else if(e.getSource() == stf_b2) {
			drawopenclass();
		}else if(e.getSource() == stf_b3) {
			drawgrade();
		}else if(e.getSource() == stf_b4) {
			drawclass();
		}else if(e.getSource() == stf_b5) {			
			createcourse();
		}else if(e.getSource() == stf_b6) {
			new UpdataPwdFrame(mydbcon,accountNum);
		}else if(e.getSource() == stf_b7) {
			give_grade();
		}else if(e.getSource() == stf_b8) {
			drawmyCourse();
		}else if(e.getSource() == stf_b9) {
			drawallCourse();
		}else if(e.getSource() == stf_b10) {
			joinCourse();
		}else if(e.getSource() == stf_b11) {
			new UpdataPwdFrame1(mydbcon,accountNum);
		}else if(e.getSource() == stf_b12) {
			drawNullCourse();
		}else if(e.getSource() == stf_b13) {
			drawcheck_class();
		}else if(e.getSource() == stf_b14) {
			quitCourse();
		}
	}
	
		


	
	private void drawNullCourse() {
		NullCourse();
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p32);stf_p2.add(scroll1);stf_p2.add(stf_p36);
		stf_p32.setLayout(new GridLayout(3,1));
		stf_p32.add(stf_p33);stf_p32.add(stf_p34);stf_p32.add(stf_p35);
		stf_p33.add(stf_b8);stf_p33.add(stf_b9);
		stf_p34.add(stf_l19);stf_p34.add(stf_t13);stf_p34.add(stf_b10);stf_p34.add(stf_t15);stf_p34.add(stf_b14);
		stf_p35.add(stf_l4);stf_p35.add(stf_t14);stf_p35.add(stf_b11);
		stf_p36.add(stf_l9);stf_p36.add(stf_t8);stf_p36.add(stf_l10);stf_p36.add(stf_t9);stf_p36.add(stf_b12);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l19.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
	}
	private void NullCourse() {
		String startyear = stf_t8.getText().trim();
		String starttime = stf_t9.getText().trim();
		String sql1 = "select * from tb_Course where Course_startyear= '"+startyear+"' and Course_starttime='"+starttime+"'and Course_maxNum="+0+"";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("上课时间");
		ColumnName.add("学分");
		ColumnName.add("地点");
		ColumnName.add("开设学年");
		ColumnName.add("开设学期");
		ColumnName.add("已选人数");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			System.out.println(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Course_no=rs.getString(1);
				String Course_name=rs.getString(2);
				String Course_time=rs.getString(3);
				double Course_gpa = Double.parseDouble(rs.getString(4));
				String Course_plase=rs.getString(5);
				String Course_startyear = rs.getString(6);
				String Course_starttime = rs.getString(7);
				int CourseMaxNum = Integer.parseInt(rs.getString(8));
				Row.add(Course_no);
				Row.add(Course_name);
				Row.add(Course_time);
				Row.add(Course_gpa);
				Row.add(Course_plase);
				Row.add(Course_startyear);
				Row.add(Course_starttime);
				Row.add(CourseMaxNum);
				Data.add(Row);
			}	
			model1.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
	}
	private void drawinformation() {//修改个人信息界面
		stf_p20.removeAll();
		stf_p21.removeAll();
		stf_p22.removeAll();
		stf_p23.removeAll();
		stf_p24.removeAll();
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(8,1));
		stf_p2.add(stf_p27);stf_p2.add(stf_p20);stf_p2.add(stf_p21);stf_p2.add(stf_p22);
		stf_p2.add(stf_p23);stf_p2.add(stf_p24);stf_p2.add(stf_p25);stf_p2.add(stf_p26);
		JLabel stf_l11 = new  JLabel("教师号: "+ Tno);
		JLabel stf_l12 = new  JLabel("教师名: "+ Tname);
		JLabel stf_l13 = new  JLabel("性别: "+ Tsex);
		JLabel stf_l14 = new  JLabel("年龄: "+ Tage);
		JLabel stf_l15 = new  JLabel("职称: "+ work);
		stf_p20.add(stf_l11);stf_l11.setFont(new Font("Dialog", 1, 25));
		stf_p21.add(stf_l12);stf_l12.setFont(new Font("Dialog", 1, 25));
		stf_p22.add(stf_l13);stf_l13.setFont(new Font("Dialog", 1, 25));
		stf_p23.add(stf_l14);stf_l14.setFont(new Font("Dialog", 1, 25));
		stf_p24.add(stf_l15);stf_l15.setFont(new Font("Dialog", 1, 25));
		
		stf_p26.add(stf_b6);
		stf_p2.revalidate();
	}	


	private void drawopenclass() {//开课界面
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(9,1));
		stf_p2.add(stf_p11);stf_p2.add(stf_p12);stf_p2.add(stf_p13);stf_p2.add(stf_p14);
		stf_p2.add(stf_p15);stf_p2.add(stf_p16);stf_p2.add(stf_p17);stf_p2.add(stf_p18);
		stf_p2.add(stf_p19);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l5.setFont(new Font("Dialog", 1, 25));
		stf_l6.setFont(new Font("Dialog", 1, 25));
		stf_l7.setFont(new Font("Dialog", 1, 25));
		stf_l8.setFont(new Font("Dialog", 1, 25));
		stf_l9.setFont(new Font("Dialog", 1, 25));
		stf_l10.setFont(new Font("Dialog", 1, 25));
		stf_p11.add(stf_l4);stf_p11.add(stf_t1);
		stf_p12.add(stf_l5);stf_p12.add(stf_t2);
		stf_p13.add(stf_l6);stf_p13.add(stf_t3);
		stf_p14.add(stf_l7);stf_p14.add(stf_t4);
		stf_p15.add(stf_l8);stf_p15.add(stf_t5);
		stf_p16.add(stf_l9);stf_p16.add(stf_t6);
		stf_p17.add(stf_l10);stf_p17.add(stf_t7);
		
		stf_p19.add(stf_b5);
		stf_p2.revalidate();
	}	


	private void joinCourse() {//加入课程
		String Course_no=stf_t13.getText();	
		String sql2 = "insert into tb_TC values('"+Course_no+"','"+accountNum+"')";
		try {
			if(judge3()) {
				JOptionPane.showMessageDialog(null, "您已存在该课程！！！","提示",2);
			}else {
					stam.executeUpdate(sql2);
					//stam.executeUpdate(sql4);
					JOptionPane.showMessageDialog(null, "成功加入！","提示",2);
					System.out.println("已加入！");		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void quitCourse() {//退出课程
		String Course_no=stf_t15.getText().trim();
		String sql2 = "delete from tb_TC where Tno= '"+accountNum+"' and Course_no = '"+Course_no+"'";
		try {
			if(!judge4()) {
				JOptionPane.showMessageDialog(null, "您不存在该课程！！！","提示",2);
			}else {
					stam.executeUpdate(sql2);
					//stam.executeUpdate(sql4);
					JOptionPane.showMessageDialog(null, "成功退出！","提示",2);
					System.out.println("已退出！");		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	private boolean judge3() {
		String sql1 = "select Course_no from tb_TC where Tno ='"+accountNum+"'";
		System.out.println("Course_no");
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				String course_no = re.getString("Course_no").trim();
				if(course_no.equals(stf_t13.getText().trim())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private boolean judge4() {
		String sql1 = "select Course_no from tb_TC where Tno ='"+accountNum+"' ";
		System.out.println("Course_no");
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				String course_no = re.getString("Course_no").trim();
				if(course_no.equals(stf_t15.getText().trim())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void drawgrade() {//写成绩
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p28);
		stf_p28.setLayout(new GridLayout(2,1));
		stf_p28.add(stf_p30);stf_p28.add(stf_p31);
		stf_p2.add(scroll2);stf_p2.add(stf_p29);
		//stf_p30.add(stf_l9);stf_p30.add(stf_t8);stf_p30.add(stf_l10);stf_p30.add(stf_t9);
		stf_p30.add(stf_l4);stf_p30.add(stf_t11);//stf_p30.add(stf_l5);
		stf_p31.add(stf_b13);
		stf_p29.add(stf_l16);stf_p29.add(stf_t10);
		stf_p29.add(stf_l18);stf_p29.add(stf_t12);stf_p29.add(stf_b7);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l5.setFont(new Font("Dialog", 1, 25));
		stf_l10.setFont(new Font("Dialog", 1, 25));
		stf_l16.setFont(new Font("Dialog", 1, 25));
		stf_l18.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
	}
	
	
	
	private void drawclass() {//查询开课界面
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p32);stf_p2.add(scroll1);stf_p2.add(stf_p36);
		stf_p32.setLayout(new GridLayout(3,1));
		stf_p32.add(stf_p33);stf_p32.add(stf_p34);stf_p32.add(stf_p35);
		stf_p33.add(stf_b8);stf_p33.add(stf_b9);
		stf_p34.add(stf_l19);stf_p34.add(stf_t13);stf_p34.add(stf_b10);stf_p34.add(stf_t15);stf_p34.add(stf_b14);
		stf_p35.add(stf_l4);stf_p35.add(stf_t14);stf_p35.add(stf_b11);
		stf_p36.add(stf_l9);stf_p36.add(stf_t8);stf_p36.add(stf_l10);stf_p36.add(stf_t9);stf_p36.add(stf_b12);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l19.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
	}
	
	
	private void drawallCourse() {
		stf_p2.removeAll();
		stf_p2.repaint();
		allCourse();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p32);stf_p2.add(scroll1);stf_p2.add(stf_p36);
		stf_p32.setLayout(new GridLayout(3,1));
		stf_p32.add(stf_p33);stf_p32.add(stf_p34);stf_p32.add(stf_p35);
		stf_p33.add(stf_b8);stf_p33.add(stf_b9);
		stf_p34.add(stf_l19);stf_p34.add(stf_t13);stf_p34.add(stf_b10);stf_p34.add(stf_t15);stf_p34.add(stf_b14);
		stf_p35.add(stf_l4);stf_p35.add(stf_t14);stf_p35.add(stf_b11);
		stf_p36.add(stf_l9);stf_p36.add(stf_t8);stf_p36.add(stf_l10);stf_p36.add(stf_t9);stf_p36.add(stf_b12);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l19.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
	}
	private void allCourse() {
		String sql1 = "select * from tb_Course";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("上课时间");
		ColumnName.add("学分");
		ColumnName.add("地点");
		ColumnName.add("开设学年");
		ColumnName.add("开设学期");
		ColumnName.add("已选人数");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Course_no=rs.getString(1);
				String Course_name=rs.getString(2);
				String Course_time=rs.getString(3);
				double Course_gpa = Double.parseDouble(rs.getString(4));
				String Course_plase=rs.getString(5);
				String Course_startyear = rs.getString(6);
				String Course_starttime = rs.getString(7);
				int CourseMaxNum = Integer.parseInt(rs.getString(8));
				Row.add(Course_no);
				Row.add(Course_name);
				Row.add(Course_time);
				Row.add(Course_gpa);
				Row.add(Course_plase);
				Row.add(Course_startyear);
				Row.add(Course_starttime);
				Row.add(CourseMaxNum);
				Data.add(Row);
			}	
			model1.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	private void drawmyCourse() {
		stf_p2.removeAll();
		stf_p2.repaint();
		myCourse();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p32);stf_p2.add(scroll1);stf_p2.add(stf_p36);
		stf_p32.setLayout(new GridLayout(3,1));
		stf_p32.add(stf_p33);stf_p32.add(stf_p34);stf_p32.add(stf_p35);
		stf_p33.add(stf_b8);stf_p33.add(stf_b9);
		stf_p34.add(stf_l19);stf_p34.add(stf_t13);stf_p34.add(stf_b10);stf_p34.add(stf_t15);stf_p34.add(stf_b14);
		stf_p35.add(stf_l4);stf_p35.add(stf_t14);stf_p35.add(stf_b11);
		stf_p36.add(stf_l9);stf_p36.add(stf_t8);stf_p36.add(stf_l10);stf_p36.add(stf_t9);stf_p36.add(stf_b12);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l19.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
	}
	private void myCourse() {
		String sql1 = "select * from tb_Course where Course_no in(select Course_no from tb_TC where Tno = '"+accountNum.trim()+"')";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("上课时间");
		ColumnName.add("学分");
		ColumnName.add("地点");
		ColumnName.add("开设学年");
		ColumnName.add("开设学期");
		ColumnName.add("已选人数");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Course_no=rs.getString(1);
				String Course_name=rs.getString(2);
				String Course_time=rs.getString(3);
				double Course_gpa = Double.parseDouble(rs.getString(4));
				String Course_plase=rs.getString(5);
				String Course_startyear = rs.getString(6);
				String Course_starttime = rs.getString(7);
				int CourseMaxNum = Integer.parseInt(rs.getString(8));
				Row.add(Course_no);
				Row.add(Course_name);
				Row.add(Course_time);
				Row.add(Course_gpa);
				Row.add(Course_plase);
				Row.add(Course_startyear);
				Row.add(Course_starttime);
				Row.add(CourseMaxNum);
				Data.add(Row);
			}	
			model1.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	private void check_class() {
		String Course_no1=stf_t11.getText();
		String sql1 = "select tb_Student.Sno,Sname,grade from tb_Student,tb_SC where Course_no= '"+Course_no1+"' and tb_Student.Sno=tb_SC.Sno";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("学号");
		ColumnName.add("姓名");
		ColumnName.add("成绩");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Sno=rs.getString(1);
				String Sname=rs.getString(2);
				String grade=rs.getString(3);
				Row.add(Sno);
				Row.add(Sname);
				Row.add(grade);	
				Data.add(Row);
			}
			model2.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}		
	}
	private void drawcheck_class() {
		stf_p2.removeAll();
		stf_p2.repaint();
		check_class();
		stf_p2.setLayout(new GridLayout(3,1));
		stf_p2.add(stf_p28);stf_p2.add(scroll2);stf_p2.add(stf_p29);
		stf_p28.setLayout(new GridLayout(2,1));
		stf_p28.add(stf_p30);stf_p28.add(stf_p31);
		stf_p30.add(stf_l4);stf_p30.add(stf_t11);
		stf_p31.add(stf_b13);
		stf_p29.add(stf_l16);stf_p29.add(stf_t10);
		stf_p29.add(stf_l18);stf_p29.add(stf_t12);stf_p29.add(stf_b7);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l5.setFont(new Font("Dialog", 1, 25));
		stf_l10.setFont(new Font("Dialog", 1, 25));
		stf_l16.setFont(new Font("Dialog", 1, 25));
		stf_l18.setFont(new Font("Dialog", 1, 25));
		stf_p2.revalidate();
		
	}
	private void give_grade() {
		String Sno=stf_t10.getText().trim();
		String Cno=stf_t11.getText().trim();
		String grade=stf_t12.getText().trim();
		int grades= Integer.parseInt(grade);
		String sql2 = "update tb_SC set grade= "+grades+" where Sno= '"+Sno+"'and Course_no = '"+Cno+"' ";
		try {
			if(judge1()) {
				JOptionPane.showMessageDialog(null, "该学生已存在成绩！！！","提示",2);
			}else {
					stam.executeUpdate(sql2);
					//stam.executeUpdate(sql4);
					JOptionPane.showMessageDialog(null, "录入成功！","提示",2);
					System.out.println("已插入！");		
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	private boolean judge1() {
		String Sno=stf_t10.getText().trim();
		String Cno=stf_t11.getText().trim();
		String sql1 = "select grade from tb_SC where Sno = '"+Sno+"' and Course_no = '"+Cno+"' ";
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				int if_exit = re.getInt("grade");
				if(if_exit > 0) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	private void createcourse() {
		String Course_no=stf_t1.getText();
		String Course_name= stf_t2.getText();
		String Course_time=stf_t3.getText();;
		double Course_gpa=Double.parseDouble(stf_t4.getText().trim());
		String Course_please=stf_t5.getText();
		String Course_startyear=stf_t6.getText();
		String Course_starttime=stf_t7.getText();
		String sql2 = "insert into tb_Course values('"+Course_no+"','"+Course_name+"','"+Course_time+"',"+Course_gpa+",'"+Course_please+"','"+Course_startyear+"','"+Course_starttime+"',"+0+")";
		try {
			if(judge2()) {
				JOptionPane.showMessageDialog(null, "已存在该课程！！！","提示",2);
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
		String sql1 = "select Course_no from tb_Course";
		ResultSet re;
		try {
			re = stam.executeQuery(sql1);
			while(re.next()) {
				String mycourse = re.getString("Course_no").trim();
				if(mycourse.equals(stf_t1.getText())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	//************************************************************
	class UpdataPwdFrame implements ActionListener{
		MyDBConnection mydbcon1;
		Connection conn1;
		Statement stam1;
		String accountNum1;
		JFrame upf = new JFrame("教师修改密码");
		JPanel upf_p1 = new JPanel();
		JPanel upf_p2 = new JPanel();
		JPanel upf_p3 = new JPanel();
		JLabel upf_l1 = new JLabel("新密码：");
		JLabel upf_l2 = new JLabel("确认新密码：");
		JTextField upf_t1 = new JTextField(20);
		JTextField upf_t2 = new JTextField(20);
		JButton upf_b1 = new JButton("确认修改");
		public UpdataPwdFrame(MyDBConnection mydbcon1,String accountNum1) {
			this.mydbcon1 = mydbcon1;
			this.conn1 = mydbcon1.getMyConnection();
			this.stam1 = mydbcon1.getMyStatement();
			this.accountNum1=accountNum1;
			drawUI();
			upf_b1.addActionListener(this);
		}

		private void drawUI() {
			upf.setVisible(true);
			upf.setSize(450, 300);
			upf.setLocationRelativeTo(null);
			upf.setDefaultCloseOperation(upf.DISPOSE_ON_CLOSE);
			upf.setLayout(new GridLayout(3,1));
			upf.add(upf_p1);upf.add(upf_p2);upf.add(upf_p3);
			upf_b1.setPreferredSize(new Dimension(150,30));
			upf_l1.setFont(new Font("Dialog", 1, 25));
			upf_l2.setFont(new Font("Dialog", 1, 25));
			upf_p1.add(upf_l1);upf_p1.add(upf_t1);
			upf_p2.add(upf_l2);upf_p2.add(upf_t2);
			upf_p3.add(upf_b1);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == upf_b1) {
				changePwd();
			}
		}
		private void changePwd() {
			String newPwd = upf_t1.getText().trim();
			String sql = "update tb_Teacher set code ='"+newPwd+"' where Tno = '"+accountNum1+"'";
			String sql2 = "update tb_logging set code ='"+newPwd+"' where account = '"+accountNum1+"'";
			System.out.println(sql);
			try {
				if(upf_t1.getText().equals(upf_t2.getText())) {
					stam1.executeUpdate(sql);
					stam1.executeUpdate(sql2);
					JOptionPane.showMessageDialog(null, "修改成功！","提示",2);
				}else
				{
					JOptionPane.showMessageDialog(null, "两次输入不一致！","提示",2);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//************************************************************删除课程人员窗口
		class UpdataPwdFrame1 implements ActionListener{
			MyDBConnection mydbcon1;
			Connection conn1;
			Statement stam1;
			String accountNum1;
			JFrame upf = new JFrame("输入密码");
			JPanel upf_p1 = new JPanel();
			JPanel upf_p2 = new JPanel();
			JPanel upf_p3 = new JPanel();
			JLabel upf_l1 = new JLabel("输入密码：");
			JLabel upf_l2 = new JLabel("再次输入密码：");
			JTextField upf_t1 = new JTextField(20);
			JTextField upf_t2 = new JTextField(20);
			JButton upf_b1 = new JButton("确认删除");
			public UpdataPwdFrame1(MyDBConnection mydbcon1,String accountNum1) {
				this.mydbcon1 = mydbcon1;
				this.conn1 = mydbcon1.getMyConnection();
				this.stam1 = mydbcon1.getMyStatement();
				this.accountNum1=accountNum1;
				drawUI();
				upf_b1.addActionListener(this);
			}

			private void drawUI() {
				upf.setVisible(true);
				upf.setSize(450, 300);
				upf.setLocationRelativeTo(null);
				upf.setDefaultCloseOperation(upf.DISPOSE_ON_CLOSE);
				upf.setLayout(new GridLayout(3,1));
				upf.add(upf_p1);upf.add(upf_p2);upf.add(upf_p3);
				upf_b1.setPreferredSize(new Dimension(150,30));
				upf_l1.setFont(new Font("Dialog", 1, 25));
				upf_l2.setFont(new Font("Dialog", 1, 25));
				upf_p1.add(upf_l1);upf_p1.add(upf_t1);
				upf_p2.add(upf_l2);upf_p2.add(upf_t2);
				upf_p3.add(upf_b1);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == upf_b1) {
					deleteAll();
				}
			}
			private void deleteAll() {
				String Cousre_no = stf_t14.getText().trim();
				String sql = "delete from tb_SC where Course_no = '"+Cousre_no+"' ";
				String sql2 = "update tb_Course set Course_maxNum = 0 where Course_no = '"+Cousre_no+"' ";
				String sql1 = "delete from tb_SC";
				System.out.println(sql);System.out.println(sql1);
				try {
					if(judge3()) {	
						if(upf_t1.getText().equals(upf_t2.getText())) {
							if(Cousre_no.equals(null)) {
								stam1.executeUpdate(sql1);
							}else {
								stam1.executeUpdate(sql);
								stam1.executeUpdate(sql2);
							}
							JOptionPane.showMessageDialog(null, "删除成功！","提示",2);
						}else
							{
								JOptionPane.showMessageDialog(null, "两次输入不一致！","提示",2);
							}
					}else {
						JOptionPane.showMessageDialog(null, "您未开此门课程！","提示",2);
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			private boolean judge3() {
				String sql3 = "select Course_no from tb_TC where Tno ='"+accountNum1+"'";
				System.out.println("Course_no");
				ResultSet re;
				try {
					re = stam.executeQuery(sql3);
					while(re.next()) {
						String course_no = re.getString("Course_no").trim();
						if(course_no.equals(stf_t14.getText().trim())) {
							return true;
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return false;
			}
		}
}	
	
	
	
	
	
	
	