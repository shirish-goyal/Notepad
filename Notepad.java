import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
class note extends Frame implements ActionListener
{
    MenuBar m;
    Menu me[]=new Menu[5];
    MenuItem i1[]=new MenuItem[7];
    MenuItem i2[]=new MenuItem[11];
    MenuItem i3[]=new MenuItem[2];   
    MenuItem i4;
    MenuItem i5[]=new MenuItem[3];
    TextArea t;
    public note()
    {
        t=new TextArea();
        setTitle("Untitled");
        m=new MenuBar();
        me[0]=new Menu("File");
        me[1]=new Menu("Edit");
        me[2]=new Menu("Format");
        me[3]=new Menu("View");
        me[4]=new Menu("Help");
        i1[0]=new MenuItem("New");
        i1[1]=new MenuItem("Open");
        i1[2]=new MenuItem("Save");
        i1[3]=new MenuItem("SaveAs");
        i1[4]=new MenuItem("PageSetup");
        i1[5]=new MenuItem("Print");
        i1[6]=new MenuItem("Exit");
        i2[0]=new MenuItem("Undo");
        i2[1]=new MenuItem("Cut");
        i2[2]=new MenuItem("Copy");
        i2[3]=new MenuItem("Paste");
        i2[4]=new MenuItem("Delete");
        i2[5]=new MenuItem("Find");
        i2[6]=new MenuItem("FindNext");
        i2[7]=new MenuItem("Replace");
        i2[8]=new MenuItem("GoTo");
        i2[9]=new MenuItem("SelectAll");
        i2[10]=new MenuItem("Time/Date");
        i3[0]=new CheckboxMenuItem("WordWrap");
        i3[1]=new MenuItem("Font");
        i4=new MenuItem("StatusBar");
        i5[0]=new MenuItem("ViewHelp");
        i5[1]=new MenuItem("About");
        setMenuBar(m);
        for(int i=0;i<5;i++)
            m.add(me[i]);
        for(int i=0;i<7;i++)
            me[0].add(i1[i]);
        for(int i=0;i<11;i++)
            me[1].add(i2[i]);
        for(int i=0;i<2;i++)
            me[2].add(i3[i]);
        me[3].add(i4);
        for(int i=0;i<2;i++)
            me[4].add(i5[i]);
        add(t);
        for(int i=0;i<7;i++)
            i1[i].addActionListener(this);
        for(int i=0;i<11;i++)
            i2[i].addActionListener(this);
        for(int i=0;i<2;i++)
            i3[i].addActionListener(this);
        i4.addActionListener(this);
        for(int i=0;i<2;i++)
            i5[i].addActionListener(this);
	addWindowListener(new c5(this));
    }
    String str1="";
    String str2="";
    public void actionPerformed(ActionEvent ae)
    {
        String str=ae.getActionCommand();
        if(str.equals("New"))
        {
            t.setText("");
            setTitle("Untitled");
        }
        else if(str.equals("Open"))
        {
            try
            {
                FileDialog f1=new FileDialog(this,"Open",FileDialog.LOAD);
                f1.setVisible(true);
                String s1=f1.getDirectory()+f1.getFile();
		this.setTitle(f1.getFile());
                FileInputStream f=new FileInputStream(s1);
                int x=f.available();
                String s2="";
                for(int i=0;i<x;i++)
                    s2+=(char)f.read();
                t.setText(s2);
                f.close();
            }
            catch(Exception e)
            {}
        }
        else if(str.equals("Save"))
        {
            if(this.getTitle().toString().equals("Untitled"))
            {
                try
                {
                    FileDialog f1=new FileDialog(this,"Save",FileDialog.SAVE);
                    f1.setVisible(true);
                    String s1=f1.getDirectory()+f1.getFile();
                    FileOutputStream f=new FileOutputStream(s1);
                    String s2=t.getText();
                    byte b[]=s2.getBytes();
                    for(int i=0;i<b.length;i++)
                        f.write(b[i]);
                    this.setTitle(s1);
                    f.close();
                }
                catch(Exception e)
                {}
            }
            else
            {
                 try
                {
                    String s1=getTitle();
                    FileOutputStream f=new FileOutputStream(s1);
                    String s2=t.getText();
                    byte b[]=s2.getBytes();
                    for(int i=0;i<b.length;i++)
                        f.write(b[i]);
                    this.setTitle(s1);
                    f.close();
                }
                catch(Exception e)
                {}
            }
        }
        else if(str.equals("SaveAs"))
        {
            try
                {
                    FileDialog f1=new FileDialog(this,"Save",FileDialog.SAVE);
                    f1.setVisible(true);
                    String s1=f1.getDirectory()+f1.getFile();
                    FileOutputStream f=new FileOutputStream(s1);
                    String s2=t.getText();
                    byte b[]=s2.getBytes();
                    for(int i=0;i<b.length;i++)
                        f.write(b[i]);
                    this.setTitle(s1);
                    f.close();
                }
                catch(Exception e)
                {}
        }
        else if(str.equals("Exit"))
            this.dispose();
        else if(str.equals("Cut"))
        {
            str2=t.getText();
            str1=t.getSelectedText();
            String s=t.getText();
            int x=s.indexOf(str1);
            if(x<0)
            {}
            else
            {
                t.setText(t.getText().substring(0,x)+t.getText().substring(x+str1.length()));
            }
        }
        else if(str.equals("Copy"))
            str1=t.getSelectedText();
        else if(str.equals("Paste"))
        {
            str2=t.getText();
            t.insert(str1,t.getCaretPosition());
        }
        else if(str.equals("Delete"))
        {
            str2=t.getText();
            str1=t.getSelectedText();
            String s=t.getText();
            int x=s.indexOf(str1);
            if(x<0)
            {}
            else
            {
                t.setText(t.getText().substring(0,x)+t.getText().substring(x+str1.length()));
            }
        }
        else if(str.equals("SelectAll"))
            t.select(0,t.getText().length());
        else if(str.equals("Undo"))
            t.setText(str2);
	else if(str.equals("Find"))
	{
	    find k=new find(this,"Find",false);
	    k.setResizable(false);
	    k.setSize(490,172);
	    k.setVisible(true);
	}
	else if(str.equals("Replace"))
	{
	    replace k=new replace(this,"Replace",false);
	    k.setResizable(false);
	    k.setSize(490,200);
	    k.setVisible(true);
	}
	else if(str.equals("Font"))
	{
	    font k=new font(this,"Font",true);
	    k.setResizable(false);
	    k.setSize(350,230);
	    k.setVisible(true);
	}
    }
}
class font extends JDialog
{
note k;
JLabel l[]=new JLabel[3];
Choice c[]=new Choice[3];
JButton b[]=new JButton[2];
public font(note p,String tit,boolean tt)
{
super(p,tit,tt);
k=p;
l[0]=new JLabel("Color");
l[1]=new JLabel("Size");
l[2]=new JLabel("Style");
b[0]=new JButton("Submit");
b[1]=new JButton("Cancel");
for(int i=0;i<3;i++)
c[i]=new Choice();
c[0].add("red");
c[0].add("yellow");
c[0].add("blue");
c[0].add("green");
c[1].add("10");
c[1].add("20");
c[1].add("30");
c[1].add("40");
c[2].add("Regular");
c[2].add("Italic");
c[2].add("Bold");
c[2].add("BoldItalic");
setLayout(null);
Container cc=getContentPane();
for(int i=0;i<3;i++)
{
cc.add(l[i]);
cc.add(c[i]);
if(i==2)
continue;
cc.add(b[i]);
}
l[0].setBounds(20,20,40,20);
c[0].setBounds(80,20,250,20);
l[1].setBounds(20,60,40,20);
c[1].setBounds(80,60,250,20);
l[2].setBounds(20,100,40,20);
c[2].setBounds(80,100,250,20);
b[0].setBounds(110,150,100,20);
b[1].setBounds(230,150,100,20);
addWindowListener(new c3(this));
}
}
class c3 extends WindowAdapter
{
font k;
public c3(font p)
{
k=p;
}
public void windowClosing(WindowEvent we)
{
k.dispose();
}
}
class replace extends Dialog
{
Button b[]=new Button[4];
TextField t[]=new TextField[2];
Label l[]=new Label[2];
Checkbox c;
public replace(note p,String tit,boolean tt)
{
super(p,tit,tt);
c=new Checkbox("Match Case");
l[0]=new Label("Find what:   ");
l[1]=new Label("Replace with:");
t[0]=new TextField(15);
t[1]=new TextField(15);
b[0]=new Button("Find Next");
b[1]=new Button("Replace");
b[2]=new Button("Replace All");
b[3]=new Button("Cancel");
setLayout(null);
for(int i=0;i<2;i++)
{
	add(l[i]);
	add(t[i]);
}
for(int i=0;i<4;i++)
	add(b[i]);
add(c);
l[0].setBounds(20,60,80,20);
t[0].setBounds(100,60,290,20);
b[0].setBounds(400,60,80,20);
l[1].setBounds(20,100,80,20);
t[1].setBounds(100,100,290,20);
b[1].setBounds(400,90,80,20);
b[2].setBounds(400,120,80,20);
b[3].setBounds(400,150,80,20);
c.setBounds(20,170,80,20);
addWindowListener(new c6(this));
}
}
class c6 extends WindowAdapter
{
replace k;
public c6(replace p)
{
k=p;
}
public void windowClosing(WindowEvent we)
{
k.dispose();
}
}
class find extends Dialog
{
Button b1,b2;
TextField t1;
Label l1,l2;
Checkbox c,c1,c2;
CheckboxGroup cg;
public find(note p,String tit,boolean tt)
{
super(p,tit,tt);
c=new Checkbox("Match Case");
cg=new CheckboxGroup();
c1=new Checkbox("Up",cg,false);
c2=new Checkbox("Down",cg,true);
b1=new Button("Find Next");
b2=new Button("Close");
t1=new TextField(40);
l1=new Label("Find What:   ");
setLayout(null);
add(l1);
add(t1);
add(b1);
add(b2);
add(c);
add(c1);
add(c2);
l1.setBounds(20,60,80,20);
t1.setBounds(100,60,290,20);
b1.setBounds(400,60,80,20);
b2.setBounds(400,90,80,20);
c.setBounds(20,140,80,20);
c1.setBounds(245,130,40,20);
c2.setBounds(295,130,50,20);
addWindowListener(new c4(this));
}

}
class c4 extends WindowAdapter
{
find k;
public c4(find p)
{
k=p;
}
public void windowClosing(WindowEvent we)
{
k.dispose();
}
}

class c5 extends WindowAdapter
{
note l;
public c5(note p)
{
l=p;
}
public void windowClosing(WindowEvent we)
{
l.dispose();
}
}
public class Notepad {

    public static void main(String[] args) {
        note p=new note();
        p.setSize(500,500);
        p.setVisible(true);
    }
    
}
