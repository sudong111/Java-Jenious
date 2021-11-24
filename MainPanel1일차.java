import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

@SuppressWarnings("serial")

public class MainPanel extends JFrame{
	
	static String[] CheckDate;
	static String[] CheckLeft;
	static String[] CheckRight;
	static String[] CheckDateCom;
	static String[] CheckLeftCom;
	static String[] CheckRightCom;
	static String Header[] = {"날짜","좌안","우안"};
	static String StaticLeftInfo;
	static String StaticRightInfo;
	static String StaticFilePathLeft;
	static String StaticFilePathRight;
	static String StaticFilePathSave;
	static String StaticFilePathComplete;
	static String StaticFilePathLeft1;
	static String StaticFilePathRight1;
	static String StaticFilePathSave1;
	static String StaticFilePathComplete1;
	static String StaticFilePathNull;
	static String UserInfo;
	static JButton Main_b1 = new JButton("", new ImageIcon("C:\\Users\\CCNS\\Downloads\\돋보기.png"));			//Main_Panel 버튼
	static JButton Main_b2 = new JButton("", new ImageIcon("C:\\Users\\CCNS\\Downloads\\서류.png"));
	static JButton Lookup_b1 = new JButton("조회");
	static JButton Lookup_b2 = new JButton("뒤로");
	static JLabel Main_l1 = new JLabel("환자 조회");
	static JLabel Main_l2 = new JLabel("환자 등록");
	static JLabel Lookup_l1 = new JLabel("성명");
	static JLabel Lookup_l2 = new JLabel("생년월일");
	static JTextField Lookup_t1 = new JTextField();
	@SuppressWarnings("rawtypes")
	static JComboBox Lookup_x1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	static JComboBox Lookup_x2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	static JComboBox Lookup_x3 = new JComboBox();			//Search_Panel 텍스트 필드
	static JButton Register_b1 = new JButton("저장");
	static JButton Register_b2 = new JButton("뒤로");
	static JLabel Register_l1 = new JLabel("성명");
	static JLabel Register_l2 = new JLabel("생년월일");
	static JTextField Register_t1 = new JTextField();
	@SuppressWarnings("rawtypes")
	static JComboBox Register_x1 = new JComboBox();
	@SuppressWarnings("rawtypes")
	static JComboBox Register_x2 = new JComboBox();
	@SuppressWarnings("rawtypes")
	static JComboBox Register_x3 = new JComboBox();
	static JButton Information_b1 = new JButton("측정(좌)");
	static JButton Information_b2 = new JButton("측정(우)");
	static JButton Information_b3 = new JButton("취소");
	static JButton Information_b4 = new JButton("측정 완료");
	static JButton Information2_b1 = new JButton("측정(좌)");
	static JButton Information2_b2 = new JButton("측정(우)");
	static JButton Information2_b3 = new JButton("취소");
	static JButton Information2_b4 = new JButton("측정 완료");
	static JButton Information3_b1 = new JButton("측정(좌)");
	static JButton Information3_b2 = new JButton("측정(우)");
	static JButton Information3_b3 = new JButton("취소");
	static JButton Information3_b4 = new JButton("측정 완료");
	static JButton Information4_b1 = new JButton("측정(좌)");
	static JButton Information4_b2 = new JButton("측정(우)");
	static JButton Information4_b3 = new JButton("취소");
	static JButton Information4_b4 = new JButton("측정 완료");
	static JPanel Main_Panel = new JPanel();					//Main_Panel ( 여기서 배경화면 넣으면 됩니다 )
	static JPanel Lookup_Panel = new JPanel();					//Lookup_Panel ( 환자 조회 눌렀을 때 나오는 화면 )
	static JPanel Register_Panel = new JPanel();				//Register_Panel ( 신규 환자 등록 눌렀을 때 나오는 화면 )
	static JPanel Information_Panel = new JPanel();				//Information_Panel ( 선택 눌렀을 때 나오는 화면 )
	static JPanel Information2_Panel = new JPanel();
	static JPanel Information3_Panel = new JPanel();	
	static JPanel Information4_Panel = new JPanel();
	Draw_Panel drawpanel = new Draw_Panel();
	Draw_Panel1 drawpanel1 = new Draw_Panel1();
	BufferedImage img = null;
	

	
	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");
	Date time = new Date();
	String timeNow = format1.format(time);
	
