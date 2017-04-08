package com.gz.lk.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;

public class Addyt extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Addyt(Shell parent, int style) {
		super(parent, style);
		setText("添加影厅");
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
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(255, 255, 255));
		label.setFont(SWTResourceManager.getFont("华文行楷", 16, SWT.NORMAL));
		label.setBounds(162, 10, 102, 23);
		label.setText("\u6DFB\u52A0\u5F71\u5385");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(59, 107, 61, 17);
		label_1.setText("\u79CD\u7C7B\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(126, 104, 158, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(59, 157, 61, 17);
		label_2.setText("\u89C4\u683C\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(126, 154, 31, 23);
		
		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 8, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name="第"+text_2.getText()+"影厅";
				String kind=text.getText();
				String seating=text_1.getText()+"-"+text_3.getText();
				DB db=new DB();
				int i=db.update("insert into fyt (name,kind,seating) values ('"+name+"','"+kind+"','"+seating+"')");
				if (i>0) {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("添加成功！");
					mb.open();
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("添加失败！");
					mb.open();
				}
				shell.close();
			}
		});
		button.setBounds(277, 221, 68, 27);
		button.setText("\u786E\u5B9A\u6DFB\u52A0");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(0, 0, 0));
		label_3.setBounds(59, 58, 61, 17);
		label_3.setText("\u5F71\u5385\u540D\uFF1A");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(162, 55, 64, 23);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setForeground(SWTResourceManager.getColor(255, 255, 0));
		label_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_4.setBounds(140, 54, 22, 21);
		label_4.setText("\u7B2C");
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setForeground(SWTResourceManager.getColor(255, 255, 0));
		label_5.setText("\u5F71\u5385");
		label_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label_5.setBounds(232, 54, 52, 21);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 255, 0));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 18, SWT.NORMAL));
		lblNewLabel_1.setBounds(193, 154, 22, 23);
		lblNewLabel_1.setText("*");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(253, 154, 31, 23);

	}
}
