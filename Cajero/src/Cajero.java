
import javax.swing.*;
import cajero.GUI_Cajero;

public class Cajero extends GUI_Cajero {

    public static void main(String[] args) {
        
        
        
        int contador;
        contador=0;
        JPanel panel =new JPanel ();
    	JLabel label = new JLabel();
        JPasswordField pwd = new JPasswordField(10);
    	JOptionPane dialogo= new JOptionPane();
    	panel.add(label);
    	panel.add(pwd);
    	String[] options = new String [] {"Aceptar", "Cancelar"};
        
    	int action = dialogo.showOptionDialog(null, panel, "Ingresar contrase�a",JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
    	char []password=pwd.getPassword();
    	if (action==0){
    		if( "0000".equals(new String(password))) {
    			
    			GUI_Cajero unaCuenta = new GUI_Cajero();
    			unaCuenta.setVisible(true);                  
                
                } else {
                    JOptionPane.showMessageDialog(null,"�Error! Reintente ");
                    
                }
                }
        
        }
    		
        
 
    
  }
    

