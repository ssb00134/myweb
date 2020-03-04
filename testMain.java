package testPackage;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.util.ArrayList;

public class testMain {

	private JFrame frame;
	private JMenuBar menubar;
	private JButton btnMain;
	private JTextField txtSearch;
	private JPanel TopAreaPanel;
	private JButton btnExeSearch;
	private JMenu menubar2;
	private JButton btnLogin;
	private JButton btnSignIn;
	private JPanel MidAreaPanel;
	private JPanel BotAreaPanel;
	private JButton btnGetCategory;
	private static SearchDAO dao;
	private JMenuBar menubarCategory;
	private JMenu screenMenuCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		dao = SearchDAOImple.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testMain window = new testMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public testMain() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		int TopAreaHeight = 40;
		
		
		//[상단바] 영역
		TopAreaPanel = new JPanel();
		TopAreaPanel.setBounds(14, 13, 1200, TopAreaHeight);
		TopAreaPanel.setVisible(true);
		TopAreaPanel.setLayout(null);
		frame.getContentPane().add(TopAreaPanel);
		

		
		ArrayList<CompanyVO> list = dao.SelectCompany();
		System.out.println("list = " + list.size());

		ArrayList<String> slist = dao.SelectCompanyMenu();
		System.out.println(slist);
		//test
		menubarCategory = new JMenuBar();
		screenMenuCategory = new JMenu("카테고리");
		for(int i=0; i<list.size(); i++) {
			screenMenuCategory.add(new JMenuItem(list.get(i).getCompanyMenu()));
		}
		menubarCategory.add(screenMenuCategory);
		menubarCategory.setBounds(14, 0, 100, TopAreaHeight);
		TopAreaPanel.add(menubarCategory);

		//end test

		btnMain = new JButton(); // 메인으로 갈수있는 버튼
		btnMain.setText("Main");
		btnMain.setBounds(114 , 0, 100, TopAreaHeight);
		btnMain.setVisible(true);
		TopAreaPanel.add(btnMain);
		//end [메인버튼] 영역
		
		//[검색바] 영역
		txtSearch = new JTextField(); // 메인으로 갈수있는 버튼
		txtSearch.setText("검색어를 입력해 주세요");
		txtSearch.setBounds(214, 0, 300, TopAreaHeight);
		txtSearch.setVisible(true);
		TopAreaPanel.add(txtSearch);
		//end [검색바] 영역
		
		//[검색버튼] 영역
		btnExeSearch = new JButton(); // 메인으로 갈수있는 버튼
		btnExeSearch.setText("Search");
		btnExeSearch.setBounds(514 , 0, 100, TopAreaHeight);
		btnExeSearch.setVisible(true);
		TopAreaPanel.add(btnExeSearch);
		//end [검색버튼] 영역
		
		//[로그인버튼] 영역
		btnLogin = new JButton(); // 메인으로 갈수있는 버튼
		btnLogin.setText("로그인");
		btnLogin.setBounds(614 , 0, 100, TopAreaHeight);
		btnLogin.setVisible(true);
		TopAreaPanel.add(btnLogin);
		//end [로그인버튼] 영역
		
		
		//[회원가입버튼] 영역
		btnSignIn = new JButton(); // 메인으로 갈수있는 버튼
		btnSignIn.setText("회원가입");
		btnSignIn.setBounds(714 , 0, 100, TopAreaHeight);
		btnSignIn.setVisible(true);
		TopAreaPanel.add(btnSignIn);
		//end [회원가입] 영역
		
		//테스트
		btnGetCategory = new JButton(); // 메인으로 갈수있는 버튼
		btnGetCategory.setText("카테고리");
		btnGetCategory.setBounds(814 , 0, 100, TopAreaHeight);
		btnGetCategory.setVisible(true);
		btnGetCategory.addActionListener((e->{
			
		}));
		TopAreaPanel.add(btnGetCategory);
		//end 테스트
		
		
		//[중간영역]
		MidAreaPanel = new JPanel();
		MidAreaPanel.setBounds(14, 13 + TopAreaHeight, 1200, 800);
		MidAreaPanel.setVisible(true);
		frame.getContentPane().add(MidAreaPanel);
		GridBagLayout gbl_MidAreaPanel = new GridBagLayout();
		gbl_MidAreaPanel.columnWidths = new int[]{0};
		gbl_MidAreaPanel.rowHeights = new int[]{0};
		gbl_MidAreaPanel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_MidAreaPanel.rowWeights = new double[]{Double.MIN_VALUE};
		MidAreaPanel.setLayout(gbl_MidAreaPanel);
		//end [중간영역]
		
		//[하단영역]
		BotAreaPanel = new JPanel();
		BotAreaPanel.setBounds(14, (int) (13 + MidAreaPanel.getSize().getHeight()), 1200, 800);
		BotAreaPanel.setVisible(true);
		frame.getContentPane().add(BotAreaPanel);
		//end [하단영역]
		
		
		
		
		
		
		

	}
}
