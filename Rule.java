import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rule extends JFrame{
	private JButton jbtSure = new JButton("確定");
	
	public Rule(){
		setLayout(null);
		
		//說明遊戲規則
		JTextArea jtaRule = new JTextArea(" 記憶配對遊戲(對對碰) : \n\n"
								  +	"               共有6對12張神奇寶貝球牌, \n"
								  + "               請在最短時間及最少次數內, \n"
								  + "               依照相同的神奇寶貝做配對 !!");
		jtaRule.setFont(new Font("TimesRoman",Font.BOLD,15));
		jtaRule.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		jtaRule.setBounds(70, 30, 350, 130);
		add(jtaRule);
		
		//確定按鈕
		jbtSure.setBounds(190, 190, 100, 40);
		add(jbtSure);
		
		//按下後建立game類別並將規則視窗關閉
		jbtSure.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				Game game = new Game();
				game.setVisible(true);
				dispose();
			}
		});
		
	}
	
	//main method
	public static void main(String[] args) {
		JFrame frame = new Rule();
		frame.setTitle("U10316046_1032JavaProject");
		frame.setLayout(null);
		frame.setBounds(100,100,500,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}

}

