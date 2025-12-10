/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.MlrUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Maria
 */
public class ControllerUsuarios extends AbstractTableModel {

    private List lstUsuarios;

    public void setList(List lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
    
    public MlrUsuarios getBean(int rowIndex) {
        return (MlrUsuarios) lstUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MlrUsuarios usuarios = (MlrUsuarios) lstUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getMlrIdUsuarios();
        } else if (columnIndex ==1) {
            return usuarios.getMlrNome();        
        } else if (columnIndex ==2) {
            return usuarios.getMlrApelido();
        } else if (columnIndex ==3) {
            return usuarios.getMlrCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
