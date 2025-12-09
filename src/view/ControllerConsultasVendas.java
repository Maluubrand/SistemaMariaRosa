/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.MlrVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author
 */
public class ControllerConsultasVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }
    
//    public Pedidos getBean(int rowIndex) {
//        return (Pedidos) lstVendas.get(rowIndex);
//    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MlrVendas clientes = (MlrVendas) lstVendas.get( rowIndex);
               if (columnIndex == 0 ) {
            return clientes.getMlrIdVendas();
        }else if (columnIndex ==1) {
            return clientes.getMlrClientes();   
        }else if (columnIndex ==2) {
            return clientes.getMlrFuncionarios();        
        } else if (columnIndex ==3) {
            return clientes.getMlrTotal();        
        } 
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";         
        }else if ( columnIndex == 1) {
            return "Clientes";         
        } else if ( columnIndex == 2) {
            return "Funcionários";         
        }else if ( columnIndex == 3) {
            return "Total";         
        }
        return "";
    }
}
