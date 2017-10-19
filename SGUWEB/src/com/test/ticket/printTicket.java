
package com.test.ticket;


import DAO.impresionDAO;
import DAO.impresionTipoDocumentoDAO;
import ENTIDAD.impresionC;
import ENTIDAD.impresionTipoDocumentoC;

import java.awt.Font;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.awt.print.*;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="printTicketB")
public class printTicket  implements Printable {
	
	
	private List<impresionTipoDocumentoC> impresionTipoDocumentoL;
	private List<impresionTipoDocumentoC> impresionTipoDocumentoDetL;
	private impresionC impresion;

    //1 inch to mm = 25.4
    static final double INCH = 72;//dpi    
    static final double CM_INCH = 0.393700787;
    static final double INCH_MM = 25.4;

    static final double PAGE_WIDTH = 22.7;//INCH_MM
    static final double PAGE_HEIGHT = 14.5;//INCH_MM

    //parece que las coordenadas ya contaban con los margenes
    private final static double MARGIN_LEFT_RIGHT = 1.0;//* INCH_MM
    private final static double MARGIN_TOP_BOTTOM = 0.5;//* INCH_MM
    //static final double MARGIN_HEADER = 0;//podria obviarlo--2.0
    String tipoDocumento="5";
    String numeroDocumento="";
    
    
    



	public printTicket() {
		this.tipoDocumento=tipoDocumento;
		this.numeroDocumento=numeroDocumento;
	}

    private static double deCMaDPI(double cm) {
        return aDPI(cm * CM_INCH);
    }

    private static double aDPI(double in) {
        return in * INCH;
    }

