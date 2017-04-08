package com.gz.lk.editor;



import java.awt.geom.Arc2D.Double;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.gz.lk.dialog.FilmTicket;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.wb.swt.SWTResourceManager;



public class SeatEditor extends EditorPart implements IEditorInput{

	public static final String ID = "com.gz.lk.editor.SeatEditor"; //$NON-NLS-1$

	private int leftadd = 31;
	
	private int topadd =31 ;
	
	private int top = 80;//
	
	ArrayList<String[]> arr2;
	
	
	ArrayList<String> arr = new ArrayList<String> ();//定义个集合用来存储已经被选中的座位坐标
	
	String id;//传递过来的影片id
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	String ssje;
	
	String jz;
	
	public SeatEditor() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/1106021.jpg"));
		
		Button button = new Button(container, SWT.NONE);
		
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img.jpg"));
		button.setBounds(49, 10, 26, 25);
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img2.jpg"));
		button_1.setBounds(148, 10, 26, 25);
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img3.jpg"));
		button_2.setBounds(257, 10, 26, 25);
		
		Label label = new Label(container, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label.setBounds(81, 15, 61, 15);
		label.setText("\u53EF\u4EE5\u9009\u5EA7");
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_1.setBounds(190, 15, 61, 15);
		label_1.setText("\u5DF2\u552E\u51FA\u5EA7\u4F4D");
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_2.setBounds(297, 15, 61, 15);
		label_2.setText("\u5DF2\u9009\u5EA7\u4F4D");
		
		Group group = new Group(container, SWT.NONE);
		group.setText("\u7ED3\u8D26\u533A");
		group.setBounds(627, 32, 428, 563);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_3.setBounds(31, 152, 61, 17);
		label_3.setText("\u5F53\u524D\u603B\u989D\uFF1A");
		
		text = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(121, 149, 229, 23);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_4.setBounds(31, 66, 61, 17);
		label_4.setText("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode==13) {
					

					for (int i = 0; i < arr.size(); i++) {
						DB db = new DB();
						ArrayList<String []> arr1=db.arrQuery("select *from upfilm where id="+id);
						
		
						
						
						System.out.println(arr1.get(0)[7]);
						
			
						text.setText(arr1.get(0)[7]);
						
						String hynum=text_1.getText();
						
						double dz=1;
					
						ArrayList<String []> arr3=db.arrQuery("select *from vip where id ="+hynum);
						if (arr3.get(0)[4].equals("钻石")) {
							dz=0.8;
						}else 
							if (arr3.get(0)[4].equals("铂金")) {
								dz=0.85;
						}else if (arr3.get(0)[4].equals("黄金")) {
							dz=0.9;
						}else if (arr3.get(0)[4].equals("白银")) {
							dz=0.95;
							
						}else if (arr3.get(0)[4].equals("青铜")) {
							dz=0.98;
						}else if(arr3.get(0)[4].equals("游客")) {
							dz=1;
						}
						
						
						ssje=String.valueOf(java.lang.Double.parseDouble(arr1.get(0)[7])*dz);
					
						text_2.setText(String.valueOf(java.lang.Double.parseDouble(arr1.get(0)[7])*dz));
						
						
						double xj=java.lang.Double.parseDouble(text_3.getText());
						
						
						
						
						
						
					}
					
					
					
					
					
					
				}
				
				
				
				
			}
		});
		text_1.setBounds(121, 63, 229, 23);
		
		Label label_5 = new Label(group, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_5.setBounds(31, 236, 61, 17);
		label_5.setText("\u5B9E\u6536\u91D1\u989D\uFF1A");
		
		text_2 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(121, 230, 229, 23);
		
		Label label_6 = new Label(group, SWT.NONE);
		label_6.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		label_6.setBounds(31, 331, 61, 17);
		label_6.setText("\u6536\u53D6\u73B0\u91D1\uFF1A");
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode==13) {
					

					for (int i = 0; i < arr.size(); i++) {
						DB db = new DB();
						ArrayList<String []> arr1=db.arrQuery("select *from upfilm where id="+id);
						
		
						
						
						System.out.println(arr1.get(0)[7]);
						
			
						
						
						String hynum=text_1.getText();
						
						double dz=1;
						
						ArrayList<String []> arr3=db.arrQuery("select *from vip where id ="+hynum);
						if (arr3.get(0)[4].equals("钻石")) {
							dz=0.8;
						}else 
							if (arr3.get(0)[4].equals("铂金")) {
								dz=0.85;
						}else if (arr3.get(0)[4].equals("黄金")) {
							dz=0.9;
						}else if (arr3.get(0)[4].equals("白银")) {
							dz=0.95;
							
						}else if (arr3.get(0)[4].equals("青铜")) {
							dz=0.98;
						}else if(arr3.get(0)[4].equals("游客")) {
							dz=1;
						}
						
						
						jz=String.valueOf(java.lang.Double.parseDouble(arr1.get(0)[7])*dz);
						double xj1=java.lang.Double.parseDouble(arr1.get(0)[7])*dz;
					
						text_2.setText(jz);
						
						
						double xj=java.lang.Double.parseDouble(text_3.getText());
						
						if (xj-xj1>=0) {
							text_4.setText((xj-xj1)+"");
						}else {
							
							MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
							mb.setMessage("对不起，你的金额不足！");
							mb.setText("消息提示");
							mb.open();													
						}
					
					}
					
				}				
			}
		});
		text_3.setBounds(121, 331, 229, 23);
		
		Label label_7 = new Label(group, SWT.NONE);
		label_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_7.setBounds(31, 424, 61, 17);
		label_7.setText("\u627E       \u96F6\uFF1A");
		
		text_4 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(121, 418, 229, 23);
		
		Button button_5 = new Button(group, SWT.BORDER);
		button_5.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {      //结账
				
				
				
				String data = BuyTicket.data;//获取从show界面传递过来的信息
				String[] s = data.split("-");

				id=s[0];
				
				
				int rows = Integer.parseInt(s[1]);//获取数字字符串 转化成 int类型数据
				
				int cols = Integer.parseInt(s[2]);				
				for (int i = 0; i < arr.size(); i++) {
					DB db = new DB();
					ArrayList<String []> arr1=db.arrQuery("select *from upfilm where id="+id);
					
					Date dt=new Date();
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式"yyyy/MM/dd HH:mm:ss"
					String nowTime = df.format(dt);
					String sql = "INSERT INTO filmticket (seat,time,filmName,address,sid,price,buyTime)VALUES('"+arr.get(i)+"','"+arr1.get(0)[5]+"','"+arr1.get(0)[1]+"','第"+arr1.get(0)[2]+"大厅',"+id+",'"+jz+"','"+nowTime+"')";
					int s1=(int)java.lang.Double.parseDouble(jz);
					db.update(sql);
					ArrayList<String []> arrayList =db.arrQuery("select *from vip where id="+text_1.getText());
					db.update("update vip set integral="+(Integer.parseInt(arrayList.get(0)[3])+s1)+" where id="+text_1.getText());
					
					
					ArrayList<String []> array =db.arrQuery("select *from vip where id="+text_1.getText());
					
					if ((Integer.parseInt(array.get(0)[3])>10000)) {
						db.update("update vip set grade='钻石' where id="+text_1.getText());
					}
					if ((Integer.parseInt(array.get(0)[3])>5000)) {
						db.update("update vip set grade='铂金' where id="+text_1.getText());
					}
					if ((Integer.parseInt(array.get(0)[3])>3000)) {
						db.update("update vip set grade='黄金' where id="+text_1.getText());
					}
					if ((Integer.parseInt(array.get(0)[3])>2000)) {
						db.update("update vip set grade='白银' where id="+text_1.getText());
					}
				
					
					
					
					
					
					System.out.println("update vip set integral="+(Integer.parseInt(arrayList.get(0)[3])+s1)+" where id="+text_1.getText());
					
					//System.out.println("update vip set integral="+(Integer.parseInt(arrayList.get(0)[3])+jz)+"where id="+text_1.getText());
					ArrayList<String []> arr2=db.arrQuery("select *from filmticket where seat='"+arr.get(i)+"' and sid="+id);
					
					
					//System.out.println("select *from filmticket where seat='"+arr.get(i)+"' and sid="+id+"-------------------------------");
					String seat=arr2.get(0)[1];
					
					String [] s3=seat.split("-");
					
					int hang=((Integer.parseInt(s3[1])-80)/31)+1;
					int lie=((Integer.parseInt(s3[0])-49)/31)+1;
					
					
					
					
					System.out.println(hang+"--"+lie);
					FilmTicket ft=new FilmTicket(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
					String [] str={arr2.get(0)[3],arr2.get(0)[2],arr2.get(0)[4],"第"+hang+"行,第"+lie+"列。",arr2.get(0)[0]};
					
					ft.open(str);
					
					
					System.out.println(arr1.get(0)[7]);
					
					
					text.setText(arr1.get(0)[7]);
					
					
				
					
					
					String hynum=text_1.getText();
					
					double dz=1;
					
					ArrayList<String []> arr3=db.arrQuery("select *from vip where id ="+hynum);
					if (arr3.get(0)[4].equals("钻石")) {
						dz=0.8;
					}else 
						if (arr3.get(0)[4].equals("铂金")) {
							dz=0.85;
					}else if (arr3.get(0)[4].equals("黄金")) {
						dz=0.9;
					}else if (arr3.get(0)[4].equals("白银")) {
						dz=0.95;
						
					}else if (arr3.get(0)[4].equals("青铜")) {
						dz=0.98;
					}else if(arr3.get(0)[4].equals("游客")) {
						dz=1;
					}
					
																			
				//	ssje=String.valueOf(java.lang.Double.parseDouble(arr1.get(0)[7])*dz);
				
			//		text_2.setText(String.valueOf(java.lang.Double.parseDouble(arr1.get(0)[7])*dz));
					
					
					
					
				}
				
				
//				try {
//					
//					//--------------------------刷新editor-------------------------------------
//				//	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new SeatEditor(), SeatEditor.ID);//打开一个新的Seat座位的editor
//					
//				//	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(SeatEditor.this, true);//关闭自己
//					//--------------------------刷新editor-------------------------------------
//					
//				} catch (PartInitException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}//打开一个editor
//	
				
				
				
				
				
				MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				mb.setMessage("购票成功！");
				mb.setText("消息提示");
				mb.open();
				try {
					
					//--------------------------刷新editor-------------------------------------
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new SeatEditor(), SeatEditor.ID);//打开一个新的Seat座位的editor
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(SeatEditor.this, true);//关闭自己
					//--------------------------刷新editor-------------------------------------
					
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//打开一个editor
//	
				
				
			}
		});
		button_5.setBounds(303, 514, 80, 27);
		button_5.setText("\u7ED3\u8D26");
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setBounds(112, 103, 238, 17);
		lblNewLabel.setText("\u63D0\u793A\uFF1A\u5982\u679C\u6CA1\u6709\u4F1A\u5458\u5361\u8BF7\u8F93\u51654.\uFF08\u6E38\u5BA2\u8EAB\u4EFD\uFF09");
		
		
		
		String data = com.gz.lk.editor.BuyTicket.data;//获取从show界面传递过来的信息
		String[] s = data.split("-");

		id=s[0];
		
		
		int rows = Integer.parseInt(s[1]);//获取数字字符串 转化成 int类型数据
		
		int cols = Integer.parseInt(s[2]);
		
		
		
		
		
		//遍历座位
		//在遍历的时候 我得判断 哪些位置是已经被售出
		
		
		for (int i = 0; i < rows; i++) {
			
			for (int j = 0; j <cols; j++) {
				
				
				
				
				final Button button_3 = new Button(container, SWT.NONE);
				button_3.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img.jpg"));
				
				button_3.addSelectionListener(new SelectionAdapter() {
					
					private int state = 0 ; //设置一个变量 当state 等于0时 表示没被选中  1时 代表选中  （开关模式）
					
					
					@Override
					public void widgetSelected(SelectionEvent e) {
						
					
						
						String num = (String)button_3.getData();
						System.out.println(num+"=-----=-=-=-=-=-=-=-=-=-=-=-=-=-");
						if(num.equals("101")){//当num==101时 判断这个位置已经被选中了  不可在选
							return;
						}
						
						
						if(state==0){
							button_3.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img3.jpg"));
							state = 1;
							String data = (String)button_3.getData();//获取数据后 存储到【集合】当中统一管理
							arr.add(data);//把数据存储在arrylist当中
						}else if(state == 1){
							button_3.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img.jpg"));
							state = 0;
							String data  = (String)button_3.getData();
							
							if(arr.contains(data)){
								arr.remove(data);
							}//判断是否包含data座位的坐标
							
						}
					}
				});
				
				button_3.setBounds(49+j*leftadd, top, 26, 25);
				
				button_3.setData(49+j*leftadd +"-"+top);//向button按钮中增加数据（坐标）
				
				DB db = new DB();
				
				
				

				ArrayList<String[]> arrl = db.arrQuery("select seat from filmticket where sid ="+id);//查询到影片与之对应的座位的坐标
				
				for (int k = 0; k <arrl.size(); k++) {
					
					
					System.out.println(arrl.get(k)[0]+"-------"+(49+j*leftadd +"-"+top));
					if(arrl.get(k)[0].equals(49+j*leftadd +"-"+top)){
						button_3.setImage(ResourceManager.getPluginImage("Yyglxt", "img/sit_div_img2.jpg"));//变成灰色图片
						button_3.setData("101");//设置一个特殊的值 来判断是否还能点击
					}
				}
				
				
				
				
			}
//			      80
			top = top + topadd ;
			System.out.println();
			
		}
		
		
		
		

		
		
		
		
		
		
		
		
		
//		Button button_3 = new Button(container, SWT.NONE);
//		button_3.setImage(ResourceManager.getPluginImage("filmSystem", "img/sit_div_img.jpg"));
//		button_3.setBounds(49, 69, 26, 25);
//		
//		Button button_4 = new Button(container, SWT.NONE);
//		button_4.setImage(ResourceManager.getPluginImage("filmSystem", "img/sit_div_img.jpg"));
//		button_4.setBounds(81, 69, 26, 25);
//		
//		Button button_5 = new Button(container, SWT.NONE);
//		button_5.setImage(ResourceManager.getPluginImage("filmSystem", "img/sit_div_img.jpg"));
//		button_5.setBounds(49, 100, 26, 25);

	}
	
	
	
//	
//	public boolean equals(Object obj) {
//		boolean bEquals = false;
//		try {
//			if (obj != null && obj instanceof SeatEditor) {
//				if (getName().equals(((SeatEditor) obj).getName())) {
//					bEquals = true;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bEquals;
//	}


	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "text";
	}
}
