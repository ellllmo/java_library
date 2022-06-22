import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.JTextField;
import java.awt.*;
import java.io.FileReader;
import java.awt.*;
import java.util.*;
import javax.swing.*;
public class main extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	public static void main(String[] args) 
		throws Exception
		{
	    int r=0,m=0;
		JSONParser parser=new JSONParser();
		JSONArray q = (JSONArray) parser.parse(new FileReader("articles.json"));
		for (Object a:q)
		{
			JSONObject p =(JSONObject) a;
			String summary = (String) p.get("summary");
			String id = (String) p.get("id");
            r++;
		}
		String s[]=new String[r];
		String article[]=new String[r];
		String id[]=new String[r];
		String sa;
		for (Object a:q)
		{
			JSONObject p =(JSONObject) a;
			s[m] = (String) p.get("summary");
			article[m] = (String) p.get("summary");
			id[m] = (String) p.get("id");
			m++;
		}
		stopwords b=new stopwords();
		article a[]=new article[1000];
		b.stop();
		ArrayList n=new ArrayList();
		n=b.stop();
		word B=new word( s, n, "p");
		for(int e=0;e<1000;e++) {
		a[e]=new article(s, n);
		a[e].split(s,e);
		}
		B.search(s, 1000, a);
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
		main frame = new main(B, a,s,article,id);
		frame.setVisible(true);
		} catch (Exception e) {
		e.printStackTrace();
		}}});}
	public main(word B,article[] a,String[] s,String[] article,String[] id) 
	{
		setTitle("..* LIBRARY *..");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 682);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Scanner q=new Scanner(System.in);
		textField = new JTextField();
		textField.setBackground(new Color(230, 230, 250));
		textField.setBounds(76, 11, 414, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		JTextPane txtpnClickToOne = new JTextPane();
		txtpnClickToOne.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		txtpnClickToOne.setBackground(new Color(255, 228, 225));
		txtpnClickToOne.setForeground(new Color(0, 0, 0));
		txtpnClickToOne.setText("click to one List to see the summery..");
		txtpnClickToOne.setBounds(10, 210, 556, 399);
		contentPane.add(txtpnClickToOne);
		JList<String> list = new JList<String>();
		list.setModel(new AbstractListModel() {
		String[] values = new String[] {"The list of articles","...","","",""};
		public int getSize() {
		return values.length;
		}
		public Object getElementAt(int index) {
		return values[index];
		}});
		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List :", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		list.setBackground(new Color(64, 224, 208));
		list.setBounds(10, 89, 556, 110);
		contentPane.add(list);
		JButton btnNewButton = new JButton("Search");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String w = textField.getText();
			ArrayList<String> qw=new ArrayList<String>();
			if(B.hmap.get(w)==null) {
				list.setVisibleRowCount(7);
				list.setModel(new AbstractListModel() {
					String[] values = new String[] {"The list of articles","...","","",""};
					public int getSize() {
					return values.length;
					}
					public Object getElementAt(int index) {
					return values[index];
					}});
				
				listChanged(txtpnClickToOne);
			}
			else {
			qw=(ArrayList<String>) B.hmap.get(w);
			if(qw.size()>5) {	
				String[] q=new String[5];
		     	for(int w1=0;w1<5;w1++)
					 q[w1]=qw.get(w1);
			list.setVisibleRowCount(7);
			list.setModel(new AbstractListModel() {
			String[] values = new String[] {q[0],q[1],q[2],q[3],q[4]};
			public int getSize() {
			return values.length;
				}
			public Object getElementAt(int index) {
			return values[index];
			}});
			list.addListSelectionListener(new ListSelectionListener() {
	    	      public void valueChanged(ListSelectionEvent evt) {
				listValueChanged(evt,list,txtpnClickToOne,article,s,q);
				 }});}
			else 
				{
					switch(qw.size())
					{
					case 5:{
						String[] q=new String[qw.size()];
			     	for(int w1=0;w1<qw.size();w1++)
						 q[w1]=qw.get(w1);
						list.setVisibleRowCount(7);
						list.setModel(new AbstractListModel() {
						String[] values = new String[] {q[0],q[1],q[2],q[3],q[4]};
						public int getSize() {
						return values.length;
							}
						public Object getElementAt(int index) {
						return values[index];
						}});
						list.addListSelectionListener(new ListSelectionListener() {
				    	      public void valueChanged(ListSelectionEvent evt) {
							listValueChanged(evt,list,txtpnClickToOne,article,s,q);
							 }});break;}
					case 4:{String[] q=new String[qw.size()];
			     	for(int w1=0;w1<qw.size();w1++)
						 q[w1]=qw.get(w1);
						list.setVisibleRowCount(7);
						list.setModel(new AbstractListModel() {
						String[] values = new String[] {q[0],q[1],q[2],q[3]};
						public int getSize() {
						return values.length;
							}
						public Object getElementAt(int index) {
						return values[index];
						}});
						list.addListSelectionListener(new ListSelectionListener() {
				    	      public void valueChanged(ListSelectionEvent evt) {
							listValueChanged(evt,list,txtpnClickToOne,article,s,q);
							 }});break;}
				case 3:{String[] q=new String[qw.size()];
		     	for(int w1=0;w1<qw.size();w1++)
					 q[w1]=qw.get(w1);
					list.setVisibleRowCount(7);
					list.setModel(new AbstractListModel() {
					String[] values = new String[] {q[0],q[1],q[2]};
					public int getSize() {
					return values.length;
						}
					public Object getElementAt(int index) {
					return values[index];
					}});
					list.addListSelectionListener(new ListSelectionListener() {
			    	      public void valueChanged(ListSelectionEvent evt) {
						listValueChanged(evt,list,txtpnClickToOne,article,s,q);
						 }});break;}
				case 2:{String[] q=new String[qw.size()];
		     	for(int w1=0;w1<qw.size();w1++)
					 q[w1]=qw.get(w1);
					list.setVisibleRowCount(7);
					list.setModel(new AbstractListModel() {
					String[] values = new String[] {q[0],q[1]};
					public int getSize() {
					return values.length;
						}
					public Object getElementAt(int index) {
					return values[index];
					}});
					list.addListSelectionListener(new ListSelectionListener() {
			    	      public void valueChanged(ListSelectionEvent evt) {
						listValueChanged(evt,list,txtpnClickToOne,article,s,q);
						 }});break;}
				case 1:{String[] q=new String[qw.size()];
		     	for(int w1=0;w1<qw.size();w1++)
					 q[w1]=qw.get(w1);
					list.setVisibleRowCount(7);
					list.setModel(new AbstractListModel() {
					String[] values = new String[] {q[0]};
					public int getSize() {
					return values.length;
						}
					public Object getElementAt(int index) {
					return values[index];
					}});
					list.addListSelectionListener(new ListSelectionListener() {
			    	      public void valueChanged(ListSelectionEvent evt) {
						listValueChanged(evt,list,txtpnClickToOne,article,s,q);
						 }});break;}
					}
				}}
			
		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List :", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			
			}});
		btnNewButton.setForeground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("ae_Arab", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(216, 191, 216));
		btnNewButton.setBounds(200, 50, 162, 28);
		contentPane.add(btnNewButton);
	}
	private void listValueChanged(ListSelectionEvent evt,JList list,JTextPane txtpnClickToOne,String[] article,String[] s,String[] q) {
	    if (!list.getValueIsAdjusting()) {
	    	String g=(String) list.getSelectedValue();
	    	char[] c=new char[g.length()-9];
	    	int f=0;
	    	for(int e=0;e<c.length-1;e++)
	    	{
	    	c[e]=g.charAt(8+e);
	    	f=f*10+c[e]-48;
	    	}
		    	txtpnClickToOne.setText((String) list.getSelectedValue()+":\n"+s[f]);
	        }}
	private void listChanged(JTextPane txtpnClickToOne) {
	 // if (!list.getValueIsAdjusting()) {	
	    txtpnClickToOne.setText(" not exist!!!");
	   }}
         