	public MainPanel() {
			        
		try { 
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName()); 
	                break; 
	            }
	        } 
		}
		
		catch (Exception e) {} 

		Main_Frame();			//Main_Frame 함수를 실행
		Panel_Setting();		//Panel_Setting 함수를 실행]
	}
	

	public void Main_Frame() {								//Main_Frame 설정
		
		setTitle("환자 테스트");								//타이틀
		setSize(800,480);									//프레임의 크기 ( x , y )
		setResizable(false);								//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);						//창이 가운데 나오게
		setLayout(null);									//레이아웃 설정
		setVisible(true);									//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//JFrame이 정상적으로 종료되게
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void Panel_Setting() {						//Panel_Setting 설정
						
		
		
		Font font = new Font("굴림", Font.PLAIN, 15);		//버튼 폰트 ( 추가 가능 )
		Font fontbic = new Font("굴림", Font.PLAIN, 30);
				
		Main_b1.setBounds(0, 0, 385, 400);			//버튼 패널 라벨 등 크기 밑 위치 ( x축 , y축 , x축 크기 , y축 크기 )
		Main_b2.setBounds(395, 0, 385, 400);
		Main_l1.setBounds(0,400,385,40);
		Main_l2.setBounds(395,400,385,40);
		Lookup_b1.setBounds(250, 380, 100, 30);
		Lookup_b2.setBounds(450, 380, 100, 30);
		Lookup_l1.setBounds(240, 50, 100, 30);
		Lookup_l2.setBounds(240, 150, 100, 30);
		Lookup_t1.setBounds(340, 50, 210, 30);
		Lookup_x1.setBounds(340, 150, 90, 30);
		Lookup_x2.setBounds(430, 150, 60, 30);
		Lookup_x3.setBounds(490, 150, 60, 30);
		Register_b1.setBounds(250, 380, 100, 30);
		Register_b2.setBounds(450, 380, 100, 30);
		Register_l1.setBounds(240, 50, 100, 30);
		Register_l2.setBounds(240, 150, 100, 30);
		Register_t1.setBounds(340, 50, 210, 30);
		Register_x1.setBounds(340, 150, 80, 30);
		Register_x2.setBounds(420, 150, 65, 30);
		Register_x3.setBounds(485, 150, 65, 30);
		Information_b1.setBounds(200, 380, 100, 30);
		Information_b2.setBounds(300, 380, 100, 30);
		Information_b3.setBounds(500, 380, 100, 30);
		Information_b4.setBounds(400, 380, 100, 30);
		Information2_b1.setBounds(200, 380, 100, 30);
		Information2_b2.setBounds(300, 380, 100, 30);
		Information2_b3.setBounds(500, 380, 100, 30);
		Information2_b4.setBounds(400, 380, 100, 30);
		Information3_b1.setBounds(200, 380, 100, 30);
		Information3_b2.setBounds(300, 380, 100, 30);
		Information3_b3.setBounds(500, 380, 100, 30);
		Information3_b4.setBounds(400, 380, 100, 30);
		Information4_b1.setBounds(200, 380, 100, 30);
		Information4_b2.setBounds(300, 380, 100, 30);
		Information4_b3.setBounds(500, 380, 100, 30);
		Information4_b4.setBounds(400, 380, 100, 30);
		
		Main_Panel.setBounds(0, 0, 800, 480);			
		Lookup_Panel.setBounds(0, 0, 800, 480);
		Register_Panel.setBounds(0, 0, 800, 480);
		Information_Panel.setBounds(0, 0, 800, 480);
		Information2_Panel.setBounds(0, 0, 800, 480);
		Information3_Panel.setBounds(0, 0, 800, 480);
		Information4_Panel.setBounds(0, 0, 800, 480);
		drawpanel.setBounds(170,180, 420, 195);
		drawpanel1.setBounds(170,180, 420, 195);		

		
		Main_Panel.setBackground(Color.WHITE);			//배경 색 , 레이아웃 , 창 보이는 유무 설정
		Main_Panel.setLayout(null);
		Lookup_Panel.setBackground(Color.WHITE);
		Lookup_Panel.setLayout(null);
		Lookup_Panel.setVisible(false);	
		Register_Panel.setBackground(Color.WHITE);
		Register_Panel.setLayout(null);
		Register_Panel.setVisible(false);
		Information_Panel.setBackground(Color.WHITE);
		Information_Panel.setLayout(null);
		Information_Panel.setVisible(false);
		Information2_Panel.setBackground(Color.WHITE);
		Information2_Panel.setLayout(null);
		Information2_Panel.setVisible(false);
		Information3_Panel.setBackground(Color.WHITE);
		Information3_Panel.setLayout(null);
		Information3_Panel.setVisible(false);		
		Information4_Panel.setBackground(Color.WHITE);
		Information4_Panel.setLayout(null);
		Information4_Panel.setVisible(false);
		drawpanel.setVisible(false);
		drawpanel.setLayout(null);
		drawpanel1.setVisible(false);
		drawpanel1.setLayout(null);
	
		Main_b1.setBorderPainted(false);				//버튼 설정 (테두리 안보이게, 색깔 등등)
		Main_b1.setFocusPainted(false);
		Main_b1.setBackground(Color.WHITE);
		Main_b1.setHorizontalAlignment(JButton.CENTER);
		Main_b1.setFont(font);
		
		Main_b2.setBorderPainted(false);				
		Main_b2.setFocusPainted(false);
		Main_b2.setBackground(Color.WHITE);
		Main_b2.setHorizontalAlignment(JButton.CENTER);
		Main_b2.setFont(font);
		
		Lookup_b1.setBorderPainted(true);				
		Lookup_b1.setFocusPainted(false);
		Lookup_b1.setBackground(Color.WHITE);
		Lookup_b1.setHorizontalAlignment(JButton.CENTER);
		Lookup_b1.setFont(font);
		
		Lookup_b2.setBorderPainted(true);				
		Lookup_b2.setFocusPainted(false);
		Lookup_b2.setBackground(Color.WHITE);
		Lookup_b2.setHorizontalAlignment(JButton.CENTER);
		Lookup_b2.setFont(font);
		
		Register_b1.setBorderPainted(true);				
		Register_b1.setFocusPainted(false);
		Register_b1.setBackground(Color.WHITE);
		Register_b1.setHorizontalAlignment(JButton.CENTER);
		Register_b1.setFont(font);
		
		Register_b2.setBorderPainted(true);				
		Register_b2.setFocusPainted(false);
		Register_b2.setBackground(Color.WHITE);
		Register_b2.setHorizontalAlignment(JButton.CENTER);
		Register_b2.setFont(font);
		
		Information_b1.setBorderPainted(true);				
		Information_b1.setFocusPainted(false);
		Information_b1.setBackground(Color.WHITE);
		Information_b1.setHorizontalAlignment(JButton.CENTER);
		Information_b1.setFont(font);
		
		Information_b2.setBorderPainted(true);				
		Information_b2.setFocusPainted(false);
		Information_b2.setBackground(Color.WHITE);
		Information_b2.setHorizontalAlignment(JButton.CENTER);
		Information_b2.setFont(font);
		
		Information_b3.setBorderPainted(true);				
		Information_b3.setFocusPainted(false);
		Information_b3.setBackground(Color.WHITE);
		Information_b3.setHorizontalAlignment(JButton.CENTER);
		Information_b3.setFont(font);
		
		Information_b4.setBorderPainted(true);				
		Information_b4.setFocusPainted(false);
		Information_b4.setBackground(Color.WHITE);
		Information_b4.setHorizontalAlignment(JButton.CENTER);
		Information_b4.setFont(font);

		Information2_b1.setBorderPainted(true);				
		Information2_b1.setFocusPainted(false);
		Information2_b1.setBackground(Color.WHITE);
		Information2_b1.setHorizontalAlignment(JButton.CENTER);
		Information2_b1.setFont(font);
		
		Information2_b2.setBorderPainted(true);				
		Information2_b2.setFocusPainted(false);
		Information2_b2.setBackground(Color.WHITE);
		Information2_b2.setHorizontalAlignment(JButton.CENTER);
		Information2_b2.setFont(font);
		
		Information2_b3.setBorderPainted(true);				
		Information2_b3.setFocusPainted(false);
		Information2_b3.setBackground(Color.WHITE);
		Information2_b3.setHorizontalAlignment(JButton.CENTER);
		Information2_b3.setFont(font);
		
		Information2_b4.setBorderPainted(true);				
		Information2_b4.setFocusPainted(false);
		Information2_b4.setBackground(Color.WHITE);
		Information2_b4.setHorizontalAlignment(JButton.CENTER);
		Information2_b4.setFont(font);
		
		Information3_b1.setBorderPainted(true);				
		Information3_b1.setFocusPainted(false);
		Information3_b1.setBackground(Color.WHITE);
		Information3_b1.setHorizontalAlignment(JButton.CENTER);
		Information3_b1.setFont(font);
	
		Information3_b2.setBorderPainted(true);				
		Information3_b2.setFocusPainted(false);
		Information3_b2.setBackground(Color.WHITE);
		Information3_b2.setHorizontalAlignment(JButton.CENTER);
		Information3_b2.setFont(font);
		
		Information3_b3.setBorderPainted(true);				
		Information3_b3.setFocusPainted(false);
		Information3_b3.setBackground(Color.WHITE);
		Information3_b3.setHorizontalAlignment(JButton.CENTER);
		Information3_b3.setFont(font);
		
		Information3_b4.setBorderPainted(true);				
		Information3_b4.setFocusPainted(false);
		Information3_b4.setBackground(Color.WHITE);
		Information3_b4.setHorizontalAlignment(JButton.CENTER);
		Information3_b4.setFont(font);
		
		Information4_b1.setBorderPainted(true);				
		Information4_b1.setFocusPainted(false);
		Information4_b1.setBackground(Color.WHITE);
		Information4_b1.setHorizontalAlignment(JButton.CENTER);
		Information4_b1.setFont(font);
	
		Information4_b2.setBorderPainted(true);				
		Information4_b2.setFocusPainted(false);
		Information4_b2.setBackground(Color.WHITE);
		Information4_b2.setHorizontalAlignment(JButton.CENTER);
		Information4_b2.setFont(font);
		
		Information4_b3.setBorderPainted(true);				
		Information4_b3.setFocusPainted(false);
		Information4_b3.setBackground(Color.WHITE);
		Information4_b3.setHorizontalAlignment(JButton.CENTER);
		Information4_b3.setFont(font);
		
		Information4_b4.setBorderPainted(true);				
		Information4_b4.setFocusPainted(false);
		Information4_b4.setBackground(Color.WHITE);
		Information4_b4.setHorizontalAlignment(JButton.CENTER);
		Information4_b4.setFont(font);
			
		Main_l1.setBackground(Color.WHITE);	
		Main_l1.setHorizontalAlignment(JButton.CENTER);
		Main_l1.setFont(fontbic);
		Main_l2.setBackground(Color.WHITE);	
		Main_l2.setHorizontalAlignment(JButton.CENTER);
		Main_l2.setFont(fontbic);

		Lookup_l1.setBackground(Color.WHITE);					
		Lookup_l1.setHorizontalAlignment(JButton.CENTER);
		Lookup_l1.setFont(font);
		Lookup_l2.setBackground(Color.WHITE);					
		Lookup_l2.setHorizontalAlignment(JButton.CENTER);
		Lookup_l2.setFont(font);
		
		Register_l1.setBackground(Color.WHITE);					
		Register_l1.setHorizontalAlignment(JButton.CENTER);
		Register_l1.setFont(font);
		Register_l2.setBackground(Color.WHITE);					
		Register_l2.setHorizontalAlignment(JButton.CENTER);
		Register_l2.setFont(font);
		
		Lookup_t1.setBackground(Color.WHITE);					//텍스트 필드 설정
		Lookup_t1.setHorizontalAlignment(JButton.CENTER);
		Lookup_t1.setFont(font);
		
		Register_t1.setBackground(Color.WHITE);					
		Register_t1.setHorizontalAlignment(JButton.CENTER);
		Register_t1.setFont(font);
		
		Lookup_x1.setBackground(Color.WHITE);					
		Lookup_x1.setFont(font);
		Lookup_x2.setBackground(Color.WHITE);					
		Lookup_x2.setFont(font);
		Lookup_x3.setBackground(Color.WHITE);					
		Lookup_x3.setFont(font);
		
		Register_x1.setBackground(Color.WHITE);					
		Register_x1.setFont(font);
		Register_x2.setBackground(Color.WHITE);					
		Register_x2.setFont(font);
		Register_x3.setBackground(Color.WHITE);					
		Register_x3.setFont(font);
		
		Main_b1.addActionListener(new MyActionListener_b1());		//버튼 리스너 지정
		Main_b2.addActionListener(new MyActionListener_b2());
		Main_b1.addMouseListener(new MyMouseListener());
		Main_b2.addMouseListener(new MyMouseListener());
		Lookup_b1.addActionListener(new MyActionListenerTrd(drawpanel));
		Lookup_b2.addActionListener(new MyActionListener());
		Lookup_b1.addMouseListener(new MyMouseListener());
		Lookup_b2.addMouseListener(new MyMouseListener());
		Register_b1.addActionListener(new MyActionListenerTwo());
		Register_b2.addActionListener(new MyActionListener());
		Register_b1.addMouseListener(new MyMouseListener());
		Register_b2.addMouseListener(new MyMouseListener());
		Information_b1.addActionListener(new MyActionListenerLeft(drawpanel));
		Information_b2.addActionListener(new MyActionListenerRight(drawpanel));
		Information_b3.addActionListener(new MyActionListener());
		Information_b4.addActionListener(new MyActionListenerComplete(drawpanel1));
		Information_b1.addMouseListener(new MyMouseListener());
		Information_b2.addMouseListener(new MyMouseListener());
		Information_b3.addMouseListener(new MyMouseListener());
		Information_b4.addMouseListener(new MyMouseListener());
		Information2_b1.addActionListener(new MyActionListenerLeft(drawpanel));
		Information2_b2.addActionListener(new MyActionListenerRight(drawpanel));
		Information2_b3.addActionListener(new MyActionListener());
		Information2_b4.addActionListener(new MyActionListenerComplete(drawpanel1));
		Information2_b1.addMouseListener(new MyMouseListener());
		Information2_b2.addMouseListener(new MyMouseListener());
		Information2_b3.addMouseListener(new MyMouseListener());
		Information2_b4.addMouseListener(new MyMouseListener());
		Information3_b1.addActionListener(new MyActionListenerLeft(drawpanel));
		Information3_b2.addActionListener(new MyActionListenerRight(drawpanel));
		Information3_b3.addActionListener(new MyActionListener());
		Information3_b4.addActionListener(new MyActionListenerComplete(drawpanel1));
		Information3_b1.addMouseListener(new MyMouseListener());
		Information3_b2.addMouseListener(new MyMouseListener());
		Information3_b3.addMouseListener(new MyMouseListener());
		Information3_b4.addMouseListener(new MyMouseListener());
		Information4_b1.addActionListener(new MyActionListenerLeft(drawpanel));
		Information4_b2.addActionListener(new MyActionListenerRight(drawpanel));
		Information4_b3.addActionListener(new MyActionListener());
		Information4_b4.addActionListener(new MyActionListenerComplete(drawpanel1));
		Information4_b1.addMouseListener(new MyMouseListener());
		Information4_b2.addMouseListener(new MyMouseListener());
		Information4_b3.addMouseListener(new MyMouseListener());
		Information4_b4.addMouseListener(new MyMouseListener());

		add(Main_Panel);				//프레임에 패널을 추가
		add(Lookup_Panel);
		add(Register_Panel);
		add(drawpanel);
		add(drawpanel1);
		add(Information_Panel);
		add(Information2_Panel);
		add(Information3_Panel);
		add(Information4_Panel);
		Main_Panel.add(Main_b1);		//패널에 오브젝트를 추가
		Main_Panel.add(Main_b2);
		Lookup_Panel.add(Lookup_b1);
		Lookup_Panel.add(Lookup_b2);
		Lookup_Panel.add(Lookup_l1);
		Lookup_Panel.add(Lookup_l2);
		Lookup_Panel.add(Lookup_t1);
		Lookup_Panel.add(Lookup_x1);
		Lookup_Panel.add(Lookup_x2);
		Lookup_Panel.add(Lookup_x3);
		Register_Panel.add(Register_b1);
		Register_Panel.add(Register_b2);
		Register_Panel.add(Register_l1);
		Register_Panel.add(Register_l2);
		Register_Panel.add(Register_t1);
		Register_Panel.add(Register_x1);
		Register_Panel.add(Register_x2);
		Register_Panel.add(Register_x3);
		Information_Panel.add(Information_b1);
		Information_Panel.add(Information_b2);
		Information_Panel.add(Information_b3);
		Information_Panel.add(Information_b4);
		Information2_Panel.add(Information2_b1);
		Information2_Panel.add(Information2_b2);
		Information2_Panel.add(Information2_b3);
		Information2_Panel.add(Information2_b4);
		Information3_Panel.add(Information3_b1);
		Information3_Panel.add(Information3_b2);
		Information3_Panel.add(Information3_b3);
		Information3_Panel.add(Information3_b4);
		Information4_Panel.add(Information4_b1);
		Information4_Panel.add(Information4_b2);
		Information4_Panel.add(Information4_b3);
		Information4_Panel.add(Information4_b4);
		Main_Panel.add(Main_l1);
		Main_Panel.add(Main_l2);
		Lookup_b1.updateUI();
		Lookup_b2.updateUI();
		Lookup_t1.updateUI();
		Lookup_x1.updateUI();
		Lookup_x2.updateUI();
		Lookup_x3.updateUI();
		Register_b1.updateUI();
		Register_b2.updateUI();
		Register_t1.updateUI();
		Register_x1.updateUI();
		Register_x2.updateUI();
		Register_x3.updateUI();
		Information_b1.updateUI();
		Information_b2.updateUI();
		Information_b3.updateUI();
		Information_b4.updateUI();
		Information2_b1.updateUI();
		Information2_b2.updateUI();
		Information2_b3.updateUI();
		Information2_b4.updateUI();
		Information3_b1.updateUI();
		Information3_b2.updateUI();
		Information3_b3.updateUI();
		Information3_b4.updateUI();
		Information4_b1.updateUI();
		Information4_b2.updateUI();
		Information4_b3.updateUI();
		Information4_b4.updateUI();

		
		for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
			Register_x1.addItem(i + "년");}
		for (int i = 1 ; i <=12 ; i++) {
			Register_x2.addItem(i + "월");}
		for (int i = 1 ; i <=31 ; i++) {
			Register_x3.addItem(i + "일");}
		
		for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
			Lookup_x1.addItem(i + "년");}
		for (int i = 1 ; i <=12 ; i++) {
			Lookup_x2.addItem(i + "월");}
		for (int i = 1 ; i <=31 ; i++) {
			Lookup_x3.addItem(i + "일");}
		
		try {
			img = ImageIO.read(new File("C:\\Users\\CCNS\\Downloads\\그래프1.png"));
		}
		catch(IOException e) {}
		
	}
	
	class Draw_Panel extends JPanel{
			
		Font font = new Font("굴림", Font.PLAIN, 12);
		int to = 0;
		int yo = 0;
		String[] CheckDateInfo;
		String[] CheckLeftInfo;
		String[] CheckRightInfo;
		String[] LineLeft;
		String[] LineRight;
		public void paint(Graphics g) {
				
		g.setFont(font);
		g.drawImage(img,0,0,null);
		g.drawString("400",30,30);
		g.drawString("350",30,70);
		g.drawString("300",30,110);
		g.drawString("250",30,150);
		g.drawString("mOsmol", 0, 10);
		g.drawString("좌안", 350, 15);
		g.drawString("우안", 280, 15);
		int a = CheckDate.length - 6;
		if(CheckDate.length < 6) {
		CheckDateInfo = new String[CheckDate.length];
		CheckLeftInfo = new String[CheckDate.length];
		CheckRightInfo = new String[CheckDate.length];
		LineLeft = new String[CheckDate.length];
		LineRight = new String[CheckDate.length];}
		else {
			CheckDateInfo = new String[6];
			CheckLeftInfo = new String[6];
			CheckRightInfo = new String[6];
			LineLeft = new String[6];
			LineRight = new String[6];}
		
		if(CheckDate.length > 6) {
			for(int t = 0 ; t < 6 ; t++) {
			
				CheckRightInfo[t] = CheckRight[a];
				CheckLeftInfo[t] = CheckLeft[a];
				CheckDateInfo[t] = CheckDate[a];
				a++;}}
		else {
			for(int t = 0 ; t < CheckDate.length ; t++) {
				
				CheckRightInfo[t] = CheckRight[t];
				CheckLeftInfo[t] = CheckLeft[t];
				CheckDateInfo[t] = CheckDate[t];}}

		for(int t = 0 ; t < CheckDateInfo.length ; t++) { 
			
			int p = Integer.parseInt(CheckLeftInfo[t]);
			int x = Integer.parseInt(CheckRightInfo[t]);
			int q = (int) ((400 - p) * 0.8 + 25);
			int y = (int) ((400 - x) * 0.8 + 25);
		g.setColor(Color.BLACK);
		g.drawString(CheckDateInfo[t].substring(5),(t+1) * 60,190);
		g.setColor(Color.RED);	
		g.fillRect(15 + (t+1) * 60,q,3,3);
		LineLeft[t] = Integer.toString(q);
		g.setColor(Color.BLUE);	
		g.fillRect(15 + (t+1) * 60,y,3,3);
		LineRight[t] = Integer.toString(y);}	
		g.setColor(Color.LIGHT_GRAY);	
		g.drawLine(60, 25, 375, 25);
		g.drawLine(60, 65, 375, 65);
		g.drawLine(60, 105, 375, 105);
		g.drawLine(60, 145, 375, 145);
		g.drawLine(60, 145, 375, 145);
		g.setColor(Color.BLUE);	
		g.drawLine(250, 10, 270, 10);
		g.setColor(Color.RED);	
		g.drawLine(320, 10, 340, 10);
		
		for(int t = 0 ; t < CheckDateInfo.length - 1 ; t++) {
			
			int p = Integer.parseInt(LineLeft[t]);
			int x = Integer.parseInt(LineRight[t]);
				if(t<5) {
					 to = Integer.parseInt(LineLeft[t+1]);
					 yo = Integer.parseInt(LineRight[t+1]);}
						else {
							 to = 0;
							 yo = 0;}
				
				if(x > 145 || yo > 145) {}
				
				else {
				g.setColor(Color.BLUE);	
				g.drawLine(15 + (t+1) * 60,x, 15 + (t+2) * 60,yo);}
				
				if(p > 145 || to > 145) {}
				
				else {
					g.setColor(Color.RED);
					g.drawLine(15 + (t+1) * 60,p, 15 + (t+2) * 60,to);}}
		}
	}
	
	class Draw_Panel1 extends JPanel{
		
		Font font = new Font("굴림", Font.PLAIN, 12);
		int to = 0;
		int yo = 0;
		String[] CheckDateInfo;
		String[] CheckLeftInfo;
		String[] CheckRightInfo;
		String[] LineLeft;
		String[] LineRight;
		
		public void paint(Graphics g) {
				
		g.setFont(font);
		g.drawImage(img,0,0,null);
		g.drawString("400",30,30);
		g.drawString("350",30,70);
		g.drawString("300",30,110);
		g.drawString("250",30,150);
		g.drawString("mOsmol", 0, 10);
		g.drawString("좌안", 350, 15);
		g.drawString("우안", 280, 15);
		int a = CheckDateCom.length - 6;
		
		if(CheckDate.length < 6) {
		CheckDateInfo = new String[CheckDateCom.length];
		CheckLeftInfo = new String[CheckDateCom.length];
		CheckRightInfo = new String[CheckDateCom.length];
		LineLeft = new String[CheckDateCom.length];
		LineRight = new String[CheckDateCom.length];}
		else {
			CheckDateInfo = new String[6];
			CheckLeftInfo = new String[6];
			CheckRightInfo = new String[6];
			LineLeft = new String[6];
			LineRight = new String[6];}
		
		if(CheckDateCom.length > 6) {
			for(int t = 0 ; t < 6 ; t++) {
			
				CheckRightInfo[t] = CheckRightCom[a];
				CheckLeftInfo[t] = CheckLeftCom[a];
				CheckDateInfo[t] = CheckDateCom[a];
				a++;}}
		else {
			for(int t = 0 ; t < CheckDateCom.length ; t++) {
				
				CheckRightInfo[t] = CheckRightCom[t];
				CheckLeftInfo[t] = CheckLeftCom[t];
				CheckDateInfo[t] = CheckDateCom[t];}}

		for(int t = 0 ; t < CheckDateInfo.length ; t++) { 
			
			int p = Integer.parseInt(CheckLeftInfo[t]);
			int x = Integer.parseInt(CheckRightInfo[t]);
			int q = (int) ((400 - p) * 0.8 + 25);
			int y = (int) ((400 - x) * 0.8 + 25);
		g.setColor(Color.BLACK);
		g.drawString(CheckDateInfo[t].substring(5),(t+1) * 60,190);
		g.setColor(Color.RED);	
		g.fillRect(15 + (t+1) * 60,q,3,3);
		LineLeft[t] = Integer.toString(q);
		g.setColor(Color.BLUE);	
		g.fillRect(15 + (t+1) * 60,y,3,3);
		LineRight[t] = Integer.toString(y);}	
		g.setColor(Color.LIGHT_GRAY);	
		g.drawLine(60, 25, 375, 25);
		g.drawLine(60, 65, 375, 65);
		g.drawLine(60, 105, 375, 105);
		g.drawLine(60, 145, 375, 145);
		g.drawLine(60, 145, 375, 145);
		g.setColor(Color.BLUE);	
		g.drawLine(250, 10, 270, 10);
		g.setColor(Color.RED);	
		g.drawLine(320, 10, 340, 10);
		
		for(int t = 0 ; t < CheckDateInfo.length - 1 ; t++) {
			
			int p = Integer.parseInt(LineLeft[t]);
			int x = Integer.parseInt(LineRight[t]);
				if(t<5) {
					 to = Integer.parseInt(LineLeft[t+1]);
					 yo = Integer.parseInt(LineRight[t+1]);}
						else {
							 to = 0;
							 yo = 0;}
			
				if(x > 145 || yo > 145) {}
				
				else {
				g.setColor(Color.BLUE);	
				g.drawLine(15 + (t+1) * 60,x, 15 + (t+2) * 60,yo);}
				
				if(p > 145 || to > 145) {}
				
				else {
					g.setColor(Color.RED);
					g.drawLine(15 + (t+1) * 60,p, 15 + (t+2) * 60,to);}}
		}
	}
	
	
	class MyMouseListener implements MouseListener {	//마우스 이벤트
		
		public void mouseEntered(MouseEvent e) {		//버튼에 마우스 올렸을 때 버튼 색깔
			JButton button = (JButton) e.getSource();
			button.setBackground(Color.LIGHT_GRAY);}
		
		public void mouseExited(MouseEvent e) {			//버튼에 마우스 땠을 때 버튼 색깔
	        JButton button = (JButton) e.getSource();
	        button.setBackground(Color.WHITE);}
		
	    public void mousePressed(MouseEvent e) {}
	    public void mouseReleased(MouseEvent e) {}
	    public void mouseClicked(MouseEvent e) {}
	    
	}
	class MyActionListener_b1 implements ActionListener{
		
		public void actionPerformed(ActionEvent e){	

			Main_Panel.setVisible(false);
			Register_Panel.setVisible(false);
			Information_Panel.setVisible(false);
			Information2_Panel.setVisible(false);
			Information3_Panel.setVisible(false);
			Information4_Panel.setVisible(false);
			Lookup_Panel.setVisible(true);
			revalidate();
			repaint();
			
		}
	}
	
