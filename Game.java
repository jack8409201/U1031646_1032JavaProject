import javax.swing.*;
import javax.swing.text.StyledEditorKit.AlignmentAction;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class Game extends JFrame{
	private ImageIcon icon[] = new ImageIcon[13];
	private ArrayList<Integer> dataList = new ArrayList<Integer>();
	private JButton jbt[] = new JButton[12];
	//紀錄時間
	private JPanel jpnTime = new JPanel();
	//紀錄翻牌總次數
	private JPanel jpnTimes = new JPanel();
	private Mouse mouse = new Mouse();
	//紀錄翻第一張或第二張
	int p_num = 0;
	//記錄第1,2次翻牌按鈕的編號
	int press1 = -1, press2 = -1;
	//紀錄成功配對的次數
	int correct = 0;
	int count = 0;
	int minute = 0;
	int second = 0;
	Timer timer = new Timer(1000, new TimerListener());
	private JLabel jlbTimes = new JLabel("翻牌次數 "+count+" 次");
	private JLabel jlbTime = new JLabel(minute+" 分 "+second+" 秒");
	
	public Game(){
		timer.start();
		
		//逞生背面圖
		icon[0] = new ImageIcon("C:/Users/Dan-Hour/Desktop/image/0.jpg");
		//正面圖
		for(int i = 1;i <= 6;i++){
			icon[i] = new ImageIcon("C:/Users/Dan-Hour/Desktop/image/"+ i +".jpg");
			icon[i+6] = new ImageIcon("C:/Users/Dan-Hour/Desktop/image/"+ i +".jpg");
		}
		
		//隨機取1~12不重複亂數
		for(int i = 1;i <= 12; i++){
			dataList.add(i);
		}
		Collections.shuffle(dataList);
	
		//12個圖形按鈕皆先放入背面圖
		int k = 0;
		for(int i = 0;i <= 2;i++){
			for(int j = 0;j <= 3;j++){
				jbt[k] = new JButton(icon[0]);
				jbt[k].setBounds(10+j*160, 10+i*170, 150, 160);
				add(jbt[k]);
				k++;
			}
		}
		
		//註冊傾聽者
		for(int i = 0;i <= 11; i++){
			jbt[i].addMouseListener(mouse);
		}
		
		jlbTime.setFont(new Font("TimesRoman",Font.BOLD,13));
		jpnTime.add(jlbTime);
		//顯示遊戲時間的面版
		jpnTime.setBounds(0,515,485,30);
		jpnTime.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); 
		add(jpnTime);
		//顯示翻牌次數的面版
		jpnTimes.add(jlbTimes);
		jlbTimes.setFont(new Font("TimesRoman",Font.BOLD,13));
		jpnTimes.setBounds(485,515,169,30);
		jpnTimes.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); 
		add(jpnTimes);
		
		
		setTitle("U10316046_1032JavaProject");
		setLayout(null);
		setBounds(100,100,660,574);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	//翻牌事件處理
	public class Mouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			//同一按鈕超過一次將回傳,不做任何動作
			if(press1 != -1){
				if(e.getSource() == jbt[press1]){
					count++;
					//重設次數
					jlbTimes.setText("翻牌次數 "+count+" 次");
					return;
				}
			}
			if(press2 != -1){
				if(e.getSource() == jbt[press2]){
					count++;
					//重設次數
					jlbTimes.setText("翻牌次數 "+count+" 次");
					return;
				}
			}
			
			for(int i = 0;i <= 11;i++){
				//偵測按哪一個有效按鈕
				if(jbt[i].isEnabled()){
					if(e.getSource() == jbt[i]){
						count++;
						//重設次數
						jlbTimes.setText("翻牌次數 "+count+" 次");
						p_num++;
						if(p_num > 2){
							//翻回背面
							jbt[press1].setIcon(icon[0]);
							jbt[press2].setIcon(icon[0]);
							press1 = -1;
							press2 = -1;
							p_num = 1;
						}
						//圖片按鈕翻牌
						jbt[i].setIcon(icon[dataList.get(i)]);
						if(p_num == 1){
							press1 = i;
						}
						if(p_num == 2){
							press2 = i;
						}
					}
				}
			}
			
			if(press1 != -1 && press2 != -1){
				//翻牌配對成功時
				if(Math.abs(dataList.get(press1) - dataList.get(press2)) == 6){
					//按鈕設為無效
					jbt[press1].setEnabled(false);
					jbt[press2].setEnabled(false);
					p_num = 0;
					press1 = -1;
					press2 = -1;
					//配對成功的次數加1
					correct++;
					//遊戲結束叫出新的框架
					if(correct == 6){
						rePlay replay = new rePlay();
						replay.setVisible(true);
						dispose();
						timer.stop();
					}
				}
			}
		}
	}
	
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			second++;
			if(second == 60){
				minute++;
				second = 0;
			}
			jlbTime.setText(minute+" 分  "+second+" 秒");
		}
	}
		
	//重玩遊戲類別
	public class rePlay extends JFrame{
		private JButton jbtRePlay = new JButton("重玩");
		private JButton jbtFinish = new JButton("結束");
		private JLabel jlb = new JLabel("恭喜完成!!");
		private JLabel jlbFinal = new JLabel("您花了"+minute+"分"+second+"秒,"+"  翻了"+count+"次");
				
		public rePlay(){
			setLayout(null);
			jlb.setBounds(120, 30, 100, 40);
			jlb.setFont(new Font("TimesRoman",Font.BOLD,20));
			add(jlb);
			jlbFinal.setBounds(90, 70, 150, 30);
			add(jlbFinal);
			
			jbtRePlay.setBounds(60, 120, 80, 30);
			add(jbtRePlay);
			jbtFinish.setBounds(190, 120, 80, 30);
			add(jbtFinish);
			
			//重玩按鈕,按下後重新呼叫game類別
			jbtRePlay.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					Game game = new Game();
					game.setVisible(true);
					dispose();
				}
			});
			
			//結束按鈕,按下後關閉所有視窗
			jbtFinish.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					dispose();
				}
			});
			
			setTitle("U10316046_1032JavaProject");
			setLayout(null);
			setBounds(100,100,350,200);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			setResizable(false);
		}
	}
}
