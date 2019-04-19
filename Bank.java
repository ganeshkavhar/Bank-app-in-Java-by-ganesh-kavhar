Code :</p>
<p>/**********************************************************</p>
<p>*     Program to create GUI for Bank Account Simulation.   *</p>
<p>***********************************************************/</p>
<p>import java.awt.*;<br />
import java.awt.event.*;<br />
import javax.swing.*;<br />
class GuiAccTest extends Frame implements ActionListener<br />
{<br />
        Label lab=new Label(” “);<br />
        Label lab1=new Label(” “);<br />
        TextField t[]=new TextField [4];<br />
        Label l[]=new Label [4];<br />
        Button but=new Button(“Create Account”);<br />
        Button but1=new Button(“Test Account”);<br />
        BankAccount b;<br />
        GuiAccTest()<br />
        {<br />
                addWindowListener(new NewWindowAdapter());<br />
                setLayout(new GridLayout(2,0));<br />
                Panel p=new Panel();<br />
                Panel p1=new Panel();<br />
                but.addActionListener(this);<br />
                but1.addActionListener(this);<br />
                p.setLayout(new GridLayout(5,2));<br />
                p1.add(lab1);<br />
                p1.add(lab);<br />
                l[0]=new Label(“Account Number”);<br />
                l[1]=new Label(“Initial Balance”);<br />
                l[2]=new Label(“Deposit Amount”);<br />
                l[3]=new Label(“Withdraw Amount”);<br />
                for(int i=0;i<4;i++)<br />
                {<br />
                        t[i]=new TextField(10);<br />
                        p.add(l[i]);<br />
                        p.add(t[i]);<br />
                }<br />
                p.add(but);<br />
                p.add(but1);<br />
                but1.setVisible(false);<br />
                l[2].setVisible(false);<br />
                l[3].setVisible(false);<br />
                t[2].setVisible(false);<br />
                t[3].setVisible(false);<br />
                add(p);<br />
                add(p1);<br />
        }<br />
        String testAccount(int d_amt,int w_amt)<br />
        {<br />
                String msg;<br />
                b.deposit(d_amt);<br />
                msg=”Transaction Succesful”;<br />
                try<br />
                {<br />
                        b.withdraw(w_amt);<br />
                }catch(FundsInsufficientException fe)<br />
                {<br />
                        fe=new<br />
FundsInsufficientException(b.amount,w_amt);<br />
                        msg=String.valueOf(fe);<br />
                }<br />
                return msg;<br />
        }<br />
        public void actionPerformed(ActionEvent ae)<br />
        {<br />
                String str=ae.getActionCommand();<br />
                if(str.equals(“Create Account”))<br />
                {<br />
                        b=new<br />
BankAccount(Integer.parseInt(t[0].getText()),<br />
            Integer.parseInt(t[1].getText()));<br />
                        but1.setVisible(true);<br />
                        l[2].setVisible(true);<br />
                        l[3].setVisible(true);<br />
                        t[2].setVisible(true);<br />
                        t[3].setVisible(true);<br />
                        but.setVisible(false);<br />
                        l[0].setVisible(false);<br />
                        l[1].setVisible(false);<br />
                        t[0].setVisible(false);<br />
                        t[1].setVisible(false);<br />
                        lab1.setText(“Account : “+b.accnum+”, Current<br />
Balance : “+b.amount);<br />
                        return;<br />
                }<br />
                else<br />
                {</p>
<p>lab.setText(testAccount(Integer.parseInt(t[2].getText()),<br />
Integer.parseInt(t[3].getText())));<br />
                        lab1.setText(“Account : “+b.accnum+”, Current<br />
Balance : “+b.amount);<br />
                }<br />
        }<br />
        public static void main(String arg[])<br />
        {<br />
                GuiAccTest at=new GuiAccTest();<br />
                at.setTitle(“Bank Account Tester”);<br />
                at.setSize(600,200);<br />
                at.setVisible(true);<br />
        }<br />
}<br />
class NewWindowAdapter extends WindowAdapter<br />
{<br />
        public void windowClosing(WindowEvent we)<br />
        {<br />
                System.exit(0);<br />
        }<br />
}<br />
class BankAccount<br />
{<br />
        int accnum;<br />
        int amount;<br />
        BankAccount(int num,int amt)<br />
        {<br />
                accnum=num;<br />
                amount=amt;<br />
        }<br />
        public void deposit(int amt)<br />
        {<br />
                amount=amount+amt;<br />
        }<br />
        public void withdraw(int amt) throws FundsInsufficientException<br />
        {<br />
                if(amt>amount)<br />
                        throw new<br />
FundsInsufficientException(amount,amt);<br />
                else<br />
                        amount=amount-amt;<br />
        }<br />
}<br />
class FundsInsufficientException extends Exception<br />
{<br />
        int balance;<br />
        int withdraw_amount;<br />
        FundsInsufficientException(int bal,int w_amt)<br />
        {<br />
                balance=bal;<br />
                withdraw_amount=w_amt;<br />
        }<br />
        public String toString()<br />
        {<br />
                return “Your withdraw amount (“+withdraw_amount+”) is<br />
less<br />
than the balance (“+balance+”). No withdrawal was recorded.”;<br />
        }<br />
}</p>
<p>