class MyActionListener_b2 implements ActionListener{
		
		public void actionPerformed(ActionEvent e){	
			
			Main_Panel.setVisible(false);
			Information_Panel.setVisible(false);
			Information2_Panel.setVisible(false);
			Information3_Panel.setVisible(false);
			Information4_Panel.setVisible(false);
			Lookup_Panel.setVisible(false);
			Register_Panel.setVisible(true);
			revalidate();
			repaint();
			
		}
	}

class MyActionListenerTwo implements ActionListener{
		
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e){
		
		String Name = Register_t1.getText();
		String Year = Register_x1.getSelectedItem().toString();
		String Month = Register_x2.getSelectedItem().toString();
		String Day = Register_x3.getSelectedItem().toString();
		String FolderPath = "C:/Users/CCNS/Desktop/지니어링/회원정보/" + Name + " " + Year + " " + Month + " " + Day;
		String FilePath = "C:/Users/CCNS/Desktop/지니어링/회원정보/" + Name + " " + Year + " " + Month + " " + Day + "/";
		File Folder = new File(FolderPath);
		
		if(!Folder.exists()) {
			try {
				Folder.mkdir();}
				
			catch(Exception e1) {}
				
			try {
				FileWriter fileWriter = new FileWriter(FilePath + "좌" + ".txt",true);
				
				fileWriter.write(" ");
				fileWriter.close();}
				
				catch (Exception e1) {}
				
			try {
				FileWriter fileWriter = new FileWriter(FilePath + "우" + ".txt",true);
				
				fileWriter.write(" ");
				fileWriter.close();}
				
				catch (Exception e1) {}
				
			try {
				FileWriter fileWriter = new FileWriter(FilePath + "저장용" + ".txt",true);
				
				fileWriter.write(" ");
				fileWriter.close();}
				
				catch (Exception e1) {}
				
			try {
				FileWriter fileWriter = new FileWriter(FilePath + "완성용" + ".txt",true);
				
				fileWriter.write(" ");
				fileWriter.close();}
				
				catch (Exception e1) {}
				
			try {
				FileWriter fileWriter = new FileWriter(FilePath + "-" + ".txt",true);
				
				fileWriter.write(" - - -");
				fileWriter.close();}
				
				catch (Exception e1) {}
				
			JOptionPane.showMessageDialog(null, "저장되었습니다.");

		}
			
		else {
			JOptionPane.showMessageDialog(null, "동명이인이 있습니다. 카운터에 문의하세요.");
			return;}
			
		Register_t1.setText("");
		Register_x1.removeAllItems();
		Register_x2.removeAllItems();
		Register_x3.removeAllItems();
			
		for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
			Register_x1.addItem(i + "년");}
		for (int i = 1 ; i <=12 ; i++) {
			Register_x2.addItem(i + "월");}
			for (int i = 1 ; i <=31 ; i++) {
			Register_x3.addItem(i + "일");}
		
		Lookup_Panel.setVisible(false);
		Register_Panel.setVisible(false);
		Information_Panel.setVisible(false);
		Information2_Panel.setVisible(false);
		Information3_Panel.setVisible(false);
		Information4_Panel.setVisible(false);
		drawpanel.setVisible(false);
		drawpanel1.setVisible(false);
		Main_Panel.setVisible(true);
		revalidate();
		repaint();
			
		
		}
	}
	

