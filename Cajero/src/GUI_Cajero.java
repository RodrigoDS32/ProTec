
package cajero;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class GUI_Cajero extends JFrame {
   float saldo=1000;
   
  
    private final Container contenedor;
    private final JPanel paneldeacciones;
    private final JPanel panelsaldo;
    private final JButton Consultar;
    private JButton Retirar, Depositar;
    
    public GUI_Cajero (){
        
        contenedor = getContentPane();
        paneldeacciones = new JPanel();
        panelsaldo = new   JPanel();
        Depositar = new JButton ();
        Retirar = new JButton ();
        Consultar = new JButton();
        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        construirInterfaz();
        setLocationRelativeTo(null);
        
    }
    public  void construirInterfaz(){
        //Apariencias de los botones
        Depositar.setText("Depositar");
        Depositar.setPreferredSize(new Dimension (130, 50));
        Depositar.setSize(140, 40);
        
        //Depositar.setBorder(BorderFactory.createCompoundBorde(new LineBorder (new java.awt.Color(0,0,0), 1, false), null));
        Retirar.setText("Retirar");
        Retirar.setPreferredSize(new Dimension (130, 50));
        //Extraer.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new java.awt.Color(0,0,0), 1, false), null));
        Consultar.setText("Consultar Saldo");
        Consultar.setPreferredSize(new Dimension (130, 50));
        Consultar.setSize(140,40);
        Consultar.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        
        //creacion de oyentes
        
        OyenteDepositar oDepositar= new OyenteDepositar();
        OyenteRetirar oRetirar= new OyenteRetirar();
        OyenteConsultar oConsultar = new OyenteConsultar();
        
        //Registro de oyentes
        Depositar.addActionListener((ActionListener) oDepositar);
        Retirar.addActionListener((ActionListener) oRetirar);
        Consultar.addActionListener((ActionListener) oConsultar);
        
        //Layout del panel contenedor 
        contenedor.setLayout(new BorderLayout());
        //Panel de acciones 
        paneldeacciones.setBorder(BorderFactory.createEtchedBorder(BevelBorder.LOWERED));
        paneldeacciones.setPreferredSize(new Dimension (170, 140));
        paneldeacciones.setSize(150, 130);
        //Colocar botones a los paneles
        paneldeacciones.add(Depositar);
        paneldeacciones.add(Retirar);
        panelsaldo.add(Consultar);
        //Colocar paneles al contenedor
        contenedor.add(paneldeacciones, BorderLayout.NORTH);
        contenedor.add(panelsaldo, BorderLayout.SOUTH);
        
    }
    private class OyenteDepositar implements ActionListener{

        
        public void actionPerformed(ActionEvent e) {
            float dep;
           String  deposito;
           JOptionPane dia= new JOptionPane();
           deposito=dia.showInputDialog("Introduzca la cantidad:");
           if ((deposito!=null)&&(deposito.length()>0)){
               dep=Float.parseFloat(deposito);
               dia.showMessageDialog(null, "Usted depositó: "+dep+" pesos", "Depósito",JOptionPane.PLAIN_MESSAGE);
                saldo=saldo+dep;
           }
           
            
        }
    }
    private class OyenteConsultar implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent a) {
            
            JOptionPane dia = new JOptionPane();
            if(saldo>=0){
                JOptionPane.showMessageDialog(null, "Usted Tiene un saldo de: "+ saldo+ " pesos", "Saldo", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Usted está en rojo, saldo actual de: "+saldo+" pesos", "Saldo", JOptionPane.ERROR_MESSAGE);
            }
        
        }
    }

    private class OyenteRetirar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
           int ext;
           int mil=0, quinientos=0, docientos=0, cien=0, cincuenta=0, veinte=0;
           float residuo = 0;
           String extraccion;
           JOptionPane dia=new JOptionPane();
           extraccion=dia.showInputDialog("Ingrese la cantidad a retirar: ");
          
           if((extraccion!=null)&&(extraccion.length()>0)){
               ext = Integer.parseInt(extraccion);;
               
               if(ext>8000){
                   dia.showMessageDialog( null, "Usted NO puede retirar esa cantidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
               }else{
                   if(ext%50==0){
                       saldo=saldo-ext;
                       mil=(ext/2)/1000;
                       ext=ext-(mil*1000);
                       quinientos=(ext/2)/500;
                       ext=ext-(quinientos*500);
                       docientos=(ext/)/200;
                       ext=ext-(docientos*200);
                       cien=ext/100;
                       ext=ext-(cien*100);
                       cincuenta=ext/50;
                       ext=ext-(cincuenta*50);
                       veinte=ext/20;
                       ext=ext-(veinte*20);
                       
                                              
                       JOptionPane.showMessageDialog(null, "Usted extrajo: \n"+mil+" Billetes de Mil\n"
                                                                              +quinientos+" Billetes de Quinientos\n"
                                                                              +docientos+" Billetes de Docientos\n"
                                                                              +cien+" Billetes de Cien\n"
                                                                              +cincuenta+ "Billetes de cincuenta\n"
                                                                              +veinte+ "Billetes de veinte"\n, "Extraccion", JOptionPane.PLAIN_MESSAGE  );
                       
                       
                   }else{
                        dia.showMessageDialog( null, "Usted NO puede extraer esa cantidad", "Advertencia", JOptionPane.WARNING_MESSAGE);
                   }
               }
           }
        }
    }

    

   
    
}