    public void imprimir() {

       
        try {

            
            
      
            if (tipoDocumento != null ) {

                PrinterJob impresion = PrinterJob.getPrinterJob();
                Paper papel = new Paper();
                PageFormat pf = impresion.defaultPage();
                
             //   papel.setImageableArea(deCMaDPI(MARGIN_LEFT_RIGHT), deCMaDPI(MARGIN_TOP_BOTTOM), papel.getWidth(), papel.getHeight());
                
                
                pf.setPaper(papel);

                impresion.setPrintable(this, pf);


                try {
                
                    impresion.print();
                } catch (PrinterException e) {
                	System.out.println(e.getMessage());
                   
                }

            } else {
                
                System.out.println("una o mas variables null | vacias");
            }

        } catch (NullPointerException ex) {
          System.out.println(ex);
        }

    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
    	System.out.println("----Inicio -----");    	
    	
        try {
        	
        	
        	
        	  if (page == 0) {
        	
        	 Graphics2D g2d = (Graphics2D) g;        	 
        	
            g2d.translate(pf.getImageableX(), pf.getImageableY());//punto para evitar estar fuera del area de impresion
        	//g2d.translate(pf.getImageableWidth(), pf.getImageableHeight());//punto para evitar estar fuera del area de impresion
         
        	   System.out.println("1 - ancho pf " + pf.getImageableX());
               System.out.println("1 - alto pf " + pf.getImageableY());
               
               
            System.out.println("2 - ancho pf " + pf.getWidth());
            System.out.println("2 - alto pf " + pf.getHeight());
            
            System.out.println("3 - ancho pf " + pf.getImageableWidth());
            System.out.println("3 - alto pf " + pf.getImageableHeight());
            
            
    	 
    	   
    	   
    	   
    	   
    	   
    	   Rectangle2D rect = new Rectangle2D.Double(0,0, pf.getImageableWidth(), pf.getImageableHeight());
    	   g2d.draw(rect);
    	   
    	   
    	   
    	   
         
            impresion=new impresionDAO().morstrarImpresion(5);
            impresionTipoDocumentoL=new impresionTipoDocumentoDAO().listaImpresionTipoDocumentoDetalle(1,5,1);
            
            
            
            for (impresionTipoDocumentoC c : impresionTipoDocumentoL) {    
                g2d.setFont(new Font(c.getTipoFuente(), c.getEstiloFuente() , c.getTamanioFuente()));
                double ejeX = deCMaDPI(c.getCoordenadaX());
                double ejeY = deCMaDPI(c.getCoordenadaY());
                g2d.drawString(c.getEtiqueta(), Math.round((long) ejeX), Math.round((long) (ejeY)));
            }
            
            /*
            impresionTipoDocumentoDetL.add(new impresionTipoDocumentoC(1, 1, "concepto", "", 8, "arial", 0, 0.0, 20.0, 2, 1));
            for (impresionTipoDocumentoC c : impresionTipoDocumentoDetL) {    
                g2d.setFont(new Font(c.getTipoFuente(), c.getEstiloFuente() , c.getTamanioFuente()));
                double ejeX = deCMaDPI(c.getCoordenadaX());
                double ejeY = deCMaDPI(c.getCoordenadaY());
                g2d.drawString(c.getEtiqueta(), Math.round((long) ejeX), Math.round((long) (ejeY)));
            }
        */
            //List<camposReporte> campos = cargarCampos();//campos de la BD
            //List<camposReporte> cabecera = llenarCampos(campos, 1);//DATOS DEL COMPROBANTE - 1 CABECERA
            //List<camposReporte> detalle = llenarCampos(campos, 2);//DATOS DEL COMPROBANTE - 2 DETALLE

        

            
          
                System.out.println("PAGINAS " + page);
        	  }
        	  else{
        		  
                return NO_SUCH_PAGE;
            }

           

            
            
            
            
            
//            int SALTO = 0;
 //           int ITEM_DETALLE = (int) (MAXIMO_ITEMS_DETALLE * CAMPOS_DETALLE * page);
 //           int MAXIMO_PAGINA = (int) (MAXIMO_ITEMS_DETALLE * CAMPOS_DETALLE * (page += 1));
/*
            for (camposReporte c : detalle) {
                if (SALTO == ITEM_DETALLE) {
                    if (ITEM_DETALLE < MAXIMO_PAGINA) {
                    
                        Font fuente = new Font("Time new roman", Font.BOLD, c.tamanio_fuente);
                        g2d.setFont(fuente);
                        double ejeX = deCMaDPI(c.getEje_x());
                        double ejeY = deCMaDPI(c.getEje_y());
                        g2d.drawString(c.getNombre_columna(), Math.round((long) ejeX), Math.round((long) (ejeY + MARGEN_DETALLE)));

                        //COMO RECORRE CAMPOS LO QUE HAGO ES "SEPARAR" FILAS
                        //CANTIDAD DE CAMPOS DE DETALLE PARTIDO EN LA CANTIDAD DE CAMPOS DE UN ITEM
                        if (CAMPO < CAMPOS_DETALLE) {
                            CAMPO++;
                        } else {
                            // ULTIMO CAMPO SE DEBE ROMPER LA FILA Y EMPEZAR DENUEVO ... ADEMAS AGREGAR UN MARGEN ENTRE ITEMS
                            CAMPO = 1;
                            MARGEN_DETALLE += (deCMaDPI(c.getIncremento_det()));
                        }
                    }
                    ITEM_DETALLE++;
                }
                SALTO++;
            }
*/
        } catch (ArithmeticException e) {
        	System.out.println("error  = " + e.getMessage());
            
            return NO_SUCH_PAGE;//**********************PARA NO CREAR UN LOOP
        }

        return PAGE_EXISTS;
    }
/*
    private List<camposReporte> llenarCampos(List<camposReporte> campos, int tipo_item) {
        //System.out.println(tipo_item == 2 ? "fue llamado por printer" : null);
        List<camposReporte> lista = new ArrayList<>();
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        camposReporte cr;
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            c = ConexionWeb();
            //System.out.println("TIPO_DOCUMENTO " + TIPO_DOCUMENTO + " NUM_COMPROBANTE " + NUM_COMPROBANTE);
            cs = c.prepareCall("{CALL SIGU.CON_IMPRESIONX (3,'%','%',?,?,'%','%','%','%')}");
            cs.setString(1, TIPO_DOCUMENTO);
            cs.setString(2, NUM_COMPROBANTE);

            rs = cs.executeQuery();

            if (tipo_item == 1) {
                if (rs.next()) {//solo quiero una fila para formar la cabecera                    
                    for (camposReporte s : campos) {
                        cr = new camposReporte();
                        if (s.getTipo_item() == tipo_item) {
                            //System.out.println(tipo_item + " " + s.getNombre_columna());
                            cr.setValor_moneda(s.getValor_moneda());

                            if (cr.getValor_moneda() == 1) {//formatear *NUMERO* a 2 decimales
                                cr.setNombre_columna(df.format(Double.parseDouble(rs.getString(s.getNombre_columna()))));
                            } else {
                                cr.setNombre_columna(rs.getString(s.getNombre_columna()));
                            }

                            cr.setEje_x(s.getEje_x());
                            cr.setEje_y(s.getEje_y());
                            cr.setTamanio_fuente(s.getTamanio_fuente());
                            //cr.setIncremento_det(s.getIncremento_det());
                            //cr.setTipo_item(s.getTipo_item());
                            lista.add(cr);
                        }
                    }
                }
            } else {
                int i = 1;//para separar detalles
                while (rs.next()) {//tomo todas las filas para formar el detalle                    
                    for (camposReporte s : campos) {
                        cr = new camposReporte();
                        if (s.getTipo_item() == tipo_item) {
                            //System.out.println(tipo_item + " " + s.getNombre_columna());
                            cr.setValor_moneda(s.getValor_moneda());

                            if (cr.getValor_moneda() == 1) {//formatear *NUMERO* a 2 decimales
                                cr.setNombre_columna(df.format(Double.parseDouble(rs.getString(s.getNombre_columna()))));
                            } else {
                                cr.setNombre_columna(rs.getString(s.getNombre_columna()));
                            }

                            cr.setEje_x(s.getEje_x());
                            cr.setEje_y(s.getEje_y());
                            cr.setTamanio_fuente(s.getTamanio_fuente());
                            cr.setTipo_item(i);//para separar detalles
                            cr.setIncremento_det(s.getIncremento_det());
                            lista.add(cr);
                        }
                    }
                    i++;
                }
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            util.consolaCliente("LLENAR CAMPOS " + e.getMessage());
            //e.printStackTrace();
        }
        return lista;
    }
*/
  

    
    
    
    
    
    
    
	
	
	public impresionC getImpresion() {
		return impresion;
	}

	public void setImpresion(impresionC impresion) {
		this.impresion = impresion;
	}

	
	public List<impresionTipoDocumentoC> getImpresionTipoDocumentoL() {
		return impresionTipoDocumentoL;
	}

	public void setImpresionTipoDocumentoL(List<impresionTipoDocumentoC> impresionTipoDocumentoL) {
		this.impresionTipoDocumentoL = impresionTipoDocumentoL;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public List<impresionTipoDocumentoC> getImpresionTipoDocumentoDetL() {
		return impresionTipoDocumentoDetL;
	}

	public void setImpresionTipoDocumentoDetL(List<impresionTipoDocumentoC> impresionTipoDocumentoDetL) {
		this.impresionTipoDocumentoDetL = impresionTipoDocumentoDetL;
	}
	
	
	

}