class MyActionListenerTrd implements ActionListener{
	
	Draw_Panel drawpanel;
	String[][] Contents;
	String[] ArrayComplete;
	String[] ArrayNull;
	String[] Information;
	String InfoNull;
	String FilePathLeft;
	String FilePathRight;
	String FilePathSave;
	String FilePathComplete;
	String FilePathNull;
	String FilePathLeft1;
	String FilePathRight1;
	String FilePathSave1;
	String FilePathComplete1;
	String User;	
	int total; 
	
	MyActionListenerTrd(Draw_Panel drawpanel){this.drawpanel = drawpanel;}
		
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e){
		String StringComplete = null;
		String StringNull = null;
		String InfoComplete;
		String Name = Lookup_t1.getText();
		String Year = Lookup_x1.getSelectedItem().toString();
		String Month = Lookup_x2.getSelectedItem().toString();
		String Day = Lookup_x3.getSelectedItem().toString();
		User = Name + " " + Year + " " + Month + " " + Day;
		String Path = "C:/Users/CCNS/Desktop/지니어링/회원정보/";
		FilePathLeft = Path + User + "/" + "좌" + ".txt";
		FilePathRight = Path + User + "/" + "우" + ".txt";
		FilePathSave = Path + User + "/" + "저장용" + ".txt";
		FilePathComplete = Path + User + "/" + "완성용" + ".txt";
		FilePathLeft1 = Path + User + "/" + "좌1" + ".txt";
		FilePathRight1 = Path + User + "/" + "우1" + ".txt";
		FilePathSave1 = Path + User + "/" + "저장용1" + ".txt";
		FilePathComplete1 = Path + User + "/" + "완성용1" + ".txt";
		FilePathNull = Path + User + "/" + "-" + ".txt";
		int num = 0;
		List<String> input = new ArrayList<String>();
		String read = null;
		int j = 0;
		
		InfoComplete = null;
		try {
			  FileReader file_reader = new FileReader(FilePathComplete);
			  
			  while((num = file_reader.read()) != -1){
				  read = Character.toString((char)num);
				  input.add(read);
				  }
			  
			  ArrayComplete = new String[input.size()];
		
			  for(j = 0 ; j < input.size(); j++) 
				  ArrayComplete[j] = input.get(j);
		
			  file_reader.close();}         
	
		catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "입력하신 정보가 올바르지 않거나 존재하지 않습니다.");
			return;}
		
		for(j = 0 ; j < ArrayComplete.length ; j++)
			InfoComplete += ArrayComplete[j];
	
		StringComplete = InfoComplete.substring(4);
		
		String[] StringCompleteInfo = StringComplete.split("\r");
		String[] CheckDate1 = new String[StringCompleteInfo.length];
		String[] CheckLeft1	= new String[StringCompleteInfo.length];
		String[] CheckRight1 = new String[StringCompleteInfo.length];
		
		for(int q = 0 ; q < StringCompleteInfo.length ; q++) {
			
			String Info = StringCompleteInfo[q];

			String[] testcom = Info.split(" ");

			for(int t = 0 ; t < testcom.length ; t++) {
			if(testcom[t].length() == 1) 
				testcom[t] = testcom[t].replaceAll("-", "000mOsmol");}
			
			CheckDate1[q] = testcom[0];
			CheckLeft1[q] = testcom[1].substring(0,3);
			CheckRight1[q] = testcom[2].substring(0,3);}


		CheckDate = CheckDate1;
		CheckLeft = CheckLeft1;
		CheckRight = CheckRight1;

		input.removeAll(input);
		read = null;
		num = 0;
		Information = null;
		

			if(ArrayComplete.length == 1) {
			
			try {
				  FileReader file_reader = new FileReader(FilePathNull);
				  
				  while((num = file_reader.read()) != -1){
					  read = Character.toString((char)num);
					  input.add(read);}
					  
				  ArrayNull = new String[input.size()];
				
				  for(j = 0 ; j < input.size(); j++)
					  ArrayNull[j] = input.get(j);

				  file_reader.close();}
				
			catch (Exception e1) {}
				
			for(j = 0 ; j < ArrayNull.length ; j++) 
				InfoNull += ArrayNull[j]; 
								
			StringNull = InfoNull.substring(5);
			Information = StringNull.split("\r");
			total = Information.length;
			Contents = new String[total][3];
				
			for(j = 0 ; j < Information.length ; j++) {
					
				String g[] = Information[j].split(" ");
				Contents[j][0] = g[0];
				Contents[j][1] = g[1];
				Contents[j][2] = g[2];}
			
			input.removeAll(input);
			read = null;
			num = 0;
			InfoNull = null;
			
			}
			
			else {
				
			Information = StringComplete.split("\r");
			total = Information.length;
			Contents = new String[total][3];
			
			for(j = 0 ; j < Information.length ; j++) {
				
			String g[] = Information[j].split(" ");
			Contents[j][0] = g[0];
			Contents[j][1] = g[1];
			Contents[j][2] = g[2];}
			
			
		}
	
		JTable Information_table = new JTable(Contents, Header);
		Font font = new Font("돋움", Font.PLAIN, 25);	
		Font fontsmall = new Font("돋움", Font.PLAIN, 15);
		JLabel Information_l1 = new JLabel(User);
		JScrollPane total_List_Scroll = new JScrollPane();
		total_List_Scroll.setBounds(220, 78, 360, 100);
		Information_Panel.add(total_List_Scroll);
		total_List_Scroll.setViewportView(Information_table);
		Information_table.setFont(fontsmall);
		Information_table.setOpaque(true);
		Information_table.setBackground(Color.LIGHT_GRAY);				
		
		Information_l1.setBounds(220, 45, 360, 30);
		Information_l1.setOpaque(true);
		Information_l1.setBackground(Color.LIGHT_GRAY);					
		Information_l1.setHorizontalAlignment(JButton.CENTER);
		Information_l1.setFont(font);
		Information_Panel.add(Information_l1);		
				
		Lookup_t1.setText("");
		Lookup_x1.removeAllItems();
		Lookup_x2.removeAllItems();
		Lookup_x3.removeAllItems();
			
		for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
			Lookup_x1.addItem(i + "년");}
		for (int i = 1 ; i <=12 ; i++) {
			Lookup_x2.addItem(i + "월");}
		for (int i = 1 ; i <=31 ; i++) {
			Lookup_x3.addItem(i + "일");}
			
		Lookup_Panel.setVisible(false);
		Register_Panel.setVisible(false);
		Information_Panel.setVisible(true);
		drawpanel.setVisible(true);
		Information2_Panel.setVisible(false);
		Information3_Panel.setVisible(false);
		Information4_Panel.setVisible(false);
		Main_Panel.setVisible(false);
		StaticFilePathLeft = FilePathLeft;
		StaticFilePathRight = FilePathRight;
		StaticFilePathSave = FilePathSave;
		StaticFilePathComplete = FilePathComplete;
		StaticFilePathLeft1 = FilePathLeft1;
		StaticFilePathRight1 = FilePathRight1;
		StaticFilePathSave1 = FilePathSave1;
		StaticFilePathComplete1 = FilePathComplete1;
		StaticFilePathNull = FilePathNull;
		UserInfo = User;

		Name = "";
		Month = "";
		Day = "";
		Year = "";
		revalidate();
		repaint();
			
		}
	}

