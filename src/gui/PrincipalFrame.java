/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controlador.Controller;
import exepciones.AlumnosExistenteExeption;
import exepciones.ArchivoInvalidoExeption;
import exepciones.CalificacionErroneaExeption;
import exepciones.CargarArchivoExption;
import exepciones.GuardarArchivoExeption;
import model.Alumno;
import model.Carrera;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */

public class PrincipalFrame extends JFrame {

    private EliminarAlumnosDialog eliminarAlumnosDialog;

    private AcercaDeDialog acercaDeDialog;
    private BusquedaPanel pnlBusqueda;
    private JTable tblAlumnos;
    private Controller controlador;
    private AlumnosDialog dlgAlumno;
    private AlumnosTableModel modelAlumnos;



    public PrincipalFrame() throws AlumnosExistenteExeption, CargarArchivoExption, ArchivoInvalidoExeption {
        super("Control escolar");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(500, 300);
        super.setLayout(new BorderLayout());
        super.setLocationRelativeTo(null);


        //Carga inicial
        try {
        controlador = new Controller();            
        } catch (ArchivoInvalidoExeption e) {
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    e.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE
            );
        }catch (CargarArchivoExption e){
            JOptionPane.showMessageDialog(PrincipalFrame.this,
                    e.getMessage(),
                    "Archivo corrompido",
                    JOptionPane.ERROR_MESSAGE
            );            
        }

        modelAlumnos = new AlumnosTableModel(controlador);
        tblAlumnos = new JTable(modelAlumnos);
        pnlBusqueda = new BusquedaPanel();
        pnlBusqueda.setListener(new BusquedaPanelListener() {
            @Override
            public void buscarAlumno(String id) {
                JOptionPane.showMessageDialog(PrincipalFrame.this, 
                        controlador.buscarAlumno(id), 
                        "Informacion del alumno", 
                        JOptionPane.INFORMATION_MESSAGE
                );
                pnlBusqueda.clean();
                
            }
        });

        acercaDeDialog = new AcercaDeDialog(this);
        eliminarAlumnosDialog = new EliminarAlumnosDialog(this);
        eliminarAlumnosDialog.setListener(new EliminarAlumnoListener() {
            @Override
            public void eliminarButtonCLick(String noControl) {
                JOptionPane.showMessageDialog(PrincipalFrame.this, controlador.borrarAlumno(noControl), "Alumno", JOptionPane.ERROR_MESSAGE);
                modelAlumnos.fireTableDataChanged();
                eliminarAlumnosDialog.clean();
                eliminarAlumnosDialog.setVisible(false);

            }

            @Override
            public void salirButtonClick() {
                eliminarAlumnosDialog.setVisible(false);
            }
        });

        dlgAlumno = new AlumnosDialog(this);
        dlgAlumno.setListener(new AlumnoDialogListener() {
            @Override
            public void aceptarButtonClick(Alumno a) {
                try {
                    System.out.println(a.getNoCOntrol());
                    controlador.add(a);
                    modelAlumnos.fireTableDataChanged();
                    dlgAlumno.setVisible(false);
                    dlgAlumno.clean();

                } catch (AlumnosExistenteExeption e) {
                    JOptionPane.showMessageDialog(PrincipalFrame.this,
                            e.getMessage(),
                            "Alumno no ingresado",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }

            @Override
            public void cancelarButtonClick() {
                dlgAlumno.setVisible(false);
            }
        });

        super.add(makeMenu(), BorderLayout.NORTH);
        super.add(new JScrollPane(tblAlumnos), BorderLayout.CENTER);
        super.add(pnlBusqueda, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    private JMenuBar makeMenu() {
        JMenuBar menu = new JMenuBar();

        JMenu mmAlumnos = new JMenu("Alumnos");
        JMenuItem miNuevoAlumno = new JMenuItem("Nuevo ..");
        JMenuItem miSalir = new JMenuItem("Salir");
        JMenuItem miEliminarAlumno = new JMenuItem("Eliminar alumno");

        miSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        mmAlumnos.add(miNuevoAlumno);
        miNuevoAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlgAlumno.setVisible(true);
            }
        });


        miEliminarAlumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                eliminarAlumnosDialog.setVisible(true);
            }
        });

        
        
        
        JMenuItem miGuardar = new JMenuItem("Guardar");

        miGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controlador.guardar();
                } catch (IOException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (GuardarArchivoExeption ex) {
                    JOptionPane.showInternalMessageDialog(PrincipalFrame.this,
                            ex.getMessage(), 
                            "Error al guardar", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        mmAlumnos.add(miEliminarAlumno);
        mmAlumnos.add(miGuardar);
        mmAlumnos.add(new JSeparator());
        mmAlumnos.add(miSalir);

        JMenu mmAyuda = new JMenu("Ayuda");
        JMenuItem miAcercaDe = new JMenuItem("Acerca de");


        mmAyuda.add(miAcercaDe);

        miAcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acercaDeDialog.setVisible(true);
            }
        });

        menu.add(mmAlumnos);
        menu.add(mmAyuda);

        return menu;

    }

    public static void main(String[] args) throws CalificacionErroneaExeption, ArchivoInvalidoExeption, AlumnosExistenteExeption, CargarArchivoExption, CargarArchivoExption, CargarArchivoExption, CargarArchivoExption {
        try {
            new PrincipalFrame();
        } catch (CargarArchivoExption ex) {
            JOptionPane.showInternalMessageDialog(null,
                            ex.getMessage(), 
                            "Error al guardar", 
                            JOptionPane.ERROR_MESSAGE);            
        }
//
//        Controller a = new Controller();
//        a.add(new Alumno("01", "JAIro", "A", "a", 4.2, Carrera.SISTEMAS));
//        //a.add(new Alumno("01", "JAIro", "A", "a", 4.2, Carrera.SISTEMAS));
//        a.add(new Alumno("a01", "JAIro", "A", "a", 4.2, Carrera.SISTEMAS));
//        a.buscarAlumno("a01");
//        
        
        
    }
}
