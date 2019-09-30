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

public class StudentFrame implements ActionListener {
	Graphics g;
	MyDBConnection mydbcon;
	Connection conn;
	Statement stam;
	String accountNum;
	String accountName;
	String Sno;
	String Sname;
	String Class_name;
	String Ssex;
	String Sage;
	String major;
	int judgeNum1 = 0;
	int judgeNum2 = 0;
	int judgeNum3 = 0;
	
	JFrame stf = new JFrame("选课管理系统——学生");
	
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
	JPanel stf_p7 = new JPanel();//按钮框里
	JPanel stf_p8 = new JPanel();
	JPanel stf_p9 = new JPanel();
	JPanel stf_p10 = new JPanel();
	JPanel stf_p11 = new JPanel();
	JPanel stf_p12 = new JPanel();
	JPanel stf_p13 = new JPanel();//个人信息里
	JPanel stf_p14 = new JPanel();
	JPanel stf_p15 = new JPanel();
	JPanel stf_p16 = new JPanel();
	JPanel stf_p17 = new JPanel();
	JPanel stf_p18 = new JPanel();
	JPanel stf_p19 = new JPanel();
	JPanel stf_p20 = new JPanel();
	JPanel stf_p21 = new JPanel();//sc
	JPanel stf_p22 = new JPanel();
	JPanel stf_p23 = new JPanel();
	JPanel stf_p24 = new JPanel();
	JPanel stf_p25 = new JPanel();
	JPanel stf_p26 = new JPanel();//我的课程里
	JPanel stf_p27 = new JPanel();//退课
	JPanel stf_p28 = new JPanel();
	JPanel stf_p29 = new JPanel();
	JPanel stf_p30 = new JPanel();
	JPanel stf_p31 = new JPanel();//查学分
	JPanel stf_p32 = new JPanel();
	
	
	
	JLabel stf_l1 = new  JLabel();
	JLabel stf_l2 = new  JLabel();
	JLabel stf_l3 = new  JLabel("欢迎您！");
	JLabel stf_l4 = new  JLabel("输入学年查询未被选修的课程：");
	JLabel stf_l5 = new  JLabel("输入需要选修课程的课程号：");
	JLabel stf_l6 = new  JLabel("输入开课学年和学期：");
	JLabel stf_l7 = new  JLabel("输入所退课程课程号：");
	
	
	JButton stf_b1 = new JButton("个人信息");
	JButton stf_b2 = new JButton("选课");
	JButton stf_b3 = new JButton("我的课程");
	JButton stf_b4 = new JButton("成绩查询");
	JButton stf_b5 = new JButton("修改密码");
	JButton stf_b6 = new JButton("确认");
	JButton stf_b7 = new JButton("确认选课");
	JButton stf_b8 = new JButton("查询学分");
	JButton stf_b9 = new JButton("退课");
	JButton stf_b10 = new JButton("确认退课");
	JButton stf_b11 = new JButton("查询所有学期总学分");
	
	JTextField stf_t1 = new JTextField(8);
	JTextField stf_t2 = new JTextField(8);
	JTextField stf_t3 = new JTextField(15);
	JTextField stf_t4 = new JTextField(8);
	JTextField stf_t5 = new JTextField(8);
	JTextField stf_t6 = new JTextField(15);

	
	ImageIcon img1 = new ImageIcon("src/test/4.jpg");
	ImageIcon img2 = new ImageIcon("src/test/5.jpg");
	