class MyActionListenerLeft implements ActionListener{

	String[][] Contents;
	String[] ArrayLeft;
	String[] ArraySave;
	String[] ArrayComplete;
	String InfoLeft;
	int total;
	Draw_Panel drawpanel;
	MyActionListenerLeft(Draw_Panel drawpanel){this.drawpanel = drawpanel;}
	
	@SuppressWarnings({ "unchecked"})
	public void actionPerformed(ActionEvent e){
		
		List<String> input = new ArrayList<String>();
		String[] Information = null;
		String TotalInfo = null;
		String StringLeft = null;
		String MainInfo = null;
		String Info = null;
		String Read = null;
		String CompleteInfo = null;
		String SaveInfo = null;
		int num = 0;
		int j = 0;
		int t = 0;
			
		try {				//저장용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathSave);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArraySave = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArraySave[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		input.removeAll(input);
		Read = null;
		num = 0;
		
		for(j = 0 ; j < ArraySave.length ; j++)
			SaveInfo += ArraySave[j]; 
		
		try {				// 완성용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathComplete);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArrayComplete = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArrayComplete[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		input.removeAll(input);
		Read = null;
		num = 0;
		
		for(j = 0 ; j < ArrayComplete.length ; j++)
			CompleteInfo += ArrayComplete[j]; 
		
		if(ArraySave.length == 1) {  // 불러온 저장용에 아무것도 적혀있지 않을 경우 ( 좌안 먼저 검사 )
	
			Information2_Panel.removeAll();				
			Information2_Panel.add(Information2_b1);
			Information2_Panel.add(Information2_b2);
			Information2_Panel.add(Information2_b3);
			Information2_Panel.add(Information2_b4);
			
			while(true) {
				
			try {
				FileReader file_reader = new FileReader(StaticFilePathLeft);
				  
				while((num = file_reader.read()) != -1){
					Read = Character.toString((char)num);
					input.add(Read);}
				  	         
				ArrayLeft = new String[input.size()];
			
				for(j = 0 ; j < input.size(); j++)
					ArrayLeft[j] = input.get(j);

				file_reader.close();}
				
			catch (Exception e1) {}
			
			input.removeAll(input);
			Read = null;
			num = 0;
				
			if(t == ArrayLeft.length) {
					
				for(j = 0 ; j < ArrayLeft.length ; j++)
					InfoLeft += ArrayLeft[j]; 

				StringLeft = InfoLeft.substring(5);
				break;}

			t = ArrayLeft.length + 9;
			
			}
			
			StaticLeftInfo = StringLeft;
			TotalInfo = timeNow + " " + StaticLeftInfo + " - "; //24
			
			if( ArrayComplete.length == 1) {			//완성용이 비어있을 경우 ( 첫 검사 )
											
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}			
			}
			
			else {			// 완성용이 이미 있을경우 ( 첫 검사가 아니다 / 근데 왼쪽 먼저) 
								
				for(j = 0 ; j < ArrayComplete.length ; j++)
					Info += ArrayComplete[j]; 
				
				Info = Info + "\r" + TotalInfo;
				
				MainInfo = Info.substring(4);
				Information = MainInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}	
			
			try {				// 저장용에 시간 좌안 - 저장
				FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
				
				fileWriter.write(TotalInfo);
				fileWriter.close();}
			
			catch (Exception e1) {}
		}
	
		else if (ArraySave.length == 23) {			//불러온 저장용에 이미 있는 경우 ( 우안 검사 후 좌안 검사)
			
			Information2_Panel.removeAll();				
			Information2_Panel.add(Information2_b1);
			Information2_Panel.add(Information2_b2);
			Information2_Panel.add(Information2_b3);
			Information2_Panel.add(Information2_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathLeft);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayLeft = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayLeft[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayLeft.length) {
						
					for(j = 0 ; j < ArrayLeft.length ; j++)
						InfoLeft += ArrayLeft[j]; 

					StringLeft = InfoLeft.substring(5);
					break;}

				t = ArrayLeft.length + 9;
				
				}
			
			StaticLeftInfo = StringLeft;
			
			for(j = 0 ; j < ArraySave.length ; j++)
				Info += ArraySave[j]; 
			
			TotalInfo = timeNow + " " + StaticLeftInfo + Info.substring(17); //31
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(TotalInfo);			//30
					fileWriter.close();}
				
					catch (Exception e1) {}
			}
			
