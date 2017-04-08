package com.gz.lk.dialog;


import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.tools.DB;

public class ckEmployee extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	Label lblNewLabel_1 ;
	private Button button;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ckEmployee(Shell parent, int style) {
		super(parent, style);
		setText("查看员工信息");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String str) {
		createContents(str);
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
	private void createContents(String str) {
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
		label_1.setBounds(46, 106, 73, 17);
		label_1.setText("\u767B\u5F55\u5BC6\u7801\uFF1A");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(46, 102+50, 61, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(46, 102+(50*2), 61, 17);
		label_2.setText("\u6027\u522B\uFF1A");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(46, 102+(50*3), 73, 17);
		label_3.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(46, 102+(50*4), 73, 17);
		label_4.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_5.setBounds(46, 102+(50*5), 61, 17);
		label_5.setText("\u4F4F\u5740\uFF1A");
		
		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		
		text.setBounds(145, 56, 234, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(145, 102, 234, 23);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(145, 150, 234, 23);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(145, 200, 234, 23);
		
		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(145, 250, 234, 23);
		
		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(145, 300, 234, 23);
		
		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(145, 350, 234, 23);
		
		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_1.setBounds(471, 56, 225, 276);
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from user where id="+str);
		text.setText(arr.get(0)[1]);
		text_1.setText(arr.get(0)[2]);
		text_2.setText(arr.get(0)[4]);
		text_3.setText(arr.get(0)[5]);
		text_4.setText(arr.get(0)[6]);
		text_5.setText(arr.get(0)[7]);
		text_6.setText(arr.get(0)[8]);
		String imgName=arr.get(0)[9];
		lblNewLabel_1.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName+""));
		
		button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button.setBounds(616, 348, 80, 27);
		button.setText("\u786E\u5B9A");
		
	}
}
