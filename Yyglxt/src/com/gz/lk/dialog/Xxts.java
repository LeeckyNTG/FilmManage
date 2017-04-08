package com.gz.lk.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.ResourceManager;

public class Xxts extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public Xxts(Shell parent, int style) {
		super(parent, style);
		setText("消息提示");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String str,String str2) {
		createContents(str,str2);
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
	private void createContents(String str,String str2) {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setSize(331, 229);
		shell.setText(getText());
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		composite.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		composite.setBounds(0, 0, 341, 197);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel.setText(str);
		lblNewLabel.setBounds(57, 30, 182, 34);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(57, 70, 182, 34);
		lblNewLabel_1.setText(str2);
		
		
		Button button = new Button(composite, SWT.NONE);
		button.setBounds(204, 110, 80, 27);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		button.setText("\u786E\u5B9A");
	}	
}
