package com.gz.lk.dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import com.gz.lk.core.Activator;
import com.gz.lk.tools.pd;

public class addEmployee extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	Label lblNewLabel_1 ;
	String str1;
	String target;
	private Button button_1;
	
	Button button_2;
	Button button_3;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public addEmployee(Shell parent, int style) {
		super(parent, style);
		setText("增加员工");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
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
		shell = new Shell(getParent(), SWT.DIALOG_TRIM);
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/1134372.jpg"));
		shell.setSize(817, 499);
		shell.setText(getText());
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label.setBounds(46, 56, 61, 17);
		label.setText("\u7528\u6237\u540D\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_1.setBounds(46, 102, 61, 17);
		label_1.setText("\u767B\u5F55\u5BC6\u7801\uFF1A");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(46, 149, 61, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(46, 204, 61, 17);
		label_2.setText("\u6027\u522B\uFF1A");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(46, 256, 61, 17);
		label_3.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(46, 309, 61, 17);
		label_4.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		label_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_5.setBounds(46, 364, 61, 17);
		label_5.setText("\u4F4F\u5740\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(145, 56, 234, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(145, 102, 234, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(145, 149, 234, 23);
		
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(145, 256, 234, 23);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(145, 309, 234, 23);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(145, 364, 234, 23);
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_1.setBounds(471, 56, 225, 276);
		
		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				String str=fd.open();//获取文件路径
				
				lblNewLabel_1.setImage(SWTResourceManager.getImage(str));//////
				
				
				URL url = Activator.getDefault().getBundle().getResource("img");
				try {
					String targetPath = FileLocator.toFileURL(url).toString();
					
					String hz=str.substring(str.lastIndexOf("."));
					
					long wjm=new Date().getTime();
					target=targetPath.substring(6);
					str1=wjm+hz;												
					FileInputStream fis=new FileInputStream(str);
					FileOutputStream fos=new FileOutputStream(targetPath.substring(6)+wjm+hz);
					
					
					String target=targetPath.substring(6)+wjm+hz;
					System.out.println(target);
					
					byte [] b=new byte[1024];
					
					int num=0;
					while ((num=fis.read(b))!=-1) {
						fos.write(b,0,num);
					}	
					fis.close();
					fos.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
		
			}
		});
		button.setBounds(616, 349, 94, 27);
		button.setText("\u4E0A\u4F20\u56FE\u7247");
		
		button_1 = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String userName=text.getText();
				
				String password=text_1.getText();
				
				String name=text_2.getText();
				
				String sex;
				
				if (button_2.getSelection()) {
					sex=button_2.getText();
				}else {
					sex=button_3.getText();
				}
				pd pd=new pd();
				
				String tel=text_4.getText();
			
				
				String iDcard=text_5.getText();
				
				
				String address=text_6.getText();

				boolean bol=true;
				if (pd.isNumber(tel)&&pd.isNumber(iDcard)) {
					
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("insert into user (userName,password,limits,name,sex,tel,iDcard,address,imgName)values ('"+userName+"','"+password+"','"+2+"','"+name+"','"+sex+"','"+tel+"','"+iDcard+"','"+address+"','"+str1+"')");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yyglxt","root","mysql");
					PreparedStatement ps=con.prepareStatement("insert into user (userName,password,limits,name,sex,tel,iDcard,address,imgName,img)values (?,?,?,?,?,?,?,?,?,?)");
					FileInputStream fis;
					if (target!=null) {
						fis =new FileInputStream(target+str1);
					}else {
						fis =new FileInputStream("icons/alt_about.gif");
					}
					
					
					
					ps.setString(1, userName);
					
					ps.setString(2, password);
					
					
					
					ps.setString(3, "2");
					
					ps.setString(4, name);
					ps.setString(5, sex);
					ps.setString(6, tel);
					ps.setString(7, iDcard);
					ps.setString(8, address);
					ps.setString(9, str1);
					
					
					ps.setBinaryStream(10, fis,fis.available());
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
					
					shell.close();	
				}
				
				
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("消息提示");
					mb.setMessage("你输入的数据格式不对，请重新输入！");
					mb.open();
				}
				
				
				
				
				
			
				
			}
		});
		button_1.setBounds(586, 433, 110, 27);
		button_1.setText("\u786E\u5B9A\u6DFB\u52A0\u4FE1\u606F");
		
		button_2 = new Button(shell, SWT.RADIO);
		button_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		button_2.setBounds(145, 204, 54, 17);
		button_2.setText("\u7537");
		
		button_3 = new Button(shell, SWT.RADIO);
		button_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_3.setBounds(318, 204, 61, 17);
		button_3.setText("\u5973");
		
	
		

	}
}
