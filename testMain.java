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
		
		
		//[��ܹ�] ����
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
		screenMenuCategory = new JMenu("ī�װ�");
		for(int i=0; i<list.size(); i++) {
			screenMenuCategory.add(new JMenuItem(list.get(i).getCompanyMenu()));
		}
		menubarCategory.add(screenMenuCategory);
		menubarCategory.setBounds(14, 0, 100, TopAreaHeight);
		TopAreaPanel.add(menubarCategory);

		//end test

		btnMain = new JButton(); // �������� �����ִ� ��ư
		btnMain.setText("Main");
		btnMain.setBounds(114 , 0, 100, TopAreaHeight);
		btnMain.setVisible(true);
		TopAreaPanel.add(btnMain);
		//end [���ι�ư] ����
		
		//[�˻���] ����
		txtSearch = new JTextField(); // �������� �����ִ� ��ư
		txtSearch.setText("�˻�� �Է��� �ּ���");
		txtSearch.setBounds(214, 0, 300, TopAreaHeight);
		txtSearch.setVisible(true);
		TopAreaPanel.add(txtSearch);
		//end [�˻���] ����
		
		//[�˻���ư] ����
		btnExeSearch = new JButton(); // �������� �����ִ� ��ư
		btnExeSearch.setText("Search");
		btnExeSearch.setBounds(514 , 0, 100, TopAreaHeight);
		btnExeSearch.setVisible(true);
		TopAreaPanel.add(btnExeSearch);
		//end [�˻���ư] ����
		
		//[�α��ι�ư] ����
		btnLogin = new JButton(); // �������� �����ִ� ��ư
		btnLogin.setText("�α���");
		btnLogin.setBounds(614 , 0, 100, TopAreaHeight);
		btnLogin.setVisible(true);
		TopAreaPanel.add(btnLogin);
		//end [�α��ι�ư] ����
		
		
		//[ȸ�����Թ�ư] ����
		btnSignIn = new JButton(); // �������� �����ִ� ��ư
		btnSignIn.setText("ȸ������");
		btnSignIn.setBounds(714 , 0, 100, TopAreaHeight);
		btnSignIn.setVisible(true);
		TopAreaPanel.add(btnSignIn);
		//end [ȸ������] ����
		
		//�׽�Ʈ
		btnGetCategory = new JButton(); // �������� �����ִ� ��ư
		btnGetCategory.setText("ī�װ�");
		btnGetCategory.setBounds(814 , 0, 100, TopAreaHeight);
		btnGetCategory.setVisible(true);
		btnGetCategory.addActionListener((e->{
			
		}));
		TopAreaPanel.add(btnGetCategory);
		//end �׽�Ʈ
		
		
		//[�߰�����]
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
		//end [�߰�����]
		
		//[�ϴܿ���]
		BotAreaPanel = new JPanel();
		BotAreaPanel.setBounds(14, (int) (13 + MidAreaPanel.getSize().getHeight()), 1200, 800);
		BotAreaPanel.setVisible(true);
		frame.getContentPane().add(BotAreaPanel);
		//end [�ϴܿ���]
		
		
		
		
		
		
		

	}
}
