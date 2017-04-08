package com.gz.lk.dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;

import com.gz.lk.core.Activator;
import com.gz.lk.tools.DB;
import com.gz.lk.tools.pd;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Button;

public class xgEmployee extends Dialog {

	protected Object result;
	protected Shell shell;
	
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	Label lblNewLabel_1 ;
	String str;
	String target;
	String id;
	String imgname;
	private Button button;
	private Button button_1;
	private Button button_2;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public xgEmployee(Shell parent, int style) {
		super(parent, style);
		setText("修改信息");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String str) {
		
		this.str = str;
		
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setSize(817, 499);
		shell.setText(getText());
		
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label.setBounds(46, 56, 61, 17);
		label.setText("\u7528\u6237\u540D\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_1.setBounds(46, 102, 61, 17);
		label_1.setText("\u767B\u5F55\u5BC6\u7801\uFF1A");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(46, 149, 61, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(46, 204, 61, 17);
		label_2.setText("\u6027\u522B\uFF1A");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(46, 256, 61, 17);
		label_3.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(46, 309, 61, 17);
		label_4.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_5.setBounds(46, 364, 61, 17);
		label_5.setText("\u4F4F\u5740\uFF1A");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(145, 56, 234, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(145, 99, 234, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(145, 149, 234, 23);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(145, 256, 234, 23);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(145, 309, 234, 23);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(145, 364, 234, 23);
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_1.setBounds(471, 56, 225, 276);
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select * from user where id="+str);
		
		System.out.println("select * from user where id="+str+"     =====");
		
		text.setText(arr.get(0)[1]);
		text_1.setText(arr.get(0)[2]);
		text_2.setText(arr.get(0)[4]);
		text_4.setText(arr.get(0)[6]);
		text_5.setText(arr.get(0)[7]);
		text_6.setText(arr.get(0)[8]);
		String imgName=arr.get(0)[9];
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName+""));
		
		Link link = new Link(shell, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("楷体", 9, SWT.NORMAL));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				String str = fd.open();//源路径

				lblNewLabel_1.setImage(SWTResourceManager.getImage(str));//让选中 的图片显示在label中
				try {
					
					URL url = Activator.getDefault().getBundle().getResource("img");//获取url对象   uniform  resource   locator  统一资源定位器
					String targetPath = FileLocator.toFileURL(url).toString();
					System.out.println(targetPath.substring(6));
					//给目标文件起名字
					String t = str.substring(str.lastIndexOf("."));//找到.最后一次出现的位置
					
					
					imgname = new Date().getTime()+t;//获取图片名称
					
					
					System.out.println("名字是："+targetPath.substring(6)+new Date().getTime()+t); //获取名字同时要获取上传文件的后缀名
					
					target =targetPath.substring(6)+new Date().getTime()+t;//
					
					
					FileInputStream fis = new FileInputStream(str);//输入流 指向源 从源中拉取数据
					FileOutputStream fos = new FileOutputStream(target);//输出流 指向目标  向目标写入数据
					
					
					byte[] b = new byte[1024];
					int num = 0;
					while((num = fis.read(b))!=-1){
						fos.write(b, 0, num);
					}
					
					
					fis.close();
					fos.close();
					
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			}
		});
		link.setBounds(635, 364, 61, 17);
		link.setText("<a>\u66F4\u6539\u56FE\u7247</a>");
		
		
		button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String userName=text.getText();
				
				String password=text_1.getText();
				
				String name=text_2.getText();
				
				String sex;
				
				if (button_1.getSelection()) {
					sex=button_1.getText();
				}else {
					sex=button_2.getText();
				}

				
				String tel=text_4.getText();
				
				String iDcard=text_5.getText();
				
				String address=text_6.getText();

				boolean bol=true;
				
				pd pd=new pd();
				if (pd.isNumber(tel)&&pd.isNumber(iDcard)) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yyglxt","root","mysql");
					PreparedStatement ps=con.prepareStatement("update user set userName=?,password=?,name=?,sex=?,tel=?,iDcard=?,address=?,imgName=?,img=? where id="+str);
					FileInputStream fis =new FileInputStream(target);
					ps.setString(1, userName);
					
					ps.setString(2, password);
					
					
					ps.setString(3, name);
					ps.setString(4, sex);
					ps.setString(5, tel);
					ps.setString(6, iDcard);
					ps.setString(7, address);
					ps.setString(8, imgname);
					ps.setBinaryStream(9, fis,fis.available());	
					
					bol=ps.execute();
					
					System.out.println(bol);					
					con.close();
					fis.close();
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					if (!bol) {
						MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("保存成功");
						mb.open();
					}else {
						MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("保存失败！请检查数据。");
						mb.open();
					}
				}
	
			shell.close();	
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("消息提示");
					mb.setMessage("你输入的数据格式不对，请重新输入！");
					mb.open();
				}
			}
		});
		button.setBounds(616, 430, 80, 27);
		button.setText("\u786E\u5B9A\u4FEE\u6539");
		
		button_1 = new Button(shell, SWT.RADIO);
		button_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_1.setBounds(145, 204, 54, 17);
		button_1.setText("\u7537");
		
		button_2 = new Button(shell, SWT.RADIO);
		button_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_2.setBounds(303, 204, 46, 17);
		button_2.setText("\u5973");
		
		
		

	}
}
