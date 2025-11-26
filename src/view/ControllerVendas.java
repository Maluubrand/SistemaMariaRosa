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
 * @author Marcos
 */
public class ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public MlrVendas getBean(int rowIndex) {
        return (MlrVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MlrVendas vendas = (MlrVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getMlrIdVendas();
        } else if (columnIndex ==1) {
            return vendas.getMlrDataVenda();        
        } else if (columnIndex ==2) {
            return vendas.getMlrTotal();
        } else if (columnIndex ==3) {
            return vendas.getMlrClientes().getMlrNome();
        }else if (columnIndex ==4) {
            return vendas.getMlrFuncionarios().getMlrNome();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data da venda";         
        } else if ( columnIndex == 2) {
            return "Total";
        } else if ( columnIndex == 3) {
            return "Cliente";
        } else if ( columnIndex == 4) {
            return "Funcionários";
        } 
        return "";
    }
}
