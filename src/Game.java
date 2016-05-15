import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;

import org.jvnet.substance.skin.SubstanceGreenMagicLookAndFeel;
public class Game extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1038922514275248123L;
	/**
	 * @param args
	 */
	public JButton pButtonOne,pButtonTwo,pButtonThree,pButtonFour;
	public JButton fButtonJia,fButtonJian,fButtonCheng,fButtonChu,fButtonZKuo,fButtonYKuo;
	public JTextField text;
	public JButton okButton,cancelButton;
	public Icon icon1,icon2,icon3,icon4;
	public String path1=null,path2=null,path3=null,path4=null;
	public String s="";                                               //定义输出的字符串
	public JButton startButton,nextButton;         //定义确定，撤销按钮
	public int a,b,c,d;                         //定义四个随机数
	String aPath="",bPath="",cPath="",dPath="";     //定义四张图片的路径
	Thread thread;
	boolean isClicked=false;
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	public void init(){
		/*////////////////////////////////////////////////////////
		try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        }catch(Exception exe){
            exe.printStackTrace();
        }*/
		////////////////////////////////////////
		
		try {
			UIManager.setLookAndFeel(new SubstanceGreenMagicLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		this.setTitle("24点");
		this.setBounds(300,50,800,600);
		this.setVisible(true);
		path1="first.jpg";
		path2="first.jpg";
		path3="first.jpg";
		path4="first.jpg";
		Image img=Toolkit.getDefaultToolkit().getImage("10.JPG");
		this.setIconImage(img);
		icon1 = new ImageIcon(path1);
		icon2 = new ImageIcon(path2);
		icon3 = new ImageIcon(path3);
		icon4 = new ImageIcon(path4);
		this.addTextField();
		this.addpButton();
		this.addfButton();
		this.addOCButton();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
	}
	public void addpButton(){                                       //添加扑克牌按钮
		pButtonOne = new JButton();
		pButtonTwo = new JButton();
		pButtonThree = new JButton();
		pButtonFour = new JButton();
		pButtonOne.setBounds(50,25,100,150);
		pButtonTwo.setBounds(250,25,100,150);
		pButtonThree.setBounds(450,25,100,150);
		pButtonFour.setBounds(650,25,100,150);
		pButtonOne.setIcon(icon1);
		pButtonTwo.setIcon(icon2);
		pButtonThree.setIcon(icon3);
		pButtonFour.setIcon(icon4);
		pButtonOne.addActionListener(new pButtonEvent());
		pButtonTwo.addActionListener(new pButtonEvent());
		pButtonThree.addActionListener(new pButtonEvent());
		pButtonFour.addActionListener(new pButtonEvent());          
		this.add(pButtonOne);
		this.add(pButtonTwo);
		this.add(pButtonThree);
		this.add(pButtonFour);
	}
	public void addfButton(){                                    //添加符号按钮
		fButtonJia = new JButton();
		fButtonJian = new JButton();
		fButtonCheng = new JButton();
		fButtonChu = new JButton();
		fButtonZKuo = new JButton();
		fButtonYKuo = new JButton();
		fButtonJia.setBounds(60,220,60,60);
		fButtonJian.setBounds(180,220,60,60);
		fButtonCheng.setBounds(300,220,60,60);
		fButtonChu.setBounds(420,220,60,60);
		fButtonZKuo.setBounds(540,220,60,60);
		fButtonYKuo.setBounds(660,220,60,60);
		fButtonJia.setIcon(new ImageIcon("Jia.png"));
		fButtonJian.setIcon(new ImageIcon("jian.png"));
		fButtonCheng.setIcon(new ImageIcon("cheng.png"));
		fButtonChu.setIcon(new ImageIcon("chu.png"));
		fButtonZKuo.setIcon(new ImageIcon("ZuoKuoHao.png"));
		fButtonYKuo.setIcon(new ImageIcon("YouKuoHao.png"));
		fButtonJia.setContentAreaFilled(false);
		fButtonJian.setContentAreaFilled(false);
		fButtonCheng.setContentAreaFilled(false);
		fButtonChu.setContentAreaFilled(false);
		fButtonZKuo.setContentAreaFilled(false);
		fButtonYKuo.setContentAreaFilled(false);
		fButtonJia.addActionListener(new fButtonEvent());
		fButtonJian.addActionListener(new fButtonEvent());
		fButtonCheng.addActionListener(new fButtonEvent());
		fButtonChu.addActionListener(new fButtonEvent());
		fButtonZKuo.addActionListener(new fButtonEvent());
		fButtonYKuo.addActionListener(new fButtonEvent()); 
		this.add(fButtonJia);
		this.add(fButtonJian);
		this.add(fButtonCheng);
		this.add(fButtonChu);
		this.add(fButtonZKuo);
		this.add(fButtonYKuo);
		
	}
	public void addTextField(){                             //添加文本框
		text = new JTextField(); 
		text.setOpaque(false);                             //设置文本框透明
		text.setEditable(false);                           //设置文本框不可编辑
		text.setBounds(100,350,620,100);
		Font font = new Font("宋体",Font.BOLD,100);
		text.setFont(font);
		this.add(text);
	}
	public void addOCButton(){                            //添加确定取消按钮
		okButton = new JButton("确定");
		cancelButton = new JButton("撤销");
		startButton = new JButton("开始");
		nextButton = new JButton("停止");
		okButton.setFont(new Font("楷体",Font.BOLD,22));
		cancelButton.setFont(new Font("楷体",Font.BOLD,22));
		startButton.setFont(new Font("楷体",Font.BOLD,22));
		nextButton.setFont(new Font("楷体",Font.BOLD,22));
		okButton.setBounds(130,500,200,50);
		cancelButton.setBounds(470,500,200,50);
		startButton.setBounds(350,500,100,50);
		nextButton.setBounds(350,500,100,50);
		this.add(okButton);
		this.add(startButton);
		this.add(nextButton);
		this.add(cancelButton);
		nextButton.setVisible(false);
		JButton answerButton = new JButton("想知道答案？点击我！"); 
		answerButton.setBounds(300, 300, 200, 40);
		answerButton.setContentAreaFilled(false);
		answerButton.setBorderPainted(false);
		answerButton.setFont(new Font("楷体",Font.BOLD,15));
		answerButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e){
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e){
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		answerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ee){
				int op1,op2,op3;
				for(op1=1;op1<=4;op1++)
					for(op2=1;op2<=4;op2++)
						for(op3=1;op3<=4;op3++){
							if(calculate_model1(a,b,c,d,op1,op2,op3)==24)
								System.out.println("(("+a+showFuHao(op1)+b+")"+showFuHao(op2)+c+")"+showFuHao(op3)+d); /*对应表达式类型：((A□B)□C)□D*/
							if(calculate_model2(a,b,c,d,op1,op2,op3)==24)
								System.out.println("("+a+showFuHao(op1)+"("+b+showFuHao(op2)+c+")"+")"+showFuHao(op3)+d);/*对应表达式类型：(A□(B□C))□D */
							if(calculate_model3(a,b,c,d,op1,op2,op3)==24)
								 System.out.println(a+showFuHao(op1)+"("+b+showFuHao(op2)+"("+c+showFuHao(op3)+d+"))");/*对应表达式类型：A□(B□(C□D))*/
							if(calculate_model4(a,b,c,d,op1,op2,op3)==24)
								System.out.println(a+showFuHao(op1)+"(("+b+showFuHao(op2)+c+")"+showFuHao(op3)+d+")");/*对应表达式类型：A□((B□C)□D)*/
							if(calculate_model5(a,b,c,d,op1,op2,op3)==24)
								System.out.println("("+a+showFuHao(op1)+b+")"+showFuHao(op2)+"("+c+showFuHao(op3)+d+")");/*对应表达式类型：(A□B)□(C□D)*/
						}
			}
		});
		this.add(answerButton);
		
		startButton.addActionListener(new ActionListener(){                 //"开始"按钮实现单击功能

			public void actionPerformed(ActionEvent e){
				thread=new Thread(new Runnable(){
					public void run(){
						isClicked=false;
						while(isClicked==false){
							try{
								Thread.sleep(2);
								int a1,b1,c1,d1;
								a1=new Random().nextInt(11);
								b1=new Random().nextInt(11);
								c1=new Random().nextInt(11);
								d1=new Random().nextInt(11);
								if(a1==0) a1++;
								if(b1==0) b1++;
								if(c1==0) c1++;
								if(d1==0) d1++;
								setpButtonIcon(a1,b1,c1,d1);
								if(isClicked==true){
									setpButtonIcon(a,b,c,d);
									return ;
								}
							}catch(Exception e){
								e.printStackTrace();
							}	
						}
					}
				});
				setButtonEnabled();
				nextButton.setVisible(true);
				startButton.setVisible(false);
				text.setText(null);
				thread.start();
			}
		});
		cancelButton.addActionListener(new ActionListener(){           //"撤销"按钮实现单击功能
			public void actionPerformed(ActionEvent e){
				s="";
				text.setText(null);
				setButtonEnabled();
				
			}
		});
		nextButton.addActionListener(new ActionListener(){                //“停止“按钮实现单击功能
			public void actionPerformed(ActionEvent e){
				startButton.setVisible(true);
				nextButton.setVisible(false);
				isClicked=true;
				setButtonEnabled();
				s="";
				text.setText(null);
				boolean bool=false;
				while(bool==false){
					a = new Random().nextInt(11);
					b = new Random().nextInt(11);
					c = new Random().nextInt(11);
					d= new Random().nextInt(11);
					if(a==0) a++;
					if(b==0) b++;
					if(c==0) c++;
					if(d==0) d++;
					if(isGet24(a,b,c,d)){
						bool=true;
						setpButtonIcon(a,b,c,d);
					}
				}
			}
		});
		okButton.addActionListener(new ActionListener(){                   //"确定"按钮实现单击功能
			public void actionPerformed(ActionEvent e){
				String str=text.getText();
				int len=str.length();
				StringBuffer sb= new StringBuffer(s);
				for(int i=0;i<sb.length();i++){
					if(sb.charAt(i)=='1'){
						int j=i+1;
						if(j<sb.length()&&sb.charAt(j)=='0')
						{
							sb=sb.replace(i, j,"$");
							sb.deleteCharAt(j);
							i=0;
						}
					}
				}
				try{
					Stack<Character> ct=new Stack<Character>();
					Stack<Character> c1 = new Stack<Character>();
					Stack<Character> s1 = new Stack<Character>();
					ct.push(new Character('#'));
					for(int i=sb.length()-1;i>=0;i--)
						ct.push(new Character(sb.charAt(i)));
					s1.push(new Character('#'));
					char ch=ct.peek().charValue();
					char y;
					while(ch!='#'){
						if(isDigit(ch)) 
							c1.push(ct.peek().charValue());
						else if(ch==')')
							for(y=s1.peek().charValue(),s1.pop();y!='(';y=s1.peek().charValue(),s1.pop())
								c1.push(new Character(y));
						else{
							for(y=s1.peek().charValue(),s1.pop();icp(ch)<=isp(y);y=s1.peek().charValue(),s1.pop())
								c1.push(new Character(y));
							s1.push(new Character(y));
							s1.push(new Character(ch));
						}
						ct.pop();
						ch=ct.peek().charValue();
					}
					while(!s1.isEmpty()){
						y=s1.peek().charValue();
						s1.pop();
						if(y!='#')
							c1.push(new Character(y));
					}
					s1.push(new Character('#'));
					while(c1.isEmpty()==false){  
						char temp=c1.peek().charValue();
						if(temp>='1'&&temp<='9')
							temp=(char)(temp-48);
						else if(temp=='$')
							temp=(char)(temp-26);
						s1.push(new Character(temp));
						c1.pop();
					}
					Stack<Character> re=new Stack<Character>();
					
					char cha[]=new char[20];
					int i=0;
					while(s1.peek().charValue()!='#')
					{
						cha[i++]=s1.peek().charValue();
						s1.pop();
					}
					cha[i]='#';
					for(i=0;cha[i]!='#';){
						if(cha[i]=='+'){
							cha[i-2]=(char)(cha[i-1]+cha[i-2]);
							deletetwoElements(i-1,cha);
							i=0;
						}
						else if(cha[i]=='-'){
							cha[i-2]=(char)(cha[i-2]-cha[i-1]);
							deletetwoElements(i-1,cha);
							i=0;
						}
						else if(cha[i]=='*'){
							cha[i-2]=(char)(cha[i-1]*cha[i-2]);
							deletetwoElements(i-1,cha);
							i=0;
						}
						else if(cha[i]=='/'){
							cha[i-2]=(char)(cha[i-2]/cha[i-1]);
							deletetwoElements(i-1,cha);
							i=0;
						}
						else i++;
					}
					if((int)cha[0]==24){
						text.setText("   Y^o^Y ");}
					else {
						text.setText("  (＞﹏＜)");}
				}catch(Exception ee){}
				////////////////////////////////////////把后缀表达式放在s中
				
				
			}

		});
	}
	String showFuHao(int op){
		switch(op){
		case 1:return "+";
		case 2:return "-";
		case 3:return "*";
		case 4:return "/";
		}
		return "";
	}
	void deletetwoElements(int i,char cha[]){
		for(int j=i;j<cha.length-2;j++){
			cha[j]=cha[j+2];
		}
	}
	int icp(char ch){
		switch(ch){
		case '#':return 0;
		case '(':return 7;
		case '*':
		case '/':return 4;
		case '+':
		case '-':return 2;
		case ')':return 1;
		}
		return 0;
	}
	int isp(char ch){
		switch(ch){
		case '#':return 0;
		case '(':return 1;
		case '*':
		case '/':return 5;
		case '+':
		case '-':return 3;
		case ')':return 7;
		}
		return 0;
	}
	boolean isDigit(char ch){
		char c=ch;
		if(c>='0'&&c<='9'||c=='$')
			return true;
		else return false;
	}
	public void setpButtonIcon(int i,int j,int k,int t){
		aPath=""+i+".JPG";
		bPath=""+j+".JPG";
		cPath=""+k+".JPG";
		dPath=""+t+".JPG";
		pButtonOne.setIcon(new ImageIcon(aPath));
		pButtonTwo.setIcon(new ImageIcon(bPath));
		pButtonThree.setIcon(new ImageIcon(cPath));
		pButtonFour.setIcon(new ImageIcon(dPath));	
	}
	public void setButtonEnabled(){
		pButtonOne.setEnabled(true);
		pButtonTwo.setEnabled(true);
		pButtonThree.setEnabled(true);
		pButtonFour.setEnabled(true);
	}
	
	public  float cal(float x,float y,int op){                               //计算两个操作数
		switch(op){
		case 1:return x+y;
		case 2:return x-y;
		case 3:return x*y;
		case 4:return x/y;
		}
		return 0;
	}
	
	public float calculate_model1(float i,float j,float k,float t,int op1,int op2,int op3){

		float r1,r2,r3;                                           /*对应表达式类型：((A□B)□C)□D*/
		r1 = cal(i,j,op1);
		r2 = cal(r1,k,op2);
		r3 = cal(r2,t,op3);
		return r3;
	}
	
	public float calculate_model2(float i,float j,float k,float t,int op1,int op2,int op3){
		float r1,r2,r3;                                         /*对应表达式类型：(A□(B□C))□D */
		r1 = cal(j,k,op2);
		r2 = cal(i,r1,op1);
		r3 = cal(r2,t,op3);
		return r3;
	}
	
	public float calculate_model3(float i,float j,float k,float t,int op1,int op2,int op3){
		    float r1,r2,r3;                                     /*对应表达式类型：A□(B□(C□D))*/
		    r1 = cal(k,t,op3);
		    r2 = cal(j,r1,op2);
		    r3 = cal(i,r2,op1);
		    return r3;
	}
	
	public float calculate_model4(float i,float j,float k,float t,int op1,int op2,int op3){
		float r1,r2,r3;                                         /*对应表达式类型：A□((B□C)□D)*/
		r1 = cal(j,k,op2);
		r2 = cal(r1,t,op3);
		r3 = cal(i,r2,op1);
		return r3;
	}
	
	public float calculate_model5(float i,float j,float k,float t,int op1,int op2,int op3){
		float r1,r2,r3;                                            /*对应表达式类型：(A□B)□(C□D)*/
		r1 = cal(i,j,op1);
		r2 = cal(k,t,op3);
		r3 = cal(r1,r2,op2);
		return r3;
	}
	
	public boolean isGet24(int i,int j,int k,int t){                 //判断是否能得到24
		int op1,op2,op3;
		boolean flag=false;
		for(op1=1;op1<=4;op1++)
			for(op2=1;op2<=4;op2++)
				for(op3=1;op3<=4;op3++){
					if(calculate_model1(i,j,k,t,op1,op2,op3)==24)
						flag=true;
					if(calculate_model2(i,j,k,t,op1,op2,op3)==24)
						flag=true;
					if(calculate_model1(i,j,k,t,op1,op2,op3)==24)
						flag=true;
					if(calculate_model1(i,j,k,t,op1,op2,op3)==24)
						flag=true;
					if(calculate_model1(i,j,k,t,op1,op2,op3)==24)
						flag=true;
				}
		return flag;
	}
	
	public Game(){                                                     //构造函数 
		this.setLayout(null);
		this.init();
		
	}
			
	public static void main(String[] args) {
		new Game();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////内部类定义
	
	class fButtonEvent implements ActionListener{                                 //定义符号按钮的监视器类
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==fButtonJia){
				s+="+";
				text.setText(s);
			}
			if(e.getSource()==fButtonJian){
				s+="-";
				text.setText(s);
			}
			if(e.getSource()==fButtonChu){
				s+="/";
				text.setText(s);
			}
			if(e.getSource()==fButtonCheng){
				s+="*";
				text.setText(s);
			}
			if(e.getSource()==fButtonZKuo){
				s+="(";
				text.setText(s);
			}
			if(e.getSource()==fButtonYKuo){
				s+=")";
				text.setText(s);
			}
			
		}
	}
	
	class pButtonEvent implements ActionListener{                     //定义牌按钮的监视器类
		public void actionPerformed(ActionEvent e){
			if(e.getSource()==pButtonOne){
				s+=""+a;
				text.setText(s);
				pButtonOne.setEnabled(false);
			}
			if(e.getSource()==pButtonTwo){
				s+=""+b;
				text.setText(s);
				pButtonTwo.setEnabled(false);
			}
			if(e.getSource()==pButtonThree){
				s+=""+c;
				text.setText(s);
				pButtonThree.setEnabled(false);
			}
			if(e.getSource()==pButtonFour){
				s+=""+d;
				text.setText(s);
				pButtonFour.setEnabled(false);
			}
		}
	}
	
}
