import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PersonalProject1 extends JFrame  {

BufferedImage i = null; 
JLabel label1;
JLabel label2;
JLabel label3;
JLabel label4;
JButton newspaper;
JButton closet;
JButton bed;
JButton bedroom;
JButton kitchen;
JButton livingRoom;
JButton bank;
JButton market;
JButton park;
JLabel label5;
JComboBox answerOptions;
JButton confirm;

public static final Color dark_brown = new Color(153, 102, 0);
public static final Color light_brown = new Color(187, 153, 102);

public PersonalProject1() throws IOException{
		
		this.setSize(500, 340);
		//this.getContentPane().setBackground(dark_brown);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("The Troubled Double");
		BufferedImage bf = ImageIO.read(new File("src/background.png"));
		this.setContentPane(new backImage(bf));

		label1 = new JLabel();
		label1.setText("                                   ");
		this.add(label1); 
		
		JPanel rect = new JPanel();
		rect.setBackground(light_brown);
		rect.setPreferredSize(new Dimension(480, 260));
		this.add(rect);
		
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);
		
		label1 = new JLabel();
		label1.setText("Wake up, Mr. Holmes! We have a new case for you!");
		rect.add(label1);
		
		label2 = new JLabel();
		label2.setText("A mysterious occurence has happened in town and we need you to solve it!");
		rect.add(label2);
		
		label3 = new JLabel();
		label3.setText("Find clues and use your wits to solve the mystery! Good luck!");
		rect.add(label3);
		
		newspaper = new JButton("Newspaper");
		newspaper.addActionListener(new MyNewspaperAction());
		rect.add(newspaper);
		
		closet = new JButton("Closet");
		closet.addActionListener(new MyClosetAction());
		rect.add(closet);
		
		bed = new JButton("Bed");
		bed.addActionListener(new MyBedAction());
		rect.add(bed);
		
		bedroom = new JButton("Watson's Bedroom");
		bedroom.addActionListener(new MyBedroomAction());
		rect.add(bedroom);
		
		kitchen = new JButton("Kitchen");
		kitchen.addActionListener(new MyKitchenAction());
		rect.add(kitchen);
		
		livingRoom = new JButton("Living Room");
		livingRoom.addActionListener(new MyLivingRoomListener());
		rect.add(livingRoom);
		
		bank = new JButton("Bank");
		bank.addActionListener(new MyBankListener());
		rect.add(bank);
		
		market = new JButton("Market");
		market.addActionListener(new MyMarketListener());
		rect.add(market);
		
		park = new JButton("Park");
		park.addActionListener(new MyParkListener());
		rect.add(park);
		
		ImageIcon sherlock = new ImageIcon(PersonalProject1.class.getResource("sherlock.jpg"));
		JLabel imageLabel = new JLabel(sherlock);
		rect.add(imageLabel);
		
		label5 = new JLabel();
		label5.setText("The criminals are: ");
		rect.add(label5);
		
		String[] options = {" ", "Annie and James", "Ella and Jennie", "Henry and Ava"};
		answerOptions = new JComboBox(options);
		rect.add(answerOptions);
		
		confirm = new JButton("Confirm");
		confirm.addActionListener(new MyConirmListener());
		rect.add(confirm);
	}

	private class MyNewspaperAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "BREAKING NEWS: Someone dressed as the esteemed detective Sherlock Holmes seems to be on the loose and causing chaos in London. \nThe perpetrator stole significant sums from the bank, broke into a local market, and damaged public property at Hyde Park. \nWho could this psychopathic criminal be?", "The London Times", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyClosetAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ImageIcon closet = new ImageIcon(PersonalProject1.class.getResource("closet_open.jpg"));
			JOptionPane.showMessageDialog(null, "Hmm, all of my clothes are gone. \nThe criminal seems very determined to frame me.", "My Closet", JOptionPane.DEFAULT_OPTION, closet);
		} 
	}

	private class MyBedAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ImageIcon bed = new ImageIcon(PersonalProject1.class.getResource("bed.jpg"));
			JOptionPane.showMessageDialog(null, "I check under the bed and find my flat key, pipe and wallet are gone. \nWhat could this criminal be after?", "My Bed", JOptionPane.DEFAULT_OPTION, bed);
		}
	}
	
	private class MyBedroomAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame bedroom = new JFrame();
			bedroom.setSize(600, 500);
			bedroom.getContentPane().setBackground(light_brown);
			bedroom.setTitle("Watson's Bedroom");
			FlowLayout layout = new FlowLayout();
			bedroom.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("bedroom.jpg"));
			JLabel imageLabel = new JLabel(image);
			bedroom.add(imageLabel);
			bedroom.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>I enter Watson's bedroom and find him reading by the window.<br/>He informs me that he received news of my scandalous double.<br/>He also tells me that he hired a maid and a cook with the money we have saved up.<br/>Why does he never consult me about these things?</html>");
			bedroom.add(text);
			
			JButton maid = new JButton("Maid");
			MyMaidListener maidListener = new MyMaidListener();
			maid.addActionListener(maidListener);
			bedroom.add(maid);
			
			JButton cook = new JButton("Cook");
			MyCookListener cookL= new MyCookListener();
			cook.addActionListener(cookL);
			bedroom.add(cook);
		}
	}
	
	private class MyMaidListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: Annie Williams / Age: 19 / Gender: Female<br/>Annie lives in a central London flat with her parents and 4 siblings.<br/>She has minimal experience working as a maid and is not educated, but seems like a clever girl.<br/>Annie has a spare key to my flat.</html>","Maid",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyCookListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: James Moore / Age: 29 / Gender: Male<br/>James is a professor that dabbles in the art of cooking.<br/>He knows London well and is also a moderate smoker.<br/>James has a spare key to my flat.</html>","Cook",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyKitchenAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame kitchen = new JFrame();
			kitchen.setSize(1000, 550);
			kitchen.getContentPane().setBackground(light_brown);
			kitchen.setTitle("Kitchen");
			FlowLayout layout = new FlowLayout();
			kitchen.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("kitchen.jpg"));
			JLabel imageLabel = new JLabel(image);
			kitchen.add(imageLabel);
			kitchen.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>I walk into the kitchen and find our landlady, Mrs. Hudson, preparing tea (but only this one time!).<br/>I inquire about any suspicious activity at Baker Street, but she says everything seems as usual.<br/>The only people she saw this week were two guests that wanted to see the flat next to mine.<br/>They were also curious about my flat for some reason and Mrs. Hudson thought it was a good idea to show them around my flat while I was out.<br/>God, that woman.</html>");
			kitchen.add(text);
			
			JButton guest1 = new JButton("First Guest");
			Myg1Listener g1 = new Myg1Listener();
			guest1.addActionListener(g1);
			kitchen.add(guest1);
			
			JButton guest2 = new JButton("Second Guest");
			Myg2Listener g2 = new Myg2Listener();
			guest2.addActionListener(g2);
			kitchen.add(guest2);
		}
	}
	
	private class Myg1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: Ella Clark / Age: 32 / Gender: Female<br/>Ella works at St. Barts Hospital as a nurse.<br/>She is looking for a flat in London where she can settle down with her partner.<br/>The two guests seem interested in my flat.</html>","First Guest",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class Myg2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: Jennie Martin / Age: 33 / Gender: Female<br/>Jennie works as a governess for the Edwards family in the downtown area.<br/>She likes to walk in Hyde Park to stay healthy.<br/>The two guests seem interested in my flat.</html>","First Guest",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyLivingRoomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame livingRoom = new JFrame();
			livingRoom.setSize(1000, 500);
			livingRoom.getContentPane().setBackground(light_brown);
			livingRoom.setTitle("Living Room");
			FlowLayout layout = new FlowLayout();
			livingRoom.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("livingRoom.jpg"));
			JLabel imageLabel = new JLabel(image);
			livingRoom.add(imageLabel);
			livingRoom.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>I find Inspector Lestraude and others from Scotland Yard searching the living room for clues.<br/>I notice two new people I haven't seen previously, so I ask Lestraude about them and he explains that they're new recruits.<br/>How convenient.</html>");
			livingRoom.add(text);
			
			JLabel space = new JLabel();
			space.setText("                              ");
			livingRoom.add(space);
			
			JButton recruit1 = new JButton("First Recruit");
			Myr1Listener r1 = new Myr1Listener();
			recruit1.addActionListener(r1);
			livingRoom.add(recruit1);
			
			JButton recruit2 = new JButton("Second Recruit");
			Myr2Listener r2 = new Myr2Listener();
			recruit2.addActionListener(r2);
			livingRoom.add(recruit2);
		
	}
}
		
	private class Myr1Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: Henry Bennett / Age: 25 / Gender: Male<br/>Henry is a college graduate and new recruit for Scotland Yard.<br/>He is helping to support his older brother Joseph, who works at the London Bank, and his younger sister Millie, who is still in school. <br/>Henry seems competent at his job.</html>","First Recruit",JOptionPane.DEFAULT_OPTION);

		}
	}
		
	private class Myr2Listener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Name: Ava Hughes / Age: 26 / Gender: Female<br/>Ava has experience working at the Cardiff Police Department.<br/>Apparently she lived in the local orphanage during her childhood, but became the top of her class at Cardiff University.<br/>Impressive, I guess.</html>","Second Recruit",JOptionPane.DEFAULT_OPTION);

		}
	}
	
	private class MyBankListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Bank = new JFrame();
			Bank.setSize(800, 500);
			Bank.getContentPane().setBackground(light_brown);
			Bank.setTitle("The London Bank");
			FlowLayout layout = new FlowLayout();
			Bank.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("bank.jpg"));
			JLabel imageLabel = new JLabel(image);
			Bank.add(imageLabel);
			Bank.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>I go to the bank to investigate the crime scene.<br/>The owner shows me the local orphanage manager Alice Hill's broken vault that the money was stolen from.<br/>Eyewitness account says two cloaked individuals committed the crime.<br/>I may be getting closer ...</html>");
			Bank.add(text);
			
			JButton search = new JButton("Search the Scene");
			MyBankSearchListener s = new MyBankSearchListener();
			search.addActionListener(s);
			Bank.add(search);
		}
	}
	
	private class MyBankSearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Looking closer at the safe, something shiny catches my eye.<br/>I move some rubble and find ... ah, so that's where it went. It's my missing flat key.<br/>Was this dropped on purpose or by accident?</html>","Search the Scene",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyMarketListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Market = new JFrame();
			Market.setSize(800, 600);
			Market.getContentPane().setBackground(light_brown);
			Market.setTitle("The Market");
			FlowLayout layout = new FlowLayout();
			Market.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("market.jpg"));
			JLabel imageLabel = new JLabel(image);
			Market.add(imageLabel);
			Market.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>At the market, I find the trail left behind by the criminals.<br/>The doors are unhinged and the store is a mess.<br/>Different foods are scattered across the floor and the shelves are empty.<br/>The manager recalls that they smelled smoke when they first found the wrecked market.<br/>Smoke ... God, why'd they have to take the pipe?</html>");
			Market.add(text);
			
			JLabel space = new JLabel();
			space.setText("                          ");  
			Market.add(space);
			
			JButton search = new JButton("Search the Scene");
			MyMarketSearchListener s = new MyMarketSearchListener();
			search.addActionListener(s);
			Market.add(search);
		}
	}
	
	private class MyMarketSearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>They've cleaned some of the mess, so I can walk through the market to search for anything significant.<br/>As I walk down the aisles, I come across something interesting and slightly amusing.<br/>A transparent water jug is in the middle of the aisle with my ruined pipe at the very bottom of it.<br/>Now they're just playing with me.</html>", "Search the Scene",JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyParkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Park = new JFrame();
			Park.setSize(1000, 450);
			Park.getContentPane().setBackground(light_brown);
			Park.setTitle("Hyde Park");
			FlowLayout layout = new FlowLayout();
			Park.setLayout(layout);
			
			ImageIcon image = new ImageIcon(PersonalProject1.class.getResource("park.jpg"));
			JLabel imageLabel = new JLabel(image);
			Park.add(imageLabel);
			Park.setVisible(true);
			
			JLabel text = new JLabel();
			text.setText("<html>When I arrive at Hyde Park, I find one of the local monuments (well, the remains of it) roped off.<br/>I believe it was a statue of sorts, but I've erased that irrelevant piece of information from my memory.<br/>Scotland Yard found two different sets of fingerprints on the statue's remains, but still aren't certain who the perpetrators are.<br/>A big load of help these people are.</html>");
			Park.add(text);
			
			JLabel space = new JLabel();
			space.setText("                              ");
			Park.add(space);
			
			JButton search = new JButton("Search the Scene");
			MyParkSearchListener s = new MyParkSearchListener();
			search.addActionListener(s);
			Park.add(search);
		}
	}
	
	private class MyParkSearchListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"<html>Ducking under the caution rope, I crouch next to the base of the statue.<br/>There's a plaque describing the individual: MARK BENNETT, SENIOR COMMANDER OF SCOTLAND YARD.<br/>Bennett ... that name seems familiar ...</html>","Search the Scene", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	private class MyConirmListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String selectedAnswer = (String)answerOptions.getSelectedItem();
			if(selectedAnswer == "Henry and Ava")
				JOptionPane.showMessageDialog(null, "Congratulations! You found the criminals! \nI confront Henry and Ava and find my stolen wallet in Ava's pocket.\nAfter being arrested, they revealed their motivation for their crimes.\nHenry's father, Mark Bennett, left Henry's mother for another woman named Alice Hill, forcing Henry and his siblings to help support themselves from a young age.\nAva had a traumatic experience at the orphanage that involved Ms. Hill and continued to hate the police even as she became one herself.\nWith Henry's brother's connection to the bank and Ava's experince and resources as a police officer, they agreed to have Henry dress as the beloved Sherlock Holmes and cause chaos in London to get revenge for their past.", "Are Henry and Ava the criminals?", JOptionPane.DEFAULT_OPTION);
			if(selectedAnswer == "Annie and James")
				JOptionPane.showMessageDialog(null, "I confront Annie and James, but find nothing of importance. \nThe only time they have been in my flat is when Watson interviewed them for their positions and when they received the spare keys. \nNeither one has my wallet in their possession. \nI guess I'll let them work in my flat if Watson thinks it's best. \nAnnie and James are not the criminals! Try again!",  "Are Annie and James the criminals?", JOptionPane.DEFAULT_OPTION);
			if(selectedAnswer == "Ella and Jennie")
				JOptionPane.showMessageDialog(null, "I confront Ella and Jennie, but they do not seem to be guilty. \nThey were only interested in my flat because Mrs. Hudson was rambling on about how great it is (God, that woman!). \nNeither one has my wallet in their possession. \nElla and Jennie decide to lease the flat next to mine together. \nElla and Jennie are not the criminals! Try again!", "Are Ella and Jennie the criminals?", JOptionPane.DEFAULT_OPTION);
			if(selectedAnswer == " ")
				JOptionPane.showMessageDialog(null, "Please choose another option.", "Try Again!", JOptionPane.DEFAULT_OPTION);
		}
	}
	
	class backImage extends JComponent {
		Image i;
		public backImage(Image i) {
			this.i = i;
		} 
		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(i, 0, 0, null);  
		}
	}
	
	public static void main(String[] args) throws IOException {
		PersonalProject1 myFrame = new PersonalProject1(); 
		myFrame.setVisible(true);
		}
	
	
}
	