			if(ArrayComplete.length == 1) {			//완성용 데이터 없음
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
					Info = null;
				for(j = 0 ; j < ArrayComplete.length ; j++)
					Info += ArrayComplete[j];
				
				MainInfo = Info.substring(4);
				Info = MainInfo + "\r" + TotalInfo;
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
					
			}
			
		}
		
		else if (ArraySave.length == 24) {			//첫검사가 좌안인데 또 좌안 누른 경우
			
			Information2_Panel.removeAll();				
			Information2_Panel.add(Information2_b1);
			Information2_Panel.add(Information2_b2);
			Information2_Panel.add(Information2_b3);
			Information2_Panel.add(Information2_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathLeft);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayLeft = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayLeft[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayLeft.length) {
						
					for(j = 0 ; j < ArrayLeft.length ; j++)
						InfoLeft += ArrayLeft[j]; 

					StringLeft = InfoLeft.substring(5);
					InfoLeft = null;
					break;}

				t = ArrayLeft.length + 9;
				
				}
			
			StaticLeftInfo = StringLeft;
			TotalInfo = timeNow + " " + StaticLeftInfo + " - "; //24

			
			if(ArrayComplete.length == 1) {				//완성용 데이터 없을때
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
				for(j = 0 ; j < ArrayComplete.length ; j++)
					Info += ArrayComplete[j];
				
				MainInfo = Info.substring(4);
				Info = MainInfo + "\r" + TotalInfo;
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}		
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(" " + TotalInfo);
					fileWriter.close();}
				
					catch (Exception e1) {}
				}
			
		}
		
		
		else {				// 두번째 검사가 좌안인데 또 좌안 누른 경우
			
			Information2_Panel.removeAll();				
			Information2_Panel.add(Information2_b1);
			Information2_Panel.add(Information2_b2);
			Information2_Panel.add(Information2_b3);
			Information2_Panel.add(Information2_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathLeft);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayLeft = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayLeft[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayLeft.length) {
						
					for(j = 0 ; j < ArrayLeft.length ; j++)
						InfoLeft += ArrayLeft[j]; 

					StringLeft = InfoLeft.substring(5);
					InfoLeft = null;
					break;}

				t = ArrayLeft.length + 9;
				
				}
			
			StaticLeftInfo = StringLeft;
			//ArraySave = 2020-12-25 300mOsmol 200mOsmol  30
			System.out.println("여기" + SaveInfo);
			TotalInfo = timeNow + " " + StaticLeftInfo + SaveInfo.substring(24);
			System.out.println(TotalInfo);
			System.out.println(StaticLeftInfo);

			if(ArrayComplete.length == 1) {				//완성용 데이터 없을때
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
				MainInfo = CompleteInfo.substring(4);
				Info = MainInfo + "\r" + TotalInfo;
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(TotalInfo);
					fileWriter.close();}
				
					catch (Exception e1) {}
				}
			
		}
		
		File fileLeft = new File(StaticFilePathLeft);
		File fileLeft1 = new File(StaticFilePathLeft1);
		
		while(fileLeft.exists()) {
			
			if(fileLeft.delete()){}
			
			else{}	
		
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathLeft1,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
		
			catch (Exception e1) {}
			
		}
		
		while(fileLeft1.exists()) {
			
			if(fileLeft1.delete()){}
			
			else{}	
			
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathLeft,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
			
				catch (Exception e1) {}
		}
	
	Font font = new Font("돋움", Font.PLAIN, 25);	
	Font fontsmall = new Font("돋움", Font.PLAIN, 15);
	JLabel Information2_l1 = new JLabel(UserInfo);
	JTable Information_table = new JTable(Contents, Header);
	JScrollPane total_List_Scroll = new JScrollPane();
	total_List_Scroll.setBounds(220, 78, 360, 100);
	Information2_Panel.add(total_List_Scroll);
	total_List_Scroll.setViewportView(Information_table);
	Information_table.setFont(fontsmall);
	Information_table.setOpaque(true);
	Information_table.setBackground(Color.LIGHT_GRAY);				
	
	Information2_l1.setBounds(220, 45, 360, 30);
	Information2_l1.setOpaque(true);
	Information2_l1.setBackground(Color.LIGHT_GRAY);					
	Information2_l1.setHorizontalAlignment(JButton.CENTER);
	Information2_l1.setFont(font);
	Information2_Panel.add(Information2_l1);
	
	Lookup_t1.setText("");
	Lookup_x1.removeAllItems();
	Lookup_x2.removeAllItems();
	Lookup_x3.removeAllItems();
	
	for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
		Lookup_x1.addItem(i + "년");}
	for (int i = 1 ; i <=12 ; i++) {
		Lookup_x2.addItem(i + "월");}
	for (int i = 1 ; i <=31 ; i++) {
		Lookup_x3.addItem(i + "일");}
	
	Main_Panel.setVisible(false);
	Register_Panel.setVisible(false);
	Information_Panel.setVisible(false);
	Information2_Panel.setVisible(true);
	Information3_Panel.setVisible(false);
	Information4_Panel.setVisible(false);
	drawpanel.setVisible(true);
	Lookup_Panel.setVisible(false);
	revalidate();
	repaint();
	
	}
}

class MyActionListenerRight implements ActionListener{
	