	String[] columnNames1 = {"课程号","课程名","时间","学分","地点","开课学年","开课学期","已选人数","任课教师"};
	String[] columnNames2 = {"课程号","课程名","时间","学分","地点","开课学年","开课学期","已选人数"};
	String[] columnNames3 = {"课程号","课程名","时间","学分","地点","开课学年","开课学期","已选人数"};
	String[] columnNames4 = {"课程名","成绩"};
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
	String [][] data3 = { };
	//创建表格并设置表格只读
	DefaultTableModel model3 = new DefaultTableModel(data3, columnNames3) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
		    return false;
		  }
	};
	String [][] data4 = { };
	//创建表格并设置表格只读
	DefaultTableModel model4 = new DefaultTableModel(data4, columnNames4) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
		    return false;
		  }
	};
	JTable table1= new JTable(model1);
	JTable table2= new JTable(model2);
	JTable table3= new JTable(model3);
	JTable table4= new JTable(model4);
	JScrollPane scroll1 = new JScrollPane(table1);
	JScrollPane scroll2 = new JScrollPane(table2);
	JScrollPane scroll3 = new JScrollPane(table3);
	JScrollPane scroll4 = new JScrollPane(table4);
	
	public StudentFrame(MyDBConnection mydbcon,String accountNum) {
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
		JLabel stf_l4 = new JLabel(accountName+"同学");
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_p6.add(stf_l3);stf_p6.add(stf_l4);
		
		stf_p4.setLayout(new GridLayout(6,1));
		stf_p4.add(stf_p7);stf_p4.add(stf_p8);stf_p4.add(stf_p9);
		stf_p4.add(stf_p10);stf_p4.add(stf_p11);stf_p4.add(stf_p12);
		stf_b1.setPreferredSize(new Dimension(150,30));
		stf_b2.setPreferredSize(new Dimension(150,30));
		stf_b3.setPreferredSize(new Dimension(150,30));
		stf_b4.setPreferredSize(new Dimension(150,30));
		stf_b9.setPreferredSize(new Dimension(150,30));
		stf_p8.add(stf_b1);stf_p9.add(stf_b2);stf_p10.add(stf_b3);stf_p11.add(stf_b4);stf_p12.add(stf_b9);
	}
	private void selecetAccountName() {
		String sql = "select * from tb_Student where Sno = '"+accountNum.trim()+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			re.next();
			accountName = re.getString("Sname");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == stf_b1) {
			drawPersonelInf();
		}else if(e.getSource() == stf_b2) {
			drawSC();
		}else if(e.getSource() == stf_b3) {
			drawMyCourses();
		}else if(e.getSource() == stf_b4) {
			drawGrade();
		}else if(e.getSource() == stf_b5) {
			new UpdataPwdFrame(mydbcon,accountNum);
		}else if(e.getSource() == stf_b6) {
			drawSC2();
		}else if(e.getSource() == stf_b7) {
			chooseCourse();
		}else if(e.getSource() == stf_b8) {
			showCreaditSum();
		}else if(e.getSource() == stf_b9) {
			drawDeleteCourse();
		}else if(e.getSource() == stf_b10) {
			deleteChoosenLog();
		}else if(e.getSource() == stf_b11) {
			showAllCreadit();
		}
		
	}
	private void showAllCreadit() {
		String sql = "select sum_creadit=sum(Course_gpa) from view_mycourse where Sno = '"+accountNum+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			re.next();
			double allCreadit = re.getDouble(1);
			String allCreadit2 = String.valueOf(allCreadit);
			JOptionPane.showMessageDialog(null, "所有学期总学分："+allCreadit2,"提示",2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void deleteChoosenLog() {
		String courseNum = stf_t6.getText().trim();
		String sql = "delete from tb_SC where Sno = '"+accountNum+"' and Course_no = '"+courseNum+"'";
		try {
			boolean t=stam.execute(sql);
			JOptionPane.showMessageDialog(null, "删除成功!","提示",2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void drawDeleteCourse() {
		stf_p2.removeAll();
		stf_p28.removeAll();stf_p29.removeAll();
		stf_p2.repaint();
		stf_l7.setFont(new Font("Dialog", 1, 25));
		stf_p2.setLayout(new GridLayout(4,1));
		stf_p2.add(stf_p27);stf_p2.add(stf_p28);stf_p2.add(stf_p29);stf_p2.add(stf_p30);
		stf_p28.add(stf_l7);stf_p29.add(stf_t6);stf_p29.add(stf_b10);
		stf_p2.revalidate();
	}
	private void drawGrade() {
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(2,1));
		showGrade();
		stf_p2.add(scroll4);
		stf_p2.revalidate();
	}
	private void showGrade() {
		String sql1 = "select * from view_mycourse where Sno = '"+accountNum+"'";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程名");
		ColumnName.add("成绩");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Course_name=rs.getString(3);
				int grade = rs.getInt(9);
				Row.add(Course_name);
				Row.add(grade);
				Data.add(Row);
			}	
			model4.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		
		
	}
	private void showCreaditSum() {
		String year = stf_t4.getText().trim();
		String term = stf_t5.getText().trim();
		String sql = "exec proc_select_creadit '"+accountNum+"','"+year+"','"+term+"'";
		try {
			 /*CallableStatement c=conn.prepareCall("{call proc_select_creadit(?,?)}");
			 c.setString(1, accountNum);
			 c.setString(2, year);
			 c.setString(3, term);
			 ResultSet rs = c.executeQuery();*/
			ResultSet re = stam.executeQuery(sql);
			re.next();
			String creadit = String.valueOf(re.getDouble(1));
			JOptionPane.showMessageDialog(null, "总学分："+creadit,"提示",2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void drawMyCourses() {
		stf_p2.removeAll();
		stf_p31.removeAll();stf_p32.removeAll();
		stf_p2.repaint();
		selectMyCourse();
		stf_p2.setLayout(new GridLayout(2,1));
		stf_p2.add(scroll3);stf_p2.add(stf_p26);
		stf_l6.setFont(new Font("Dialog", 1, 25));
		stf_p26.setLayout(new GridLayout(2,1));
		stf_p26.add(stf_p31);stf_p26.add(stf_p32);
		stf_p31.add(stf_l6);stf_p31.add(stf_t4);stf_p31.add(stf_t5);stf_p31.add(stf_b8);
		stf_b11.setPreferredSize(new Dimension(200,30));
		stf_p32.add(stf_b11);
		stf_p2.revalidate();
	}
	private void selectMyCourse() {
		String sql1 = "select * from view_mycourse where Sno = '"+accountNum+"'";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("时间");
		ColumnName.add("学分");
		ColumnName.add("地点");
		ColumnName.add("开设学年");
		ColumnName.add("开设学期");
		try {
			ResultSet rs = stam.executeQuery(sql1);
			while(rs.next()) {
				Vector Row = new Vector();
				String Course_no=rs.getString(2);
				String Course_name=rs.getString(3);
				String Course_time=rs.getString(4);
				double Course_gpa = Double.parseDouble(rs.getString(5));
				String Course_plase=rs.getString(6);
				String Course_startyear = rs.getString(7);
				String Course_starttime = rs.getString(8);
				Row.add(Course_no);
				Row.add(Course_name);
				Row.add(Course_time);
				Row.add(Course_gpa);
				Row.add(Course_plase);
				Row.add(Course_startyear);
				Row.add(Course_starttime);
				Data.add(Row);
			}	
			model3.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	private void chooseCourse() {
		
		String courseNum = stf_t3.getText().trim();
		String sql = "insert into tb_SC values('"+accountNum+"','"+courseNum+"',null)";
		judgeExistCourse(accountNum,courseNum);//judgeNum1
		judgeHadChoosen(accountNum,courseNum);//judgeNum2
		judgeFull(accountNum,courseNum);//judgeNum3
		if(judgeNum1 == 0) {
			JOptionPane.showMessageDialog(null, "未找到该课程！","提示",2);
		}
		if(judgeNum1 == 1 && judgeNum2 == 0 ) {
			JOptionPane.showMessageDialog(null, "此课程已选！","提示",2);
		}
		if(judgeNum1 == 1 && judgeNum2 == 1 && judgeNum3 == 0 ) {
			JOptionPane.showMessageDialog(null, "此课程人数已满！","提示",2);
		}
		if(judgeNum1 == 1 && judgeNum2 == 1 && judgeNum3 == 1 ) {
			try {
				stam.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "选课成功！","提示",2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	private int judgeFull(String accountNum, String courseNum) {
		String sql = "select * from tb_Course where Course_no = '"+courseNum+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			if(re.next()) {
				int choosenNum = Integer.parseInt(re.getString("Course_maxNum"));
				if(choosenNum < 10) {
					judgeNum3 = 1;
				}else {
					judgeNum3 = 0;
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return judgeNum3;	
	}
	private int judgeHadChoosen(String accountNum, String courseNum) {
		String sql = "select * from tb_SC where Sno = '"+accountNum+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			if(!re.next()) {
				judgeNum2 = 1;
			}else {
				while(re.next()) {
					String Sno = re.getString("Sno");
					String Course_no = re.getString("Course_no");
					if(accountNum.equals(Sno)&&courseNum.equals(Course_no)) {
						judgeNum2 = 0;
						break;
					}else{
						judgeNum2 = 1;
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judgeNum2;
	}
	private int judgeExistCourse(String accountNum,String courseNum) {
		String sql = "select * from tb_Course where Course_no = '"+courseNum+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			while(re.next()) {
				String Course_no = re.getString("Course_no");
				if(courseNum.equals(Course_no)) {
					judgeNum1 = 1;
					break;
				}else {
					judgeNum1 = 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judgeNum1;
	}
	private void drawSC2() {
		
		selectNoChooseCourse();
		stf_p22.removeAll();stf_p23.removeAll();stf_p24.removeAll();stf_p25.removeAll();
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(2,1));
		stf_p2.add(scroll2);stf_p2.add(stf_p21);
		stf_p21.setLayout(new GridLayout(4,1));
		stf_p21.add(stf_p22);stf_p21.add(stf_p23);stf_p21.add(stf_p24);stf_p21.add(stf_p25);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l5.setFont(new Font("Dialog", 1, 25));
		stf_p22.add(stf_l4);
		stf_p23.add(stf_t1);stf_p23.add(stf_t2);stf_p23.add(stf_b6);
		stf_p24.add(stf_l5);
		stf_p25.add(stf_t3);stf_p25.add(stf_b7);
		
	
		stf_p2.revalidate();
		
	}
	private void selectNoChooseCourse() {
		String startyear1 = stf_t1.getText().trim();
		String startyear2 = stf_t2.getText().trim();
		String sql1 = "select * from view_"+startyear1+"_"+startyear2+"";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("时间");
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
			model2.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	private void selectAllCourse() {
		String sql1 = "select * from view_course_teacher";
		Vector Data = new Vector();
		Vector ColumnName = new Vector();
		ColumnName.add("课程号");
		ColumnName.add("课程名");
		ColumnName.add("时间");
		ColumnName.add("学分");
		ColumnName.add("地点");
		ColumnName.add("开设学年");
		ColumnName.add("开设学期");
		ColumnName.add("已选人数");
		ColumnName.add("任课教师");
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
				String Tname = rs.getString(9);
				Row.add(Course_no);
				Row.add(Course_name);
				Row.add(Course_time);
				Row.add(Course_gpa);
				Row.add(Course_plase);
				Row.add(Course_startyear);
				Row.add(Course_starttime);
				Row.add(CourseMaxNum);
				Row.add(Tname);
				Data.add(Row);
			}	
			model1.setDataVector(Data,ColumnName);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		
		
	}
	private void drawSC() {
		selectAllCourse();
		stf_p22.removeAll();stf_p23.removeAll();stf_p24.removeAll();stf_p25.removeAll();
		stf_p2.removeAll();
		stf_p2.repaint();
		stf_p2.setLayout(new GridLayout(2,1));
		stf_p2.add(scroll1);stf_p2.add(stf_p21);
		stf_p21.setLayout(new GridLayout(4,1));
		stf_p21.add(stf_p22);stf_p21.add(stf_p23);stf_p21.add(stf_p24);stf_p21.add(stf_p25);
		stf_l4.setFont(new Font("Dialog", 1, 25));
		stf_l5.setFont(new Font("Dialog", 1, 25));
		stf_p22.add(stf_l4);
		stf_p23.add(stf_t1);stf_p23.add(stf_t2);stf_p23.add(stf_b6);
		stf_p24.add(stf_l5);
		stf_p25.add(stf_t3);stf_p25.add(stf_b7);
		
	
		stf_p2.revalidate();
	}

	private void drawPersonelInf() {
		stf_p14.removeAll();stf_p15.removeAll();stf_p16.removeAll();
		stf_p17.removeAll();stf_p18.removeAll();stf_p19.removeAll();
		stf_p2.removeAll();
		stf_p2.repaint();
		selectStudentInf();
		stf_p2.setLayout(new GridLayout(8,1));
		stf_p2.add(stf_p13);stf_p2.add(stf_p14);stf_p2.add(stf_p15);stf_p2.add(stf_p16);
		stf_p2.add(stf_p17);stf_p2.add(stf_p18);stf_p2.add(stf_p19);stf_p2.add(stf_p20);
		JLabel PersonelInf_l1 = new JLabel("学号："+Sno);
		JLabel PersonelInf_l2 = new JLabel("姓名："+Sname);
		JLabel PersonelInf_l3 = new JLabel("班级："+Class_name);
		JLabel PersonelInf_l4 = new JLabel("性别："+Ssex);
		JLabel PersonelInf_l5 = new JLabel("年龄："+Sage);
		JLabel PersonelInf_l6 = new JLabel("专业："+major);
		PersonelInf_l1.setFont(new Font("Dialog", 1, 25));
		PersonelInf_l2.setFont(new Font("Dialog", 1, 25));
		PersonelInf_l3.setFont(new Font("Dialog", 1, 25));
		PersonelInf_l4.setFont(new Font("Dialog", 1, 25));
		PersonelInf_l5.setFont(new Font("Dialog", 1, 25));
		PersonelInf_l6.setFont(new Font("Dialog", 1, 25));
		stf_p14.add(PersonelInf_l1);stf_p15.add(PersonelInf_l2);stf_p16.add(PersonelInf_l3);
		stf_p17.add(PersonelInf_l4);stf_p18.add(PersonelInf_l5);stf_p19.add(PersonelInf_l6);
		stf_p20.add(stf_b5);
		stf_b5.setPreferredSize(new Dimension(150,30));
		stf_p2.revalidate();
		
	}
	private void selectStudentInf() {
		String sql = "select * from view_student_class where Sno = '"+accountNum.trim()+"'";
		try {
			ResultSet re = stam.executeQuery(sql);
			re.next();
			Sno = re.getString("Sno");
			Sname = re.getString("Sname");
			Class_name = re.getString("Class_name");
			Ssex = re.getString("Ssex");
			Sage = re.getString("Sage");
			major = re.getString("major");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
class UpdataPwdFrame implements ActionListener{
	MyDBConnection mydbcon1;
	Connection conn1;
	Statement stam1;
	String accountNum1;
	JFrame upf = new JFrame("学生修改密码");
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
		String sql = "update tb_Student set code ='"+newPwd+"' where Sno = '"+accountNum1+"'";
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