	String[][] Contents;
	String[] ArrayRight;
	String[] ArraySave;
	String[] ArrayComplete;
	String InfoRight;
	int total;
	Draw_Panel drawpanel;
	MyActionListenerRight(Draw_Panel drawpanel){this.drawpanel = drawpanel;}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e){
		
		List<String> input = new ArrayList<String>();
		String[] Information = null;
		String TotalInfo = null;
		String StringRight = null;
		String MainInfo = null;
		String Info = null;
		String Read = null;
		String CompleteInfo = null;
		String SaveInfo = null;
		int num = 0;
		int j = 0;
		int t = 0;

		
		try {				//저장용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathSave);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArraySave = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArraySave[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		input.removeAll(input);
		Read = null;
		num = 0;
		
		for(j = 0 ; j < ArraySave.length ; j++)
			SaveInfo += ArraySave[j]; 
		
		try {				// 완성용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathComplete);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArrayComplete = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArrayComplete[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		input.removeAll(input);
		Read = null;
		num = 0;
		
		for(j = 0 ; j < ArrayComplete.length ; j++)
			CompleteInfo += ArrayComplete[j]; 
		
		if(ArraySave.length == 1) {  // 불러온 저장용에 아무것도 적혀있지 않을 경우 ( 우안 먼저 검사 )
	
			Information3_Panel.removeAll();				
			Information3_Panel.add(Information3_b1);
			Information3_Panel.add(Information3_b2);
			Information3_Panel.add(Information3_b3);
			Information3_Panel.add(Information3_b4);
			
			while(true) {
				
			try {
				FileReader file_reader = new FileReader(StaticFilePathRight);
				  
				while((num = file_reader.read()) != -1){
					Read = Character.toString((char)num);
					input.add(Read);}
				  	         
				ArrayRight = new String[input.size()];
			
				for(j = 0 ; j < input.size(); j++)
					ArrayRight[j] = input.get(j);

				file_reader.close();}
				
			catch (Exception e1) {}
			
			input.removeAll(input);
			Read = null;
			num = 0;
				
			if(t == ArrayRight.length) {
					
				for(j = 0 ; j < ArrayRight.length ; j++)
					InfoRight += ArrayRight[j]; 

				StringRight = InfoRight.substring(5);
				break;}

			t = ArrayRight.length + 9;
			
			}
			
			StaticRightInfo = StringRight;
			TotalInfo = timeNow + " - " + StaticRightInfo; //23
			
			if( ArrayComplete.length == 1) {			//완성용이 비어있을 경우 ( 첫 검사 )
											
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}			
			}
			
			else {			// 완성용이 이미 있을경우 ( 첫 검사가 아니다 / 근데 오른쪽 먼저) 
								
				for(j = 0 ; j < ArrayComplete.length ; j++)
					Info += ArrayComplete[j]; 
				
				Info = Info + "\r" + TotalInfo;
				
				MainInfo = Info.substring(4);
				Information = MainInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}	
			
			try {				// 저장용에 시간 우안 - 저장
				FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
				
				fileWriter.write(TotalInfo);
				fileWriter.close();}
			
			catch (Exception e1) {}
		}
	
		else if (ArraySave.length == 24) {			//불러온 저장용에 이미 있는 경우 ( 우안 검사 후 좌안 검사)
			
			Information3_Panel.removeAll();				
			Information3_Panel.add(Information3_b1);
			Information3_Panel.add(Information3_b2);
			Information3_Panel.add(Information3_b3);
			Information3_Panel.add(Information3_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathRight);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayRight = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayRight[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayRight.length) {
						
					for(j = 0 ; j < ArrayRight.length ; j++)
						InfoRight += ArrayRight[j]; 

					StringRight = InfoRight.substring(5);
					break;}

				t = ArrayRight.length + 9;
				
				}
			
			StaticRightInfo = StringRight;
			
			for(j = 0 ; j < ArraySave.length ; j++)
				Info += ArraySave[j]; 
			System.out.println("1 : " + Info);
			TotalInfo = timeNow + " " + Info.substring(16,25) + " " + StaticRightInfo; //31
			System.out.println("2 : " + TotalInfo);
			System.out.println("3 : " + TotalInfo.length());
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(TotalInfo);			//30
					fileWriter.close();}
				
					catch (Exception e1) {}
			}
			
			if(ArrayComplete.length == 1) {			//완성용 데이터 없음
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
					Info = null;
				for(j = 0 ; j < ArrayComplete.length ; j++)
					Info += ArrayComplete[j];
				
				System.out.println(Info);
				MainInfo = Info.substring(4);
				Info = MainInfo + "\r" + TotalInfo;
				System.out.println(Info);
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
					
			}
			
		}
		
		else if (ArraySave.length == 23) {			//첫검사가 우안인데 또 우안 누른 경우
			
			Information3_Panel.removeAll();				
			Information3_Panel.add(Information3_b1);
			Information3_Panel.add(Information3_b2);
			Information3_Panel.add(Information3_b3);
			Information3_Panel.add(Information3_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathRight);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayRight = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayRight[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayRight.length) {
						
					for(j = 0 ; j < ArrayRight.length ; j++)
						InfoRight += ArrayRight[j]; 

					StringRight = InfoRight.substring(5);
					InfoRight = null;
					break;}

				t = ArrayRight.length + 9;
				
				}
			
			StaticRightInfo = StringRight;
			TotalInfo = timeNow + " - " + StaticRightInfo; //23

			
			if(ArrayComplete.length == 1) {				//완성용 데이터 없을때
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
				MainInfo = CompleteInfo.substring(4);
				Info = MainInfo + "\r" + TotalInfo;
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}		
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(" " + TotalInfo);
					fileWriter.close();}
				
					catch (Exception e1) {}
				}
			
		}
		
		
		else {				// 두번째 검사가 우안인데 또 우안 누른 경우
			
			Information3_Panel.removeAll();				
			Information3_Panel.add(Information3_b1);
			Information3_Panel.add(Information3_b2);
			Information3_Panel.add(Information3_b3);
			Information3_Panel.add(Information3_b4);
			
			while(true) {
				
				try {
					FileReader file_reader = new FileReader(StaticFilePathRight);
					  
					while((num = file_reader.read()) != -1){
						Read = Character.toString((char)num);
						input.add(Read);}
					  	         
					ArrayRight = new String[input.size()];
				
					for(j = 0 ; j < input.size(); j++)
						ArrayRight[j] = input.get(j);

					file_reader.close();}
					
				catch (Exception e1) {}
				
				input.removeAll(input);
				Read = null;
				num = 0;
					
				if(t == ArrayRight.length) {
						
					for(j = 0 ; j < ArrayRight.length ; j++)
						InfoRight += ArrayRight[j]; 

					StringRight = InfoRight.substring(5);
					InfoRight = null;
					break;}

				t = ArrayRight.length + 9;
				
				}
			
			StaticRightInfo = StringRight;
			//ArraySave = 2020-12-25 300mOsmol 200mOsmol  30
			System.out.println("여기" + SaveInfo);
			TotalInfo = timeNow + " " + SaveInfo.substring(15,25) + StaticRightInfo;
			System.out.println(TotalInfo);
			System.out.println(StaticRightInfo);

			if(ArrayComplete.length == 1) {				//완성용 데이터 없을때
				
				Information = TotalInfo.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			else {				//완성용 데이터 있음
				
				MainInfo = CompleteInfo.substring(5);
				Info = MainInfo + "\r" + TotalInfo;
				
				Information = Info.split("\r");
				total = Information.length;
				Contents = new String[total][3];
				
				for(j = 0 ; j < Information.length ; j++) {
					String g[] = Information[j].split(" ");
						
					Contents[j][0] = g[0];
					Contents[j][1] = g[1];
					Contents[j][2] = g[2];}
				
			}
			
			File fileSave = new File(StaticFilePathSave);
			File fileSave1 = new File(StaticFilePathSave1);
			
			while(fileSave.exists()) {
				
				if(fileSave.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileSave1.exists()) {
				
				if(fileSave1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
					
					fileWriter.write(TotalInfo);
					fileWriter.close();}
				
					catch (Exception e1) {}
				}
			
		}
		
		File fileRight = new File(StaticFilePathRight);
		File fileRight1 = new File(StaticFilePathRight1);
		
		while(fileRight.exists()) {
			
			if(fileRight.delete()){}
			
			else{}	
		
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathRight1,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
		
			catch (Exception e1) {}
			
		}
		
		while(fileRight1.exists()) {
			
			if(fileRight1.delete()){}
			
			else{}	
			
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathRight,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
			
				catch (Exception e1) {}
		}
	
	Font font = new Font("돋움", Font.PLAIN, 25);	
	Font fontsmall = new Font("돋움", Font.PLAIN, 15);
	JLabel Information3_l1 = new JLabel(UserInfo);
	JTable Information_table = new JTable(Contents, Header);
	JScrollPane total_List_Scroll = new JScrollPane();
	total_List_Scroll.setBounds(220, 78, 360, 100);
	Information3_Panel.add(total_List_Scroll);
	total_List_Scroll.setViewportView(Information_table);
	Information_table.setFont(fontsmall);
	Information_table.setOpaque(true);
	Information_table.setBackground(Color.LIGHT_GRAY);				
	
	Information3_l1.setBounds(220, 45, 360, 30);
	Information3_l1.setOpaque(true);
	Information3_l1.setBackground(Color.LIGHT_GRAY);					
	Information3_l1.setHorizontalAlignment(JButton.CENTER);
	Information3_l1.setFont(font);
	Information3_Panel.add(Information3_l1);

	Lookup_t1.setText("");
	Lookup_x1.removeAllItems();
	Lookup_x2.removeAllItems();
	Lookup_x3.removeAllItems();
	
	for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
		Lookup_x1.addItem(i + "년");}
	for (int i = 1 ; i <=12 ; i++) {
		Lookup_x2.addItem(i + "월");}
	for (int i = 1 ; i <=31 ; i++) {
		Lookup_x3.addItem(i + "일");}
	
	Main_Panel.setVisible(false);
	Register_Panel.setVisible(false);
	Information_Panel.setVisible(false);
	Information2_Panel.setVisible(false);
	Information3_Panel.setVisible(true);
	Information4_Panel.setVisible(false);
	drawpanel.setVisible(true);
	drawpanel1.setVisible(false);
	Lookup_Panel.setVisible(false);
	revalidate();
	repaint();	
	
	}
	
}	

class MyActionListenerComplete implements ActionListener{
	
	String[][] Contents;
	String[] ArrayComplete;
	int total;
	Draw_Panel1 drawpanel1;
	MyActionListenerComplete(Draw_Panel1 drawpanel){this.drawpanel1 = drawpanel;}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e){
		
		int num = 0;
		List<String> input = new ArrayList<String>();
		String Read = null;
		int j = 0;
		String CompleteInfo = null;
		String TotalInfo = null;
		String LeftInfo = null;
		String RightInfo = null;
		String LastInfo = null;
		String[] Information = null;
		String InfoComplete = null;
		String StringComplete = null;
		
		Information4_Panel.removeAll();				
		Information4_Panel.add(Information4_b1);
		Information4_Panel.add(Information4_b2);
		Information4_Panel.add(Information4_b3);
		Information4_Panel.add(Information4_b4);
		
		try {				// 완성용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathComplete);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArrayComplete = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArrayComplete[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		
		input.removeAll(input);
		Read = null;
		num = 0;
		
		for(j = 0 ; j < ArrayComplete.length ; j++)
			CompleteInfo += ArrayComplete[j]; 
		
		CompleteInfo = CompleteInfo.substring(4);
		
		LeftInfo = StaticLeftInfo;
		RightInfo = StaticRightInfo;
		
		if(StaticLeftInfo == null) 				//좌안 검사 안함	
			LeftInfo = "-";
		
		if(StaticRightInfo == null) 					//우안 검사 안함
			RightInfo = "-";
		
		if(StaticLeftInfo == null && StaticRightInfo == null) {
			JOptionPane.showMessageDialog(null, "검사한 결과가 없습니다.");
			return;}
		
		TotalInfo = timeNow + " " + LeftInfo + " " + RightInfo;

		if(ArrayComplete.length == 1) {		//완성용 데이터 없음
			
			File fileComplete = new File(StaticFilePathComplete);
			File fileComplete1 = new File(StaticFilePathComplete1);
			
			while(fileComplete.exists()) {
				
				if(fileComplete.delete()){}
				
				else{}	
			
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathComplete1,true);
					
					fileWriter.write(" ");
					fileWriter.close();}
			
				catch (Exception e1) {}
				
			}
			
			while(fileComplete1.exists()) {
				
				if(fileComplete1.delete()){}
				
				else{}	
				
				try {
					FileWriter fileWriter = new FileWriter(StaticFilePathComplete,true);
					
					fileWriter.write(TotalInfo);
					fileWriter.close();}
				
					catch (Exception e1) {}
			}
			
			Information = TotalInfo.split("\r");
			total = Information.length;
			Contents = new String[total][3];
			for(j = 0 ; j < Information.length ; j++) {
				String g[] = Information[j].split(" ");
					
				Contents[j][0] = g[0];
				Contents[j][1] = g[1];
				Contents[j][2] = g[2];}
			
		}
		
		else {					//완성용 데이터 있음
			
			LastInfo = CompleteInfo + "\r" + TotalInfo;
			Information = LastInfo.split("\r");
			total = Information.length;
			Contents = new String[total][3];
			for(j = 0 ; j < Information.length ; j++) {
				String g[] = Information[j].split(" ");
					
				Contents[j][0] = g[0];
				Contents[j][1] = g[1];
				Contents[j][2] = g[2];}
		
		
		try {
			FileWriter fileWriter = new FileWriter(StaticFilePathComplete,true);
			
			fileWriter.write("\r" + TotalInfo);
			fileWriter.close();}
		
		catch (Exception e1) {}
		
		}
		
		File fileSave = new File(StaticFilePathSave);
		File fileSave1 = new File(StaticFilePathSave1);
		
		while(fileSave.exists()) {
			
			if(fileSave.delete()){}
			
			else{}	
		
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
		
			catch (Exception e1) {}
			
		}
		
		while(fileSave1.exists()) {
			
			if(fileSave1.delete()){}
			
			else{}	
			
			try {
				FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
				
				fileWriter.write(" ");
				fileWriter.close();}
			
				catch (Exception e1) {}
			}
		
		try {				// 완성용 불러오기
			FileReader file_reader = new FileReader(StaticFilePathComplete);
			
			while((num = file_reader.read()) != -1){
				Read = Character.toString((char)num);
				input.add(Read);}
		  	         
			ArrayComplete = new String[input.size()];
	
			for(j = 0 ; j < input.size(); j++)
				ArrayComplete[j] = input.get(j);
	
			file_reader.close();}
		
		catch (Exception e1) {}
		
		
		for(j = 0 ; j < ArrayComplete.length ; j++)
			InfoComplete += ArrayComplete[j];
		
		StringComplete = InfoComplete.substring(4);
		
		String[] StringCompleteInfo = StringComplete.split("\r");
		String[] CheckDate2 = new String[StringCompleteInfo.length];
		String[] CheckLeft2	= new String[StringCompleteInfo.length];
		String[] CheckRight2 = new String[StringCompleteInfo.length];
		
		for(int q = 0 ; q < StringCompleteInfo.length ; q++) {
			
			String Info = StringCompleteInfo[q];

			String[] testcom = Info.split(" ");

			for(int t = 0 ; t < testcom.length ; t++) {
			if(testcom[t].length() == 1) 
				testcom[t] = testcom[t].replaceAll("-", "000mOsmol");}
			
			CheckDate2[q] = testcom[0];
			CheckLeft2[q] = testcom[1].substring(0,3);
			CheckRight2[q] = testcom[2].substring(0,3);}


		CheckDateCom = CheckDate2;
		CheckLeftCom = CheckLeft2;
		CheckRightCom = CheckRight2;
		
		input.removeAll(input);
		Read = null;
		num = 0;

		JTable Information_table = new JTable(Contents, Header);
		Font font = new Font("돋움", Font.PLAIN, 25);	
		Font fontsmall = new Font("돋움", Font.PLAIN, 15);
		JLabel Information_l1 = new JLabel(UserInfo);
		JScrollPane total_List_Scroll = new JScrollPane();
		total_List_Scroll.setBounds(220, 78, 360, 100);
		Information4_Panel.add(total_List_Scroll);
		total_List_Scroll.setViewportView(Information_table);
		Information_table.setFont(fontsmall);
		Information_table.setOpaque(true);
		Information_table.setBackground(Color.LIGHT_GRAY);				
		
		Information_l1.setBounds(220, 45, 360, 30);
		Information_l1.setOpaque(true);
		Information_l1.setBackground(Color.LIGHT_GRAY);					
		Information_l1.setHorizontalAlignment(JButton.CENTER);
		Information_l1.setFont(font);
		Information4_Panel.add(Information_l1);
		
		Lookup_Panel.setVisible(false);
		Register_Panel.setVisible(false);
		Information_Panel.setVisible(false);
		Information2_Panel.setVisible(false);
		Information3_Panel.setVisible(false);
		Information4_Panel.setVisible(true);
		Main_Panel.setVisible(false);
		drawpanel1.setVisible(true);
		drawpanel.setVisible(false);
		revalidate();
		repaint();
		
		
		
		}
	}
			
	
	class MyActionListener implements ActionListener {			//버튼 이벤트
		
		public void actionPerformed(ActionEvent e) {			// 버튼 클릭 시
			
			if(e.getActionCommand().equals("뒤로")){
				
				Register_t1.setText("");
				Register_x1.removeAllItems();
				Register_x2.removeAllItems();
				Register_x3.removeAllItems();
				
				for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
					Register_x1.addItem(i + "년");}
				for (int i = 1 ; i <=12 ; i++) {
					Register_x2.addItem(i + "월");}
				for (int i = 1 ; i <=31 ; i++) {
					Register_x3.addItem(i + "일");}
				
				Lookup_t1.setText("");
				Lookup_x1.removeAllItems();
				Lookup_x2.removeAllItems();
				Lookup_x3.removeAllItems();
				
				for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
					Lookup_x1.addItem(i + "년");}
				for (int i = 1 ; i <=12 ; i++) {
					Lookup_x2.addItem(i + "월");}
				for (int i = 1 ; i <=31 ; i++) {
					Lookup_x3.addItem(i + "일");}
				
				Lookup_Panel.setVisible(false);
				Register_Panel.setVisible(false);
				Information_Panel.setVisible(false);
				Information2_Panel.setVisible(false);
				Information3_Panel.setVisible(false);
				Information4_Panel.setVisible(false);
				drawpanel.setVisible(true);
				drawpanel1.setVisible(false);
				Main_Panel.setVisible(true);
				revalidate();
				repaint();
				
			}
			
			if(e.getActionCommand().equals("취소")){
				
				Register_t1.setText("");
				Register_x1.removeAllItems();
				Register_x2.removeAllItems();
				Register_x3.removeAllItems();
				
				for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
					Register_x1.addItem(i + "년");}
				for (int i = 1 ; i <=12 ; i++) {
					Register_x2.addItem(i + "월");}
				for (int i = 1 ; i <=31 ; i++) {
					Register_x3.addItem(i + "일");}
				
				Lookup_t1.setText("");
				Lookup_x1.removeAllItems();
				Lookup_x2.removeAllItems();
				Lookup_x3.removeAllItems();
				
				for (int i = 1920 ; i <=2020 ; i++) {			//콤보박스 생년월일 계산 반복문
					Lookup_x1.addItem(i + "년");}
				for (int i = 1 ; i <=12 ; i++) {
					Lookup_x2.addItem(i + "월");}
				for (int i = 1 ; i <=31 ; i++) {
					Lookup_x3.addItem(i + "일");}
				
				Information_Panel.removeAll();				
				Information2_Panel.removeAll();
				Information3_Panel.removeAll();
				Information4_Panel.removeAll();
				Information_Panel.add(Information_b1);
				Information_Panel.add(Information_b2);
				Information_Panel.add(Information_b3);
				Information_Panel.add(Information_b4);
				Information2_Panel.add(Information2_b1);
				Information2_Panel.add(Information2_b2);
				Information2_Panel.add(Information2_b3);
				Information2_Panel.add(Information2_b4);
				Information3_Panel.add(Information3_b1);
				Information3_Panel.add(Information3_b2);
				Information3_Panel.add(Information3_b3);
				Information3_Panel.add(Information3_b4);
				Information4_Panel.add(Information4_b1);
				Information4_Panel.add(Information4_b2);
				Information4_Panel.add(Information4_b3);
				Information4_Panel.add(Information4_b4);
				
				File fileSave = new File(StaticFilePathSave);
				File fileSave1 = new File(StaticFilePathSave1);
				File fileLeft = new File(StaticFilePathLeft);
				File fileLeft1 = new File(StaticFilePathLeft1);
				File fileRight = new File(StaticFilePathRight);
				File fileRight1 = new File(StaticFilePathRight1);
				
				while(fileRight.exists()) {
					
					if(fileRight.delete()){}
					
					else{}	
				
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathRight1,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
				
					catch (Exception e1) {}
					
				}
				
				while(fileRight1.exists()) {
					
					if(fileRight1.delete()){}
					
					else{}	
					
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathRight,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
					
						catch (Exception e1) {}
				}
				while(fileLeft.exists()) {
					
					if(fileLeft.delete()){}
					
					else{}	
				
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathLeft1,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
				
					catch (Exception e1) {}
					
				}
				
				while(fileLeft1.exists()) {
					
					if(fileLeft1.delete()){}
					
					else{}	
					
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathLeft,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
					
						catch (Exception e1) {}
				}
				
				while(fileSave.exists()) {
					
					if(fileSave.delete()){}
					
					else{}	
				
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathSave1,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
				
					catch (Exception e1) {}
					
				}
				
				while(fileSave1.exists()) {
					
					if(fileSave1.delete()){}
					
					else{}	
					
					try {
						FileWriter fileWriter = new FileWriter(StaticFilePathSave,true);
						
						fileWriter.write(" ");
						fileWriter.close();}
					
						catch (Exception e1) {}
					}
				
				Lookup_Panel.setVisible(false);
				Register_Panel.setVisible(false);
				Information_Panel.setVisible(false);
				Information2_Panel.setVisible(false);
				Information3_Panel.setVisible(false);
				Information4_Panel.setVisible(false);
				drawpanel.setVisible(false);
				drawpanel1.setVisible(false);
				Main_Panel.setVisible(true);
				revalidate();
				repaint();
				}
		}
	}
	
	
	public static void main(String[] args){				//메인 함수
		
		new MainPanel();} 								//실행하면 생성자가 실행됨.
}